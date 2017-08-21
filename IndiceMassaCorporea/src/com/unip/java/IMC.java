/**
 * @author T2354C-5 Gabriel Tavares de Souza
 */
package com.unip.java;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.text.DecimalFormat;
import java.text.ParseException;



public class IMC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtIMC;
	protected Component frameSobre,frameAjuda;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					IMC frame = new IMC();
					frame.setVisible(true);
					frame.setTitle("Calculadora de IMC - Exercicio 1");
					frame.setLocationRelativeTo(null);
				
			}
		});
	}

	public IMC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 380);
		
		//Cria o menu e inclui o 'menu' criado na barra de menu
		JMenuBar menu = new JMenuBar();
		menu.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		setJMenuBar(menu);
		
		//Cria os itens do menu e os adiciona no 'menu' criado acima
		JMenu sobre = new JMenu("Sobre");
		sobre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				final ImageIcon icon = new ImageIcon("/Volumes/OSXFILESYS/Developer/test-database-workspace/IndiceMassaCorporea/res/about.png");
				JOptionPane.showMessageDialog(frameSobre, "Exercicio 1 da disciplina LPOO do 4o Semestre do curso Ciência da Computação.", "Sobre", JOptionPane.INFORMATION_MESSAGE,icon);
			}
		});
		menu.add(sobre);
		
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frameAjuda, "Ao informar a altura não é necessário digitar a pontuação. " + "\nAssim, ao informar uma altura de 1.75, por exemplo, basta digitar no campo da altura '175' (sem aspas)" + "\nque será convertido automaticamente com a pontuação.", "Ajuda", JOptionPane.QUESTION_MESSAGE);
			}
		});
		menu.add(ajuda);
		
		JMenu sair = new JMenu("Sair");
		sair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(NORMAL); //Fecha a janela ao ser clicado o botão Sair"
			}
		});
		menu.add(sair);
		
		
		painel = new JPanel();
		painel.setForeground(new Color(47, 79, 79));
		painel.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(painel);
		painel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Calculadora de IMC");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(203, 6, 192, 29);
		painel.add(lblTitulo);
		
		JLabel lblComoUsar = new JLabel("Informe a sua altura e seu peso nos campos abaixo e clique no botão Calcular IMC");
		lblComoUsar.setBounds(42, 35, 519, 16);
		painel.add(lblComoUsar);
		
		JLabel lblIMC = new JLabel("IMC :");
		lblIMC.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblIMC.setBounds(19, 211, 69, 16);
		painel.add(lblIMC);
		
		JLabel lblPeso = new JLabel("PESO :");
		lblPeso.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblPeso.setBounds(19, 143, 69, 16);
		painel.add(lblPeso);
		
		JLabel lblAltura = new JLabel("ALTURA :");
		lblAltura.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblAltura.setBounds(19, 85, 69, 16);
		painel.add(lblAltura);
		
		JLabel lblAlturaExemplo = new JLabel("Ex.: 1.75");
		lblAlturaExemplo.setBounds(122, 104, 61, 16);
		painel.add(lblAlturaExemplo);
		
		JLabel lblPesoExemplo = new JLabel("Ex.: 80.5");
		lblPesoExemplo.setBounds(122, 163, 61, 16);
		painel.add(lblPesoExemplo);
		
		JLabel lblMetros = new JLabel("Metros");
		lblMetros.setBounds(224, 86, 61, 16);
		painel.add(lblMetros);
		
		JLabel lblKilos = new JLabel("Kilos");
		lblKilos.setBounds(224, 144, 61, 16);
		painel.add(lblKilos);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblResultado.setBounds(310, 81, 253, 169);
		painel.add(lblResultado);
		
		JButton btnCalcular = new JButton("Calcular IMC");
		btnCalcular.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				float altura, imc, peso;
				String resultado;
				
				peso = Float.parseFloat(txtPeso.getText());
				altura = Float.parseFloat(txtAltura.getText());
				imc = peso / (altura*altura);
				
				DecimalFormat normalizar = new DecimalFormat("#.0");
				resultado = normalizar.format(imc);
				
				txtIMC.setText(resultado);
				
				if(imc > 18.6 && imc < 24.9) {
					lblResultado.setText("<html><font color='blue'>Você está dentro do peso considerado saudável. Parabéns!</font></html>");
				} else {
					if (imc < 18.6) {
						lblResultado.setText("<html><font color='green'>Você está abaixo do peso considerado saudável.</font></html>");
					} else {
						if(imc > 25) {
							lblResultado.setText("<html><font color='red'>Atenção! Você está acima do peso considerado saudável.</font></html>");
						}
					}
				}
			}
		});
		btnCalcular.setBounds(19, 271, 123, 52);
		painel.add(btnCalcular);
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtAltura.setText("");
				txtPeso.setText("");
				txtIMC.setText("");
				lblResultado.setText("");
			}
		});
		btnLimpar.setBounds(154, 271, 123, 52);
		painel.add(btnLimpar);
		
		
		try {
			MaskFormatter msk = new MaskFormatter("#.##");
			txtAltura = new JFormattedTextField(msk);
			txtAltura.setBounds(94, 81, 130, 26);
			painel.add(txtAltura);
			txtAltura.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		txtPeso = new JTextField();
		txtPeso.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtPeso.getText().length() >= 5 ) // limita o campo em 5 caracteres
		            e.consume(); 
		    }  
		});
		txtPeso.setColumns(10);
		txtPeso.setBounds(94, 139, 130, 26);
		painel.add(txtPeso);
		
		txtIMC = new JTextField();
		txtIMC.setColumns(10);
		txtIMC.setBounds(94, 207, 130, 26);
		txtIMC.setEditable(false);
		painel.add(txtIMC);
		
	}
}