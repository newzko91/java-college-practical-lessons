package br.com.unip.servlets.participantes;

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

import br.com.unip.models.Participante;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/participantesviagem" })
public class RetrieveParticipantesServlet extends HttpServlet {
	private static final long serialVersionUID = 5430053715831604979L;

	public RetrieveParticipantesServlet() {
		super();
	}
	
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = OperGer.getStoredConnection(request);
	 
	        String id = (String) request.getParameter("id");
	        String errorString = null;
	        List<Participante> participante = null;
	        try {
	        	    participante = OperBD.queryParticipantes(conn,id); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("participante", participante);
	         
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/participantes/participantesView.jsp");
	        dispatcher.forward(request, response);
	    }
	 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

	
}
