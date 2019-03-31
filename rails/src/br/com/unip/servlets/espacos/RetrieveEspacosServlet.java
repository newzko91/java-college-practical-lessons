package br.com.unip.servlets.espacos;

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

import br.com.unip.models.Espaco;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/locais" })
public class RetrieveEspacosServlet extends HttpServlet {
	private static final long serialVersionUID = -3165540903094068440L;

	public RetrieveEspacosServlet() {
		super();
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String errorString = null;
        List<Espaco> list = null;
        try {
            list = OperBD.queryEspacos(conn); 
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("espaco", list);
         
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/espaco/espacoView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
