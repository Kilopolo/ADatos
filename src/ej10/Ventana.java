package ej10;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ventana extends Canvas{
	

	public Ventana(int width,int height, String title, ErrorTempGrafico errorTempGrafico) {
	
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(errorTempGrafico);
		frame.setVisible(true);
				
		JPanel p = new JPanel();
		
		
	}
	
}

