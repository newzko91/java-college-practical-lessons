package br.com.unip.servlets.espacos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unip.models.Espaco;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/cadastrarlocal" })
public class CreateEspacosServlet extends HttpServlet {
	private static final long serialVersionUID = 78515176434515498L;

	public CreateEspacosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Direciona para a página de criação do login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/espaco/createEspacoView.jsp");
        dispatcher.forward(request, response);
    }
    
    //Método executado após o usuário preencher os campos e clicar em salvar 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        String nome = (String) request.getParameter("nome");
        
        int id = 0;
        try {
        		id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }
        
        Espaco local = new Espaco(id, nome);
 
 
        String errorString = null;
 
        //A matricula é lida como String 
        String regex = "\\w+";
 
        if (idStr == null || ! idStr.matches(regex)) {
            errorString = "Código de local inválido!";
        }
 
        if (errorString == null) {
            try {
                OperBD.insertLocal(conn, local);
               
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // armazena os dados no atributo da request antes de direcionar o usuário a outra pa'gina
        request.setAttribute("errorString", errorString);
        request.setAttribute("local", local);
 
        // No caso de erro retorna o usuário a página de edição 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/espaco/createEspacoView.jsp");
            dispatcher.forward(request, response);
        }
        
        //Se o cadastro for completado com sucesso, direciona a página de admin
        else {
            response.sendRedirect(request.getContextPath() + "/locais");
        }
    }
}
