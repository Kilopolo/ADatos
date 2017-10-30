package ev1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DescargaDatosClima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			// URL url = new URL
			// ("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
			// URLConnection urlCon = url.openConnection();
			// System.out.println(urlCon.getContentType());
			// InputStream is = urlCon.getInputStream();
			// System.out.println(is.available());
			// FileOutputStream foStream = new FileOutputStream("D:\\Google
			// Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\04.
			// Clima\\clim_anti_to_new.csv");
			// byte[]tempArray=new byte[1000];
			// int leido = is.read(tempArray);
			// while (leido > 0){
			// foStream.write(tempArray, 0, leido);
			// leido = is.read(tempArray);
			// }
			// is.close();
			// foStream.close();

			URL url = new URL(
					"http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine = "";
			String splitBy = ",";
			String[] cabezera = in.readLine().split(splitBy);
			String[] campos = null;
			ArrayList<String> lineas = new ArrayList<String>();
			String lineatemp = "";
			String fichero = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\04. Clima\\clim_anti_to_new.csv";
			BufferedWriter out = new BufferedWriter(new FileWriter(fichero));
			
			// ();

			while ((inputLine = in.readLine()) != null) {

				lineas.add(inputLine);

			}

			lineatemp = lineas.get(2);
			campos = lineatemp.split(splitBy);
			
//				out.write(lineas.get(2)+"\n");
				for (int i = 0; i < campos.length; i++) {
					out.write(campos[i]);
					System.out.print(campos[i]);
					
				}
				out.write("\n");
				System.out.print("\n");
				
//				System.out.println(lineatemp);
				
			for (int i = lineas.size() - 1; i > 2; i--) {
				
				lineatemp = lineas.get(i);
				campos = lineatemp.split(splitBy);
				
				for (int j = 0; j < campos.length; j++) {
					out.write(campos[j]);
					System.out.print(campos[j]);
				}
				out.write("\n");
				System.out.print("\n");
//				out.write(lineatemp+"\n");
//				System.out.println(lineatemp);
			}

			in.close();
			out.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
