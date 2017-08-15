package gui;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Botao extends JFrame {
	private JButton sair;
	
	public Botao() {
		super("Criando botoes");
		
		sair = new JButton("SAIR");
		add(sair);
	}
}
