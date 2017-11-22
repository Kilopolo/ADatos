package ej10.prueba2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Precip extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		g.fillOval(200, 200, 200, 200);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 200, 200);

//		for (Datos d : horas) {
//			d.getDate();
//		}
		
		g.setColor(Color.GREEN);
	    int[] xs = {25, 75, 125, 85, 125, 75, 25, 65};
	    int[] ys = {50, 90, 50, 100, 150, 110, 150, 100};
	    g.drawPolyline(xs, ys, 8);

		
	}
}
