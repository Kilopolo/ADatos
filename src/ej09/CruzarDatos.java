package ej09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CruzarDatos {

	private static File DatPrevClim = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatPrevClim.txt");
	private static File DatRealClim = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatRealClim.csv");
	private static File DatEnfrentados = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatEnfrentados.txt");
	BufferedReader inPrev, inReal;
	BufferedWriter outEnfren;

	public static void main(String[] args) {
		CruzarDatos o = new CruzarDatos();
		o.CruzDat(DatPrevClim, DatRealClim, DatEnfrentados);

	}
	/**
	 * 
 * Abrir FMaestro para lectura
 * Abrir FMovimientos para lectura
 * Abrir FActualizado para escritura
 * 
 * Leer RegistroMaestro
 * Leer RegistroMovimientos
 * 
 * 		Mientras no EOF(FMaestro) y no EOF(FMovimientos)
 * 			Si ClaveRegistroMaestro<ClaveRegistroMovimientos
 * 				Entonces <Tratar Maestro sin Movimientos>
 * 						Leer RegistroMaestro
 * 			
 * 				Sino
 * 					Si ClaveRegistroMaestro>ClaveRegistroMovimientos
 * 					Entonces <Tratar Movimiento sin Maestro>
 * 							Leer RegistroMovimientos
 * 					SiNo <Tratar Maestro con Movimientos>
 * 						//Puede incluir una ruptura de control si hay varios Movimientos
 * 						//En cualquier caso incluye como minimo una lectura de Movimientos
 * 						//Mientras FMaestro == FMovimientos { hacer lo que se tenga que hacer }
 * 						Leer RegistroMaestro
 * 				FinSi
 * 						
 * 			FinSi
 * 		FinMientras
 * 
 * 		Si EOF(FMaestro)
 * 			Entonces 
 * 				Mientras no EOF(FMovimientos)
 * 					<Tratar Movimiento sin Maestro>
 * 					Leer RegistroMovimientos
 * 				FinMientras
 * 		SiNo
 * 			Mientras no EOF(Maestro)
 * 				<Tratar Maestro sin Movimientos>
 * 				Leer RegistroMaestro
 * 			Fin Mientras
 * 		FinSi
 * 
 * Cerrar ficheros
 * 
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
					System.out.println("1.PRUEBASS_ _ _ " + hP.toString());
					lineaPrev = inPrev.readLine();
					lineaPrev = lineaPrev.replaceAll("\"", "");
					hP = new HoraPrevision(lineaPrev.split(","));

				} else {
					if (hP.getFechayHora().after(hR.getDate())) {
						// <Tratar Movimiento sin Maestro>
						System.out.println("2.PRUEBAS- - - " + hR.toString());
						lineaReal = inReal.readLine();

					} else {
						// <Tratar Maestro con Movimientos>

						// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! <TRATAR AMBOS>

						/*
						 * Puede incluir una ruptura de control si hay varios Movimientos En cualquier
						 * caso incluye como minimo una lectura de Movimientos Mientras FMaestro ==
						 * FMovimientos { hacer lo que se tenga que hacer }
						 */

						System.out.println("1.PRUEBASS_ _ _ " + hP.toString());
						lineaPrev = inPrev.readLine();
						lineaPrev = lineaPrev.replaceAll("\"", "");

					}
				}
			}

			// Ahora vamos con lo que no se haya tratado aun.

			if ((lineaPrev = inPrev.readLine()) != null) {
				System.out.println("ENTRA if");
				while ((lineaReal = inReal.readLine()) != null) {
					// <Tratar Movimiento sin Maestro>
					System.out.println("2.PRUEBAS- - - " + hR.toString());
					lineaReal = inReal.readLine();
					hR = new HoraRealClima(lineaReal.split(","));
				}
			} else {
				System.out.println("ELSE");
				while ((lineaPrev = inPrev.readLine()) != null) {
					// <Tratar Maestro sin Movimientos>
					System.out.println("1.PRUEBASS_ _ _ " + hP.toString());
					lineaPrev = inPrev.readLine();
					lineaPrev = lineaPrev.replaceAll("\"", "");
					hP = new HoraPrevision(lineaPrev.split(","));
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
	
	

