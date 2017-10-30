package ej06;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Dia implements Comparable<Dia>{
//dia
	private DateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
	private DateFormat formatHour = new SimpleDateFormat("HH:mm", Locale.GERMANY);
	private Date date;
//coordenadas
	private float lat;
	private float lon;
//	precipitaciones
	private boolean prec;
//Temperatura
	private float maxTemp;
	private Date horaMaxTemp;
	private float minTemp;
	private Date horaMinTemp;
	private float avgTemp;
	
	
	
	public Dia(Date date, float lat, float lon, boolean prec, float maxTemp, Date horaMaxTemp, float minTemp,
			Date horaMinTemp, float avgTemp) {
		super();
		this.date = date;
		this.lat = lat;
		this.lon = lon;
		this.prec = prec;
		this.maxTemp = maxTemp;
		this.horaMaxTemp = horaMaxTemp;
		this.minTemp = minTemp;
		this.horaMinTemp = horaMinTemp;
		this.avgTemp = avgTemp;
	}

	@Override
	public String toString() {//date.toInstant()
		return 	  "Dia: " + formatDay.format(date) + "\n"
//				+ "Posición(lat=" + lat + ", lon=" + lon + ")" + "\n"
				+ "Precipitaciones=" + prec + "\n"
				+ "Temperatura Máxima= " + maxTemp + "ºC, Hora: " + formatHour.format(horaMaxTemp)+ "\n"
				+ "Temperatura Mínima= " + minTemp + "ºC, Hora: " + formatHour.format(horaMinTemp)+ "\n"
				+ "Temperatura media dia= " + Math.round(avgTemp) + "ºC\n";
	}
	
	@Override
	public int compareTo(Dia o) {
		return getDate().compareTo(o.getDate());
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public boolean isPrec() {
		return prec;
	}
	public void setPrec(boolean prec) {
		this.prec = prec;
	}
	public float getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(float maxTemp) {
		this.maxTemp = maxTemp;
	}
	public Date getHoraMaxTemp() {
		return horaMaxTemp;
	}
	public void setHoraMaxTemp(Date horaMaxTemp) {
		this.horaMaxTemp = horaMaxTemp;
	}
	public float getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(float minTemp) {
		this.minTemp = minTemp;
	}
	public Date getHoraMinTemp() {
		return horaMinTemp;
	}
	public void setHoraMinTemp(Date horaMinTemp) {
		this.horaMinTemp = horaMinTemp;
	}
	public float getAvgTemp() {
		return avgTemp;
	}
	public void setAvgTemp(float avgTemp) {
		this.avgTemp = avgTemp;
	}
		
}
