package ej09;

import java.text.DateFormat;
import java.util.Date;

public class DatosFallo {


	/**
	 * * hay que fusionar los archivos de nuestro histórico de predicciones con el histórico de datos reales que nos pasa Esteban de AEMET
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
	 */
	
	private DateFormat format;
	private Date date;
	private String WindDir;
	private float WindVel;
	private float Precip;
	private float Temp;
	
	public DatosFallo(Date date, String windDir, float windVel, float precip, float temp) {
		super();
		this.date = date;
		WindDir = windDir;
		WindVel = windVel;
		Precip = precip;
		Temp = temp;
	}
	
	
	
	@Override
	public String toString() {
		return  format.format(date) + ", WindDir=" + WindDir + ", WindVel=" + WindVel + ", Precip=" + Precip
				+ ", Temp=" + Temp;
	}



	public DateFormat getFormat() {
		return format;
	}
	public void setFormat(DateFormat format) {
		this.format = format;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWindDir() {
		return WindDir;
	}
	public void setWindDir(String windDir) {
		WindDir = windDir;
	}
	public float getWindVel() {
		return WindVel;
	}
	public void setWindVel(float windVel) {
		WindVel = windVel;
	}
	public float getPrecip() {
		return Precip;
	}
	public void setPrecip(float precip) {
		Precip = precip;
	}
	public float getTemp() {
		return Temp;
	}
	public void setTemp(float temp) {
		Temp = temp;
	}
	
	
	
	
}
