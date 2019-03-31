package br.com.unip.servlets.semacesso;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/semacesso" })
public class SemAcessoServlet extends HttpServlet {
	private static final long serialVersionUID = -297435297495189031L;

	public SemAcessoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/semacesso/semacessoView.jsp");
        dispatcher.forward(request, response);
    }
 

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}

}
