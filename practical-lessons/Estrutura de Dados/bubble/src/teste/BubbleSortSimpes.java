package teste;
//itera��es: N-1
//compara��es: N*(N-1)/2
public class BubbleSortSimpes {

public static void main (String args[]) {
	int numeros [] = {23,4,33,45,19,12,28,40}; // n = 8
	
	int x, totalIteracoes, totalComparacoes, totalTrocas;
	totalIteracoes=0;
	totalComparacoes=0;
	totalTrocas =0;
	for (int i =1; i<numeros.length;i++) {//controle de itera��es
		for (int j= numeros.length-1; j>=i; j--) { //controle de compara��es
			if (numeros [j-1] > numeros [j]) {
				x=numeros[j-1];
				numeros[j-1]=numeros [j];
			    numeros[j]=x;
			    totalTrocas++;
			}
			totalComparacoes++;
			System.out.printf("\n %s%d","Iteração: " , i);
			//s marca lugar para String e d para n�meros inteiros. O n�mero � a tabula��o.
		      for(int k = 0; k < numeros.length; k++)
		        System.out.printf("%5d", numeros[k]);		
			
		}
		totalIteracoes++;
	}
	System.out.println("\n\nO total de iteracoes é: " + totalIteracoes + " e o total de comparacoes é de: "+ totalComparacoes + "O total de Trocas é " + totalTrocas );
}

}
