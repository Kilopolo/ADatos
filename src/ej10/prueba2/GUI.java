package ej10.prueba2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// FECHA  , Precip=  [Diferencia]  , Temp=  [Diferencia]  , WindVel=  [Diferencia] , WindDir= [Diferencia] 

public class GUI extends JFrame implements ActionListener{

	protected static final int WIDTH = 900;
	protected static final int HEIGHT = WIDTH / 16 * 9;
	private Temp temp;
	private JButton b1,b2,b3,b4,b5;
	private JPanel menu,grafica;
	private Precip precip;
	private WindDir windDir;
	private WindVel windVel;
	
	public GUI(){
		//JFRAME
		setTitle("Grafica");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		
		//PANEL MENU
		menu = new JPanel();
		menu.setPreferredSize(new Dimension(145, HEIGHT));
		menu.setLayout(new GridLayout(5,0,0,0));
		
		add(menu,BorderLayout.EAST);
		
		b1 = new JButton("TEMPERATURA");
		b1.setActionCommand("B1");
		b1.addActionListener(this);
		menu.add(b1);
		
		b2 = new JButton("PRECIPITACIONES");
		b2.setActionCommand("B2");
		b2.addActionListener(this);
		menu.add(b2);
		
		b3 = new JButton("DIRECCION VIENTO");
		b3.setActionCommand("B3");
		b3.addActionListener(this);
		menu.add(b3);
		
		b4 = new JButton("VELOCIDAD VIENTO");
		b4.setActionCommand("B4");
		b4.addActionListener(this);
		menu.add(b4);
		
		b5 = new JButton("VOLVER");
		b5.setActionCommand("B5");
		b5.addActionListener(this);
		menu.add(b5);
		
		//PANEL GRAFICA
		grafica = new JPanel();
		grafica.setPreferredSize(new Dimension(WIDTH-150, HEIGHT));
		add(grafica, BorderLayout.WEST);
	

		temp = new Temp();
		temp.setVisible(false);
		temp.setPreferredSize(new Dimension(WIDTH-150, HEIGHT));
		grafica.add(temp);
		
		precip = new Precip();
		precip.setVisible(false);
		precip.setPreferredSize(new Dimension(WIDTH-150, HEIGHT));
		grafica.add(precip);
		
		windDir = new WindDir();
		windDir.setVisible(false);
		windDir.setPreferredSize(new Dimension(WIDTH-150, HEIGHT));
		grafica.add(windDir);
		
		windVel = new WindVel();
		windVel.setVisible(false);
		windVel.setPreferredSize(new Dimension(WIDTH-150, HEIGHT));
		grafica.add(windVel);
		
		
		
		
		grafica.setBackground(Color.BLACK);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getActionCommand().equals("B1")) {
			windDir.setVisible(false);
			windVel.setVisible(false);
			precip.setVisible(false);
			temp.setVisible(true);
			temp.repaint();
		}
		
		if(e.getActionCommand().equals("B2")) {
			windDir.setVisible(false);
			windVel.setVisible(false);
			temp.setVisible(false);
			precip.setVisible(true);
			precip.repaint();
		}
		
		if(e.getActionCommand().equals("B3")) {
			windVel.setVisible(false);
			precip.setVisible(false);
			temp.setVisible(false);
			windDir.setVisible(true);
			windDir.repaint();
		}
		
		if(e.getActionCommand().equals("B4")) {
			windDir.setVisible(false);
			precip.setVisible(false);
			temp.setVisible(false);
			windVel.setVisible(true);
			windVel.repaint();
		}
		
		if(e.getActionCommand().equals("B5")) {
			windDir.setVisible(false);
			windVel.setVisible(false);
			precip.setVisible(false);
			temp.setVisible(false);
			grafica.setBackground(Color.BLACK);
			grafica.repaint();
		}
		
		
		
	}
	

	

}
