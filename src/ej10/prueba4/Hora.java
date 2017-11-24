package ej10.prueba4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class Hora implements Comparable<Hora> {
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
	private Date date;
	private float precip;
	private float temp;
	private float windVel;
	private String windDir;
	
	Hora(String[]campos){
		
		try {
			this.date = format.parse(campos[0]);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("PROBLEMA AL CREAR HORAS");
		}
		
		precip = Float.parseFloat(campos[1]);
		temp = Float.parseFloat(campos[2]);
		windVel = Float.parseFloat(campos[3]);
		windDir = campos[4];
		
		
	}

	@Override
	public String toString() {
		return "date=" + date + ", precip=" + precip + ", temp=" + temp + ", windVel=" + windVel + ", windDir="
				+ windDir;
	}

	@Override
	public int compareTo(Hora o) {
		// TODO Auto-generated method stub
		return getDate().compareTo(o.getDate());
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrecip() {
		return precip;
	}

	public void setPrecip(float precip) {
		this.precip = precip;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getWindVel() {
		return windVel;
	}

	public void setWindVel(float windVel) {
		this.windVel = windVel;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}
	
	
	
	
	
}
