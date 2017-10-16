package com.unip.model.dao;

import com.unip.conexao.Conexao;
import com.unip.model.entity.funcionario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class funcionarioDAO {

	Connection con;
	
	public funcionarioDAO() {
		try {
			con = Conexao.conectar();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	public void incluir(funcionario f) {
		
		PreparedStatement stmt = null;
		
		try {
            stmt = con.prepareStatement("INSERT INTO funcionario (Nome,Area)VALUES(?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getArea());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
				Conexao.desconectar(con);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
	}
	
	public void excluir(funcionario f) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE Nome = ?");
            stmt.setString(1, f.getNome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
        		try {
					Conexao.desconectar(con);
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        }
        
        

    }

    public List<funcionario> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                funcionario funcionario = new funcionario();

                funcionario.setNome(rs.getString("Nome"));
                funcionario.setArea(rs.getString("Area"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
				Conexao.desconectar(con);
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
        }

        return funcionarios;

    }

    public void alterar(funcionario f) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET Area = ? WHERE Nome = ?");
            stmt.setString(1, f.getArea());
            stmt.setString(2, f.getNome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            try {
				Conexao.desconectar(con);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

    }
    
}
