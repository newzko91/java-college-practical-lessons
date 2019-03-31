package br.com.unip.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.unip.models.ContaUsuario;
import br.com.unip.dao.OperGer;


@WebFilter(filterName = "FiltroAdmin", urlPatterns = {
		"/admin","/editaradmin","/criaradmin","/removerdelete",
		"/pessoas","/cadastrarpessoa","/editarpessoa","/removerpessoa",
		"/removerparticipante", "/cadastrarlocal", "/editarlocal", "/removerlocal"
		})
public class FiltroAdmin implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filtro Admin");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		ContaUsuario perfil = OperGer.getLoginedUser(session);
		
		String testeperfil = perfil.getTipoacesso();
		
		switch (testeperfil) {
		case "Membro": res.sendRedirect(req.getContextPath() + "/semacesso");
		break;
		case "Visitante": res.sendRedirect(req.getContextPath() + "/semacesso");
		break;
		case "Guia": res.sendRedirect(req.getContextPath() + "/semacesso");
		break;
		default: chain.doFilter(request, response);
		}
	} 

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
