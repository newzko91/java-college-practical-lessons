package BuscaBin;

public class BuscaBinaria {
	private int valores[] = { 1, 5, 8, 24, 33, 78, 89, 90, 100 }; // obrigatoriamente ordenados

	public int buscaBin(int val) {
		int meio, inicio, fim;
		inicio = 0;
		fim = valores.length - 1;

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (val == valores[meio]) {
				return meio;
			} else {
				if (val > valores[meio]) {
					inicio = meio + 1;
				} else {
					fim = meio - 1;
				}
			}
		}
		return -1; // caso n�o encontre o elemento no vetor
	}
}
