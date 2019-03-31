

public class FilaDinamicaApp {
	
	public static void main (String args[]) {
		
	
	FilaDinamica fl = new FilaDinamica ();
	fl.enqueue("Rafael");
	fl.enqueue(1);
	fl.enqueue(3.76f);
	fl.print();
	fl.dequeue();
	fl.print();
	fl.enqueue("Unip");
	fl.print();
	fl.dequeue();
	fl.print();
	}
}
