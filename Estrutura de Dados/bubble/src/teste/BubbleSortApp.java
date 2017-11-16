package teste;
import java.io.IOException;

public class BubbleSortApp {
public static void main (String args[]) throws IOException {
	
	int numeros[];	
	GeradorNumeros gn= new GeradorNumeros(); //cria��o do objeto para gera��o de n�meros
	numeros= gn.GeradorNumerosVetor(); 
	// gn.GeradorNumerosArquivo();
	 //LerArqTextoParaInt latxpi = new LerArqTextoParaInt();
	 //numeros=latxpi.getLer();	
	
	 BubbleSort bs = new BubbleSort(numeros);	
}
}
