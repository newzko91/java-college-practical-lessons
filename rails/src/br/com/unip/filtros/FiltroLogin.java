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


@WebFilter(filterName = "FiltroLogin", urlPatterns = { "/home",
		"/admin","/editaradmin","/criaradmin","/removerdelete",
		"/pessoas","/cadastrarpessoa","/editarpessoa","/removerpessoa",
		"/eventos","/editarevento","/apagarevento","/criarevento",
		"/salas", "/participantesevento", "/removerparticipante", "/cadastrarparticipante",
		"/semacesso", "/meuseventos"
		})
public class FiltroLogin implements Filter {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filtro Login");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if(session == null || session.getAttribute("loginedUser") == null) {
			res.sendRedirect(req.getContextPath() + "/login");
			System.out.println("Acesso negado! Usuario nao autenticado");
		} 
		
		else {
			chain.doFilter(request, response);

			
		} 

	} 
}
