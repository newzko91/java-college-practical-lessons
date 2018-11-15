package br.com.unip.conexao;

import java.sql.*;

public class ConexaoMySQL {
	public static Connection getMySQLConnection()
			throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName = "eventviewer";
		String userName = "sqluser";
		String password = "sqluserpw";

		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
	ClassNotFoundException {


		Class.forName("com.mysql.jdbc.Driver");

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName +"?autoReconnect=true&useSSL=false";
		/*
		 * When switching OS
		 * String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName +"?useTimezone=true&serverTimezone=UTC;
		 */
	
		
		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);

		System.out.println("Conexão ao BD efetuada!");

		return conn;
	}
}