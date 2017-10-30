package ev1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class copiatxt {
	static String leercadena="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copiatxt c = new copiatxt();
		
		c.leerFicheroTexto("D:\\Users\\Pablo\\Desktop\\uxue.txt");
		System.out.println(leercadena);
		c.escribirFicheroTexto("D:\\Users\\Pablo\\Desktop\\uxue2.txt", leercadena);
	}
	
	
	public void leerFicheroTexto(String fichero) { 
		try {
			
			/**
			 * Canal de lectura en una linea
			 */
			BufferedReader entrada = new BufferedReader(new FileReader(fichero));
			while (entrada.ready()) { //
				leercadena = leercadena+"\n"+entrada.readLine();
			}
			
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void escribirFicheroTexto(String fichero, String datos) { 
		try {
			/**
			 * para archivos de texto sin formato
			 */
			BufferedWriter salida = new BufferedWriter(new FileWriter(fichero));  
			salida.write(datos); // escribe el fichero
			salida.write("\n");// escribe un salto de linea
			salida.close(); // cierra el fichero
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
