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
import javax.servlet.http.HttpSession;

import br.com.unip.models.Evento;
import br.com.unip.models.ContaUsuario;
import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;

@WebServlet(urlPatterns = { "/minhasviagens" })
public class MInhasViagensServlet extends HttpServlet {
	private static final long serialVersionUID = -436108890627359114L;

	public MInhasViagensServlet() {
		super();
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
        
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		ContaUsuario user = OperGer.getLoginedUser(session);
		int matricula = user.getMatricula();
		
        String errorString = null;
        List<Evento> list = null;
        try {
            list = OperBD.queryMeusEventos(conn, matricula); 
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("meuEvento", list);
         
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/viagens/minhasViagensView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
