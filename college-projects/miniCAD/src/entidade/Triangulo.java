package entidade;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Triangulo extends DoisD{

	 int x=0;
	 int y=0;
	 
	private static final long serialVersionUID = 1L;

  public static DoisD desenhaTriangulo (int x1, int x2,int x3, int y1,int y2,int y3,Graphics g){
    	
		Linha.desenhaLinha(x1, x2, y1, y2, g);
		Linha.desenhaLinha(x1, x3, y1, y3, g);
		Linha.desenhaLinha(x2, x3, y2, y3, g);
    	return null;
    }


  
  public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(cor); //Define a cor da figura

		
		if(preenchido) {
			
			//largura x | altura y
			/*
			 * x1 100 x2 200 x3 300
			 * y1 200 y2 300 y3 100
			 * 
			 */
			
			//g.drawLine(0, 0, largura-1, altura-1);
			Linha.desenhaLinha(inicio.x, inicio.y, fim.x, fim.y, g);
			//Linha.desenhaLinha(x+(largura/2)-1, y+altura-1, x-(largura/2)-1, y+altura-1, g);
			//Linha.desenhaLinha(x, y, x-(largura/2)-1, y+altura-1, g);
			
		}
		else {
			
			Linha.desenhaLinha(inicio.x, inicio.y, fim.x, fim.y, g);
			
		}
	}
  
 

	public Triangulo() {
		super();
		
	}

	public Triangulo(Point inicio, Point fim, int largura, int altura, boolean preenchido, Color cor) {
		super(inicio, fim, largura, altura, preenchido, cor);
		
	}
	
	


}
