package br.com.unip.servlets.viagens;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unip.models.Evento;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/viagens" })
public class RetrieveViagensServlet extends HttpServlet {
	private static final long serialVersionUID = -4456255205775286969L;

	public RetrieveViagensServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 

        String errorString = null;
        List<Evento> list = null;
       
        try {
            list = OperBD.queryEventos(conn); 
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("evento", list);
         
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/viagens/viagensView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
