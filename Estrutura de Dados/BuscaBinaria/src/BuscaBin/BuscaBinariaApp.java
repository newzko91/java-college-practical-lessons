package BuscaBin;

public class BuscaBinariaApp {
public static void main (String args[]) {
	//valores []= {1,5,8,24,33,78,89,90,100};
	
	BuscaBinaria bb= new BuscaBinaria();
	System.out.println("Buscando índice do elemento 89: "+ bb.buscaBin(89));
	System.out.println("Buscando índice do elemento 90: "+ bb.buscaBin(90));
	System.out.println("Buscando índice do elemento 1: "+ bb.buscaBin(1));
}
}
