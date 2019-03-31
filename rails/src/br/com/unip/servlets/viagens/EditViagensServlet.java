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

@WebServlet(urlPatterns = { "/editarviagem" })
public class EditViagensServlet extends HttpServlet {
	private static final long serialVersionUID = -33905425333127430L;
	
	public EditViagensServlet() {
        super();
    }
    
    // Exibe a página de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
 
        Evento evento = null;
 
        String errorString = null;
 
        try {
        		evento = OperBD.findEvento(conn, id);    
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //No caso do atributo estiver vazio direciona para a própria página
        if (errorString != null && evento == null) {
            response.sendRedirect(request.getServletPath() + "/viagens");
            return;
        }
 
        // Armazena o erro antes de direcionar a página de edição
        request.setAttribute("errorString", errorString);
        request.setAttribute("eventoEdit", evento);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/viagens/editViagensView.jsp");
        dispatcher.forward(request, response);
 
    }
    
    //método executado quando do salvar.
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
        
        Evento evento = new Evento (id, nome,descricao,palestrante,local, data);
 
        String errorString = null;
 
        try {
            OperBD.updateEvento(conn, evento);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("eventoEdit", evento);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/viagens/editViagensView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/viagens");
        }
    }

}
