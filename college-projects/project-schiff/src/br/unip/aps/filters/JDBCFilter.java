package br.unip.aps.filters;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.unip.aps.conn.APSGeneralConn;
import br.unip.aps.dao.GenOper;

@WebFilter(filterName = "JDBCFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {

	 
    public JDBCFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    // Verifica se a requisição é para um Servlet
    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");

        String servletPath = request.getServletPath();

        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
            
            urlPattern = servletPath + "/*";
        }
 
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();
 

        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
        
        if (this.needJDBC(req)) {
 
            System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            try {
               
                conn = APSGeneralConn.getConnection();
               
                conn.setAutoCommit(false);
 
                GenOper.storeConnection(request, conn);
           
                chain.doFilter(request, response);
       
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                APSGeneralConn.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
            		APSGeneralConn.closeQuietly(conn);
            }
        }
        
        else {
            
            chain.doFilter(request, response);
        	
        }
    }
}
