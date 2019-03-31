package br.com.unip.servlets.pessoas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unip.dao.OperGer;
import br.com.unip.dao.OperBD;
import br.com.unip.models.Pessoa;


@WebServlet(urlPatterns = { "/editarpessoa" })
public class EditPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 6666758713031444862L;
	
    public EditPessoasServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = OperGer.getStoredConnection(request);
 
        String login = (String) request.getParameter("matricula");
 
        Pessoa p = null;
 
        String errorString = null;
 
        try {
            p = OperBD.findPessoa(conn, login);    
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //No caso do atributo estiver vazio direciona para a própria página
        if (errorString != null && p == null) {
            response.sendRedirect(request.getServletPath() + "/pessoas");
            return;
        }
 
        // Armazena o erro antes de direcionar a página de edição
        request.setAttribute("errorString", errorString);
        request.setAttribute("pessoa", p);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/pessoas/editPessoasView.jsp");
        dispatcher.forward(request, response);
 
    }
    
    //método executado quando o usuário clicar em Salvar.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    		Connection conn = OperGer.getStoredConnection(request);
        
        String matriculaStr = (String) request.getParameter("matricula");
        String nome = (String) request.getParameter("nome");
        String endereco = (String) request.getParameter("endereco");
        String telefone = (String) request.getParameter("telefone");
        String email = (String) request.getParameter("email");
        String rg = (String) request.getParameter("rg");
        String cpf = (String) request.getParameter("cpf");
        String cnpj = (String) request.getParameter("cnpj");
        String status = (String) request.getParameter("status");
        String tipo = (String) request.getParameter("tipo");
        String tipo_acesso = (String) request.getParameter("tipo_acesso");
     	
        
        int matricula = 0;
        try {
            matricula = Integer.parseInt(matriculaStr);
        } catch (Exception e) {
        }
        
        Pessoa pessoa = new Pessoa(matricula, nome, endereco,  telefone,  email, rg,
    			 cpf,cnpj,  status,  tipo,  tipo_acesso);
 
        String errorString = null;
 
        try {
            OperBD.updatePessoa(conn, pessoa);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("pessoa", pessoa);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/pessoas/editPessoasView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/pessoas");
        }
    }

}
