package ej10.prueba2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Temp extends JPanel {

//	private MainClass m;
//	private int n = m.getnPoints();
//	private int[] tempXpoints = new int[n];
//	private int[] tempYpoints = new int[n];
//	private int contPuntosX;
//	private final int proporcionX, proporcionY;
//
//	public Temp() {
//		proporcionY = 5;
//		proporcionX = 5;
//		contPuntosX = 0;
//		
//		for (Datos o : m.horas) {
//			tempYpoints[contPuntosX] = (int) o.getTemp() * proporcionY;
//			tempXpoints[contPuntosX] = contPuntosX * proporcionX;
//			contPuntosX++;
//		}
//
//		
//	}

	@Override
	public void paintComponent(Graphics g) {

		g.setColor(Color.GREEN);
//		g.drawPolyline(tempXpoints, tempYpoints, n);
		g.fillRect(200, 200, 30, 400);
	}

}
