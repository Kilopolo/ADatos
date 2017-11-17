package ej09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HoraRealClima implements Comparable<HoraRealClima> {

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
	
	/**
	 * CONSTRUCTOR
	 * Datos reales
	 * date,lat[unit="degrees_north"],lon[unit="degrees_east"],dir[unit="degree"],mod[unit="m s-1"],mslp[unit="Pa"],prec[unit="kg m-2"],rh[unit="1"],temp[unit="K"]
	 * 2017-11-09T01:00:00Z,43.339286234347675,-5.858834520544583,219.91175842285156,2.46604061126709,103059.8984375,9.999999747378752E-5,0.8752444982528687,278.53863525390625
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
	 * @param campos
	 */
	public HoraRealClima(String[] campos) {

		try {
			date = format.parse(campos[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problemas en el paraiso.(Fecha entra incorrecta):"
								+" el valor que entra es " + campos[0]
								+" y el formato de entrada es "
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
		
	}

	@Override
	public String toString() {
		return format.format(date) + "," + lat + "," + lon + "," + dir + "," + mod + "," + mslp + "," + prec + "," + rh
				+ "," + temp;
	}

	@Override
	public int compareTo(HoraRealClima o) {
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

	public String getDirStr() {
		//pasamos los grados a nombres
		if (dir >= 0 && dir <= 22.5) {
			return "Norte";
		} else if (dir > 22.5 && dir <= 67.5) {
			return "Noreste";
		} else if (dir > 67.5 && dir <= 112.5) {
			return "Este";
		} else if (dir > 122.5 && dir <= 157.5) {
			return "Sureste";
		} else if (dir > 157.5 && dir <= 202.5) {
			return "Sur";
		} else if (dir > 202.5 && dir <= 247.5) {
			return "Suroeste";
		} else if (dir > 247.5 && dir <= 292.5) {
			return "Oeste";
		} else if (dir > 292.5 && dir <= 337.5) {
			return "Noroeste";
		} else
			return "Norte";
	}

	public float getDir() {
		return dir;
	}

	public void setDir(float dir) {
		this.dir = dir;
	}

	public float getMod() {
		//mod = vel viento en modulo expresada en m/s devuelta en km/h
		return (mod*3600)/1000;
	}

	public void setMod(float mod) {
		this.mod = mod;
	}

	public float getMslp() {
		//nsbp = presion reducida a nivel del mar (presion atmosferica en  hecto Pascales que son 100x los Pascales) y en el otro aparece en Pascales
		return mslp/100;
	}

	public void setMslp(float mslp) {
		this.mslp = mslp;
	}

	public float getPrec() {
		//prec = kg/m2 aqui no hace falta pasar nada pq la pagina ya nos lo pasa en mm
		return prec;
	}

	public void setPrec(float prec) {
		this.prec = prec;
	}

	public float getRh() {
		//rh= humedad relativa AEMET nos lo da en tanto por ciento y el nuestro nos lo da en tanto por 1
		return rh*100;
	}

	public void setRh(float rh) {
		this.rh = rh;
	}

	public float getTemp() {
		//temp= temp expresada en grdos Kelvin nientras q aemet nos lo expresa en celsius (restar 273,15)
		
		return Math.round(temp - 273.15f);
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

}
