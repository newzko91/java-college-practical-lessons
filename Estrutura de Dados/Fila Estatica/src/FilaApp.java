
public class FilaApp {
	public static void main (String args[] ) {

	Fila fil= new Fila (3);
	fil.enqueue(1);
	fil.enqueue(2);
	fil.enqueue(3);
	fil.printQueue();
	fil.dequeue();
	fil.printQueue();
	fil.dequeue();
	fil.enqueue(66);
	fil.printQueue();
	fil.enqueue(99);
	fil.printQueue();
	System.out.println ("A fila est� vaiza? " +fil.isEmpty());	
	fil.dequeue();
	fil.enqueue(1005);	
	fil.printQueue();
	System.out.println ("A fila est� vaiza? " +fil.isEmpty());
	}
	
}
