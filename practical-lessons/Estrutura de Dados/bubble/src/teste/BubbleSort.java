package teste;
public class BubbleSort {

	public BubbleSort (int vetor[]) {
	int  x,i;
//pegando o tempo de execu��o do m�todo

System.out.println("Vetor ANTES da ordena��o pelo m�todo Bubble Sort");
    for( i = 0; i < vetor.length; i++){
      System.out.printf("\n%d\t%d",i, vetor[i]);
    }
		
		long tempoInicio = System.currentTimeMillis(); //retorno em milisegundos		
		
	//ordena��o Bubble
	for ( i =1; i<vetor.length;i++) {//controle de itera��es
		for (int j= vetor.length-1; j>=i; j--) { //controle de compara��es
			if (vetor [j-1] > vetor [j]) {
				x=vetor[j-1];
				vetor[j-1]=vetor [j];
			    vetor[j]=x;			
			}
		}
	}	
	
	System.out.println("\n\nVetor ordenado pelo Bubble Sort");
        System.out.println("Tempo Total em segundos: "+(System.currentTimeMillis()-tempoInicio)/1000); //dividi por 1000 para saber em segundos
    for( i = 0; i < vetor.length; i++){
      System.out.printf("\n%d\t%d",i, vetor[i]);
    }
}
}
