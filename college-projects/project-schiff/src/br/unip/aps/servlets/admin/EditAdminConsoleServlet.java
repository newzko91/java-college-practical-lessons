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


import br.unip.aps.dao.OperBD;
import br.unip.aps.dao.GenOper;
import br.unip.aps.models.ContaUsuario;

@WebServlet(urlPatterns = { "/adminedit" })
public class EditAdminConsoleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    public EditAdminConsoleServlet() {
        super();
    }
    
    // Exibe a página de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String login = (String) request.getParameter("matricula");
 
        ContaUsuario user = null;
 
        String errorString = null;
 
        try {
            user = OperBD.findUserAdmin(conn, login);    
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //No caso do atributo estiver vazio direciona para a própria página
        if (errorString != null && user == null) {
            response.sendRedirect(request.getServletPath() + "/admin");
            return;
        }
 
        // Armazena o erro antes de direcionar a página de edição
        request.setAttribute("errorString", errorString);
        request.setAttribute("userEdit", user);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/admin/editAdminView.jsp");
        dispatcher.forward(request, response);
 
    }
    
    //método executado quando do salvar.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
        
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
 
        try {
            OperBD.updateUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("userEdit", user);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/admin/editAdminView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/admin");
        }
    }
}
