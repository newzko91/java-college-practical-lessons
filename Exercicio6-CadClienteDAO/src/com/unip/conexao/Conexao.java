package com.unip.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static String endereco = "jdbc:mysql://localhost:3306/exercicio5";
    private static String usuario = "sqluser";
    private static String senha = "sqluserpw";
    private static String driver = "com.mysql.jdbc.Driver";

    public static void criarBanco(String hsacademia) {
        System.out.println("::: Criando Banco de Dados");
        Connection con = null;
        try {
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=sqluser&password="
                            + senha);
            java.sql.Statement statement = con.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS exercicio5");
            System.out.println("::: Banco criado!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection conectar() throws InstantiationException,
            IllegalAccessException {

        Connection connection = null;
        try {
            Class.forName(driver).newInstance();
            System.out.println("Entrando...");
            connection = DriverManager.getConnection(endereco, usuario, senha);
            System.out.println("Entrada OK");
            System.out.println("Conectado ao BD exercicio5!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void desconectar(Connection con) throws SQLException {
        try {
            if (!con.isClosed()) {
                con.close();
            }
            System.out.println("Desconectado do BD!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}