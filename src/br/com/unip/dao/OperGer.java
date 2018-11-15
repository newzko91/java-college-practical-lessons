package br.com.unip.dao;

import java.sql.*;
import br.com.unip.models.*;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OperGer {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	//Armazena conexao no atributo 'request', onde a informacao e armazenada somente durante o tempo de vida da 'request'
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	// Get the Connection object has been stored in attribute of the request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}

	// Armazena informacoes do usuario na Session.
	public static void storeLoginedUser(HttpSession session, ContaUsuario loginedUser) {
		// On the JSP can access via ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
		
	}

	// Obtém a informação do usuário armazenada na sessao
	public static ContaUsuario getLoginedUser(HttpSession session) {
		ContaUsuario loginedUser = (ContaUsuario) session.getAttribute("loginedUser");
		return loginedUser;
	}

	// Store info in Cookie
	public static void storeUserCookie(HttpServletResponse response, ContaUsuario user) {
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getLogin());
		// 1 day (Converted to seconds)
		cookieUserName.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieUserName);
	}

	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Apaga o cookie
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
		// 0 segundos indica que o cookie irá expirar imediatamente. 
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}
}
