package teste;
//gravação em arquivo
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class GravarArquivo {
	
 int i;	
	public GravarArquivo(int vetor [], String caminho,String cabecalho)throws IOException {
	 FileWriter arq = new FileWriter(caminho); /*O arquivo externo bubbleNumeros.txt é aberto para operações de gravação
	   através do objeto arq instanciado e criado a partir da classe FileWriter */
	   
	   PrintWriter gravarArq = new PrintWriter(arq); //objeto que grava no arquivo texto.
	   gravarArq.printf("%s%n",cabecalho);// %s = string e %n = nova linha
	   
	   for (i=0; i<vetor.length; i++) {
	         gravarArq.printf("%d%n",vetor[i]); //%d= inteiro.
	    }	            	 
	    arq.close();	 
	    System.out.printf("O arquivo foi gravado com sucesso em: " + caminho + "\n");	
    }
}