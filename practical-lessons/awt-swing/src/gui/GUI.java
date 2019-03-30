package gui;

import java.awt.Button;
import javax.swing.*;

public class GUI {

	public static void main(String[] args) {
		Botao btnSair = new Botao();
		
		btnSair.setSize(350,80);
		btnSair.setVisible(true);
		btnSair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}