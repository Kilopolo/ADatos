package ej10.prueba3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import ej10.prueba2.MainClass;

public class Grafica extends JPanel {

	int opcion;
	Temp t=new Temp();
	
	public Grafica(int opcion) {
		
		if (opcion == 0) {
			this.opcion=0;
		}else
		if (opcion == 1) {
			this.opcion=1;
		}
		
	}
	

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        t.draw(g);//call draw method for entity and pass graphics object
	    }

	


}
class Temp extends MainClass {

	   //will draw whats necessary to Graphics object
	    public void draw(Graphics g) {
	        //draw to the graphics object here
	    	
	    	g.setColor(Color.GREEN);
	    	g.fillRect(0, 0, 200, 500);
	    	g.drawString("Temperatura", 300, 600);
	    	
	    }
	}