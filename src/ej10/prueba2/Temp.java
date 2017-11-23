package ej10.prueba2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Temp extends JPanel {

	private MainClass m;
//	private int n = m.getnPoints();
	private int[] tempXpoints = null;
	private int[] tempYpoints = null;
	private int contPuntosX;
	private final int proporcionX, proporcionY;
//
//	public Temp() {

//		
//		for (Datos o : m.horas) {
//			tempYpoints[contPuntosX] = (int) o.getTemp() * proporcionY;
//			tempXpoints[contPuntosX] = contPuntosX * proporcionX;
//			contPuntosX++;
//		}
//
//		
//	}
	
	public Temp() {
		// TODO Auto-generated constructor stub
		proporcionY = 5;
		proporcionX = 5;
		contPuntosX = m.getnPoints();
		
		for (int i = 0; i < contPuntosX ; i++) {
			System.out.println(i);
		}
	
	}

	@Override
	public void paintComponent(Graphics g) {

		g.setColor(Color.GREEN);
//		g.drawPolyline(tempXpoints, tempYpoints, n);
		g.fillRect(200, 200, 30, 400);
	}

}
