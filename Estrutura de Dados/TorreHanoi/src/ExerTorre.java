import java.util.Stack;

public class ExerTorre {

	public static void main(String[] args) {
		Stack<Integer> original = new Stack<>();
		Stack<Integer> dest = new Stack<>();
		Stack<Integer> aux = new Stack<>();
		
		original.push(3);
		original.push(2);
		original.push(1);
		
		torredeHanoi(original.size(), original, dest, aux);
	}
	
	public static void torredeHanoi(int n, Stack<Integer> original,
			Stack<Integer> dest, Stack<Integer> aux) {
		if(n>0) {
			torredeHanoi(n-1,original,aux,dest);
			dest.push(original.pop());
			System.out.println("-------------");
			System.out.println("Original: " + original);
			System.out.println("Destino: " + dest);
			System.out.println("Auxiliar: " + aux);
			torredeHanoi(n-1,aux,dest,original);
		}
	}

}