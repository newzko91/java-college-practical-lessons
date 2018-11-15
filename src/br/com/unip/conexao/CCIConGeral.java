package br.com.unip.conexao;

import java.sql.*;

import br.com.unip.conexao.ConexaoMySQL;

public class CCIConGeral {
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException {

		return ConexaoMySQL.getMySQLConnection();

	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
