
package ev1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class datosclim {

  private static String leercadena="";
  
  
  
  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    datosclim c = new datosclim();
    //D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\wrf_arw_det_history_d02_20151015_1200.txt
    c.leerFicheroTexto("D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\clima.csv");
    
    
        
//    c.escribirFicheroTexto("D:\\Users\\Pablo\\Desktop\\uxue2.txt", leercadena);
  }
  
  
  public void leerFicheroTexto(String fichero) { 
    try {
      

      BufferedReader entrada = new BufferedReader(new FileReader(fichero));
      String date="2015-10-16";
      double temp,tempCelsius;
      String []fields=null;
      String []head= entrada.readLine().split(",");
      String linea ;
      String diaActual;
      String hora;
      
//      for (String s : head) {
//        System.out.println(s);
//       
//      }
   
//      fields = new String[24];
      
      while ((linea= entrada.readLine()) != null) { 
        
      
    	 fields = linea.split(",");
        
        if (fields[0].substring(0, 10).equals(date)){
        	
        	diaActual = fields[0].substring(0, 10);
        	hora = fields[0].substring(11, 16);
        	temp = Double.parseDouble(fields[8]) ;  
        	tempCelsius = (Math.round((temp)*100)/100) - 273;
        	
        	System.out.println("Dia: "+diaActual+" Hora: "+hora+" Temp.K: "+temp+" Temp.C: "+tempCelsius+"\n");
        }
        
      }

      entrada.close();
      
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  
  
  
  
  
  public void escribirFicheroTexto(String fichero, String datos) { 
    try {

      BufferedWriter salida = new BufferedWriter(new FileWriter(fichero));  
      salida.write(datos); // escribe el fichero
      salida.write("\n");// escribe un salto de linea
      salida.close(); // cierra el fichero
    } catch (IOException e) {
      e.printStackTrace();
    }
  }





}
