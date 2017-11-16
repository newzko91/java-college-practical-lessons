package teste;
import javax.swing.*;

import java.io.IOException;
import java.util.*;
/*A responsabilidade desta classe é gerar números aleatórios
 *  gravando em um arquivo texto ou retornando o vetor para a classe que chamou*/

public class GeradorNumeros {
	
	 protected int vetor [];
	 String caminho= "C:\\Users\\casa\\Documents\\NumerosAleatorios.txt"; //caminho e nome do arquivo texto para saida da geração dos números.		
	 String cabecalho= "Números Únicos Aleatórios";
	
	public  boolean contem (int valor, int tam)  { // método que verifica se o valor gerado já existe no vetor
 		
		for (int i=0;i<tam;i++) {
		   if (vetor [i] == valor) {
			    return true; 
		   }		   
	    }
		return false;
	}
					
	public void GeradorNumerosArquivo () throws IOException { //gera números com saída para arquivo texto
		int i, valor;	
		int tam= Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor"));	
			vetor = new int [tam];
			System.out.println ("Criei um vetor de tamanho: " + vetor.length);		
			    Random gerador = new Random();
			    
			    for (i=0; i<vetor.length; i++) {			    	
			    	//do {
					    valor =gerador.nextInt(1000000); //gera valores aleatorios entre 0 e 999999
				    //}while(contem(valor, i));
			    	 vetor[i]=valor;			        
			    }
			    
			    GravarArquivo grava = new GravarArquivo(vetor,caminho,cabecalho);				 			   						
     }
	
	public int[] GeradorNumerosVetor () { // gera números com saída para vetor
		int i, valor;	
		int tam= Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor"));	
			vetor = new int [tam];
			System.out.println ("Criei um vetor de tamanho: " + vetor.length);		
			    Random gerador = new Random();
			    
			    for (i=0; i<vetor.length; i++) {			    	
			    	do {
					    valor =gerador.nextInt(1000000); //gera valores aleatorios entre 0 e 999999
				    }while(contem(valor, i));
			    	 vetor[i]=valor;			        
			    }			    
			    return (vetor);				 			   						
     }
	
}
