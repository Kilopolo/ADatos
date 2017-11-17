/**
 * 
 * .1FichMaestro
 * .1FichMovimientos
 * 
 * juntamos los dos anteriores
 * en el: 
 * 
 * Enfrentamiento()
 * 
 * nos crea:
 * 
 * .FichActualizado
 * --------------------------------------------------------
 * 
 * Algoritmo:
 * (a partir del ej08)
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
 * -----------------------------------------------------------------------------------------
 * 
 * hay que fusionar los archivos de nuestro histórico de predicciones con el histórico de datos reales que nos pasa Esteban de AEMET
 * y decir cuales son los datos que cambian en cada comparación que hagamos.
 * (por horas)
 * 
 * el archivo con los datos reales que hubo son:
 * fecha = yyyy-MM-ddThh:mm:ssZ (es el tiempo universal : el tiempo en españa es una hora mas que el universal porque españa es GTM+1)
 * lat = latitud
 * long = longitd
 * dir = direccion viento grados
 * mod = vel viento en modulo expresada en m/s
 * nsbp = presion reducida a nivel del mar (presion atmosferica en  hecto Pascales que son 100x los Pascales) y en el otro aparece en Pascales
 * prec = kg/m2 aqui no hace falta pasar nada pq la pagina ya nos lo pasa en mm
 * rh= humedad relativa AEMET nos lo da en tanto por ciento y el nuestro nos lo da en tanto por 1
 * temp= temp expresada en grdos Kelvin nientras q aemet nos lo expresa en celsius (restar 273,15)
 * 
 * el fich de salida solo tiene que contener los registros que coincidan entre ambos archivos. es decir las horas que coincidan
 * 
 * 
 * para pasar de km/h a m/s hay que dividir entre 3600 y multiplicar por 1000. 
 * 
 * @author Pablo
 */
package ej09;