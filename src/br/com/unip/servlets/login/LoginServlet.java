package br.com.unip.servlets.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.unip.dao.OperBD;
import br.com.unip.dao.OperGer;
import br.com.unip.models.ContaUsuario;


@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet  {
	private static final long serialVersionUID = 7589364279082469583L;

	public LoginServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login/loginView.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("username");
        String senha = request.getParameter("password");
 
        ContaUsuario user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (login == null || senha == null || login.length() == 0 || senha.length() == 0) {
            hasError = true;
            errorString = "Favor informar usuário e senha!";
        } else {
            Connection conn = OperGer.getStoredConnection(request);
            try {
                // Find the user in the DB.
                user = OperBD.findUser(conn, login, senha);
 
                if (user == null) {
                    hasError = true;
                    errorString = "Usuário ou Senha inválidos!";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
    
        if (hasError) {
            user = new ContaUsuario();
            user.setLogin(login);
            user.setSenha(senha);
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        // No caso de não haver erros [login com sucesso], armazena as informacoes do usuário na sessão
        // E direciona para a home do sistema
        else {
            HttpSession session = request.getSession(true);
            OperGer.storeLoginedUser(session, user); 
            
            response.sendRedirect(request.getContextPath() + "/confirmarlogin");
        }
    }

}
