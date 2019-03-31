package br.com.unip.servlets.login;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.unip.models.ContaUsuario;
import br.com.unip.dao.OperGer;
import br.com.unip.imagecompare.*;

@WebServlet(urlPatterns = { "/validarlogin" })
public class LoginServletDuploFator extends HttpServlet {
	private static final long serialVersionUID = -5163340095716020345L;

	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login/loginConfirmView.jsp");
 
        dispatcher.forward(request, response);
 
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		
    		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
    	
    	 	boolean hasError = false;
    	 	boolean validar;
    		ContaUsuario usuario = OperGer.getLoginedUser(session);
    		String testeUuario = usuario.getLogin();
    	
        String img1 = "/VOLUMES/free/UPLOAD_APS/"+  testeUuario + ".jpg";
        String img2 = "/VOLUMES/free/UPLOAD_APS/compare/"+  testeUuario+ ".jpg";
        
		File imgA = new File(img1);
		File imgB = new File(img2);
		
		
        
        System.out.println(img1);
        System.out.println(img2);
        
        try {
       	    //ImageCompare ic = new ImageCompare(img1, img2);
            //ic.setParameters(8, 6, 5, 10);
            //ic.setDebugMode(2);
            //ic.compare();
            //ic.match();
            
        		validar = TestImageCompare.compareImage(imgA, imgB);
        		
        		System.out.println(validar);
        		
        		if (validar == false) {
                hasError = true;
            
            }
        
        	
        } catch (Exception e) {
            e.printStackTrace();
            hasError = true;
        }
        
    
        if (hasError == true) {         
 
            response.sendRedirect(request.getContextPath() + "/logout");
            
        }

        else {

            response.sendRedirect(request.getContextPath() + "/home");
            
            imgB.delete();
            
        }
    }
}
