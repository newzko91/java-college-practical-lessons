import java.util.Arrays;

public class ExMerge {

	public static void main(String[] args) {
		int v[] = {4,6,7,3,5,1,2,8};
		int aux[] = new int[v.length];
		
		//Vetor, o auxiliar, o inicio e o fim do vetor
		mergeSort(v,aux,0,v.length-1);
		

	}

	private static void mergeSort(int[] v, int[] aux, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio+fim)/2;
			mergeSort(v,aux,inicio,meio);
			mergeSort(v,aux,meio+1,fim);
			
			intercalar(v,aux,inicio, meio, fim);
			System.out.println(Arrays.toString(v));
		}
		
	}

	private static void intercalar(int[] v, int[] aux, int inicio, int meio, int fim) {
		//copiando o vetor para o auxiliar
		for(int k = inicio; k<=fim; k++) {
			aux[k] = v[k];
		}
		
		int i = inicio;
		int j = meio+1;
		
		for (int k = inicio; k<=fim; k++) {
			if(i > meio) v[k] = aux[j++];
			else if(j>fim) v[k] = aux[i++];
			else if(aux[i] < aux[j]) v[k] = aux[i++];
			else v[k] = aux[j++];
		}
	}

}
