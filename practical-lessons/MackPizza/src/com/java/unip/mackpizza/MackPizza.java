/**
 * @author T2354C-5 Gabriel Tavares de Souza
 */
package com.java.unip.mackpizza;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MackPizza extends JFrame {
	
	/**
	 * Variaveis 
	 */
	
	String[] strSabores = new String[]{" ","Mussarela", "Pepperoni", "Supreme"};
	String tamanho = "",sabor = "";
	//String[] CoberturaExtra = new String[6];
	private static final long serialVersionUID = 02;
	private JPanel painel;
	int largura = 387;
	int altura = 559;
	private JTextField txtQuantidade;
	float PrecoFinal = 0, PrecoExtras = 0; //System.out.printf("%.2f", val);
	

	
	/**
	 * Classe principal que executa a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				MackPizza frame = new MackPizza();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
	}	


	/**
	 * Construtor para criação do frame
	 */
	
	public MackPizza() {
		super("Mack Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(largura, altura);
		
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastramento de Pedidos");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setBounds(largura/2-95, 6, 191, 16);
		painel.add(lblTitulo);
		
		JLabel lblLblsaborpizza = new JLabel("Sabor da Pizza");
		lblLblsaborpizza.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblLblsaborpizza.setBounds(26, 46, 105, 16);
		painel.add(lblLblsaborpizza);
		
		JLabel lblTituloCobExtras = new JLabel("Coberturas Extras");
		lblTituloCobExtras.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblTituloCobExtras.setBounds(largura/2-60, 135, 128, 16);
		painel.add(lblTituloCobExtras);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblQuantidade.setBounds(26, 259, 85, 16);
		painel.add(lblQuantidade);
		
		JLabel lblPedidosRealizados = new JLabel("Pedidos Realizados");
		lblPedidosRealizados.setBounds(26, 350, 128, 16);
		painel.add(lblPedidosRealizados);
		
		JComboBox cmboxSabores = new JComboBox(strSabores);
		cmboxSabores.setBounds(206, 42, 175, 27);
		painel.add(cmboxSabores);
		
		JRadioButton rbIndividual = new JRadioButton("Individual");
		rbIndividual.setBounds(6, 89, 105, 23);
		painel.add(rbIndividual);
		
		JRadioButton rbRegular = new JRadioButton("Regular");
		rbRegular.setBounds(largura/2-30, 89, 90, 23);
		painel.add(rbRegular);
		
		JRadioButton rbFamilia = new JRadioButton("Familia");
		rbFamilia.setBounds(304, 89, 77, 23);
		painel.add(rbFamilia);
		
		//Para impedir que todos os 'radio button' sejam escolhidos ao mesmo tempo
		ButtonGroup grupoBotoes = new ButtonGroup();
		grupoBotoes.add(rbIndividual);
		grupoBotoes.add(rbRegular);
		grupoBotoes.add(rbFamilia);
		
		//Bloco de Checkbox
		JCheckBox cbxBacon = new JCheckBox("Bacon");
		cbxBacon.setBounds(6, 163, 69, 23);
		painel.add(cbxBacon);
		
		JCheckBox cbxTomate = new JCheckBox("Tomate");
		cbxTomate.setBounds(6, 196, 90, 23);
		painel.add(cbxTomate);
		
		JCheckBox cbxCebola = new JCheckBox("Cebola");
		cbxCebola.setBounds(142, 163, 77, 23);
		painel.add(cbxCebola);
		
		JCheckBox cbxCatupiry = new JCheckBox("Catupiry");
		cbxCatupiry.setBounds(142, 196, 128, 23);
		painel.add(cbxCatupiry);
		
		JCheckBox cbxChampignon = new JCheckBox("Champignon");
		cbxChampignon.setBounds(269, 163, 112, 23);
		painel.add(cbxChampignon);
		
		JCheckBox cbxPresunto = new JCheckBox("Presunto");
		cbxPresunto.setBounds(269, 196, 90, 23);
		painel.add(cbxPresunto);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtQuantidade.getText().length() >= 2 ) // limita o campo em 2 caracteres
		            e.consume(); 
		    }  
		});
		txtQuantidade.setBounds(142, 255, 182, 26);
		txtQuantidade.setColumns(10);
		txtQuantidade.setText("1");
		painel.add(txtQuantidade);
		
		JTextArea txtaPedidos = new JTextArea();
		txtaPedidos.setBounds(6, 371, 375, 160);
		txtaPedidos.setEditable(false);
		txtaPedidos.setLineWrap(true);
		txtaPedidos.setWrapStyleWord(true);
		painel.add(txtaPedidos);
		
		JButton btnConfirmar = new JButton("Confirmar Pedido");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PrecoFinal = 0;
				txtaPedidos.setText("");
				ArrayList<String> CoberturaExtra = new ArrayList<String>();
				
				int  quantidade =  Integer.parseInt(txtQuantidade.getText());
				
				if(cmboxSabores.getSelectedItem()=="Mussarela") {
					if(rbIndividual.isSelected()) {
						PrecoFinal += 12.00;
						tamanho = "Individual";
					} else if(rbRegular.isSelected()) {
						PrecoFinal += 21.60;
						tamanho = "Regular";
					} else if(rbFamilia.isSelected()) {
						PrecoFinal += 26.40;
						tamanho = "Familia";
					}
					sabor = "Mussarela";
				} else if(cmboxSabores.getSelectedItem()=="Pepperoni") {
					if(rbIndividual.isSelected()) {
						PrecoFinal += 15.00;
						tamanho = "Individual";
					} else if(rbRegular.isSelected()) {
						PrecoFinal += 27.00;
						tamanho = "Regular";
					} else if(rbFamilia.isSelected()) {
						PrecoFinal += 33.00;
						tamanho = "Familia";
					}
					sabor = "Pepperoni";
				} else if(cmboxSabores.getSelectedItem()=="Supreme") {
					if(rbIndividual.isSelected()) {
						PrecoFinal += 17.00;
						tamanho = "Individual";
					} else if(rbRegular.isSelected()) {
						PrecoFinal += 30.60;
						tamanho = "Regular";
					} else if(rbFamilia.isSelected()) {
						PrecoFinal += 37.40;
						tamanho = "Familia";
					}
					sabor = "Supreme";
				}
				
				//Adiciona ao preço final os ingredientes extras, caso sejam selecionados.
				if(cbxBacon.isSelected()) {
					PrecoFinal += 2.00;
					CoberturaExtra.add(cbxBacon.getText());
				} if(cbxCatupiry.isSelected()) {
					PrecoFinal += 3.00;
					CoberturaExtra.add(cbxCatupiry.getText());
				} if(cbxCebola.isSelected()) {
					PrecoFinal += 1.50;
					CoberturaExtra.add(cbxCebola.getText());
				} if(cbxChampignon.isSelected()) {
					PrecoFinal += 2.50;
					CoberturaExtra.add(cbxChampignon.getText());
				} if(cbxPresunto.isSelected()) {
					PrecoFinal += 2.50;
					CoberturaExtra.add(cbxPresunto.getText());
				} if(cbxTomate.isSelected()) {
					PrecoFinal += 1.00;
					CoberturaExtra.add(cbxTomate.getText());
				}
				
				//Três IFs em sequencia para que seja exibido três alertas no caso de preenchimento incorreto.
				if(quantidade <= 0) {
					JOptionPane.showMessageDialog(null,"Favor verificar: \n>>> Quantidade deve ser maior que 0 (zero).","Erro de Calculo",JOptionPane.ERROR_MESSAGE);
				} if(cmboxSabores.getSelectedItem()==" ") {
					JOptionPane.showMessageDialog(null,"Favor verificar: \n>>> Não foi selecionado o sabor da pizza.","Erro de Calculo",JOptionPane.ERROR_MESSAGE);
				} if (grupoBotoes.getSelection()==null) {
					JOptionPane.showMessageDialog(null,"Favor verificar: \n>>> Não foi selecionado o tamanho da pizza.","Erro de Calculo",JOptionPane.ERROR_MESSAGE);
				}
				
				PrecoFinal *= quantidade;
				
				
				DecimalFormat normalizar = new DecimalFormat("#,##0.00");
				String resultado = normalizar.format(PrecoFinal);
				
				
				txtaPedidos.setText(txtQuantidade.getText() + " " + tamanho + " " + sabor + " Pizza" + " Coberturas Extras: " + CoberturaExtra +" TOTAL = R$"+resultado);
			}
		});
		btnConfirmar.setBounds(110, 293, 153, 41);
		painel.add(btnConfirmar);
	}
	
}
