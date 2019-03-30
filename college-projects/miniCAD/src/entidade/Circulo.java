package entidade;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Circulo extends DoisD{

	public static DoisD desenhaCirculo(int centerX, int centerY, int raio, Graphics g) {
		int p = (5 - raio * 4)/4;
		int x = 0;
		int y = raio;
 
		do {
			
			g.drawLine(Math.round(centerX + x), Math.round(centerY + y), Math.round(centerX + x), Math.round(centerY + y));
			g.drawLine(Math.round(centerX - x), Math.round(centerY + y), Math.round(centerX - x), Math.round(centerY + y));
			g.drawLine(Math.round(centerX + x), Math.round(centerY - y), Math.round(centerX + x), Math.round(centerY - y));
			g.drawLine(Math.round(centerX - x), Math.round(centerY - y), Math.round(centerX - x), Math.round(centerY - y));
			g.drawLine(Math.round(centerX + y), Math.round(centerY + x), Math.round(centerX + y), Math.round(centerY + x));
			g.drawLine(Math.round(centerX - y), Math.round(centerY + x), Math.round(centerX - y), Math.round(centerY + x));
			g.drawLine(Math.round(centerX + y), Math.round(centerY - x), Math.round(centerX + y), Math.round(centerY - x));
			g.drawLine(Math.round(centerX - y), Math.round(centerY - x), Math.round(centerX - y), Math.round(centerY - x));
			
			if (p < 0) {
				p += 2 * x + 1;
			} else {
				p += 2 * (x - y) + 1;
				y--;
			}
			x++;
		} while (x <= y);
		return null;
 
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(cor); //Define a cor da figura
		
		
		if(preenchido) {
			
			g.fillOval(0, 0, largura-1, altura-1);//fillOval � um metodo
			
		}
		else {
			
			g.drawOval(0, 0, largura-1, altura-1);
			
			
		}
		
		
		
	}

	public Circulo() {
		super();
		
	}

	public Circulo(Point inicio, Point fim, int largura, int altura, boolean preenchido, Color cor) {
		super(inicio, fim, largura, altura, preenchido, cor);
		
	}

	
	
	
}
