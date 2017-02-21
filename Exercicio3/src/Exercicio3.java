
public class Exercicio3 {

	public static void main(String[] args) {
		
		int contPar = 0;
		int contImpar = 0;

		
		for(int i=5;i<=13;i++) {
			if(i%2==0) {
				contPar +=1;
				continue;
			} else {
				contImpar +=1;
			}
		}
		
		System.out.println("Total de Números Pares: " + contPar);
		System.out.println("Total de Números Impares: " + contImpar);
	}

}
