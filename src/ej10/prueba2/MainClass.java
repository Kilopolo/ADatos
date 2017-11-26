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
	private String[] date = null;
	private String[] temp = null;
	private String[] precip = null;
	private String[] WindVel = null;
	private String[] WindDir = null;
	protected float[] tempF = null;
	private float[] precipF = null;
	private float[] windVelF = null;
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
		m.totalPuntosTreeSet();
		m.separarDatosyCrearGUI();
//		m.crearArrays();
		

	}

	public void crearArrays() {

		date = dateStr.split(",");
		temp = tempStr.split(",");
		precip = precipStr.split(",");
		WindVel = windVelStr.split(",");
		WindDir = windDirStr.split(",");
		
		
		int cont=0;
		tempF = new float[temp.length];
		for (int i = 0; i < temp.length; i++) {
			tempF[i] = Float.parseFloat(temp[i]);
			cont++;
		}
		tamañoTempF = cont;
		
		
		
		precipF = new float[precip.length];
		for (int i = 0; i < precip.length; i++) {
			precipF[i] = Float.parseFloat(precip[i]);
		}
		windVelF = new float[WindVel.length];
		for (int i = 0; i < WindVel.length; i++) {
			windVelF[i] = Float.parseFloat(WindVel[i]);
		}

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

	public void totalPuntosTreeSet() {
		int n = 0;
		for (Datos datos : horas) {
			n++;
		}
		// System.out.println(n);
		nPoints = n;
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

	public String[] getDate() {
		return date;
	}

	public String[] getTemp() {
		return temp;
	}

	public String[] getPrecip() {
		return precip;
	}

	public String[] getWindVel() {
		return WindVel;
	}

	public String[] getWindDir() {
		return WindDir;
	}

	public float[] getTempF() {
		return tempF;
	}

	public float[] getPrecipF() {
		return precipF;
	}

	public float[] getWindVelF() {
		return windVelF;
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

	public void setDate(String[] date) {
		this.date = date;
	}

	public void setTemp(String[] temp) {
		this.temp = temp;
	}

	public void setPrecip(String[] precip) {
		this.precip = precip;
	}

	public void setWindVel(String[] windVel) {
		WindVel = windVel;
	}

	public void setWindDir(String[] windDir) {
		WindDir = windDir;
	}

	public void setTempF(float[] tempF) {
		this.tempF = tempF;
	}

	public void setPrecipF(float[] precipF) {
		this.precipF = precipF;
	}

	public void setWindVelF(float[] windVelF) {
		this.windVelF = windVelF;
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
