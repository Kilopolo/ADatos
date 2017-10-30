package ev1;


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
import java.util.ArrayList;
import java.util.Arrays;

/**
 * mejorar el programa que ya tenemos para que nos guarde al final del archivo
 * es decir que si lo abrimos para escritura se nos borra los dias anteriores y
 * si existe o no existe usar un modo de apertura u otro. necesitamos que nos
 * guarde las lineas de apertura solo una vez ya que no es necesario repetir
 * informacion. buscar del archivo File como hacer para abrir y que escriba a
 * final del archivo no queremos datos duplicados. p.ej. si o abrimos a las 7pm
 * y luego a las 9pm. hacer que no haya datos duplicados
 */
public class DCD2 {

	private ArrayList<String> lineas,lineasLocales,lineasURL = new ArrayList<String>();
	private String lineatemp, inputLine, inputLineLocal = "";
	private String fichero = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\05. DatClimDiario\\DatClimDiario.txt";
//	private String splitBy = ",";
//	private final Path path = Paths.get( "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\05. DatClimDiario\\DatClimDiario.txt");
	private URL url;
	private BufferedReader in, inLocal, inComparaUrl;
	private BufferedWriter out, outLocal;
	private File f;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DCD2 d=new DCD2();
		d.getFromULR();

	}

	private void getFromULR() {
		// TODO Auto-generated method stub
		try {
			url = new URL("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
//			String[] cabezera = in.readLine().split(splitBy);
			f = new File(fichero);
			

			inLocal = new BufferedReader(new FileReader(fichero));
			inComparaUrl = new BufferedReader(new InputStreamReader(url.openStream()));
			outLocal = new BufferedWriter(new FileWriter(fichero, true));
						//archivo local
				while ((inputLineLocal = inLocal.readLine()) != null) {
					lineasLocales.add(inputLineLocal);
					System.out.println(inputLineLocal);
					//archivo URL

				}
				System.out.println("--------------------fin lectura local---------------------");
				while ((inputLine = inComparaUrl.readLine()) != null) {
					lineasURL.add(inputLine);	
					System.out.println(inputLine);
				}

				System.out.println("--------------------fin lectura URL------------------------");
				
				

				
				
				System.out.println("--------------------fin TODO------------------------");
				inLocal.close();
				inComparaUrl.close();
				outLocal.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NoSuchFileException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}


	
}
