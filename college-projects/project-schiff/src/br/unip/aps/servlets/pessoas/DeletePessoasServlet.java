package br.unip.aps.servlets.pessoas;

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

@WebServlet(urlPatterns = { "/pessoasdelete" })
public class DeletePessoasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 
    public DeletePessoasServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String matriculaStr = (String) request.getParameter("matricula");
        
        String errorString = null;
 
        try {
            OperBD.deletePessoa(conn, matriculaStr);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // Caso ocorrer algum erro direciona pra página de erro
        if (errorString != null) {

            request.setAttribute("errorString", errorString);
            
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/pessoas/deletePessoasViewErro.jsp");
            dispatcher.forward(request, response);
        }
        //Caso não tenha erro, direciona para a página /admin
        else {
            response.sendRedirect(request.getContextPath() + "/pessoas");
        }
 
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
	
}
