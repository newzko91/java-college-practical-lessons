package br.unip.aps.servlets.cargas;

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

import br.unip.aps.models.Carga;
import br.unip.aps.dao.GenOper;
import br.unip.aps.dao.OperBD;

@WebServlet(urlPatterns = { "/cargas" })
public class CargasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CargasServlet() {
        super();
    }
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String errorString = null;
        List<Carga> list = null;
        try {
            list = OperBD.queryCargas(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("cargasView", list);
         
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/cargas/cargasView.jsp");
        dispatcher.forward(request, response);
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
