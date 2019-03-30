package exemploawt;

import java.awt.*;
import java.awt.event.*;

public class ExemploAwt {

	public static void main(String[] args) {
		Frame janela = new Frame("Setembro");
		Label mensagem = new Label("Go Pats!");
		mensagem.setAlignment(mensagem.CENTER);
		janela.add(mensagem);
		janela.pack();
		janela.setVisible(true);
		janela.setSize(220, 85);
		//janela.setBackground("GREEN");
		
		janela.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
        {
                System.exit(0);
             }
        });

	}

}
