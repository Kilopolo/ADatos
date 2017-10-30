package ev1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class pruebaaaaaa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String fechaString="2017/10/17 19:30";
		//SHORT is completely numeric, such as 12.13.52 or 3:30pm
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.GERMANY);
		Date date = format.parse(fechaString);
		System.out.println(date);
	}

}
