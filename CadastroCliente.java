/*
 * @author: Gabriel Tavares de Souza | T2354C5 && Dowglas Rodrigo R de Barros | N1113G1
 */

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
	 * Construtor do frame.
	 */
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
				if(txtID.getText().isEmpty() || txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não há dados a serem alterados. Efetue uma consulta e depois tente novamente.");
				} else {
					AlterarDados();
				}
			}
		});
		btnAlterar.setBounds(327, 40, 117, 29);
		contentPane.add(btnAlterar);

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty() || txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não há dados.");
				} else {
					AnteriorDados();
				}
			}
		});
		btnAnterior.setBounds(58, 106, 117, 29);
		btnAnterior.setEnabled(false);
		contentPane.add(btnAnterior);

		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty() && txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não há dados.");
				} else {
					ProximosDados();
				}

			}
		});
		btnProximo.setBounds(198, 106, 117, 29);
		btnProximo.setEnabled(false);
		contentPane.add(btnProximo);

		JLabel lblMsg = new JLabel("Selecione uma das opções!");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMsg.setBounds(6, 136, 445, 26);
		contentPane.add(lblMsg);


		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty() || txtNome.getText().isEmpty()) {
					lblMsg.setText("<html><font color=red>Não há dados a serem inseridos!!</font></html>");
				} else {
					InserirDados();
					btnAnterior.setEnabled(false);
					btnProximo.setEnabled(false);
				}
			}
		});
		btnIncluir.setBounds(327, 40, 117, 29);
		contentPane.add(btnIncluir);

		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não informado ID do cliente a ser buscado!");
				} else {
					btnAnterior.setEnabled(true);
					btnProximo.setEnabled(true);
					ConsultaDados(); 
				}

			}
		});
		btnConsulta.setBounds(0, 176, 117, 29);
		contentPane.add(btnConsulta);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAlterar.setVisible(false);
				btnIncluir.setVisible(true);
			}
		});
		btnInserir.setBounds(113, 176, 117, 29);
		contentPane.add(btnInserir);


		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIncluir.setVisible(false);
				btnAlterar.setVisible(true);
			}
		});
		btnAtualizar.setBounds(334, 176, 117, 29);
		contentPane.add(btnAtualizar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
				btnAnterior.setEnabled(false);
				btnProximo.setEnabled(false);
			}
		});
		btnCancelar.setBounds(327, 73, 117, 29);
		contentPane.add(btnCancelar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelar.setVisible(true);

				if(txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não informado ID do cliente a ser removido!");
				} else {
					verifica = true;
					ConsultaDados();
					if(verifica) {
						ExcluirDados();
						limpaCampos();
						btnAnterior.setEnabled(false);
						btnProximo.setEnabled(false);
					} 

				}

			}
		});
		btnExcluir.setBounds(225, 176, 117, 29);
		contentPane.add(btnExcluir);
	}

	// Salva os dados no BD
	public void InserirDados() {		
		try {
			// Drive do Banco de Dados MYSQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Efetua Conexão com o Banco
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// Objeto para execucao de comando SQL
			Statement stmt = conn.createStatement();

			// Pega os dados preenchidos nos campos texto
			int NumeroCadastro = Integer.parseInt(txtID.getText());
			String NomeCadastro = txtNome.getText();

			// Insere no Banco
			stmt.executeUpdate("INSERT INTO "+nomeTabela+" ("+colunasTabela+") VALUES ('"+ NumeroCadastro+"','"+ NomeCadastro+"')");

			JOptionPane.showMessageDialog(null, "Dados Salvos!");

			limpaCampos();

			// Fecha a conexão com o Banco
			conn.close();

		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null,"Cliente ID: "+txtID.getText()+" já está cadastrado.");

			// Trata erros de conexão.
		} catch (ClassNotFoundException Erro) {

			JOptionPane.showMessageDialog(null, "Driver não encontrado!");

		}
	}

	// Exclui do Banco
	public void ExcluirDados() {	
		try {
			// Drive do Banco de Dados MYSQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Efetua Conexão com o Banco
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// Objeto para execucao de comando SQL
			Statement stmt = conn.createStatement();

			// Pega os dados atualmente no campo txtID
			int NumeroCadastro = Integer.parseInt(txtID.getText());

			// Exclui a linha da tabela
			stmt.executeUpdate("DELETE FROM "+nomeTabela+" WHERE ID="+NumeroCadastro);
			JOptionPane.showMessageDialog(null, "Cliente Removido!");


			limpaCampos();

			// Fecha a conexão com o Banco
			conn.close();

		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

			// Trata erros de conexão.
		} catch (ClassNotFoundException Erro) {

			JOptionPane.showMessageDialog(null, "Driver não encontrado!");

		}
	}

	// Busca os dados no BD
	public void ConsultaDados() {
		boolean consulta = true;

		try {
			// Drive do Banco de Dados MYSQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Efetua Conexão com o Banco
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);
			
			// Objeto para execucao de comando SQL
			Statement stmt = conn.createStatement();

			// Salva o texto contido no campo txtText numa variavel buscaID convertendo pra Inteiro.
			int buscaID = Integer.parseInt(txtID.getText());

			ResultSet RS = null;

			// Validacao. No caso de estar vazio a consulta nao eh efetuada.
			if (txtID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Infome ID para consulta!");

			} else {
				RS = stmt.executeQuery("SELECT * FROM "+nomeTabela+" WHERE ID = "+ buscaID);

				while (RS.next()) {

					// Retorna o ID.
					int id = RS.getInt("ID");

					// Exibe o resultado no campo txtID
					txtID.setText(String.valueOf(id));

					// Exibe o resultado no campo txtNome
					txtNome.setText(RS.getString("Nome"));

					consulta = false;
				}

				if (consulta) {
					// No caso de não encontrar dados.
					JOptionPane.showMessageDialog(null, "Dados não Encontrados!");
					txtID.setText("");
					txtNome.setText("");
					verifica = false;

				}
				RS.close();
				stmt.close();

				// Fecha a conexão com o Banco
				conn.close();

			}

		} catch (SQLException Erro) {JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não Encontrado!");

		}
	}

	// Altera os dados no BD
	public void AlterarDados() {
		try {

			// Drive do Banco de Dados MYSQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Efetua Conexão com o Banco
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// Objeto para execucao de comando SQL
			Statement stmt = conn.createStatement();

			// Pega o conteudo dos campos ID e Nome
			int numeroCadastro = Integer.parseInt(txtID.getText());
			String nomeCadastro = txtNome.getText();

			// Atualiza a linha da tabela em questao
			int linha = stmt.executeUpdate("UPDATE Cliente SET Nome = "+"'"+nomeCadastro+"'"+"WHERE ID = "+numeroCadastro);


			if (linha != 0) {
				JOptionPane.showMessageDialog(null, "Dados Alterados!");
			} else {
				JOptionPane.showMessageDialog(null, "Dados Não Alterados!");
				stmt.close();
			}
			// Fecha a conexão com o Banco
			conn.close();


		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, "Falha no comando SQL." + Erro.getMessage());

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado");
		}
	}

	// Exibe a proxima linha	
	public void ProximosDados() {
		boolean consulta = true;

		try {
			// Drive do Banco de Dados MYSQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Efetua Conexão com o Banco
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// Objeto para execucao de comando SQL
			Statement stmt = conn.createStatement();
            
			// Converte o texto do campo ID para Inteiro.
			int buscaID = Integer.parseInt(txtID.getText());

			// ResultSet para percorrer as linhas da tabela
			ResultSet RS = null;

			RS = stmt.executeQuery("SELECT * FROM Cliente WHERE ID = (SELECT MIN(ID) FROM Cliente WHERE ID > "+buscaID+")");

			// Enquanto houver linhas na tabela
			while (RS.next()) {

				// Retorna o ID
				int id = RS.getInt("ID");

				// Exibe o resultado no campo ID
				txtID.setText(String.valueOf(id));

				// Exibe o resultado no campo Nome
				txtNome.setText(RS.getString("Nome"));

				consulta = false;
			}

			if (consulta) {
				//Caso esteja na ultima linha, retorna a primeira novamente
				RS = stmt.executeQuery("SELECT * FROM Cliente Limit 1");


				while (RS.next()) {

					// Retorna o ID
					int id = RS.getInt("ID");

					// Exibe o resultado no campo ID
					txtID.setText(String.valueOf(id));

					// Exibe o resultado no campo Nome
					txtNome.setText(RS.getString("Nome"));

				}
				RS.close();
				stmt.close();

				// Fecha a conexão com o Banco
				conn.close();

			}
		} catch (SQLException Erro) {JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não Encontrado!");

		}
	}

	// Exibe a linha anterior
	public void AnteriorDados() {
		boolean consulta = true;

		try {
			// Drive do Banco de Dados MYSQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Efetua Conexão com o Banco
			Connection conn = DriverManager.getConnection(urlBD, usuarioBD, senhaBD);

			// Objeto para execucao de comando SQL
			Statement stmt = conn.createStatement();

			// Converte o texto do campo ID para Inteiro.
			int buscaID = Integer.parseInt(txtID.getText());

			// ResultSet para percorrer as linhas da tabela
			ResultSet RS = null;

			// Escolha a Opção de Busca.
			if (txtID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Infome ID para consulta!");

			} else {
				RS = stmt.executeQuery("SELECT * FROM Cliente WHERE ID = (SELECT MAX(ID) FROM Cliente WHERE ID < "+buscaID+")");

				while (RS.next()) {

					// Retorna o ID
					int id = RS.getInt("ID");

					// Exibe o resultado no campo txtID
					txtID.setText(String.valueOf(id));

					// Exibe o resultado no campo txtNome
					txtNome.setText(RS.getString("Nome"));

					consulta = false;
				}

				if (consulta) {
					RS = stmt.executeQuery("SELECT * FROM Cliente ORDER BY ID DESC LIMIT 1");

					while (RS.next()) {

						// Retorna o ID
						int id = RS.getInt("ID");

						// Exibe o resultado no campo txtID
						txtID.setText(String.valueOf(id));

						// Exibe o resultado no campo txtNome
						txtNome.setText(RS.getString("Nome"));

					}
					RS.close();
					stmt.close();

					//Fecha a conexão com o Banco
					conn.close();

				}
			}
		} catch (SQLException Erro) {JOptionPane.showMessageDialog(null,"Falha no comando SQL." + Erro.getMessage());

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
