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
//	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
	Date date;
	float TempPrev,TempReal,TempFallo;
	float PrecipFallo,PrecipReal,PrecipPrev;
	String WindDirFallo,WindDirReal,WindDirPrev;
	float WindVelFallo,WindVelReal,WindVelPrev;
	
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
						

						date = hR.getDate();
						
						TempPrev = hP.getTempC();
						TempReal = hR.getTemp();
						TempFallo = TempReal - TempPrev;

						PrecipPrev = hP.getPrecipitacion();
						PrecipReal = hR.getPrec();
						PrecipFallo = PrecipReal - PrecipPrev;
						
						WindDirPrev = hP.getDirViento();
						WindDirReal = hR.getDirStr();
						if (WindDirReal.equalsIgnoreCase(WindDirPrev)) {
							WindDirFallo = WindDirReal;
						} else WindDirFallo = "La dirección del viento real es: "+WindDirReal+" ,y la de la prevision es: "+WindDirPrev+".";
						
						WindVelPrev = hP.getVelViento();
						WindVelReal = hR.getMod();
						WindVelFallo = WindVelReal - WindVelPrev;
						
						DatosFallo hF = new DatosFallo(date, WindDirFallo, WindVelFallo, PrecipFallo, TempFallo);
						
						System.out.println(hF.toString());

					}

					// ----------------------------------------------------------------------------^
				} else {
					if (hP.getFechayHora().after(hR.getDate())) {
						// <Tratar Movimiento sin Maestro>
						// ----------------------------------------------------------------------------v
						if (hP.getFechayHora().compareTo(hR.getDate()) == 0) {
							

							date = hR.getDate();
							
							TempPrev = hP.getTempC();
							TempReal = hR.getTemp();
							TempFallo = TempReal - TempPrev;

							PrecipPrev = hP.getPrecipitacion();
							PrecipReal = hR.getPrec();
							PrecipFallo = PrecipReal - PrecipPrev;
							
							WindDirPrev = hP.getDirViento();
							WindDirReal = hR.getDirStr();
							if (WindDirReal.equalsIgnoreCase(WindDirPrev)) {
								WindDirFallo = WindDirReal;
							} else WindDirFallo = "La dirección del viento real es: "+WindDirReal+" ,y la de la prevision es: "+WindDirPrev+".";
							
							WindVelPrev = hP.getVelViento();
							WindVelReal = hR.getMod();
							WindVelFallo = WindVelReal - WindVelPrev;
							
							DatosFallo hF = new DatosFallo(date, WindDirFallo, WindVelFallo, PrecipFallo, TempFallo);
							
							System.out.println(hF.toString());

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
							

							date = hR.getDate();
							
							TempPrev = hP.getTempC();
							TempReal = hR.getTemp();
							TempFallo = TempReal - TempPrev;

							PrecipPrev = hP.getPrecipitacion();
							PrecipReal = hR.getPrec();
							PrecipFallo = PrecipReal - PrecipPrev;
							
							WindDirPrev = hP.getDirViento();
							WindDirReal = hR.getDirStr();
							if (WindDirReal.equalsIgnoreCase(WindDirPrev)) {
								WindDirFallo = WindDirReal;
							} else WindDirFallo = "La dirección del viento real es: "+WindDirReal+" ,y la de la prevision es: "+WindDirPrev+".";
							
							WindVelPrev = hP.getVelViento();
							WindVelReal = hR.getMod();
							WindVelFallo = WindVelReal - WindVelPrev;
							
							DatosFallo hF = new DatosFallo(date, WindDirFallo, WindVelFallo, PrecipFallo, TempFallo);
							
							System.out.println(hF.toString());

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
						

						date = hR.getDate();
						
						TempPrev = hP.getTempC();
						TempReal = hR.getTemp();
						TempFallo = TempReal - TempPrev;

						PrecipPrev = hP.getPrecipitacion();
						PrecipReal = hR.getPrec();
						PrecipFallo = PrecipReal - PrecipPrev;
						
						WindDirPrev = hP.getDirViento();
						WindDirReal = hR.getDirStr();
						if (WindDirReal.equalsIgnoreCase(WindDirPrev)) {
							WindDirFallo = WindDirReal;
						} else WindDirFallo = "La dirección del viento real es: "+WindDirReal+" ,y la de la prevision es: "+WindDirPrev+".";
						
						WindVelPrev = hP.getVelViento();
						WindVelReal = hR.getMod();
						WindVelFallo = WindVelReal - WindVelPrev;
						
						DatosFallo hF = new DatosFallo(date, WindDirFallo, WindVelFallo, PrecipFallo, TempFallo);
						
						System.out.println(hF.toString());

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
						

						date = hR.getDate();
						
						TempPrev = hP.getTempC();
						TempReal = hR.getTemp();
						TempFallo = TempReal - TempPrev;

						PrecipPrev = hP.getPrecipitacion();
						PrecipReal = hR.getPrec();
						PrecipFallo = PrecipReal - PrecipPrev;
						
						WindDirPrev = hP.getDirViento();
						WindDirReal = hR.getDirStr();
						if (WindDirReal.equalsIgnoreCase(WindDirPrev)) {
							WindDirFallo = WindDirReal;
						} else WindDirFallo = "La dirección del viento real es: "+WindDirReal+" ,y la de la prevision es: "+WindDirPrev+".";
						
						WindVelPrev = hP.getVelViento();
						WindVelReal = hR.getMod();
						WindVelFallo = WindVelReal - WindVelPrev;
						
						DatosFallo hF = new DatosFallo(date, WindDirFallo, WindVelFallo, PrecipFallo, TempFallo);
						
						System.out.println(hF.toString());

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
