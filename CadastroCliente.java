package br.com.unip;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	String usuarioBD = "sqluser";
	String senhaBD = "sqluserpw";
	String nomeTabela = "Cliente";
	String colunasTabela = "ID,Nome";
	String urlBD = "jdbc:mysql://localhost:3306/exercicio5?autoReconnect=true&useSSL=false";
	boolean verifica = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(327, 73, 117, 29);
		contentPane.add(btnIncluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(334, 176, 117, 29);
		contentPane.add(btnAtualizar);
		
		JLabel lblCadastroClientes = new JLabel("Cadastro de Clientes");
		lblCadastroClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCadastroClientes.setBounds(6, 6, 445, 16);
		contentPane.add(lblCadastroClientes);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(6, 45, 50, 16);
		contentPane.add(lblID);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(6, 78, 50, 16);
		contentPane.add(lblNome);
		
		txtID = new JTextField();
		txtID.setBounds(60, 40, 255, 26);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 73, 255, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarDados();
			}
		});
		btnAlterar.setBounds(327, 73, 117, 29);
		contentPane.add(btnAlterar);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(58, 106, 117, 29);
		contentPane.add(btnAnterior);
		btnAnterior.setEnabled(false);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProximosDados();
			}
		});
		btnProximo.setBounds(198, 106, 117, 29);
		contentPane.add(btnProximo);
		btnProximo.setEnabled(false);
		
		JLabel lblMsg = new JLabel("Entre com os Valores!");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMsg.setBounds(6, 147, 445, 16);
		contentPane.add(lblMsg);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnterior.setEnabled(true);
				btnProximo.setEnabled(true);
				ConsultaDados(); 
			}
		});
		btnConsulta.setBounds(0, 176, 117, 29);
		contentPane.add(btnConsulta);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty() || txtNome.getText().isEmpty()) {
					lblMsg.setText("<html><font color=red>Não há dados a serem inseridos!!</font></html>");
				} else {
					InserirDados();
				}
			}
		});
		btnInserir.setBounds(113, 176, 117, 29);
		contentPane.add(btnInserir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não informado ID do cliente a ser removido!");
				} else {
					verifica = true;
					ConsultaDados();
					if(verifica) {
						ExcluirDados();
					} 
						
				}
				
			}
		});
		btnExcluir.setBounds(225, 176, 117, 29);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
			}
		});
		btnCancelar.setBounds(334, 176, 117, 29);
		contentPane.add(btnCancelar);
	}
	
	//Salva os dados no BD
	public void InserirDados() {		
		try {
			// * Drive Conector MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			// * Conexão como BD.
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// * Objeto comdo SQL.
			Statement stmt = conn.createStatement();

			// * Pega os dados informado no formulário,
			int NumeroCadastro = Integer.parseInt(txtID.getText());
			String NomeCadastro = txtNome.getText();

			// * Insere os dados do formulário no BD.
			stmt.executeUpdate("INSERT INTO "+nomeTabela+" ("+colunasTabela+") VALUES ('"+ NumeroCadastro+"','"+ NomeCadastro+"')");
			
			JOptionPane.showMessageDialog(null, "Dados Salvos!");
			
			limpaCampos();

			// * Fecha a conexão do o DB.
			conn.close();

		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

			// Trata erros de conexão.
		} catch (ClassNotFoundException Erro) {

			JOptionPane.showMessageDialog(null, "Driver não encontrado!");

		}
	}
	
	//Salva os dados no BD
	public void ExcluirDados() {	
		try {
			// * Drive Conector MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			// * Conexão como BD.
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// * Objeto comdo SQL.
			Statement stmt = conn.createStatement();

			// * Pega os dados informado no formulário,
			int NumeroCadastro = Integer.parseInt(txtID.getText());

			// * Insere os dados do formulário no BD.
			stmt.executeUpdate("DELETE FROM "+nomeTabela+" WHERE ID="+NumeroCadastro);
			JOptionPane.showMessageDialog(null, "Cliente Removido!");

			limpaCampos();

			// * Fecha a conexão do o DB.
			conn.close();

		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

			// Trata erros de conexão.
		} catch (ClassNotFoundException Erro) {

			JOptionPane.showMessageDialog(null, "Driver não encontrado!");

		}
	}
	
		//Busca os dados no BD
		public void ConsultaDados() {
			boolean consulta = true;

			try {
				// * Driver conector MySQL.
				Class.forName("com.mysql.jdbc.Driver");

				// * Conexão BD
				Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

				Statement stmt = conn.createStatement();

				// * Entras de dados no campo codigo do formulário.
				int buscaID = Integer.parseInt(txtID.getText());
				//String buscaNome = txtNome.getText();

				ResultSet RS = null;

				// Escolha a Opção de Busca.
				if (txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Infome ID para consulta!");

				} else {
					RS = stmt.executeQuery("SELECT * FROM "+nomeTabela+" WHERE ID = "+ buscaID);

					while (RS.next()) {

						// * Exibe os valore retornados na consulta.

						// * Pega a Matricula.
						int id = RS.getInt("ID");

						// * Conver inteiro para String
						txtID.setText(String.valueOf(id));

						// Pega os demais.
						txtNome.setText(RS.getString("Nome"));

						consulta = false;
					}

					if (consulta) {
						JOptionPane.showMessageDialog(null, "Dados não Encontrados!");
						txtID.setText("");
						txtNome.setText("");
						verifica = false;

					}
					RS.close();
					stmt.close();

					// * Fecha conexão com DB.
					conn.close();

				}

			} catch (SQLException Erro) {JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

			} catch (ClassNotFoundException Erro) {
				JOptionPane.showMessageDialog(null, "Driver não Encontrado!");

			}
		}
		
		//Altera os dados no BD
		public void AlterarDados() {
			try {

				// * Drive Conector MySQL.
				Class.forName("com.mysql.jdbc.Driver");

				// * Conexão como BD.
				Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

				// * Objeto comdo SQL.
				Statement stmt = conn.createStatement();

				/* Opção de Entrada para Alterar.
		int buscaID = Integer.parseInt(txtID.getText());
		String buscaNome = txtNome.getText();*/

				// * Pega os dados no formulário.
				int numeroCadastro = Integer.parseInt(txtID.getText());
				String nomeCadastro = txtNome.getText();


				// Escolha a Opção de Busca.

				int registro = stmt.executeUpdate("UPDATE Cliente SET Nome = "+"'"+nomeCadastro+"'"+"WHERE ID = "+numeroCadastro);


				if (registro != 0) {
					JOptionPane.showMessageDialog(null, "Dados Alterados!");
				} else {
					JOptionPane.showMessageDialog(null, "Dados Não Alterados!");
					stmt.close();
				}
				// * Fecha conexão com BD.
				conn.close();


			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null, "Falha no comando SQL." + Erro.getMessage());

			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Driver não encontrado");
			}
		}
		
		public void ProximosDados() {
			boolean consulta = true;

			try {
				// * Driver conector MySQL.
				Class.forName("com.mysql.jdbc.Driver");

				// * Conexão BD
				Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

				Statement stmt = conn.createStatement();

				// * Entras de dados no campo codigo do formulário.
				int buscaID = Integer.parseInt(txtID.getText());
				//String buscaNome = txtNome.getText();

				ResultSet RS = null;

				// Escolha a Opção de Busca.
				if (txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Infome ID para consulta!");

				} else {
					RS = stmt.executeQuery("SELECT * FROM "+nomeTabela);

					while (RS.next()) {

						// * Exibe os valore retornados na consulta.

						// * Pega a Matricula.
						int id = RS.getInt("ID");
						String nome = RS.getString("Nome");

						// * Conver inteiro para String
						txtID.setText(String.valueOf(id));
						txtNome.setText(nome);

						consulta = false;
					}

					if (consulta) {
						JOptionPane.showMessageDialog(null, "Dados não Encontrados!");
						txtID.setText("");
						txtNome.setText("");

					}
					RS.first();
					stmt.close();

					// * Fecha conexão com DB.
					conn.close();

				}

			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null, "Falha no comando SQL." + Erro.getMessage());

			} catch (ClassNotFoundException Erro) {
				JOptionPane.showMessageDialog(null, "Driver não Encontrado!");

			}
		}

	//Metodo para limpar os campos
	public void limpaCampos() {
		txtID.setText("");
		txtNome.setText("");
	}
}
