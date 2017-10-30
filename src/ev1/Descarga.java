package ev1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Descarga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//ULR con la foto
			URL url = new URL ("http://www.nwcsaf.org/AemetWebContents/ReferenceSystem/GEO/NRT_images/SAFN-EU-PC___-MAG1-LAST.GIF");
			
			//establecemos la conexion
			
			 URLConnection urlCon = url.openConnection();
			 
			 
			 //sacamos por pantalla el tipo de fichero
			 System.out.println(urlCon.getContentType());
			 
			 //se obtiene el iput stream del gif web y se abre el fichero local
			 InputStream is = urlCon.getInputStream();
			 
			 FileOutputStream foStream = new FileOutputStream("D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Maemialoko.gif");
			 
			 
			 //lectura del gif de la web y escritura en el fichero local
			 byte[] array = new byte[1000];//buffer temporal de lectura
			 int leido = is.read(array);
			 while (leido > 0) {
				 
				 foStream.write(array, 0, leido);
				 leido = is.read(array);
				 
			 }
			 
			 //cierre de la conexion y fichero
			 is.close();
			 foStream.close();
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
