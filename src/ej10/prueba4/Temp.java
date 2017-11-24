package ej10.prueba4;

import java.awt.Color;
import java.awt.Graphics;

public class Temp extends Datos {

	private int[]tmpY=null;
	private int[]tmpX=null;
	
	Temp(){
		tmpY=new int[tempF.length];
		tmpX= new int[tempF.length];
		for (int i = 0; i < tempF.length; i++) {
			tmpY[i]= (int) (tempF[i]);
			tmpX[i]=i;
		}
		
	}
	//will draw whats necessary to Graphics object
    public void draw(Graphics g) {
        //draw to the graphics object here
    	g.setColor(Color.GREEN);
    	g.fillRect(0, 0, 200, 500);
    	g.drawString("Temperatura", 300, 600);
    	g.setColor(Color.BLUE);
    	g.drawPolyline(tmpX, tmpY, 49);
    	
    }
}
