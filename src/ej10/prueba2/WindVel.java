package ej10.prueba2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WindVel extends JPanel {
	
	private String velocidadesViento="3.0,4.0,2.0,5.0,3.0,3.0,0.0,0.0,0.0,0.0,0.0,-1.0,-4.0,0.0,1.0,1.0,3.0,2.0,2.0,0.0,-2.0,4.0,7.0,0.0,0.0,0.0,3.0,7.0,4.0,3.0,6.0,-3.0,0.0,3.0,-1.0,4.0,4.0,4.0,-2.0,-2.0,8.0,9.0,8.0,7.0,8.0,9.0,9.0,10.0,-12.0";
	
	@Override
	public void paintComponent(Graphics g) {
		g.fillOval(200, 200, 200, 200);
		g.setColor(Color.BLUE);
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
