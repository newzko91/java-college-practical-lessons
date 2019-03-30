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

@WebServlet(urlPatterns = { "/cargasedit" })
public class EditCargasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public EditCargasServlet() {
        super();
    }
    
 // Exibe a página de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
 
        Carga c = null;
 
        String errorString = null;
 
        try {
            c = OperBD.findCarga(conn, id);    
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //No caso do atributo estiver vazio direciona para a própria página
        if (errorString != null && c == null) {
            response.sendRedirect(request.getServletPath() + "/cargas");
            return;
        }
 
        // Armazena o erro antes de direcionar a página de edição
        request.setAttribute("errorString", errorString);
        request.setAttribute("cargasEdit", c);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/cargas/editCargasView.jsp");
        dispatcher.forward(request, response);
 
    }
    
    //método executado quando o usuário clicar em Salvar.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    		Connection conn = GenOper.getStoredConnection(request);
        
        String idStr = (String) request.getParameter("id");
        String descricao = (String) request.getParameter("descricao");
        String responsavel_matriculaStr = (String) request.getParameter("responsavel_matricula");
        String responsavel_nome = (String) request.getParameter("responsavel_nome");
        String transportadorStr = (String) request.getParameter("transportador");
        String transportador_nome = (String) request.getParameter("transportador_nome");
        String tipo_carga = (String) request.getParameter("tipo_carga");
        String tempotransporte = (String) request.getParameter("tempotransporte");
        
        
        int id = 0, responsavel = 0, transportador =0;
        try {
            id = Integer.parseInt(idStr);
            responsavel = Integer.parseInt(responsavel_matriculaStr);
            transportador = Integer.parseInt(transportadorStr);
        } catch (Exception e) {
        }
        
        Carga c = new Carga(id, descricao, responsavel, responsavel_nome, transportador, transportador_nome, 
        		tipo_carga, tempotransporte);
        		
        
        String errorString = null;
 
        try {
            OperBD.updateCarga(conn, c);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // armazena dados no atributo request antes de direcionar para a pagina
        request.setAttribute("errorString", errorString);
        request.setAttribute("cargaEdit", c);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/cargas/editCargasView.jsp");
            dispatcher.forward(request, response);
        }
        
        //No caso de não haver erros
        else {
            response.sendRedirect(request.getContextPath() + "/cargas");
        }
    }
	
}
