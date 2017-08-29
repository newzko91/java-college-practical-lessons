package com.unip.java.mercadinho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class MercadinhoUnip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtQtdeBatata;
	private JTextField txtQtdeCenoura;
	private JTextField txtQtdeCebola;
	private JTextField txtQtdeBeterraba;
	private JTextField txtQtdePepino;
	private JTextField txtQtdePimentao;
	private JTextField txtQtdeTomate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MercadinhoUnip frame = new MercadinhoUnip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Construtor
	 */
	public MercadinhoUnip() {
		setBounds(100, 100, 448, 376);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblProdutos = new JLabel("Produto");
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblProdutos.setBounds(0, 18, 95, 23);
		getContentPane().add(lblProdutos);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblValor.setBounds(178, 18, 95, 23);
		getContentPane().add(lblValor);
		
		JLabel lblQuantidade = new JLabel("Quantidade (Kg)");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblQuantidade.setBounds(312, 18, 130, 23);
		getContentPane().add(lblQuantidade);
		
		JCheckBox chckbxBatata = new JCheckBox("Batata");
		chckbxBatata.setBounds(0, 43, 95, 23);
		getContentPane().add(chckbxBatata);
		
		JCheckBox chckbxCenoura = new JCheckBox("Cenoura");
		chckbxCenoura.setBounds(0, 67, 95, 23);
		getContentPane().add(chckbxCenoura);
		
		JCheckBox chckbxCebola = new JCheckBox("Cebola");
		chckbxCebola.setBounds(0, 92, 95, 23);
		getContentPane().add(chckbxCebola);
		
		JCheckBox chckbxBeterraba = new JCheckBox("Beterraba");
		chckbxBeterraba.setBounds(0, 117, 95, 23);
		getContentPane().add(chckbxBeterraba);
		
		JCheckBox chckbxPepino = new JCheckBox("Pepino");
		chckbxPepino.setBounds(0, 142, 95, 23);
		getContentPane().add(chckbxPepino);
		
		JCheckBox chckbxPimentao = new JCheckBox("Pimentão");
		chckbxPimentao.setBounds(0, 166, 95, 23);
		getContentPane().add(chckbxPimentao);
		
		JCheckBox chckbxTomate = new JCheckBox("Tomate");
		chckbxTomate.setBounds(0, 191, 95, 23);
		getContentPane().add(chckbxTomate);
		
		JLabel lblValorBatata = new JLabel("R$ 1.50");
		lblValorBatata.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorBatata.setBounds(178, 43, 95, 23);
		getContentPane().add(lblValorBatata);
		
		JLabel lblValorCenoura = new JLabel("R$ 2.00");
		lblValorCenoura.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorCenoura.setBounds(178, 67, 95, 23);
		getContentPane().add(lblValorCenoura);
		
		JLabel lblValorCebola = new JLabel("R$ 3.10");
		lblValorCebola.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorCebola.setBounds(178, 92, 95, 23);
		getContentPane().add(lblValorCebola);
		
		JLabel lblValorBeterraba = new JLabel("R$ 2.35");
		lblValorBeterraba.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorBeterraba.setBounds(178, 117, 95, 23);
		getContentPane().add(lblValorBeterraba);
		
		JLabel lblValorPepino = new JLabel("R$ 1.85");
		lblValorPepino.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorPepino.setBounds(178, 142, 95, 23);
		getContentPane().add(lblValorPepino);
		
		JLabel lblValorPimentao = new JLabel("R$ 3.00");
		lblValorPimentao.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorPimentao.setBounds(178, 166, 95, 23);
		getContentPane().add(lblValorPimentao);
		
		JLabel lblValorTomate = new JLabel("R$ 3.50");
		lblValorTomate.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTomate.setBounds(178, 191, 95, 23);
		getContentPane().add(lblValorTomate);
		
		txtQtdeBatata = new JTextField();
		txtQtdeBatata.setBounds(312, 43, 115, 23);
		getContentPane().add(txtQtdeBatata);
		txtQtdeBatata.setColumns(10);
		
		txtQtdeCenoura = new JTextField();
		txtQtdeCenoura.setColumns(10);
		txtQtdeCenoura.setBounds(312, 67, 115, 23);
		getContentPane().add(txtQtdeCenoura);
		
		txtQtdeCebola = new JTextField();
		txtQtdeCebola.setColumns(10);
		txtQtdeCebola.setBounds(312, 92, 115, 23);
		getContentPane().add(txtQtdeCebola);
		
		txtQtdeBeterraba = new JTextField();
		txtQtdeBeterraba.setColumns(10);
		txtQtdeBeterraba.setBounds(312, 117, 115, 23);
		getContentPane().add(txtQtdeBeterraba);
		
		txtQtdePepino = new JTextField();
		txtQtdePepino.setColumns(10);
		txtQtdePepino.setBounds(312, 142, 115, 23);
		getContentPane().add(txtQtdePepino);
		
		txtQtdePimentao = new JTextField();
		txtQtdePimentao.setColumns(10);
		txtQtdePimentao.setBounds(312, 166, 115, 23);
		getContentPane().add(txtQtdePimentao);
		
		txtQtdeTomate = new JTextField();
		txtQtdeTomate.setColumns(10);
		txtQtdeTomate.setBounds(312, 191, 115, 23);
		getContentPane().add(txtQtdeTomate);
		
		JSeparator separatorProdutos = new JSeparator();
		separatorProdutos.setBounds(10, 215, 432, 12);
		getContentPane().add(separatorProdutos);
		
		JLabel lblTotalAPagar = new JLabel("Total a Pagar:");
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAPagar.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblTotalAPagar.setBounds(10, 280, 432, 23);
		getContentPane().add(lblTotalAPagar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				float PrecoTotal = 0;
				
				if(chckbxBatata.isSelected()) {
					String qtdeBatata = txtQtdeBatata.getText();
					float quantidade=Float.parseFloat(qtdeBatata);
					
					PrecoTotal += quantidade*1.5;
				}
				
				if(chckbxCenoura.isSelected()) {
					String qtdeCenoura = txtQtdeCenoura.getText();
					float quantidade=Float.parseFloat(qtdeCenoura);
					
					PrecoTotal += quantidade*2;
				}
				
				if(chckbxCebola.isSelected()) {
					String qtdeCebola = txtQtdeCebola.getText();
					float quantidade=Float.parseFloat(qtdeCebola);
					
					PrecoTotal += quantidade*3.1;
				}
				
				if(chckbxBeterraba.isSelected()) {
					String qtdeBeterraba = txtQtdeBeterraba.getText();
					float quantidade=Float.parseFloat(qtdeBeterraba);
					
					PrecoTotal += quantidade*2.35;
				}
				
				if(chckbxPepino.isSelected()) {
					String qtdePepino = txtQtdePepino.getText();
					float quantidade=Float.parseFloat(qtdePepino);
					
					PrecoTotal += quantidade*1.85;
				}
				
				if(chckbxPimentao.isSelected()) {
					String qtdePimentao = txtQtdePimentao.getText();
					float quantidade=Float.parseFloat(qtdePimentao);
					
					PrecoTotal += quantidade*3;
				}
				
				if(chckbxTomate.isSelected()) {
					String qtdeTomate = txtQtdeTomate.getText();
					float quantidade=Float.parseFloat(qtdeTomate);
					
					PrecoTotal += quantidade*3.5;
				}
				
				DecimalFormat normalizar = new DecimalFormat("#,##0.00");
				String resultado = normalizar.format(PrecoTotal);
				
				lblTotalAPagar.setText("Total a Pagar: R$"+resultado);
				
			}
		});
		btnComprar.setBounds(153, 226, 129, 39);
		getContentPane().add(btnComprar);

	}

}
