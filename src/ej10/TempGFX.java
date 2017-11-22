package ej10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class TempGFX extends ErrorTempGrafico {
	Graphics gfx;
	Image img;
	float []xpoints=new float[horas.size()];
	float []ypoints=new float[horas.size()];
	TempGFX() {
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();

	}

	public void paint(Graphics g) {

		gfx.setColor(Color.BLACK);
		gfx.fillRect(150, 0, WIDTH - 150, HEIGHT);

//		for (Datos d : horas) {
//			d.getDate();
//		}
		
		
	    int[] xs = {25, 75, 125, 85, 125, 75, 25, 65};
	    int[] ys = {50, 90, 50, 100, 150, 110, 150, 100};
	    g.drawPolyline(xs, ys, 8);

		g.drawImage(img, 0, 0, null);
	}
}
