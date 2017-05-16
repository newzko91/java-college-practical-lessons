public class Retangulo implements Calculo {
	private double base;
	private double altura;
	
	public double area() {
		return this.base * this.altura;
	}


	public void setBase(double base) {
		this.base = base;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	/* >>Pra não usar setter and getter
	  
	Retangulo (double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	*/
	
}
