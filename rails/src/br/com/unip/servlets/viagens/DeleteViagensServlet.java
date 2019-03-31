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

import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/apagarviagem" })
public class DeleteViagensServlet extends HttpServlet {
	private static final long serialVersionUID = -3946075549857044900L;


	public DeleteViagensServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        
        String errorString = null;
 
        try {
            OperBD.deleteEvento(conn, idStr);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // If has an error, redirecte to the error page.
        if (errorString != null) {

            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/viagens/deleteViagensViewErro.jsp");
            dispatcher.forward(request, response);
        }
        //Caso não tenha erro, direciona para a página /admin
        else {
            response.sendRedirect(request.getContextPath() + "/viagens");
        }
 
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}

