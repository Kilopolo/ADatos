package ej09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CruzarDatos {


	private static File DatPrevClim = new File("D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatPrevClim.txt");
	private static File DatRealClim = new File("D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatRealClim.csv");
	private static File DatEnfrentados = new File("D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\09. CruzarDatos\\DatEnfrentados.txt");	
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
		try {
			inPrev = new BufferedReader(new FileReader(DatPrevClim));
			inReal = new BufferedReader(new FileReader(DatRealClim));
			outEnfren = new BufferedWriter(new FileWriter(DatEnfrentados));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		while
		
		
		
		
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
