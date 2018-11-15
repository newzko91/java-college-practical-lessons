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

@WebServlet(urlPatterns = { "/editarlocal" })
public class EditEspacosServlet extends HttpServlet {
	private static final long serialVersionUID = -1890194074789307833L;

	public EditEspacosServlet() {
		super();
	}
	
	 // Exibe a página de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
 
        Espaco espaco = null;
 
        String errorString = null;
 
        try {
        		espaco = OperBD.findLocal(conn, id);    
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //No caso do atributo estiver vazio direciona para a própria página
        if (errorString != null && espaco == null) {
            response.sendRedirect(request.getServletPath() + "/locais");
            return;
        }
 
        // Armazena o erro antes de direcionar a página de edição
        request.setAttribute("errorString", errorString);
        request.setAttribute("localEdit", espaco);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/espaco/editarEspacoView.jsp");
        dispatcher.forward(request, response);
 
    }
    
    //método executado quando do salvar.
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
        
        Espaco espaco = new Espaco (id, nome);
 
        String errorString = null;
 
        try {
            OperBD.updateLocal(conn, espaco);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("localEdit", espaco);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/espaco/editarEspacoView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/locais");
        }
    }

	
	
}
