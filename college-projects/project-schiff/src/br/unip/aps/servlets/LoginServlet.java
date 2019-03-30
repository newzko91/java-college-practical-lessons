package br.unip.aps.servlets;

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

import br.unip.aps.models.ContaUsuario;
import br.unip.aps.dao.GenOper;
import br.unip.aps.dao.OperBD;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    // Show Login page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login/loginView.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
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
            Connection conn = GenOper.getStoredConnection(request);
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
        // If error, forward to /WEB-INF/views/login.jsp
        if (hasError) {
            user = new ContaUsuario();
            user.setLogin(login);
            user.setSenha(senha);
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        // No caso de não haver erros [login com sucesso], armazena as informacoes do usuário na sessão
        // E direciona para a home do sistema
        else {
            HttpSession session = request.getSession();
            GenOper.storeLoginedUser(session, user); 
 
            // Redirect to userInfo page.
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
 
}
