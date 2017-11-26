package ej10.prueba2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class WindDir extends JPanel {
//	private String horas = "09/11/2017 02:00,09/11/2017 03:00,09/11/2017 04:00,09/11/2017 05:00,09/11/2017 06:00,09/11/2017 07:00,09/11/2017 08:00,09/11/2017 09:00,09/11/2017 10:00,09/11/2017 11:00,09/11/2017 12:00,09/11/2017 13:00,09/11/2017 14:00,09/11/2017 15:00,09/11/2017 16:00,09/11/2017 17:00,09/11/2017 18:00,09/11/2017 19:00,09/11/2017 20:00,09/11/2017 21:00,09/11/2017 22:00,09/11/2017 23:00,10/11/2017 00:00,10/11/2017 01:00,10/11/2017 02:00,10/11/2017 03:00,10/11/2017 04:00,10/11/2017 05:00,10/11/2017 06:00,10/11/2017 07:00,10/11/2017 08:00,10/11/2017 09:00,10/11/2017 10:00,10/11/2017 11:00,10/11/2017 12:00,10/11/2017 13:00,10/11/2017 14:00,10/11/2017 15:00,10/11/2017 16:00,10/11/2017 17:00,12/11/2017 17:00,12/11/2017 18:00,12/11/2017 19:00,12/11/2017 20:00,12/11/2017 21:00,12/11/2017 22:00,12/11/2017 23:00,13/11/2017 00:00,13/11/2017 01:00";
//	private String direccionesViento="Sudoeste,Sudoeste,Sudoeste,Sudoeste,Real: Sudoeste / Prevision: Sur.,Real: Sudoeste / Prevision: Sur.,Real: Sudoeste / Prevision: Sur.,Real: Sudoeste / Prevision: Sur.,Sur,Real: Sudoeste / Prevision: Sur.,Real: Sur / Prevision: Noroeste.,Real: Sureste / Prevision: Noroeste.,Real: Sudoeste / Prevision: Noroeste.,Real: Sudoeste / Prevision: Oeste.,Real: Sudoeste / Prevision: Oeste.,Real: Oeste / Prevision: Sudoeste.,Real: Oeste / Prevision: Noroeste.,Oeste,Oeste,Oeste,Real: Oeste / Prevision: Sudoeste.,Oeste,Noroeste,Real: Norte / Prevision: Oeste.,Real: Noroeste / Prevision: Oeste.,Oeste,Real: Oeste / Prevision: Noroeste.,Real: Sudoeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Noroeste,Real: Sudoeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Noroeste / Prevision: Oeste.,Real: Noroeste / Prevision: Oeste.,Noroeste,Real: Noroeste / Prevision: Oeste.,Real: Noroeste / Prevision: Sudoeste.,Noroeste,Noroeste,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Noroeste,Real: Noroeste / Prevision: Nordeste.";
	private int proporcionY, proporcionX;
	private String[] yPointsStr, xHorasStr;
	private int[] xPoints,yPointsTRUE,yPointsFALSE;
	public WindDir(String horas, String direccionesViento) {
		// TODO Auto-generated constructor stub
	
		proporcionY = 20;
		proporcionX = 15;
		yPointsStr = direccionesViento.split(",");
		xHorasStr = horas.split(",");
		xPoints = new int[yPointsStr.length];
		yPointsTRUE = new int[yPointsStr.length];
		yPointsFALSE = new int[yPointsStr.length];

		for (int i = 0; i < yPointsStr.length; i++) {
			xPoints[i] = 20 + i * proporcionX;
			//no ponemos yPoints y usamos yPointsStr
			if (yPointsStr[i].startsWith("Real")) {
				//String a tratar = "Real: Sudoeste / Prevision: Sur."
				String t2 = yPointsStr[i].substring(yPointsStr[i].indexOf("/")+13, yPointsStr[i].indexOf("."));
				String t1 = yPointsStr[i].substring(6, yPointsStr[i].indexOf("/")-1);
//				System.out.println(t1+t2);
				yPointsTRUE[i]=cambiarApuntos(t1);
				yPointsFALSE[i]=cambiarApuntos(t2);
			}else {
				//aki siempre true y nunca false ya que es igual q la prediccion
				yPointsTRUE[i]=cambiarApuntos(yPointsStr[i]);
				yPointsFALSE[i]=cambiarApuntos(yPointsStr[i]);
			}
		}
	
	}
	
	private int cambiarApuntos(String direccion) {
		// TODO Auto-generated method stub
		if (direccion.equalsIgnoreCase("Norte")) {
			return 1;
		}else if (direccion.equalsIgnoreCase("Noreste")) {
			return 2;
		}else if (direccion.equalsIgnoreCase("Noroeste")) {
			return 8;
		}else if (direccion.equalsIgnoreCase("Este")) {
			return 3;
		}else if (direccion.equalsIgnoreCase("Oeste")) {
			return 7;
		}else if (direccion.equalsIgnoreCase("Sureste")) {
			return 4;
		}else if (direccion.equalsIgnoreCase("Sudoeste")) {
			return 6;
		}else if (direccion.equalsIgnoreCase("Sur")) {
			return 5;
		}else return 0;
		
		
	}
	/**0 fallo
	 *1 Norte		o	o	x
	 *2 Noreste  o
	 *3 Este					o		
	 *4 Sureste  x
	 *5 Sur						o
	 *6 Sudoeste		x
	 *7 Oeste						o
	 *8 Noroeste					x
	 * 			dia  dia dia dia dia dia
	 */
	@Override
	public void paintComponent(Graphics g) {
		// GRAFICA EJE X
				for (int i = 9; i > -10; i--) {
					g.setColor(Color.WHITE);
					if (i==2) g.drawString("N", 2, 175 + (i * proporcionY));
					else if (i==3) g.drawString("NE",2, 175 + (i * proporcionY));
					else if (i==4) g.drawString("E",2, 175 + (i * proporcionY));
					else if (i==5) g.drawString("SE", 2, 175 + (i * proporcionY));
					else if (i==6) g.drawString("S",2, 175 + (i * proporcionY));
					else if (i==7) g.drawString("SO", 2, 175 + (i * proporcionY));
					else if (i==8) g.drawString("O", 2, 175 + (i * proporcionY));
					else if (i==9) g.drawString("NO", 2, 175 + (i * proporcionY));
					g.setColor(Color.darkGray);
					if (i>=0) {
						g.drawLine(10, 175 + (i * proporcionY), 800, 175 + (i * proporcionY));
					}
					
				}
				
				
				//GRAFICA NUEVA
				
				for (int i = 0; i < xHorasStr.length; i++) {
					g.setColor(Color.RED);
					g.fillRect((i*proporcionX)+20,175+( yPointsFALSE[i]*proporcionY), proporcionX, proporcionY);
					g.setColor(Color.GREEN);
					g.fillRect((i*proporcionX)+20,175+( yPointsTRUE[i]*proporcionY), proporcionX, proporcionY);
						
					
					
				}
				
				// PARA CAMBIAR LA LEYENDA A VERTICAL
				Graphics2D g2 = (Graphics2D) g;
				Font font = new Font("Arial", Font.PLAIN, 10);
				AffineTransform affineTransform = new AffineTransform();
				affineTransform.rotate(Math.toRadians(90), 0, 0);
				Font rotatedFont = font.deriveFont(affineTransform);
				g2.setFont(rotatedFont);
			
				
				// GRAFICA EJE Y Y DIAS LEYENDA
				g.setColor(Color.darkGray);
				for (int i = 0; i < xHorasStr.length; i++) {
					g.drawLine(20 + i * proporcionX, 175, 20 + i * proporcionX, 365);
				}
				
				for (int i = 0; i < xHorasStr.length; i++) {
					g.setColor(Color.WHITE);
					g2.drawString(xHorasStr[i], 20 + (i * proporcionX), 370);
//					// DATOS GRAFICA ANTIGUOS
//					g.setColor(Color.GREEN);
					g2.drawString(yPointsStr[i], 20 + (i * proporcionX), 0);
					
				}
				g2.dispose();
		
	}
}
