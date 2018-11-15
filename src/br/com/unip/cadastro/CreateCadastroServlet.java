package br.com.unip.cadastro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unip.models.ContaUsuario;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/cadastrovisitante" })
public class CreateCadastroServlet  extends HttpServlet {
	private static final long serialVersionUID = 5717766289190760433L;

	public CreateCadastroServlet () {
        super();
    }
 
    // Direciona para a página de criação do login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/cadastro/createVisitanteView.jsp");
        dispatcher.forward(request, response);
    }
    
    //Método executado após o usuário preencher os campos e clicar em salvar 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String matriculaStr = (String) request.getParameter("matricula");
        String nome = (String) request.getParameter("nome");
        String login = (String) request.getParameter("login");
        String senha = (String) request.getParameter("senha");
        String tipoacesso = (String) request.getParameter("tipoacesso");
        
        int matricula = 0;
        try {
            matricula = Integer.parseInt(matriculaStr);
        } catch (Exception e) {
        }
        
        ContaUsuario user = new ContaUsuario (matricula,nome,login,senha,tipoacesso);
 
 
        String errorString = null;
 
        //A matricula é lida como String 
        String regex = "\\w+";
 
        if (matriculaStr == null || !matriculaStr.matches(regex)) {
            errorString = "Código de matricula inválido!";
        }
 
        if (errorString == null) {
            try {
                OperBD.insertUser(conn, user);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // armazena os dados no atributo da request antes de direcionar o usuário a outra pa'gina
        request.setAttribute("errorString", errorString);
        request.setAttribute("user", user);
 
        // No caso de erro retorna o usuário a página de edição 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/cadastro/createVisitanteView.jsp");
            dispatcher.forward(request, response);
        }
        
        //Se o cadastro for completado com sucesso, direciona a página de admin
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
 
}

