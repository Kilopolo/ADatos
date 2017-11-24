package ej10.prueba4;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGrafica extends JPanel {

	int opcion;
	Temp t = new Temp();
	Precip p = new Precip();
	
	
	public PanelGrafica(int opcion,int width,int height) {

		if (opcion == 0) {
			this.opcion = 0;
		} else if (opcion == 1) {
			this.opcion = 1;
		}
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (opcion == 0) {
			t.draw(g);// call draw method for entity and pass graphics object
		}else if (opcion == 1) {
			p.draw(g);
		}
		
	}

}