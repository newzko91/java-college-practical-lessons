public class Teste {
	public static void main(String[] args) {
		Quadrado quadrado = new Quadrado();
		Retangulo retangulo = new Retangulo();
		
		quadrado.setLado(5);
		quadrado.area();
		
		System.out.println(quadrado.area());
		
		retangulo.setAltura(5);
		retangulo.setBase(8);
		retangulo.area();
		
		System.out.println(retangulo.area());
		
	}
}
