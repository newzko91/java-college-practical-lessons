
public class Fila {
	private int tamanho;
	private int[] fila;
	private int inicio;
	private int fim;
	private int quantidadeElementos;

	public Fila(int tamanho) {
		this.tamanho = tamanho;
		fila = new int[tamanho];
		inicio = 0;
		fim = 0;
		quantidadeElementos = 0;
	}

	public void enqueue(int elemento) {

		if (!isFull()) {
			fila[fim] = elemento;
			fim = (fim + 1) % tamanho;
			quantidadeElementos++;
		} else
			System.out.println("Fila cheia!!!");
	}

	public int dequeue() {
		int temp = fila[inicio];
		inicio = (inicio + 1) % tamanho;
		quantidadeElementos--;
		return temp;
	}

	public boolean isEmpty() {
		return (quantidadeElementos == 0);
	}

	public boolean isFull() {
		return (quantidadeElementos == tamanho);
	}

	public void printQueue() {
		int i;
		if (!isEmpty()) {
			String estadoFila = "";
			int contador = inicio;
			for (i = 0; i < quantidadeElementos; i++) {
				estadoFila = estadoFila + fila[contador] + ",";
				contador++;
				contador = contador % tamanho;
			}
			System.out.println("O estado da fila �: " + estadoFila);
		} else
			System.out.println("Fila vazia");
	}
}