package com.unip.view;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.unip.model.dao.funcionarioDAO;
import com.unip.model.entity.funcionario;

public class CadastroFunc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFunc frame = new CadastroFunc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroFunc() {
		initComponents();
		lerTabela();
		
	}
	
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(58, 16, 285, 159);
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "ID", "NOME", "AREA"
	             }
	        ) {
				private static final long serialVersionUID = 1L;
				boolean[] canEdit = new boolean [] {
	                false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
		table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
		contentPane.add(table);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 205, 44, 16);
		contentPane.add(lblNome);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(27, 243, 44, 16);
		contentPane.add(lblArea);
		
		txtNome = new JTextField();
		txtNome.setBounds(83, 200, 314, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtArea = new JTextField();
		txtArea.setColumns(10);
		txtArea.setBounds(83, 238, 314, 26);
		contentPane.add(txtArea);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            		btnInserirActionPerformed(evt);
            }
        });
		btnInserir.setBounds(6, 294, 117, 29);
		contentPane.add(btnInserir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
		btnExcluir.setBounds(135, 294, 117, 29);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
		btnAlterar.setBounds(266, 294, 117, 29);
		contentPane.add(btnAlterar);
		
		
	}
	
	public void lerTabela() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
		
		funcionarioDAO func = new funcionarioDAO();
		
	       for (funcionario f : func.read()) {

	            modelo.addRow(new Object[]{
	            	    f.getID(),
	                f.getNome(),
	                f.getArea()
	            });

	        }
		
		
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        if (table.getSelectedRow() != -1) {
        		
        		txtNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());  
        		txtArea.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        }

    }

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {

        if (table.getSelectedRow() != -1) {
        		
        	txtNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
    		txtArea.setText(table.getValueAt(table.getSelectedRow(), 2).toString());

        }

    }
	
    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {

        funcionario f = new funcionario();
        funcionarioDAO dao = new funcionarioDAO();

        f.setNome(txtNome.getText());
        f.setArea(txtArea.getText());
        dao.incluir(f);

        txtNome.setText("");
        txtArea.setText("");
  
        lerTabela();


    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (table.getSelectedRow() != -1) {

        	   funcionario f = new funcionario();
           funcionarioDAO dao = new funcionarioDAO();

            f.setID((int) table.getValueAt(table.getSelectedRow(), 0));
            
            dao.excluir(f);
           
            txtNome.setText("");
            txtArea.setText("");
      
            lerTabela();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um funcionario para excluir.");
        }


    }
   
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {

        if (table.getSelectedRow() != -1) {

        		funcionario f = new funcionario();
            funcionarioDAO dao = new funcionarioDAO();

            f.setArea(txtArea.getText());
            f.setNome(txtNome.getText());
            f.setID((int) table.getValueAt(table.getSelectedRow(), 0));
            dao.alterar(f);

            txtNome.setText("");
            txtArea.setText("");
      
            lerTabela();

        }


    }

}
