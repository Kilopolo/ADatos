package ej09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CruzarDatos {

	private static File DatPrevClim = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatPrevClim.txt");
	private static File DatRealClim = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatRealClim.csv");
	private static File DatEnfrentados = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatEnfrentados.txt");
	BufferedReader inPrev, inReal;
	BufferedWriter outEnfren;
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
	Date date;
	float TempPrev, TempReal, TempFallo;
	float PrecipFallo, PrecipReal, PrecipPrev;
	String WindDirFallo, WindDirReal, WindDirPrev;
	float WindVelFallo, WindVelReal, WindVelPrev;
	DatosFallo hF;
	HoraPrevision hP = null;
	HoraRealClima hR = null;

	/**
	 * -.---.-.-.-.-MAIN-..-.--..-.--.-..-
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CruzarDatos o = new CruzarDatos();
		o.CruzDat(DatPrevClim, DatRealClim, DatEnfrentados);

	}

	/**
	 * 
	 * @param DatPrevClim
	 * @param DatRealClim
	 * @param DatEnfrentados
	 */
	public void CruzDat(File DatPrevClim, File DatRealClim, File DatEnfrentados) {
		// APERTURA
		try {
			inPrev = new BufferedReader(new FileReader(DatPrevClim));
			inReal = new BufferedReader(new FileReader(DatRealClim));
			outEnfren = new BufferedWriter(new FileWriter(DatEnfrentados));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// escribir Cabezera

		try {
			outEnfren.write(" FECHA " + " , Precip= " + " [Diferencia] " + " , Temp= " + " [Diferencia] "
					+ " , WindVel= " + " [Diferencia] " + ", WindDir=" + " [Diferencia] ");
			outEnfren.newLine();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// ALGORITMO
		try {

			String lineaPrev = inPrev.readLine();
			String lineaReal = inReal.readLine();
			lineaReal = inReal.readLine();
			while (lineaPrev != null && lineaReal != null) {
				lineaPrev = lineaPrev.replaceAll("\"", "");

				if (lineaPrev == null || lineaReal == null)
					break;

				hP = new HoraPrevision(lineaPrev.split(","));
				hR = new HoraRealClima(lineaReal.split(","));

				if (hP.getFechayHora().before(hR.getDate())) {
					// <Tratar Maestro sin Movimientos>
					lineaPrev = inPrev.readLine();
					lineaPrev = lineaPrev.replaceAll("\"", "");
				} else {
					if (hP.getFechayHora().after(hR.getDate())) {
						// <Tratar Movimiento sin Maestro>
						lineaReal = inReal.readLine();
					} else {
						// <Tratar Maestro con Movimientos>
						tratarDatos(hP, hR);

						// !!!!!!! <TRATAR AMBOS> AKI ESTAN JUNTOS ASIQUE SE TRATAN LOS DATOS.!!!!!
						// ENFRENTADOS
						/*
						 * Puede incluir una ruptura de control si hay varios Movimientos En cualquier
						 * caso incluye como minimo una lectura de Movimientos Mientras FMaestro ==
						 * FMovimientos { hacer lo que se tenga que hacer }
						 */
						lineaPrev = inPrev.readLine();
						lineaPrev = lineaPrev.replaceAll("\"", "");
					}
				}
			}

			// Ahora vamos con lo que no se haya tratado aun.

			if ((lineaPrev = inPrev.readLine()) != null) {

				while ((lineaReal = inReal.readLine()) != null) {
					// <Tratar Movimiento sin Maestro>
					lineaReal = inReal.readLine();
				}
			} else {
				System.out.println("ELSE");
				while ((lineaPrev = inPrev.readLine()) != null) {
					// <Tratar Maestro sin Movimientos>
					lineaPrev = inPrev.readLine();
					lineaPrev = lineaPrev.replaceAll("\"", "");

				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// CIERRE
		try {
			outEnfren.flush();
			inPrev.close();
			inReal.close();
			outEnfren.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tratarDatos(HoraPrevision hP, HoraRealClima hR) {
		// TODO Auto-generated method stub

		// if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {

		date = hR.getDate();

		TempPrev = hP.getTempC();
		TempReal = hR.getTemp();
		TempFallo = Math.round((TempReal - TempPrev)*1000)/1000;

		PrecipPrev = hP.getPrecipitacion();
		PrecipReal = hR.getPrec();
		PrecipFallo = Math.round((PrecipReal - PrecipPrev)*1000)/1000;

		WindDirPrev = hP.getDirViento();
		WindDirReal = hR.getDirStr();
		if (WindDirReal.equalsIgnoreCase(WindDirPrev)) {
			WindDirFallo = WindDirReal;
		} else
			WindDirFallo = "Real: " + WindDirReal + " / Prevision: "
					+ WindDirPrev + ".";

		WindVelPrev = hP.getVelViento();
		WindVelReal = hR.getMod();
		WindVelFallo = Math.round((WindVelReal - WindVelPrev)*1000)/1000;

		hF = new DatosFallo(date, WindDirFallo, WindVelFallo, PrecipFallo, TempFallo);

		try {
			outEnfren.write(format.format(date) +","+ PrecipFallo +","+ TempFallo +","+ WindVelFallo +","+ WindDirFallo);
			outEnfren.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// hF.imprimir();
		// System.out.println(hF.toString());
		// }

	}

}
