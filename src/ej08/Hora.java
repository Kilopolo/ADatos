package ej08;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * Fecha y hora oficial,"Temperatura (ºC)","Velocidad del viento (km/h)"
 * ,"Dirección del viento","Racha (km/h)","Dirección de racha"
 * ,"Precipitación (mm)","Presión (hPa)","Tendencia (hPa)","Humedad (%)"
 */
public class Hora implements Comparable<Hora> {

	DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.GERMANY);
	Date fechayHora;
	float tempC;
	int VelViento;
	String DirViento;
	int racha;
	String DirRacha;
	float precipitacion;
	float presion;
	float tendencia;
	int humedad;


	public Hora(String[] campos) throws ParseException {

		fechayHora = format.parse(campos[0]);
		tempC = Float.parseFloat(campos[1]);
		VelViento = Integer.parseInt(campos[2]);
		DirViento = campos[3];
		racha = Integer.parseInt(campos[4]);
		DirRacha = campos[5];
		precipitacion = Float.parseFloat(campos[6]);
		presion = Float.parseFloat(campos[7]);
		tendencia = Float.parseFloat(campos[8]);
		humedad = Integer.parseInt(campos[9]);
	}

	@Override
	public String toString() {
		return "\"" + format.format(fechayHora) + "\"" +","+"\"" + tempC + "\"" +","+"\"" + VelViento
				+ "\"" +","+"\"" + DirViento + "\"" +","+"\"" + racha + "\"" +","+"\"" + DirRacha 
				+ "\"" +","+"\"" + precipitacion + "\"" +","+"\"" + presion + "\"" +","+"\"" 
				+ tendencia + "\"" +","+"\"" + humedad + "\"";
	}

	@Override
	public int compareTo(Hora o) {
		return getFechayHora().compareTo(o.getFechayHora());
	}

	public Hora(DateFormat format, Date fechayHora, float tempC, int velViento, String dirViento, int racha,
			String dirRacha, float precipitacion, float presion, float tendencia, int humedad) {
		super();
		this.format = format;
		this.fechayHora = fechayHora;
		this.tempC = tempC;
		VelViento = velViento;
		DirViento = dirViento;
		this.racha = racha;
		DirRacha = dirRacha;
		this.precipitacion = precipitacion;
		this.presion = presion;
		this.tendencia = tendencia;
		this.humedad = humedad;
	}

	public DateFormat getFormat() {
		return format;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}

	public Date getFechayHora() {
		return fechayHora;
	}

	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}

	public float getTempC() {
		return tempC;
	}

	public void setTempC(float tempC) {
		this.tempC = tempC;
	}

	public int getVelViento() {
		return VelViento;
	}

	public void setVelViento(int velViento) {
		VelViento = velViento;
	}

	public String getDirViento() {
		return DirViento;
	}

	public void setDirViento(String dirViento) {
		DirViento = dirViento;
	}

	public int getRacha() {
		return racha;
	}

	public void setRacha(int racha) {
		this.racha = racha;
	}

	public String getDirRacha() {
		return DirRacha;
	}

	public void setDirRacha(String dirRacha) {
		DirRacha = dirRacha;
	}

	public float getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(float precipitacion) {
		this.precipitacion = precipitacion;
	}

	public float getPresion() {
		return presion;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}

	public float getTendencia() {
		return tendencia;
	}

	public void setTendencia(float tendencia) {
		this.tendencia = tendencia;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

}
