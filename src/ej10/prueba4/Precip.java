package ej10.prueba4;

import java.awt.Color;
import java.awt.Graphics;

public class Precip extends Datos{

	
	private int[]precY=null;
	private int[]precX=null;
	
	public Precip(){
		precY=new int[precipF.length];
		precX= new int[precipF.length];
		for (int i = 0; i < precipF.length; i++) {
			precY[i]= (int) (precipF[i]);
			precX[i]=i;
		}
		
	}
	//will draw whats necessary to Graphics object
    public void draw(Graphics g) {
        //draw to the graphics object here
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, 200, 500);
    	g.drawString("Precipitaciones", 300, 600);
    	g.setColor(Color.RED);
    	g.drawPolyline(precX, precY, 49);
    	
    }
	
}
