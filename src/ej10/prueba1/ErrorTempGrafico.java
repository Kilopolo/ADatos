package ej10;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class ErrorTempGrafico extends Canvas {

	protected static final int WIDTH = 900;
	protected static final int HEIGHT = WIDTH / 16 * 9;
	private static File f = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\10. GraficaError\\DatEnfrentados.txt");
	private BufferedReader in;
	private String linea, cabezera;
	protected TreeSet<Datos> horas = new TreeSet<Datos>();
	private TempGFX tempGfx=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErrorTempGrafico o = new ErrorTempGrafico();
		o.EntradaDatos(f);

	}

	public ErrorTempGrafico() {

		new Ventana(WIDTH, HEIGHT, "Grafico Error", this);
		if (tempGfx==null) {
			new TempGFX();
		}
		
	}



	public void EntradaDatos(File fichero) {

		// APERTURA
		try {
			in = new BufferedReader(new FileReader(fichero));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TRATADO DE DATOS
		try {
			cabezera = in.readLine();

			linea = in.readLine();
			while (linea != null) {

				Datos d = new Datos(linea.split(","));
				horas.add(d);

				linea = in.readLine();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// CIERRE
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
