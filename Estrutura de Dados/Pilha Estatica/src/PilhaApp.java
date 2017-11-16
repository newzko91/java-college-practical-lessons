

public class PilhaApp {

	public static void main (String args[]) {
		
		Pilha pilha = new Pilha(4);
				
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		
		System.out.println("Pilha Cheia: " +pilha.isFull());		
		System.out.println("Pilha Vazia: " +pilha.isEmpty());
		pilha.top();
		pilha.stateStack();
	
	}
	
	
}
