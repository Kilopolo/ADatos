package ej06;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Hora implements Comparable<Hora> {
	/**
	 * fechayHora.toInstant()
	 * 
	 * Cabezera: date, = 2015-10-15T13:00:00Z, lat[unit="degrees_north"], =
	 * 43.30409333859623, lon[unit="degrees_east"], = -5.88658785664861,
	 * dir[unit="degree"], = 29.211597, mod[unit="m s-1"], = 5.076003,
	 * mslp[unit="Pa"], = 101692.17, prec[unit="kg m-2"], = 0.0, rh[unit="1"], =
	 * 0.4861827, temp[unit="K"], = 289.59418, wind_gust[unit="m s-1"] = 4.9939604
	 *
	 * "dd/MM/yyyy HH:mm"
	 */
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.GERMANY);
	private Date date;
	private float lat;
	private float lon;
	private float dir;
	private float mod;
	private float mslp;
	private float prec;
	private float rh;
	private float temp;
	private float wind_gust;

	public Hora(String[] campos) {

		try {
			date = format.parse(campos[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problemas en el paraiso.(Fecha entra incorrecta):"
								+" el valor que entra es " + campos[0]
								+" y el formato deseado es "
								+"yyyy-MM-dd'T'HH:mm:ss'Z'");
		}
		lat = Float.parseFloat(campos[1]);
		lon = Float.parseFloat(campos[2]);
		dir = Float.parseFloat(campos[3]);
		mod = Float.parseFloat(campos[4]);
		mslp = Float.parseFloat(campos[5]);
		prec = Float.parseFloat(campos[6]);
		rh = Float.parseFloat(campos[7]);
		temp = Float.parseFloat(campos[8]);
		wind_gust = Float.parseFloat(campos[9]);

	}

	@Override
	public String toString() {
		return format.format(date) + "," + lat + "," + lon + "," + dir + "," + mod + "," + mslp + "," + prec + "," + rh
				+ "," + temp + "," + wind_gust;
	}

	@Override
	public int compareTo(Hora o) {
		return getDate().compareTo(o.getDate());
	}

	public Hora(DateFormat format, Date date, float lat, float lon, float dir, float mod, float mslp, float prec,
			float rh, float temp, float wind_gust) {
		super();
		this.format = format;
		this.date = date;
		this.lat = lat;
		this.lon = lon;
		this.dir = dir;
		this.mod = mod;
		this.mslp = mslp;
		this.prec = prec;
		this.rh = rh;
		this.temp = temp;
		this.wind_gust = wind_gust;
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

	public float getDir() {
		return dir;
	}

	public void setDir(float dir) {
		this.dir = dir;
	}

	public float getMod() {
		return mod;
	}

	public void setMod(float mod) {
		this.mod = mod;
	}

	public float getMslp() {
		return mslp;
	}

	public void setMslp(float mslp) {
		this.mslp = mslp;
	}

	public float getPrec() {
		return prec;
	}

	public void setPrec(float prec) {
		this.prec = prec;
	}

	public float getRh() {
		return rh;
	}

	public void setRh(float rh) {
		this.rh = rh;
	}

	public float getTemp() {
		return Math.round(temp- 273.15f);
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getWind_gust() {
		return wind_gust;
	}

	public void setWind_gust(float wind_gust) {
		this.wind_gust = wind_gust;
	}

}
