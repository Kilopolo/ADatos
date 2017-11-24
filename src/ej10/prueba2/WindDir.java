package ej10.prueba2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WindDir extends JPanel {
	private String direccionesViento="Sudoeste,Sudoeste,Sudoeste,Sudoeste,Real: Sudoeste / Prevision: Sur.,Real: Sudoeste / Prevision: Sur.,Real: Sudoeste / Prevision: Sur.,Real: Sudoeste / Prevision: Sur.,Sur,Real: Sudoeste / Prevision: Sur.,Real: Sur / Prevision: Noroeste.,Real: Sureste / Prevision: Noroeste.,Real: Sudoeste / Prevision: Noroeste.,Real: Sudoeste / Prevision: Oeste.,Real: Sudoeste / Prevision: Oeste.,Real: Oeste / Prevision: Sudoeste.,Real: Oeste / Prevision: Noroeste.,Oeste,Oeste,Oeste,Real: Oeste / Prevision: Sudoeste.,Oeste,Noroeste,Real: Norte / Prevision: Oeste.,Real: Noroeste / Prevision: Oeste.,Oeste,Real: Oeste / Prevision: Noroeste.,Real: Sudoeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Noroeste,Real: Sudoeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Noroeste / Prevision: Oeste.,Real: Noroeste / Prevision: Oeste.,Noroeste,Real: Noroeste / Prevision: Oeste.,Real: Noroeste / Prevision: Sudoeste.,Noroeste,Noroeste,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Real: Oeste / Prevision: Noroeste.,Noroeste,Real: Noroeste / Prevision: Nordeste.";
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.fillOval(200, 200, 200, 200);
		g.setColor(Color.WHITE);
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
