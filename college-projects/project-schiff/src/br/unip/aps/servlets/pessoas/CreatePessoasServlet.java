package br.unip.aps.servlets.pessoas;

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
import br.unip.aps.models.Pessoa;

@WebServlet(urlPatterns = { "/pessoascreate" })
public class CreatePessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public CreatePessoasServlet() {
        super();
    }
 
    // Exibe a pagina de cadastro de Pessoa.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/pessoas/createPessoasView.jsp");
        dispatcher.forward(request, response);
    }
    
    // Método executado quando o usuário clicar em Salvar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = GenOper.getStoredConnection(request);
 
        String matriculaStr = (String) request.getParameter("matricula");
        String nome = (String) request.getParameter("nome");
        String endereco = (String) request.getParameter("endereco");
        String telefone = (String) request.getParameter("telefone");
        String email = (String) request.getParameter("email");
        String rg = (String) request.getParameter("rg");
        String cpf_cnpj = (String) request.getParameter("cpf_cnpj");
        String status = (String) request.getParameter("status");
        String tipo = (String) request.getParameter("tipo");
        String tipo_emp = (String) request.getParameter("tipo_emp");
        String depto = (String) request.getParameter("depto");
        String cargo = (String) request.getParameter("cargo");
       
     	
        
        int matricula = 0;
        try {
            matricula = Integer.parseInt(matriculaStr);
        } catch (Exception e) {
        }
        
        Pessoa p = new Pessoa(matricula, nome, endereco,  telefone,  email, rg,
    			 cpf_cnpj,  status,  tipo,  tipo_emp,  depto,  cargo);
 
        String errorString = null;
 
        //String literal
        String regex = "\\w+";
 
        if (matriculaStr == null || !matriculaStr.matches(regex)) {
            errorString = "Código de matricula inválido!";
        }
 
        if (errorString == null) {
            try {
                OperBD.insertPessoa(conn, p);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("pessoa", p);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsps/pessoas/createPessoasView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/pessoas");
        }
    }
 
}
