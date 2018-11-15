package br.com.unip.servlets.viagens;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unip.models.Evento;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/criarviagem" })
public class CreateViagemServlet extends HttpServlet {
	private static final long serialVersionUID = 3123439728639694939L;

	public CreateViagemServlet() {
		super();
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/viagens/createViagensView.jsp");
        dispatcher.forward(request, response);
        
    }
    
    //Método executado após o usuário preencher os campos e clicar em salvar 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        String nome = (String) request.getParameter("nome");
        String descricao = (String) request.getParameter("descricao");
        String data = (String) request.getParameter("data");
        String palestrante = (String) request.getParameter("palestrante");
        String local = (String) request.getParameter("local");
        
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }
        
		Evento evento = new Evento (id,nome,descricao,palestrante,local,data);
 
 
        String errorString = null;
 
        //A matricula é lida como String 
        String regex = "\\w+";
 
        if (idStr == null || !idStr.matches(regex)) {
            errorString = "Código de evento inválido!";
        }
 
        if (errorString == null) {
            try {
                OperBD.insertEvento(conn, evento);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // armazena os dados no atributo da request antes de direcionar o usuário a outra pa'gina
        request.setAttribute("errorString", errorString);
        request.setAttribute("evento", evento);
 
        // No caso de erro retorna o usuário a página de edição 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/viagens/createViagensView.jsp");
            dispatcher.forward(request, response);
        }
        
        //Se o cadastro for completado com sucesso, direciona a página de admin
        else {
            response.sendRedirect(request.getContextPath() + "/viagens");
        }
    }
 

	
}
