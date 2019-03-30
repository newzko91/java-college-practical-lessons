
public class PilhaDinamicaApp {

	public static void main (String args[]) {
		
		PilhaDinamica pdin= new PilhaDinamica();
		pdin.push("Rafael");
		pdin.push(99);
		pdin.stackState();
		System.out.println("Elemento do topo: " + pdin.top());
		System.out.print(pdin.pop());
		System.out.print(pdin.pop());	
	}
}
