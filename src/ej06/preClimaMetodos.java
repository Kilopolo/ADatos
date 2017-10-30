package ej06;

/**
 * @author Pablo para cada dia temp max temp min y horas a las q esta prevista,
 *         ademas de la temp media del dia para el periodo compreto temp max
 *         temp min que dia y hora, temp media periodo y si estaba prevista
 *         lluvia para los 4 dias del periodo.
 *
 */

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.text.DecimalFormat;
	import java.util.Scanner;

	public class preClimaMetodos {
	  public static void main(String[] args) throws IOException {
	    String date;
	    Scanner teclado = new Scanner(System.in);
	    System.out.println("Dime fecha formato año-mes-dia: ");
	    date = teclado.nextLine();
	    try {
	      DecimalFormat df = new DecimalFormat("#.00");// Damos formato de 2 digitos
	      BufferedReader in = new BufferedReader(new FileReader("wrf_arw_det_history_d02_20151015_1200.txt"));
	      String rLine = in.readLine();
	      String[] head = rLine.split(",");
	      for (int i = 0; i < head.length; i++) {
	        if (i == 0 || i == 8) {
	          System.out.print("   " + head[i] + "    ");
	        }
	        if(i>8) {
	          System.out.print("temp[unit=\"Cº\"]"  + "    ");
	        }
	      }
	      System.out.println();
	      while ((rLine = in.readLine()) != null) {
	        String[] storeValue = rLine.split(",");
	        for (int j = 0; j < storeValue.length; j++) {
	          if (j == 0 && storeValue[j].contains(date)) { // indicamos hora
	            String formatString = storeValue[j].substring(11, 20);
	            System.out.print(formatString + "          ");
	          }
	          if (j == 8 && storeValue[0].contains(date)) {// indicamos temperatura en Kelvin
	            String c = storeValue[j];
	            double c1 = Double.parseDouble(c);
	            System.out.print(df.format(c1) + "          ");
	          }
	          if (j == 8 && storeValue[0].contains(date)) {// indicamos temperatura en Celsius
	            String k = storeValue[j];
	            double c = Double.parseDouble(k);
	            c = c - 273.15F;
	            System.out.print(df.format(c));
	            System.out.println();
	          }

	        }
	      }
	      in.close();

	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
	
	
}
