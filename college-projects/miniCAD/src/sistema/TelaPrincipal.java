package sistema;

import entidade.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	protected Point mousePos;
	protected JColorChooser escolheCor;
	protected Color corEscolhida = Color.WHITE;
	protected int forma = 1;
	protected Point mousePressed;
	protected Point mouseReleased;
	protected boolean preenchido = true;
	protected int x1;
	protected int y1;
	protected Point inicio = new Point();
	private ArrayList<DoisD> figuras = new ArrayList<DoisD>();
	private JTextField txtRaio;
	private JTextField txtY3;
	private JTextField txtY2;
	private JTextField txtY1;
	private JTextField txtX3;
	private JTextField txtX2;
	private JTextField txtX1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	//No Pane e no panel, foi usado absolute layout
	//nos panels menu e status foi usado group layout
	
	public TelaPrincipal() {
		setTitle("MiniCAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBounds(0, 660, 800, 62);
		contentPane.add(panelStatus);
		
		JLabel lblPosX = new JLabel("");
		lblPosX.setBackground(Color.DARK_GRAY);
		lblPosX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPosX.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosX.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "X", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblPosY = new JLabel("");
		lblPosY.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPosY.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosY.setBorder(new TitledBorder(null, "Y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnColor = new JButton("Color");		
		btnColor.setBackground(Color.WHITE);
		btnColor.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel lblQtd = new JLabel("");
		lblQtd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQtd.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtd.setBorder(new TitledBorder(null, "Qtd", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCor = new JLabel("");
		lblCor.setBackground(Color.WHITE);
		lblCor.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblFigura = new JLabel("");
		lblFigura.setBorder(new TitledBorder(null, "Figura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblFigura.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFigura.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnPreencher = new JButton("Preencher");
		
		btnPreencher.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton btnVazio = new JButton("Vazio");
		GroupLayout gl_panelStatus = new GroupLayout(panelStatus);
		gl_panelStatus.setHorizontalGroup(
			gl_panelStatus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStatus.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPosX, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPosY, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQtd, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFigura, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
					.addComponent(btnPreencher)
					.addGap(3)
					.addComponent(btnVazio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnColor)
					.addContainerGap())
		);
		gl_panelStatus.setVerticalGroup(
			gl_panelStatus.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelStatus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStatus.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPreencher, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(lblFigura, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(lblCor, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(lblQtd, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(lblPosY, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(lblPosX, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(btnVazio, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelStatus.setLayout(gl_panelStatus);
		
		JPanel panel = new JPanel();
		panel.setBounds(801, 0, 274, 722);
		contentPane.add(panel);
		
		JComboBox<String> cbxMetodo = new JComboBox<String>();
		cbxMetodo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Mouse", "Teclado"}));
		cbxMetodo.setToolTipText("");
		
		JLabel lblMtodo = new JLabel("Método:");
		
		JLabel lblX1 = new JLabel("X1: ");
		
		JLabel lblX2 = new JLabel("X2: ");
		
		JLabel lblX3 = new JLabel("X3: ");
		
		JLabel lblY1 = new JLabel("Y1: ");
		
		JLabel lblY2 = new JLabel("Y2: ");
		
		JLabel lblY3 = new JLabel("Y3: ");
		
		JLabel lblRaio = new JLabel("Raio: ");
		
		txtRaio = new JTextField();
		txtRaio.setColumns(10);
		
		txtY3 = new JTextField();
		txtY3.setColumns(10);
		
		txtY2 = new JTextField();
		txtY2.setColumns(10);
		
		txtY1 = new JTextField();
		txtY1.setColumns(10);
		
		txtX3 = new JTextField();
		txtX3.setColumns(10);
		
		txtX2 = new JTextField();
		txtX2.setColumns(10);
		
		txtX1 = new JTextField();
		txtX1.setColumns(10);
		
		
		JPanel panelDesenho = new JPanel();	
		
		panelDesenho.setBackground(Color.WHITE);
		panelDesenho.setBounds(0, 60, 800, 600);
		contentPane.add(panelDesenho);
		panelDesenho.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 800, 60);
		contentPane.add(panelMenu);
		
		JButton btnCirculo = new JButton("Circulo");
		
		
		JButton btnRetangulo = new JButton("Retangulo");
		
		JButton btnLinha = new JButton("Linha");
		
		JButton btnDesfazer = new JButton("Desfazer");
		btnDesfazer.setEnabled(false);
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		
		JButton btnTriangulo = new JButton("Triangulo");
		btnTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forma = 4;
				lblFigura.setText("Triangulo");
				
				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else if (qualMetodo.toString() == "Mouse") {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);
				} else {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);

					txtX1.setText("");
					txtX2.setText("");
					txtX3.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtY3.setText("");
					txtRaio.setText("");

					lblX1.setVisible(true);
					lblX2.setVisible(true);
					lblX3.setVisible(true);
					lblY1.setVisible(true);
					lblY2.setVisible(true);
					lblY3.setVisible(true);
					
					txtX1.setVisible(true);
					txtX2.setVisible(true);
					txtX3.setVisible(true);
					txtY1.setVisible(true);
					txtY2.setVisible(true);
					txtY3.setVisible(true);
					
				}
			}
		});
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCirculo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRetangulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLinha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTriangulo, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
					.addComponent(btnDesfazer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLimpar)
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLimpar)
							.addComponent(btnDesfazer)
							.addComponent(btnTriangulo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRetangulo, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addComponent(btnCirculo, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addComponent(btnLinha, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelMenu.setLayout(gl_panelMenu);
		
		//
		// Altera entre as figuras atraves dos bot�es
		//
		
		btnCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forma = 1;
				lblFigura.setText("Circulo");
				
				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else if (qualMetodo.toString() == "Mouse") {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);
				} else {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);

					txtX1.setText("");
					txtY1.setText("");
					txtRaio.setText("");

					lblX1.setVisible(true);
					lblY1.setVisible(true);
					lblRaio.setVisible(true);

					txtX1.setVisible(true);
					txtY1.setVisible(true);
					txtRaio.setVisible(true);
				}
				
			}
		});
		
		btnRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forma = 2;
				lblFigura.setText("Retangulo");
				
				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else if (qualMetodo.toString() == "Mouse") {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);
				} else {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);

					txtX1.setText("");
					txtX2.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtRaio.setText("");

					lblX1.setVisible(true);
					lblX2.setVisible(true);
					lblY1.setVisible(true);
					lblY2.setVisible(true);

					txtX1.setVisible(true);
					txtX2.setVisible(true);
					txtY1.setVisible(true);
					txtY2.setVisible(true);
				}
			}
		});
		
		btnLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forma = 3;
				lblFigura.setText("Linha");
				
				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else if (qualMetodo.toString() == "Mouse") {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);
				} else {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblX3.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblY3.setVisible(false);
					lblRaio.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtX3.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtY3.setVisible(false);
					txtRaio.setVisible(false);

					txtX1.setText("");
					txtX2.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtRaio.setText("");

					lblX1.setVisible(true);
					lblX2.setVisible(true);
					lblY1.setVisible(true);
					lblY2.setVisible(true);

					txtX1.setVisible(true);
					txtX2.setVisible(true);
					txtY1.setVisible(true);
					txtY2.setVisible(true);
				}
			}
		});
		
		//
		// Bot�o DESFAZER
		//
		btnDesfazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DoisD d = figuras.get(figuras.size()-1);
				figuras.remove(d);
				panelDesenho.remove(d);
				panelDesenho.repaint();
				panelDesenho.revalidate();
				lblQtd.setText(String.valueOf(figuras.size()));
				if(figuras.size()==0) {
					btnDesfazer.setEnabled(false);
				}
				
			}
		});
		
		//
		// Bot�o LIMPAR
		//
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelDesenho.removeAll();
				panelDesenho.repaint();
				figuras.clear();
				lblQtd.setText(String.valueOf(figuras.size()));
				if(figuras.size()==0) {
					btnDesfazer.setEnabled(false);
					btnLimpar.setEnabled(false);
				}
				
			}
		});
		
		
		//
		//  Captura de posi��o do MOUSE
		//
		panelDesenho.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mousePos = panelDesenho.getMousePosition();
				lblPosX.setText(String.valueOf(mousePos.x));
				lblPosY.setText(String.valueOf(mousePos.y));
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				mousePos = panelDesenho.getMousePosition();
				lblPosX.setText(String.valueOf(mousePos.x));
				lblPosY.setText(String.valueOf(mousePos.y));			
			}
		});
		
		//
		// Bot�o de preenchimento e Vazio
		//
				
		btnVazio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preenchido = false;
											
			}
		});
		
		btnPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
													
					preenchido = true;
					
			}
		});
		
		
		//
		// Cria��o das imagens
		//		
		panelDesenho.addMouseListener(new MouseAdapter() {
			@Override
			//MOUSE PRESSED
			public void mousePressed(MouseEvent arg0) {
				mousePressed = panelDesenho.getMousePosition();
			}
			
			@Override
			//MOUSE RELEASED
			public void mouseReleased(MouseEvent e) {
				mouseReleased = panelDesenho.getMousePosition();
				DoisD criar = null;
				Graphics g = panelDesenho.getGraphics();   
				g.setColor(corEscolhida);
				
				switch(forma) {
				
				
					case 1:
						criar = new Circulo();
						break;
					
					case 2:
						criar = new Retangulo();
						break;
						
					case 3:
						criar = new Linha();
						criar = Linha.desenhaLinha(mousePressed.x, mouseReleased.x, mousePressed.y, mouseReleased.y, g);
						
						break;
					case 4:
						criar = new Triangulo();
						
						break;
				}
				
				// Tratando coordenadas para poder criar a imagem em qualquer dire��o
				//Math.min atribui o menor valor na variavel
				x1 = Math.min(mouseReleased.x, mousePressed.x);
				y1 = Math.min(mouseReleased.y, mousePressed.y);
				inicio.setLocation(x1, y1);
				
				
				
				criar.setInicio(mousePressed);
				criar.setFim(mouseReleased);
				criar.setLargura(Math.abs(mouseReleased.x - mousePressed.x));//Math.abs
				criar.setAltura(Math.abs(mouseReleased.y - mousePressed.y));//Math.abs Torna o valor absoluto, sem sinal
				criar.setCor(corEscolhida);
				criar.setLocation(inicio);
				criar.setSize(criar.getLargura(), criar.getAltura());
				criar.setPreenchido(preenchido);
				
				panelDesenho.add(criar);
				panelDesenho.repaint();
				
				//Adicionar as imagens ao vetor de figuras
				
				figuras.add(criar);
				btnDesfazer.setEnabled(true);
				btnLimpar.setEnabled(true);
				lblQtd.setText(String.valueOf(figuras.size()));	
			}
		});
		
		
		//
		//   A��o do bot�o COLOR
		//
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolheCor = new JColorChooser();
				corEscolhida = JColorChooser.showDialog(null, "Escolha a cor", Color.WHITE);
				
				if( corEscolhida == null ) {
					corEscolhida = Color.BLACK;}
				
				lblCor.setBackground(corEscolhida);
				lblCor.setOpaque(true);//Tem que settar como opaco sen�o a label n�o mostra a cor				
								
			}
		});
		
		JButton btnBtnplotar = new JButton("Plotar");
		btnBtnplotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = panelDesenho.getGraphics();   
				g.setColor(corEscolhida);
				DoisD criar = null;
				
				btnLimpar.setEnabled(true);
				
				switch(forma) {
				
				
				case 1:
					criar = new Circulo();
					criar = Circulo.desenhaCirculo(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtY1.getText()),
							Integer.parseInt(txtRaio.getText()), g);
					
					figuras.add(criar);
					lblQtd.setText(String.valueOf(figuras.size()));
					btnDesfazer.setEnabled(true);
					
					txtX1.setText("");
					txtX2.setText("");
					txtX3.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtY3.setText("");
					txtRaio.setText("");
					
					break;
				
				case 2:
					criar = new Retangulo();
					criar = Retangulo.desenhaRetangulo(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtX2.getText()),
								Integer.parseInt(txtY1.getText()), Integer.parseInt(txtY2.getText()), g);
					
					figuras.add(criar);
					lblQtd.setText(String.valueOf(figuras.size()));
					btnDesfazer.setEnabled(true);
					
					txtX1.setText("");
					txtX2.setText("");
					txtX3.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtY3.setText("");
					txtRaio.setText("");
					
					break;
					
				case 3:
					criar = new Linha();
					criar = Linha.desenhaLinha(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtX2.getText()),
								Integer.parseInt(txtY1.getText()), Integer.parseInt(txtY2.getText()), g);
					
					figuras.add(criar);
					lblQtd.setText(String.valueOf(figuras.size()));
					btnDesfazer.setEnabled(true);
					
					txtX1.setText("");
					txtX2.setText("");
					txtX3.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtY3.setText("");
					txtRaio.setText("");
					break;
				case 4:
					criar = new Triangulo();
					criar = Triangulo.desenhaTriangulo(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtX2.getText()), Integer.parseInt(txtX3.getText()), 
							Integer.parseInt(txtY1.getText()), Integer.parseInt(txtY2.getText()), Integer.parseInt(txtY3.getText()), g);
					
					figuras.add(criar);
					lblQtd.setText(String.valueOf(figuras.size()));
					btnDesfazer.setEnabled(true);
					
					
					txtX1.setText("");
					txtX2.setText("");
					txtX3.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtY3.setText("");
					txtRaio.setText("");
					
					break;
				}
				
				criar.setInicio(mousePressed);
				criar.setFim(mouseReleased);
				criar.setLargura(Math.abs(mouseReleased.x - mousePressed.x));//Math.abs
				criar.setAltura(Math.abs(mouseReleased.y - mousePressed.y));//Math.abs Torna o valor absoluto, sem sinal
				criar.setCor(corEscolhida);
				criar.setLocation(inicio);
				criar.setSize(criar.getLargura(), criar.getAltura());
				criar.setPreenchido(preenchido);
				
				panelDesenho.add(criar);
				
				//Adicionar as imagens ao vetor de figuras

				
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBtnplotar, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMtodo, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxMetodo, 0, 182, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblX1)
							.addGap(18)
							.addComponent(txtX1, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblX2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtX2, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblX3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtX3, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblY1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtY1, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblY2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtY2, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblY3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtY3, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblRaio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRaio, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtodo)
						.addComponent(cbxMetodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX1)
						.addComponent(txtX1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX2)
						.addComponent(txtX2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX3)
						.addComponent(txtX3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY1)
						.addComponent(txtY1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY2)
						.addComponent(txtY2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY3)
						.addComponent(txtY3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRaio)
						.addComponent(txtRaio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
					.addComponent(btnBtnplotar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
	}
}
