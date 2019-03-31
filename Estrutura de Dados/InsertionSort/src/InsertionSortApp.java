
public class InsertionSortApp {
	
	public static void main(String[] args) {
		int vetor[] = {23,4,33,45,19,12,28,40};
		
		System.out.println("Vetor Antes de Ser ordenado");
		
		for(int i=0; i<vetor.length;i++) {
			System.out.print(vetor[i] + " ");
		}
		
		System.out.println("\nVetor Após ser ordenado");
		
		InsertionSort is = new InsertionSort(vetor);
		
		for(int j=0; j<vetor.length;j++) {
			System.out.print(vetor[j] + " ");
		}
		
	}

	
}
