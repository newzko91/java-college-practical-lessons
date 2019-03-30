package adicao;

import javax.swing.JOptionPane;

public class Adicao {

	public static void main(String[] args) {
		String primeiroNumero = JOptionPane.showInputDialog("Informe o primeiro número");
		String segundoNumero = JOptionPane.showInputDialog("Informe o segundo número");
		
		int numero1 = Integer.parseInt(primeiroNumero);
		int numero2 = Integer.parseInt(segundoNumero);
		
		int sum = numero1 + numero2;
		
		JOptionPane.showMessageDialog(null, "A soma é: " + sum);
	}

}
