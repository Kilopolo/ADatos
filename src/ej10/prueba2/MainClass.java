package ej10.prueba2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TreeSet;

public class MainClass {

	private static File Datos = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\10. GraficaError\\DatEnfrentados.txt");
	private BufferedReader in;
	private String linea, cabezera;
	private TreeSet<Datos> horas = new TreeSet<Datos>();
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);

	private int contPuntosX;
	private int nPoints;
	private String dateStr = "", tempStr = "", precipStr = "", windVelStr = "", windDirStr = "";
	int tamañoTempF = 0;

	public int getTamañoTempF() {
		return tamañoTempF;
	}

	public void setTamañoTempF(int tamañoTempF) {
		this.tamañoTempF = tamañoTempF;
	}

	public static void main(String[] args) {
		MainClass m = new MainClass();
		m.EntradaDatos(Datos);
		m.separarDatosyCrearGUI();
		

	}


	public void separarDatosyCrearGUI() {
		// TODO Auto-generated method stub
		int contador = 0;
		for (Datos o : horas) {
			if (contador == 0) {
				dateStr += o.format.format(o.getDate());
				tempStr += o.getTemp();
				precipStr += o.getPrecip();
				windVelStr += o.getWindVel();
				windDirStr += o.getWindDir();
			} else {
				dateStr += "," + o.format.format(o.getDate());
				tempStr += "," + o.getTemp();
				precipStr += "," + o.getPrecip();
				windVelStr += "," + o.getWindVel();
				windDirStr += "," + o.getWindDir();
			}

			contador++;

		}
//		 System.out.println(dateStr + "\n" + tempStr + "\n" + precipStr + "\n" +
//		 windVelStr + "\n" + windDirStr + "\n");
		GUI gui = new GUI(dateStr,tempStr,precipStr,windVelStr,windDirStr);
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

	public int getnPoints() {
		return nPoints;
	}

	public void setnPoints(int nPoints) {
		this.nPoints = nPoints;
	}

	public static File getDatos() {
		return Datos;
	}

	public BufferedReader getIn() {
		return in;
	}

	public String getLinea() {
		return linea;
	}

	public String getCabezera() {
		return cabezera;
	}

	public TreeSet<Datos> getHoras() {
		return horas;
	}

	public DateFormat getFormat() {
		return format;
	}



	public int getContPuntosX() {
		return contPuntosX;
	}

	public String getDateStr() {
		return dateStr;
	}

	public String getTempStr() {
		return tempStr;
	}

	public String getPrecipStr() {
		return precipStr;
	}

	public String getWindVelStr() {
		return windVelStr;
	}

	public String getWindDirStr() {
		return windDirStr;
	}

	public static void setDatos(File datos) {
		Datos = datos;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public void setCabezera(String cabezera) {
		this.cabezera = cabezera;
	}

	public void setHoras(TreeSet<Datos> horas) {
		this.horas = horas;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}


	public void setContPuntosX(int contPuntosX) {
		this.contPuntosX = contPuntosX;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public void setTempStr(String tempStr) {
		this.tempStr = tempStr;
	}

	public void setPrecipStr(String precipStr) {
		this.precipStr = precipStr;
	}

	public void setWindVelStr(String windVelStr) {
		this.windVelStr = windVelStr;
	}

	public void setWindDirStr(String windDirStr) {
		this.windDirStr = windDirStr;
	}
}
