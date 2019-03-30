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

import br.unip.aps.dao.OperBD;
import br.unip.aps.dao.GenOper;
import br.unip.aps.models.Embarcacao;

@WebServlet(urlPatterns = { "/embarcacaoedit" })
public class EditEmbarcacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 
    public EditEmbarcacoesServlet() {
        super();
    }
    
 // Exibe a página de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
 
        Embarcacao emb = null;
 
        String errorString = null;
 
        try {
            emb = OperBD.findEmbarcacao(conn, id);    
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //No caso do atributo estiver vazio direciona para a própria página
        if (errorString != null && emb == null) {
            response.sendRedirect(request.getServletPath() + "/embarcacoes");
            return;
        }
 
        // Armazena o erro antes de direcionar a página de edição
        request.setAttribute("errorString", errorString);
        request.setAttribute("embarcacaoEdit", emb);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/embarcacoes/editEmbarcacoesView.jsp");
        dispatcher.forward(request, response);
 
    }
    
    //método executado quando o usuário clicar em Salvar.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    		Connection conn = GenOper.getStoredConnection(request);
        
        String idStr = (String) request.getParameter("id");
        String descricao = (String) request.getParameter("descricao");
        String fabricante = (String) request.getParameter("fabricante");
        String ano_fab = (String) request.getParameter("ano_fab");
        String tamanho = (String) request.getParameter("tamanho");
        String responsavelStr = (String) request.getParameter("responsavel");
  
        
        
        int id = 0, responsavel = 0;
        try {
            id = Integer.parseInt(idStr);
            responsavel = Integer.parseInt(responsavelStr);
        } catch (Exception e) {
        }
        
        Embarcacao emb = new Embarcacao (id,descricao,fabricante,ano_fab,tamanho,responsavel);
        
 
        String errorString = null;
 
        try {
            OperBD.updateEmbarcacao(conn, emb);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // armazena dados no atributo request antes de direcionar para a pagina
        request.setAttribute("errorString", errorString);
        request.setAttribute("embarcacaoEdit", emb);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/embarcacoes/editEmbarcacoesView.jsp");
            dispatcher.forward(request, response);
        }
        
        //No caso de não haver erros
        else {
            response.sendRedirect(request.getContextPath() + "/embarcacoes");
        }
    }
}
