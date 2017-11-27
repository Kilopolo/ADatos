package ej10.prueba2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class WindVel extends JPanel {
//	private String horas = "09/11/2017 02:00,09/11/2017 03:00,09/11/2017 04:00,09/11/2017 05:00,09/11/2017 06:00,09/11/2017 07:00,09/11/2017 08:00,09/11/2017 09:00,09/11/2017 10:00,09/11/2017 11:00,09/11/2017 12:00,09/11/2017 13:00,09/11/2017 14:00,09/11/2017 15:00,09/11/2017 16:00,09/11/2017 17:00,09/11/2017 18:00,09/11/2017 19:00,09/11/2017 20:00,09/11/2017 21:00,09/11/2017 22:00,09/11/2017 23:00,10/11/2017 00:00,10/11/2017 01:00,10/11/2017 02:00,10/11/2017 03:00,10/11/2017 04:00,10/11/2017 05:00,10/11/2017 06:00,10/11/2017 07:00,10/11/2017 08:00,10/11/2017 09:00,10/11/2017 10:00,10/11/2017 11:00,10/11/2017 12:00,10/11/2017 13:00,10/11/2017 14:00,10/11/2017 15:00,10/11/2017 16:00,10/11/2017 17:00,12/11/2017 17:00,12/11/2017 18:00,12/11/2017 19:00,12/11/2017 20:00,12/11/2017 21:00,12/11/2017 22:00,12/11/2017 23:00,13/11/2017 00:00,13/11/2017 01:00";
//	private String velocidadesViento="3.0,4.0,2.0,5.0,3.0,3.0,0.0,0.0,0.0,0.0,0.0,-1.0,-4.0,0.0,1.0,1.0,3.0,2.0,2.0,0.0,-2.0,4.0,7.0,0.0,0.0,0.0,3.0,7.0,4.0,3.0,6.0,-3.0,0.0,3.0,-1.0,4.0,4.0,4.0,-2.0,-2.0,8.0,9.0,8.0,7.0,8.0,9.0,9.0,10.0,-12.0";
	private int proporcionY, proporcionX;
	private String[] yPointsStr, xHorasStr;
	private int[] xPoints, yPoints;
	
	
	public WindVel(String horas, String velocidadesViento) {
		// TODO Auto-generated constructor stub
	
		proporcionY = 15;
		proporcionX = 15;
		yPointsStr = velocidadesViento.split(",");
		xHorasStr = horas.split(",");
		xPoints = new int[yPointsStr.length];
		yPoints = new int[yPointsStr.length];

		for (int i = 0; i < yPointsStr.length; i++) {
			xPoints[i] = 20 + i * proporcionX;
			yPoints[i] = (int) ((Float.parseFloat(yPointsStr[i]) * proporcionY * -1) + 175);

		}
	
	
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		// GRAFICA EJE X
				for (int i = 9; i > -10; i--) {
					g.setColor(Color.WHITE);
					g.drawString(String.valueOf(i * -1), 5, 175 + (i * proporcionY));
					g.setColor(Color.darkGray);
					g.drawLine(10, 175 + (i * proporcionY), 800, 175 + (i * proporcionY));
				}
				// PARA CAMBIAR LA LEYENDA A VERTICAL
				Graphics2D g2 = (Graphics2D) g;
				Font font = new Font("Arial", Font.PLAIN, 10);
				AffineTransform affineTransform = new AffineTransform();
				affineTransform.rotate(Math.toRadians(90), 0, 0);
				Font rotatedFont = font.deriveFont(affineTransform);
				g2.setFont(rotatedFont);

				// DATOS GRAFICA
				g.setColor(Color.GREEN);
				g.drawPolyline(xPoints, yPoints, yPointsStr.length);

				// GRAFICA EJE Y Y DIAS LEYENDA
				g.setColor(Color.darkGray);
				for (int i = 0; i < xHorasStr.length; i++) {
					g.drawLine(20 + i * proporcionX, 0, 20 + i * proporcionX, 365);
				}
				g.setColor(Color.WHITE);
				for (int i = 0; i < xHorasStr.length; i++) {
					g2.drawString(xHorasStr[i], 20 + (i * proporcionX), 370);
				}
				g2.dispose();
		
	}
}
