package teste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LerArqTextoParaInt {
	String nome;
	//StringBuilder builder = new StringBuilder ();
	

	public int[] getLer() throws NumberFormatException, IOException {
	    //Passo 1, leitura do arquivo
	    ArrayList<Integer> numeros = new ArrayList<>();
		nome = JOptionPane.showInputDialog("Digite o caminho completo e nome do arquivo com extensão");		
	    try {
			FileReader arq = new FileReader (nome);// le o caminho + nome e extensão do aquivo.
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine(); /* le a primeira linha 
		     a variável linha recebe o valor null quando o processo de repetição
			 * atingir o final do arquivo texto*/
			System.out.println("\n\n\n\n\n");
						
			while (linha!=null) {				
				linha = lerArq.readLine(); // lê da segunda até a última linha
				if (linha!=null)
				   numeros.add(Integer.parseInt(linha));					
			}
			
			arq.close();
			//System.out.print(builder.toString());
			
		}catch(IOException e) {
			System.err.printf("erro na abertura do arquivo %s.\n", e.getMessage());
		}
		
	    
	    
	    //Passo 2: Converter para um int[]
	   int[] dados = new int[numeros.size()];
	   for (int i = 0; i < numeros.size(); i++) {
	      dados[i] = numeros.get(i);
	   }
	   return dados;
	}
	
	
	
}
