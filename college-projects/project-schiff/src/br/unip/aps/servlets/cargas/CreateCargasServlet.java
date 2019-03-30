package br.unip.aps.servlets.cargas;

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
import br.unip.aps.models.Carga;

@WebServlet(urlPatterns = { "/cargascreate" })
public class CreateCargasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public CreateCargasServlet() {
        super();
    }
    
    // Exibe a pagina de cadastro 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/cargas/createCargasView.jsp");
        dispatcher.forward(request, response);
    }
    
 // Método executado quando o usuário clicar em Salvar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
        
        String idStr = (String) request.getParameter("id");
        String descricao = (String) request.getParameter("descricao");
        String responsavel_matriculaStr = (String) request.getParameter("responsavel_matricula");
        String transportadorStr = (String) request.getParameter("transportador");
        String tipo_carga = (String) request.getParameter("tipo_carga");
        String tempotransporte = (String) request.getParameter("tempogasto");
     	
        int responsavel_matricula = 0, id=0, transportador =0;
        try {
        		id = Integer.parseInt(idStr);
        		responsavel_matricula = Integer.parseInt(responsavel_matriculaStr);
        		transportador = Integer.parseInt(transportadorStr);
        } catch (Exception e) {
        }
        
        Carga c = new Carga(id, descricao, responsavel_matricula, 
        		transportador, tipo_carga, tempotransporte);
        		
  
        String errorString = "";
 
		try {
			OperBD.insertCarga(conn, c);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
 
        //Armazena informacao antes de continuar
        request.setAttribute("errorString", errorString);
        request.setAttribute("carga", c);
 
        // No caso de erro
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/cargas/createCargasView.jsp");
            dispatcher.forward(request, response);
        }
        
        //Se tudo ocorrer bem, direciona para a pagina de visualização
        else {
            response.sendRedirect(request.getContextPath() + "/cargas");
        }
    }
}
