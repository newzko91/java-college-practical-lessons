

public class Pilha {
	private int topo;
	private Object vetor [];

	public Pilha(int tam) {
		vetor= new Object [tam];
		topo=-1; //pilha vazia
	}
	
	
	public void top() {
		if (isEmpty()==true) {
			System.out.println("Pilha Vazia");
		}
		else { 		
		   System.out.println("Elemento do topo: " + vetor[topo]);		
	    }	
	}
	
	public boolean isFull () {
		return (topo==vetor.length-1);		
	}	
	
		
	public boolean isEmpty() {
		return (topo==-1);
	}
	
	
	public void push(Object elemento)
	{
		if (isFull()==false) {
		topo++;
		vetor[topo]=elemento;
    	}
		else {
			System.out.println("Pilha cheia n�o � poss�vel a inser��o de novos elementos");
		    System.exit(0);
	    }
	}
	
	public void pop() {
		if(isEmpty()) {		   
			System.out.println("Imposs�vel remover, pilha Vazia!!!");	
			System.exit(0);
	    }
		else {
		   	   topo--;	   
		}		
	}
	
	public void stateStack () {		
		String s= new String();
		s="[ ";
		for (int i =topo;i>=0;i--) {
			s= s+ vetor[i] + " | ";
		}
		s=s+" ]";
		System.out.println("O estado da pilha eh: "+s);
	}	
}
