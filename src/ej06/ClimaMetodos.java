package ej06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TreeSet;

/**
 * @author Pablo
 * 
 *         para cada dia temp max temp min y horas a las q esta prevista, ademas
 *         de la temp media del dia para el periodo compreto temp max temp min
 *         que dia y hora, temp media periodo y si estaba prevista lluvia para
 *         los 4 dias del periodo.
 *
 */

public class ClimaMetodos {

	private static String fichero = "D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\06. ClimaMetodos\\wrf_arw_det_history_d02_20151015_1200.txt";
	private DateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
	private DateFormat formatHour = new SimpleDateFormat("HH:mm", Locale.GERMANY);
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.GERMANY);
	private ArrayList<String> lineas = new ArrayList<String>();
	private TreeSet<Hora> horas = new TreeSet<Hora>();
	static TreeSet<Dia> dias = new TreeSet<Dia>();

	public static void main(String[] args) {
		ClimaMetodos cm = new ClimaMetodos();
		// cm.leerDatosFichero(fichero);
		
		cm.añadirLineasArrayList(fichero);
		System.out.println("----------------------DATOS HORARIO------------------------------------------------");
		cm.crearHoras();
		cm.enseñarHoras();
		System.out.println("----------------------DATOS DIARIOS------------------------------------------------");
		cm.crearDias2();
		cm.enseñarDias();
		System.out.println("----------------------DATOS GLOBALES------------------------------------------------");
		cm.datosGlobales();
		
	}

	private void datosGlobales() {
		float acumulador = 0;
		float contador = 0;
		float maxTemp = 0;
		float minTemp = 600;
		float avgTemp = 0;
		Date diaMaxTemp = null;
		Date horaMaxTemp = null;
		Date horaMinTemp = null;
		Date diaMinTemp = null;
		boolean prec = false;
		for (Dia dia : dias) {

			// temp max
			if (maxTemp <= dia.getMaxTemp()) {
				maxTemp = dia.getMaxTemp();
			}
			if (maxTemp == dia.getMaxTemp()) {
				horaMaxTemp = dia.getHoraMaxTemp();
				diaMaxTemp = dia.getDate();
			}

			// temp min
			if (minTemp >= dia.getMinTemp()) {
				minTemp = dia.getMinTemp();
			}
			if (minTemp == dia.getMinTemp()) {
				horaMinTemp = dia.getDate();
				diaMinTemp = dia.getDate();
			}

			// media temp
			contador++;
			acumulador = acumulador + dia.getAvgTemp();
			avgTemp = acumulador / contador;

			// precipitaciones
			if (dia.isPrec() != false)
				prec = true;

		}

		System.out.println("Dia de temperatura máxima: " + formatDay.format(diaMaxTemp) + " Hora: "
				+ formatHour.format(horaMaxTemp) + " , Temperatura: " + maxTemp + "ºC ,\n"
				+ "Dia de temperatura mínima: " + formatDay.format(diaMinTemp) + " Hora: "
				+ formatHour.format(horaMinTemp) + " , Temperatura: " + minTemp + "ºC ,\n"
				+ "Temperatura media Periodo: " + Math.round(avgTemp) + "ºC \n" + "Precipitaciones: " + prec);
	}

	private void enseñarDias() {

		for (Dia dia : dias) {
			System.out.println(dia.toString());
		}
	}

	private void enseñarHoras() {
		for (Hora hora : horas) {
			System.out.println(hora.toString());
		}
	}

	private void crearDias2() {

		Date fechaActual = null;
		// fecha para guardar la fecha de ayer y compararla con hoy y asi saber que ha
		// cambiado el dia.
		Date fechaResiduo = null;
		boolean prec = false;
		float maxTemp = 0;
		Date horaMaxTemp = null;
		float minTemp = 600;
		Date horaMinTemp = null;
		float avgTemp = 0;
		int contadorAvgTemp = 0;
		float acumuladoAvgTemp = 0;
		Hora diaFin = horas.last();
		boolean check = false;

		for (Hora i : horas) {

			try {// consigo los dias formateados como necesito y lo almaceno en variable tipo
					// date
				fechaActual = formatDay.parse(formatDay.format(i.getDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (fechaActual!=fechaResiduo) {
				if (check) {
		
					avgTemp = acumuladoAvgTemp / contadorAvgTemp;
					Dia d = new Dia(fechaActual, i.getLat(), i.getLon(), prec, maxTemp, horaMaxTemp, minTemp,
							horaMaxTemp, avgTemp);
					dias.add(d);
					// almacenamos en residuo la fecha que usamos hasta ahora para comparar el
					// cambio de dia
					maxTemp = 0;
					minTemp = 600;
					contadorAvgTemp = 0;
					acumuladoAvgTemp = 0;
					avgTemp = 0;
					prec = false;

				}

			
//---------------------------------------------------------------------------
			// temp max
			if (i.getTemp()>maxTemp  ) {
				
				maxTemp = i.getTemp();
				horaMaxTemp = i.getDate();
				System.out.println("max"+maxTemp);
			}
			// temp min
			if (i.getTemp()<minTemp) {
				minTemp = i.getTemp();
				horaMinTemp = i.getDate();
				System.out.println("min"+minTemp);

			}
			// media temp
			contadorAvgTemp++;
			acumuladoAvgTemp = acumuladoAvgTemp + i.getTemp();
			
			// precipitaciones
			if (i.getPrec() != 0) prec = true;
//------------------------------------------------------------------------------
			
				if (diaFin.equals(i)) {

					avgTemp = acumuladoAvgTemp / contadorAvgTemp;
					Dia d = new Dia(fechaActual, i.getLat(), i.getLon(), prec, maxTemp, horaMaxTemp, minTemp,
							horaMaxTemp, avgTemp);
					dias.add(d);

					
					maxTemp = 0;
					minTemp = 600;
					contadorAvgTemp = 0;
					acumuladoAvgTemp = 0;
					avgTemp = 0;
					prec = false;
				}
				check=true;
				fechaResiduo = fechaActual;
			}

		} // --------------------------fin for each---------------

	}

	private void crearDias() {

		Date fechaActual = null;
		// fecha para guardar la fecha de ayer y compararla con hoy y asi saber que ha
		// cambiado el dia.
		Date fechaResiduo = null;
		boolean prec = false;
		float maxTemp = 0;
		Date horaMaxTemp = null;
		float minTemp = 600;
		Date horaMinTemp = null;
		float avgTemp = 0;
		int contadorAvgTemp = 0;
		float acumuladoAvgTemp = 0;
		Date diaFin = horas.last().getDate();

		for (Hora i : horas) {

			try {// consigo los dias formateados como necesito y lo almaceno en variable tipo
					// date
				fechaActual = formatDay.parse(formatDay.format(i.getDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (fechaResiduo == null) {

				fechaResiduo = fechaActual;
			}

			if (fechaActual.equals(fechaResiduo)) {
				// temp max
				if (maxTemp <= i.getTemp()) {
					maxTemp = i.getTemp();
					horaMaxTemp = i.getDate();
				}
				// temp min
				if (minTemp >= i.getTemp()) {
					minTemp = i.getTemp();
					horaMinTemp = i.getDate();
				}
				// media temp
				contadorAvgTemp++;
				acumuladoAvgTemp = acumuladoAvgTemp + i.getTemp();
				avgTemp = acumuladoAvgTemp / contadorAvgTemp;
				// precipitaciones
				if (i.getPrec() != 0)
					prec = true;

				// DONDE PONGO ESTO!!!!

				if ((diaFin.compareTo(fechaResiduo)) == 0) {
					Dia d = new Dia(fechaActual, i.getLat(), i.getLon(), prec, maxTemp, horaMaxTemp, minTemp,
							horaMaxTemp, avgTemp);
					dias.add(d);
				}

			} else {

				Dia d = new Dia(fechaActual, i.getLat(), i.getLon(), prec, maxTemp, horaMaxTemp, minTemp, horaMaxTemp,
						avgTemp);
				dias.add(d);
				// almacenamos en residuo la fecha que usamos hasta ahora para comparar el
				// cambio de dia
				fechaResiduo = fechaActual;
				maxTemp = 0;
				minTemp = 600;
				contadorAvgTemp = 0;
				acumuladoAvgTemp = 0;
				avgTemp = 0;
				prec = false;
			}

		}

	}

	private void crearHoras() {
		for (int i = 1; i < lineas.size(); i++) {
			Hora h = new Hora(lineas.get(i).split(","));
			horas.add(h);
		}
	}

	private void añadirLineasArrayList(String fichero) {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fichero));
			String linea = "";
			while ((linea = in.readLine()) != null) {
				lineas.add(linea);
			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error en el buffer de entrada");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en el in.readLine()");
		}
	}

	private void leerDatosFichero(String fichero) {

		try {
			BufferedReader in = new BufferedReader(new FileReader(fichero));
			String linea = "";
			while ((linea = in.readLine()) != null) {

				System.out.println(linea);
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en el Buffer de entrada.(leerDatosFichero())");
		}
	}

}
