abstract class Bicicleta {
	private String cor = "vermelha";
	private int aro = 16;
	private double Velocidade;
	private boolean enferruja = true;
	
	abstract void VelMaxima();

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAro() {
		return aro;
	}

	public void setAro(int aro) {
		this.aro = aro;
	}

	public double getVelocidade() {
		return Velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.Velocidade = velocidade;
	}

	public boolean isEnferruja() {
		return enferruja;
	}

	public void setEnferruja(boolean enferruja) {
		this.enferruja = enferruja;
	}
}
