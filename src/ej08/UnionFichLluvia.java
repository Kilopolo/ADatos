package ej08;

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

public class UnionFichLluvia {

	private URL url;
	private static String AEMET = "http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24";
	private static String DatosAntiguos = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\08. UnionFichLluvia\\DatClimDiario.txt";
	private static String fichLluvia = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\08. UnionFichLluvia\\fichLluvia.txt";
	private static String fichNoLluvia = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\08. UnionFichLluvia\\fichNoLluvia.txt";
	private static String ficheroUnion = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\08. UnionFichLluvia\\fichUnion.txt";
	private String cabezera = "";
	private BufferedReader inURL, inFich, inFichLLuvia, inFichNoLLuvia;
	private BufferedWriter outFichDatos, outFichLluvia, outFichNoLluvia, outFichUnionLluvia;
	private ArrayList<String> lecturaURL, lecturaFich;
	private TreeSet<Hora> horas = new TreeSet<Hora>();

	public static void main(String[] args) {
		UnionFichLluvia o = new UnionFichLluvia();
		o.lecturaURL();
		o.lecturaFichDatos(DatosAntiguos);
		o.escrituraFichDatos(DatosAntiguos);
		o.escrituraFicherosLluvia(fichLluvia, fichNoLluvia);
		o.lecturaYescrituraFicherosLluvia(fichLluvia, fichNoLluvia, ficheroUnion);

	}

	private void lecturaYescrituraFicherosLluvia(String fichLluvia, String fichNoLluvia, String ficheroUnion) {

		// OPEN BUFFERS
		try {
			inFichLLuvia = new BufferedReader(new FileReader(fichLluvia));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN LECTURA FICHERO: fichLluvia");
		}
		try {
			inFichNoLLuvia = new BufferedReader(new FileReader(fichNoLluvia));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN LECTURA FICHERO: fichNoLluvia");
		}
		try {
			outFichUnionLluvia = new BufferedWriter(new FileWriter(ficheroUnion));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA AL CREAR EL ARCHIVO: ficheroUnion");
		}

		// ALGORITMO
		Hora h = null;
		Hora h2 = null;
		try {
			String lineaFichLLuvia = inFichLLuvia.readLine();
			String lineaFichNoLLuvia = inFichNoLLuvia.readLine();
			String lineaFormat, lineaFormat2;
			while (lineaFichLLuvia != null && lineaFichNoLLuvia != null) {

				lineaFormat = lineaFichLLuvia.replaceAll("\"", "");
				lineaFormat2 = lineaFichNoLLuvia.replaceAll("\"", "");
				try {
					h = new Hora(lineaFormat.split(","));
					h2 = new Hora(lineaFormat2.split(","));
				} catch (ParseException e) {
					e.printStackTrace();
					System.out.println("PROBLEMA CREAR LAS HORAS fichUnion");
				}

				if (h.getFechayHora().before(h2.getFechayHora())) {
					outFichUnionLluvia.write(h.toString());
					outFichUnionLluvia.newLine();
					lineaFichLLuvia = inFichLLuvia.readLine();

				} else {
					outFichUnionLluvia.write(h2.toString());
					outFichUnionLluvia.newLine();
					lineaFichNoLLuvia = inFichNoLLuvia.readLine();
				}

			}

			if ((lineaFichLLuvia = inFichLLuvia.readLine()) != null) {

				while ((lineaFichNoLLuvia = inFichNoLLuvia.readLine()) != null) {
					outFichUnionLluvia.write(h2.toString());
					outFichUnionLluvia.newLine();
					lineaFichNoLLuvia = inFichNoLLuvia.readLine();
				}
			} else {
				while ((lineaFichLLuvia = inFichLLuvia.readLine()) != null) {
					outFichUnionLluvia.write(h.toString());
					outFichUnionLluvia.newLine();
					lineaFichLLuvia = inFichLLuvia.readLine();
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("PROBLEMA EN EL WHILE ENTRADA FICHEROS LLUVIA");
		}

		// CLOSE BUFFERS
		try {
			inFichLLuvia.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN LA CERRADA DEL FICHERO: fichLluvia");
		}
		try {
			inFichNoLLuvia.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN LA CERRADA DEL FICHERO: fichNoLluvia");
		}
		try {
			outFichUnionLluvia.flush();
			outFichUnionLluvia.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA AL CERRAR EL FICHERO: ficheroUnion");
		}
	}

	private void escrituraFicherosLluvia(String fichLluvia, String fichNoLluvia) {

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
				try {
					outFichNoLluvia.write(hora.toString());
					outFichNoLluvia.newLine();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("PROBLEMA EN LA ESCRITURA DEL FICHERO DE SALIDA(fichNoLluvia)");
				}

			} else {

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

	private void escrituraFichDatos(String fichero) {

		try {
			outFichDatos = new BufferedWriter(new FileWriter(fichero));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA EN LA APERTURA DEL FICHERO DE DATOS");
		}

		try {
			outFichDatos.write(cabezera);
			outFichDatos.newLine();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("PROBLEMA AL ESCRIBIR LA CABEZERA");
		}

		for (Hora hora : horas) {
			try {
				outFichDatos.write(hora.toString());
				outFichDatos.newLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("PROBLEMA EN LA ESCRITURA DE DATOS EN EL FICHERO DE DATOS");
			}
		}

		try {
			outFichDatos.flush();
			outFichDatos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA AL CERRAR EL FICHERO DE DATOS");
		}

	}

	private void lecturaFichDatos(String fichero) {

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
		for (int i = 5; i < lecturaFich.size() - 1; i++) {
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

		try {
			inFich.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA AL CERRAR ENTRADA FICHERO");
		}

	}

	private void lecturaURL() {

		lecturaURL = new ArrayList<String>();

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
		// CABEZERA
		for (int i = 0; i < 4; i++) {
			cabezera = cabezera + lecturaURL.get(i) + "\n";
		}
		// CUERPO
		String lineaFormat, lineaReplace;
		for (int i = 4; i < lecturaURL.size() - 1; i++) {
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
		try {
			inURL.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA AL CERRAR ENTRADA URL");
		}

		// for (Hora hora : horas) {
		// System.out.println(hora.toString());
		// }
	}

}
