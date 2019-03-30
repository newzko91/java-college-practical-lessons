package br.unip.aps.filters;

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


@WebFilter(filterName = "LoginFilter", urlPatterns = { "/home","/admin","/adminedit","/admincreate","/admindelete", 
		"/dashboard", "/pessoas", "/pessoasedit", "/pessoascreate", "/pessoasdelete",
		"/cargas", "/cargascreate", "/cargasdelete","/cargasedit",
		"/embarcacoescreate", "/embarcacaodelete", "/embarcacaoedit", "/embarcacoes"})
public class LoginFilter implements Filter {

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
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		
		if(session == null || session.getAttribute("loginedUser") == null) {
			res.sendRedirect(req.getContextPath() + "/login");
			System.out.println("Acesso negado!");
		} else {
            chain.doFilter(request, response);
		} 
			
	} 
	
}
