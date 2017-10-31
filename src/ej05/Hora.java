package ej05;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
//
// "11/10/2017
// 06:00","13.0","11","Sur","15","Sur","0.0","978.8","-0.6","55""11/10/2017
// 07:00","13.3","10","Sur","13","Sur","0.0","978.8","-0.2","52""11/10/2017
// 08:00","13.2","10","Sur","13","Sur","0.0","979.0","0.2","52""11/10/2017
// 09:00","11.7","9","Este","11","Este","0.0","979.7","0.9","64""11/10/2017
// 10:00","12.6","4","Este","12","Este","0.0","980.3","1.5","68""11/10/2017
// 11:00","13.9","6","Sudeste","9","Sudeste","0.0","980.8","1.8","72""11/10/2017
// 12:00","17.3","3","Este","9","Sur","0.0","981.2","1.5","60""11/10/2017
// 13:00","19.3","4","Este","10","Nordeste","0.0","981.5","1.2","62""11/10/2017
// 14:00","19.8","8","Nordeste","14","Nordeste","0.0","981.5","0.7","62""11/10/2017
// 15:00","21.0","8","Este","18","Este","0.0","981.3","0.1","64""11/10/2017
// 16:00","20.4","9","Nordeste","21","Este","0.0","981.6","0.1","64""11/10/2017
// 17:00","19.7","8","Nordeste","25","Nordeste","0.0","982.0","0.5","64""11/10/2017
// 18:00","19.0","6","Este","18","Este","0.0","982.5","1.2","68""11/10/2017
// 19:00","17.9","6","Este","15","Nordeste","0.0","983.2","1.6","71""11/10/2017
// 20:00","16.7","6","Nordeste","15","Este","0.0","983.6","1.6","77""11/10/2017
// 21:00","16.0","6","Este","12","Este","0.0","984.1","1.6","82""11/10/2017
// 22:00","15.4","4","Este","8","Nordeste","0.0","984.5","1.3","87""11/10/2017
// 23:00","15.7","5","Sudeste","9","Nordeste","0.0","984.6","1.0","86""12/10/2017
// 00:00","15.5","3","Nordeste","7","Sudeste","0.0","984.5","0.4","87""12/10/2017
// 01:00","14.2","4","Noroeste","6","Noroeste","0.0","984.6","0.1","91""12/10/2017
// 02:00","14.1","3","Oeste","6","Oeste","0.0","984.6","0.0","92""12/10/2017
// 03:00","13.5","4","Noroeste","6","Noroeste","0.0","984.6","0.1","95""12/10/2017
// 04:00","13.0","3","Oeste","5","Oeste","0.0","984.5","-0.1","95""12/10/2017
// 05:00","12.5","2","Oeste","6","Sur","0.0","984.4","-0.2","97"

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

	// String fechaString = "2017/10/17 19:30";
	// SHORT is completely numeric, such as 12.13.52 or 3:30pm
	// DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm",
	// Locale.GERMANY);
	// Date date = format.parse(fechaString);

	public Hora(String[] campos) throws ParseException {
		// creo un constructor a el cual se le pasa un array de strings para
		// luego pasa
//		System.out.println("Campo[0]: "+ campos[0]);
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
