
public class FilaDinamica {
	NoSimples comeco; // Come�o de fila
	NoSimples fim; // Fim de fila
	int total; // Total de elementos da fila

	public FilaDinamica() { // construtor
		comeco = null;
		fim = null;
		total = 0;
	}

	public boolean isEmpty() {
		return (total == 0);
	}

	public void enqueue(Object x) {
		NoSimples novo = new NoSimples(); // Cria um novo n�
		novo.setObjeto(x); // Coloca o objeto dentro do n�
		novo.setProx(null); // Como esse ser� o �ltimo da fila n�o tem pr�ximo
		if (isEmpty()) {
			comeco = novo; // Como estava vazia, esse n� ser� come�o e fim
			fim = comeco;
		} else {
			fim.setProx(novo); // Depois do fim da fila atual, o novo n�
			fim = novo; // O novo fim � o novo n�
		}
		total++; // Incrementa o n�mero de elementos
	}

	public Object dequeue() {
		Object resp = null;
		if (!isEmpty()) {
			resp = comeco.getObjeto(); // Captura o objeto do come�o da Fila
			comeco = comeco.getProx(); // O come�o anda para o pr�ximo
			total--; // Decrementa n�mero de elementos
			return resp;
		}
		return resp;
	}

	public void print() {
		if (isEmpty())
			System.out.println("Fila Vazia!");
		else {
			NoSimples aux;
			String saida = "";
			aux = comeco;
			while (aux != null) {
				saida += aux.getObjeto().toString() + ", ";
				aux = aux.getProx();
			}
			System.out.println("F:[ " + saida + "]");
		}
	}
}
