package br.unip.aps.servlets.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unip.aps.dao.GenOper;
import br.unip.aps.dao.OperBD;

@WebServlet(urlPatterns = { "/admindelete" })
public class DeleteAdminConsoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public DeleteAdminConsoleServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String matriculaStr = (String) request.getParameter("matricula");
        
        String errorString = null;
 
        try {
            OperBD.deleteUser(conn, matriculaStr);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // If has an error, redirecte to the error page.
        if (errorString != null) {

            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/admin/deleteAdminViewErro.jsp");
            dispatcher.forward(request, response);
        }
        //Caso não tenha erro, direciona para a página /admin
        else {
            response.sendRedirect(request.getContextPath() + "/admin");
        }
 
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}
