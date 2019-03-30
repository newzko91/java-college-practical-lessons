package entidade;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Retangulo extends DoisD {
	
	   public static DoisD desenhaRetangulo (float x1, float y1, float x2, float y2, Graphics g){
	        
			float x, y, dx, dy, numeroPassos,incrementaX,incrementaY;
			int i;
			

			dx = Math.abs(x2-x1);
			dy = Math.abs(y2-y1);

			if(dx>=dy)
			numeroPassos=dx;
			else
			numeroPassos=dy;

			incrementaX=dx/numeroPassos;
			incrementaY=dy/numeroPassos;

			x=x1;
			y=y1;

			i=1;

			    while(i<=numeroPassos) {        
			          g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
			          x=x+incrementaX;
			          //y=y+incrementaY;
			          i=i+1;
			    }
			i=1;
			    while(i<=numeroPassos) {        
			          g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
			          //x=x+incrementaX;
			          y=y+incrementaY;
			          i=i+1;
			    }
			    
				x=x2;
				y=y2;

				i=1;

				    while(i<=numeroPassos) {        
				          g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
				          x=x-incrementaX;
				          //y=y-incrementaY;
				          i=i+1;
						
				    }
					
				    i=1;

					    while(i<=numeroPassos) {        
					          g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
					          //x=x-incrementaX;
					          y=y-incrementaY;
					          i=i+1;
					    }
						return null;
	    	}
	
	public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.setColor(cor); //Define a cor da figura
			
			
			if(preenchido) {
				
				g.fillRect(0, 0, largura-1, altura-1);//
				
			}
			else {
				
				g.drawRect(0, 0, largura-1, altura-1);
				
			}
		}

	public Retangulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Retangulo(Point inicio, Point fim, int largura, int altura, boolean preenchido, Color cor) {
		super(inicio, fim, largura, altura, preenchido, cor);
		// TODO Auto-generated constructor stub
	}	


}
