package ej09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

		// ALGORITMO
		try {
			HoraPrevision hP = null;
			HoraRealClima hR = null;
			String lineaPrev = inPrev.readLine();
			String lineaReal = inReal.readLine();
			lineaReal = inReal.readLine();
			while (lineaPrev != null && lineaReal != null) {
				lineaPrev = lineaPrev.replaceAll("\"", "");
				hP = new HoraPrevision(lineaPrev.split(","));
				hR = new HoraRealClima(lineaReal.split(","));

				if (hP.getFechayHora().before(hR.getDate())) {
					// <Tratar Maestro sin Movimientos>
					// ----------------------------------------------------------------------------v
					lineaPrev = inPrev.readLine();
					lineaPrev = lineaPrev.replaceAll("\"", "");
					hP = new HoraPrevision(lineaPrev.split(","));
					hR = new HoraRealClima(lineaReal.split(","));

					if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {
						System.out.println("IF 1");
						System.out.println("1. " + hP.getFechayHora() + " - 2. " + hR.getDate());
						float TempPrev = hP.getTempC();
						float TempReal = hR.getTemp();
						float TempFallo = TempReal - TempPrev;
					}

					// ----------------------------------------------------------------------------^
				} else {
					if (hP.getFechayHora().after(hR.getDate())) {
						// <Tratar Movimiento sin Maestro>
						// ----------------------------------------------------------------------------v
						if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {
							System.out.println("ELSE 1 IF 2");
							System.out.println("1. " + hP.getFechayHora() + " - 2. " + hR.getDate());
						}

						lineaReal = inReal.readLine();
						// ----------------------------------------------------------------------------^
					} else {
						// <Tratar Maestro con Movimientos>

						// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! <TRATAR AMBOS>

						/*
						 * Puede incluir una ruptura de control si hay varios Movimientos En cualquier
						 * caso incluye como minimo una lectura de Movimientos Mientras FMaestro ==
						 * FMovimientos { hacer lo que se tenga que hacer }
						 */

						// ----------------------------------------------------------------------------v
						if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {
							System.out.println("ELSE 2");
							System.out.println("1. " + hP.getFechayHora() + " - 2. " + hR.getDate());
						}

						lineaPrev = inPrev.readLine();
						lineaPrev = lineaPrev.replaceAll("\"", "");
						// ----------------------------------------------------------------------------^
					}
				}
			}

			// Ahora vamos con lo que no se haya tratado aun.

			if ((lineaPrev = inPrev.readLine()) != null) {
				System.out.println("ENTRA if");
				while ((lineaReal = inReal.readLine()) != null) {
					// <Tratar Movimiento sin Maestro>
					// ----------------------------------------------------------------------------v
					lineaReal = inReal.readLine();
					hR = new HoraRealClima(lineaReal.split(","));

					if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {
						System.out.println("IF 1");
						System.out.println("1. " + hP.getFechayHora() + " - 2. " + hR.getDate());

					}
					// ----------------------------------------------------------------------------^
				}
			} else {
				System.out.println("ELSE");
				while ((lineaPrev = inPrev.readLine()) != null) {
					// <Tratar Maestro sin Movimientos>
					// ----------------------------------------------------------------------------v
					lineaPrev = inPrev.readLine();
					lineaPrev = lineaPrev.replaceAll("\"", "");
					hP = new HoraPrevision(lineaPrev.split(","));
					hR = new HoraRealClima(lineaReal.split(","));

					if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {
						System.out.println("IF 1");
						System.out.println("1. " + hP.getFechayHora() + " - 2. " + hR.getDate());

					}
					// ----------------------------------------------------------------------------^
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

}
