package ej07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.TreeSet;



/**
 * Repartir los dias del fichero que conseguimos en dos nuevos ficheros: -Horas
 * en las que llueve -Horas en las que no llueve
 */
public class RepartoDiasLluvia {

	private String AEMET = "http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24";
	private static String DatosAntiguos = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\07. RepartoDiasLluvia\\DatClimDiario.txt";
	private static String fichLluvia = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\07. RepartoDiasLluvia\\fichLluvia.txt";
	private static String fichNoLluvia = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\07. RepartoDiasLluvia\\fichNoLluvia.txt";
	private URL url;
	private BufferedReader inURL, inFich;
	private BufferedWriter outFichLluvia, outFichNoLluvia;
	private ArrayList<String> lecturaURL, lecturaFich;
	private static TreeSet<Hora> horas;
	

	public static void main(String[] args) {
		RepartoDiasLluvia o = new RepartoDiasLluvia();
		o.lecturaURL();
		o.lecturaFichero(DatosAntiguos);
		o.escrituraFicheros(fichLluvia, fichNoLluvia);
		
//		for (Hora hora : horas) {
//			System.out.println(hora.toString());
//		}
	}

	private void escrituraFicheros(String fichLluvia, String fichNoLluvia) {

//		boolean prec=false;
		try {
			outFichLluvia = new BufferedWriter(new FileWriter(fichLluvia));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN EL FICHERO DE SALIDA(fichLluvia)");
		}
		try {
			outFichNoLluvia = new BufferedWriter(new FileWriter(fichNoLluvia));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN EL FICHERO DE SALIDA(fichNoLluvia)");
		}
		
		for (Hora hora : horas) {
			
			if (hora.getPrecipitacion() != 0) {
//				prec = true;
				try {
					outFichNoLluvia.write(hora.toString());
					outFichNoLluvia.newLine();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("PROBLEMA EN LA ESCRITURA DEL FICHERO DE SALIDA(fichNoLluvia)");
				}
				
			}else {
				
				try {
					outFichLluvia.write(hora.toString());
					outFichLluvia.newLine();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("PROBLEMA EN LA ESCRITURA DEL FICHERO DE SALIDA(fichLluvia)");
				}
				
			}			
		}
		
		try {
			outFichLluvia.flush();
			outFichLluvia.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outFichNoLluvia.flush();
			outFichNoLluvia.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void lecturaURL() {

		lecturaURL = new ArrayList<String>();
		horas = new TreeSet<Hora>();

		try {
			url = new URL(AEMET);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("URL MAL ESCRITA");
		}
		try {
			inURL = new BufferedReader(new InputStreamReader(url.openStream()));

			String lineaURL;
			while ((lineaURL = inURL.readLine()) != null) {
				lecturaURL.add(lineaURL);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMAS CON LA CONEXION CON AEMET");
		}
		String lineaFormat, lineaReplace;
		for (int i = 4; i < lecturaURL.size(); i++) {
			lineaFormat = lecturaURL.get(i);
			lineaReplace = lineaFormat.replaceAll("\"", "");
			try {
				Hora h = new Hora(lineaReplace.split(","));
				horas.add(h);
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("PROBLEMA AL CREAR LAS HORAS");
			}

		}

		// for (Hora hora : horas) {
		// System.out.println(hora.toString());
		// }
	}

	private void lecturaFichero(String fichero) {

		lecturaFich = new ArrayList<String>();
		try {
			inFich = new BufferedReader(new FileReader(fichero));

			String linea;
			while ((linea = inFich.readLine()) != null) {
				lecturaFich.add(linea);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA FICHERO ENTRADA");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN EL WHILE");
		}

		String lineaFormat, lineaReplace;
		for (int i = 4; i < lecturaFich.size(); i++) {
			lineaFormat = lecturaFich.get(i);
			lineaReplace = lineaFormat.replaceAll("\"", "");
			try {
				Hora h = new Hora(lineaReplace.split(","));
				horas.add(h);
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("PROBLEMA AL CREAR LAS HORAS");
			}

		}

	}

}