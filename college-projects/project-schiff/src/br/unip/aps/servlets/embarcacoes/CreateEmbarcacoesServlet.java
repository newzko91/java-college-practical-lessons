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

@WebServlet(urlPatterns = { "/embarcacoescreate" })
public class CreateEmbarcacoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public CreateEmbarcacoesServlet() {
        super();
    }
    
    // Exibe a pagina de cadastro 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/embarcacoes/createEmbarcacoesView.jsp");
        dispatcher.forward(request, response);
    }
    
 // Método executado quando o usuário clicar em Salvar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
        
        String idStr = (String) request.getParameter("id");
        String descricao = (String) request.getParameter("desc");
        String fabricante = (String) request.getParameter("fabricante");
        String anofab = (String) request.getParameter("anofab");
        String tamanho = (String) request.getParameter("tamanho");
        String responsavelStr = (String) request.getParameter("responsavel");
     	
        int responsavel = 0,id=0;
        try {
        		id = Integer.parseInt(idStr);
            responsavel = Integer.parseInt(responsavelStr);
        } catch (Exception e) {
        }
        
        Embarcacao emb = new Embarcacao(id,descricao,fabricante,anofab,tamanho,responsavel);
        
        String errorString = "";
 
		try {
			OperBD.insertEmbarcacao(conn, emb);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
 
        //Armazena informacao antes de continuar
        request.setAttribute("errorString", errorString);
        request.setAttribute("embarcacao", emb);
 
        // No caso de erro
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/embarcacoes/createEmbarcacoesView.jsp");
            dispatcher.forward(request, response);
        }
        
        //Se tudo ocorrer bem, direciona para a pagina de visualização
        else {
            response.sendRedirect(request.getContextPath() + "/embarcacoes");
        }
    }
    
}
