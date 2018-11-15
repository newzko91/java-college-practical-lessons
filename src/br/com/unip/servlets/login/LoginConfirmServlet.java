package br.com.unip.servlets.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/confirmarlogin" })
public class LoginConfirmServlet extends HttpServlet{
	private static final long serialVersionUID = -4036833309861865050L;

	public LoginConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login/loginConfirmView.jsp");
        dispatcher.forward(request, response);
    }
 

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}
}
