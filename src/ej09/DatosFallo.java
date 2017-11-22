package ej09;

import java.text.DateFormat;
import java.util.Date;

public class DatosFallo {

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
		return format.format(date) + ", WindVel=" + WindVel + ", Precip=" + Precip + ", Temp=" + Temp + ", WindDir="
				+ WindDir;
	}

	public void imprimir() {
		System.out.println(format.format(date) + ", WindVel=" + WindVel + ", Precip=" + Precip + ", Temp=" + Temp + ", WindDir="
				+ WindDir);
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
