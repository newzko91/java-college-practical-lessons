package br.unip.aps.servlets.embarcacoes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unip.aps.dao.GenOper;
import br.unip.aps.dao.OperBD;

@WebServlet(urlPatterns = { "/embarcacaodelete" })
public class DeleteEmbarcacoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public DeleteEmbarcacoesServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        
        String errorString = null;
 
        try {
            OperBD.deleteEmbarcacao(conn, idStr);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // Caso ocorrer algum erro direciona pra página de erro
        if (errorString != null) {

            request.setAttribute("errorString", errorString);
            
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/embarcacoes/deleteEmbarcacoesView.jsp");
            dispatcher.forward(request, response);
        }
        //Caso não tenha erro, direciona para a página /admin
        else {
            response.sendRedirect(request.getContextPath() + "/embarcacoes");
        }
 
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}
