public class Quadrado implements Calculo {
	private double lado;
	
	
	public double area() {
		return this.lado * this.lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	/* >>Pra não usar setter and getter
	  
	Quadrado (double lado) {
		this.lado = lado;
	}
	
	*/
	
	
}
