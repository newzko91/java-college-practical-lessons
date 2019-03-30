package entidade;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Linha extends DoisD{
	
    public static DoisD desenhaLinha(int x1, int x2, int y1, int y2, Graphics g) {
        int d = 0;
 
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; 
        int dy2 = 2 * dy;
 
        int ix = x1 < x2 ? 1 : -1; 
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
            	g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
            	g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
        
        return null;
    }
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(cor);
		g.drawLine(0, 0, largura-1, altura-1);
		

		
	}

	public Linha() {
		super();
		
	}

	public Linha(Point inicio, Point fim, int largura, int altura, boolean preenchido, Color cor) {
		super(inicio, fim, largura, altura, preenchido, cor);
		
	}
	


}
