package entidade;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

public class DoisD extends JPanel {
	
	protected Point inicio;
	protected Point fim;
	protected int largura;
	protected int altura;
	protected boolean preenchido;	
	protected Color cor;
	
	
	public Point getInicio() {
		return inicio;
	}
	public void setInicio(Point inicio) {
		this.inicio = inicio;
	}
	public Point getFim() {
		return fim;
	}
	public void setFim(Point fim) {
		this.fim = fim;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public boolean isPreenchido() {
		return preenchido;
	}
	public void setPreenchido(boolean preenchido) {
		this.preenchido = preenchido;
	}
	public Color getCor() {
		return cor;
	}
	public void setCor(Color cor) {
		this.cor = cor;
	}
		
	//Construtores
	
	public DoisD(Point inicio, Point fim, int largura, int altura, boolean preenchido, Color cor) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.largura = largura;
		this.altura = altura;
		this.preenchido = preenchido;
		this.cor = cor;
	}
	
	public DoisD() {
		super();
		setOpaque(false);
	}
	
}
