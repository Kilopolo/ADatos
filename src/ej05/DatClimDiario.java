package ej05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TreeSet;

/**
 * ---------------------PROBLEMA------------------------- mejorar el programa
 * que ya tenemos para que nos guarde al final del archivo es decir que si lo
 * abrimos para escritura se nos borra los dias anteriores y si existe o no
 * existe usar un modo de apertura u otro. necesitamos que nos guarde las lineas
 * de apertura solo una vez ya que no es necesario repetir informacion. buscar
 * del archivo File como hacer para abrir y que escriba a final del archivo no
 * queremos datos duplicados. p.ej. si o abrimos a las 7pm y luego a las 9pm.
 * hacer que no haya datos duplicados
 */
public class DatClimDiario {
	// private final Path path = Paths.get( "D:\\Google
	// Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\05.
	// DatClimDiario\\DatClimDiario.txt");
	// private URL url = new URL(
	// "http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
	private TreeSet<Hora> lineasFinales = new TreeSet<Hora>();
	private ArrayList<String>  lineasLocales, lineasLocalesCopia, lineasURL = new ArrayList<String>();
	private String lineatemp, inputLine, inputLineLocal, inputLineLocalCopia, inSyso = "";
	private static String fichero = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\05. DatClimDiario\\DatClimDiario.txt";
	private static String ficheroCopia = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\05. DatClimDiario\\DatClimDiarioCopia.txt";
	private String splitBy = ",";
	private BufferedReader in, inLocal, inComparaUrl, inLocalCopia;
	private BufferedWriter out, outLocal;
	private File f;
	private String Cabezera="";

	public static void main(String[] args) {
		DatClimDiario d = new DatClimDiario();

		d.lecturaDatosURL();
		
	
//		System.out.println("FIN URL-------------------------");

		d.leerFicheroLocalCopia(ficheroCopia);//para comprobar que funciona sin esperar a aemet 
//		System.out.println("FIN FICHERO LOCAL COPIA------17/10/2017 19:00--------");	
		d.leerFicheroLocal(fichero);
		d.escribirDatosFichero();
		d.escribirDatosFicheroCopia();
		d.leerFicheroLocal(fichero);
		d.sacarPantallaFichLocal(fichero);

	}

	// metodo para poder comprobar que almacena bien las horas en el archivo final
	private void leerFicheroLocalCopia(String ficheroCopia) {

		try {
			inLocalCopia = new BufferedReader(new FileReader(ficheroCopia));
			//array temporal para almacenar todas las lineas del archivo
			ArrayList<String>lineas = new ArrayList<String>();
			while (inLocalCopia.ready() == true) {
				inputLineLocalCopia = inLocalCopia.readLine();
				
				lineas.add(inputLineLocalCopia);

			}

			// vamos leyendo el arraylist
			for (int i = 0; i < lineas.size(); i++) {
				// lo vamos almacenando en un string temporal
				lineatemp = lineas.get(i);
				// quitamos las comillas de cada linea temporal
				String lineaSinComillas = lineatemp.replaceAll("\"", "");

				try {
					// creamos un objeto Dia usando el constructor de array
					// de Strings y lo dividimos por las comas.
					Hora d = new Hora(lineaSinComillas.split(splitBy));
					// añadimos cada objeto dia al treeSet de objetos <Dia>.
					lineasFinales.add(d);
					// para ver el treeSet nooooooob Style

				} catch (ParseException e) {
					System.out.println("Problema para crear el objeto dia.");
					e.printStackTrace();
				}

			}
			inLocalCopia.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// metodo para ver por pantalla lo que hemos conseguido
	private void sacarPantallaFichLocal(String fichero) {

		try {

			in = new BufferedReader(new FileReader(fichero));

			while ((inSyso = in.readLine()) != null) {

				System.out.println(inSyso);

			}

			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void lecturaDatosURL() {

		try {
			// abrimos los buffer de lectura del archivo en red.
			URL url = new URL(
					"http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");

			inComparaUrl = new BufferedReader(new InputStreamReader(url.openStream()));

			// abrimos el archivo en red y lo vamos almacenande en un string
			// temporal.
			while ((inputLine = inComparaUrl.readLine()) != null) {
				// cada vez que pasa por una linea me lo almacena en el
				// Arraylist
				lineasURL.add(inputLine);

			}

			
			for (int i = 0; i < 4; i++) {
				Cabezera=Cabezera+lineasURL.get(i)+"\n";
			}
			
			
			// vamos leyendo ae arraylist invertido con todas las lineas menos
			// las tres primeras para que no me salga la cabezera
			// for (int i = lineasURL.size() - 1; i > 3; i--) {
			for (int i = lineasURL.size() - 1; i > 4; i--) {

				// lo vamos almacenando en un string temporal
				lineatemp = lineasURL.get(i);
				// quitamos las comillas de cada linea temporal
				String noob = lineatemp.replaceAll("\"", "");

				try {
					// creamos un objeto Dia usando el constructor de array de
					// Strings y lo dividimos por las comas.
					Hora d = new Hora(noob.split(splitBy));
					// añadimos cada objeto dia al treeSet de objetos <Dia>.
					lineasFinales.add(d);
					// para ver el treeSet nooooooob Style

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Problema para crear el objeto dia.");
					e.printStackTrace();
				}

			}


			
			inComparaUrl.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-------------------PROBABLEMENTE NO HAY INTERNET------------------\n\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-------------------PROBABLEMENTE NO HAY INTERNET------------------\n\n");
		}

	}

	// hay que volver y arreglar cuando creamos el objeto que no nos meta los
	// objetos repetidos
	private void leerFicheroLocal(String fichero) {

		try {
			// Si el archivo no esta vacio
			if (archivoEstaVacio(fichero) == false) {

				// abrimos los buffer de lectura del archivo local
				inLocal = new BufferedReader(new FileReader(fichero));

				// leemos el archivo local mientras lo vamos almacenando en una
				// variable string temporal
				while ((inputLineLocal = inLocal.readLine()) != null) {
					// cada vez que pasa por una linea me lo almacena en el
					// Arraylist
					lineasLocales.add(inputLineLocal);

				}
				// vamos leyendo el arraylist
				for (int i = 0; i < lineasLocales.size(); i++) {
					// lo vamos almacenando en un string temporal
					lineatemp = lineasLocales.get(i);
					// quitamos las comillas de cada linea temporal
					String noob = lineatemp.replaceAll("\"", "");

					try {
						// creamos un objeto Dia usando el constructor de array
						// de
						// Strings y lo dividimos por las comas.
						Hora d = new Hora(noob.split(splitBy));
						// añadimos cada objeto dia al treeSet de objetos <Dia>.
						lineasFinales.add(d);
						// para ver el treeSet nooooooob Style

					} catch (ParseException e) {
						System.out.println("Problema para crear el objeto dia.");
						e.printStackTrace();
					}

				}
				inLocal.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void escribirDatosFichero() {

		try {
			// abro el buffer de salida
			out = new BufferedWriter(new FileWriter(fichero));
			
			out.write(Cabezera);
			// recorro treeSet y escribo en fichero
			for (Hora dia : lineasFinales) {
				out.write(dia.toString());
				out.newLine();
			}

			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void escribirDatosFicheroCopia() {

		try {
			// abro el buffer de salida
			out = new BufferedWriter(new FileWriter(ficheroCopia));
			
			
			// recorro treeSet y escribo en fichero
			for (Hora dia : lineasFinales) {
				out.write(dia.toString());
				out.newLine();
			}

			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void imprimirTreeSet() {
		for (Hora dia : lineasFinales) {
			System.out.println(dia.toString());
		}
	}

	private boolean archivoEstaVacio(String fichero) throws IOException {

		BufferedReader av = new BufferedReader(new FileReader(fichero));
		if (av.readLine() != null) {
			return true;
		} else {
			return false;
		}
	}

}

/*
 * ---------APUNTES------------------
 * 
 * // Si el archivo existe y el directorio existe y el archivo no esta vacio. if
 * (f.exists() == false && !f.isDirectory() == false &&
 * archivoEstaVacio(fichero) == false) {
 * 
 * 
 * }
 */
