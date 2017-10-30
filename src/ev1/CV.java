package ev1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class CV {

	public static void main(String[] args) {
		try {
			BufferedWriter salida = new BufferedWriter(new FileWriter(".\\Curriculum.txt"));  
			salida.write("Pablo Diaz Rubio");
			salida.close(); // cierra el fichero
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int Edad = 23;
	private String FechaNacimiento = "27/03/1994";
	private String Direccion = "C/Mateo Llana N�3, 1�B. Oviedo";
	private String Telefono = "644 393 493";
	private String email = "pablodiazsjm@hotmail.com";
/**
 * 	 	Idiomas
	 Castellano: C2 (nativo).
	 Ingl�s: B2.
	 Catal�n: B1.
 */
	HashMap<String, String> Idiomas = new HashMap<String, String>();

	public CV() {
		Idiomas.put("Castellano", "C2(Nativo)");
		Idiomas.put("Ingles", "B2");
		Idiomas.put("Catalan", "B1");
	}
	
	/**
	 * Formaci�n Acad�mica
2018 T�tulo de T�cnico Superior en Desarrollo de Aplicaciones Multiplataforma.
Formaci�n Profesional de Grado Superior en Asturias.
2017 Vigilante de Seguridad Privada y Vigilante de proteccion de Explosivos.
Certificacion de Profesionalidad de Vigilante de Seguridad y Vigilante de Explosivos en la academia de seguridad privada AFA.
2015 Certificado de Profesionalidad en Montaje y reparaci�n de equipos inform�ticos en SERESCO.
2014 T�cnico superior en Proyectos de Edificaci�n.
Primer Curso de Formaci�n Profesional de Grado Superior en Oviedo.
2013 Prueba de Acceso a Grado Superior en Asurias.
Certificado de superaci�n positivo.
2013 Curso de Prevenci�n de Riesgos Laborales.
T�cnico en Riesgos Laborales, conforme al Anexo IV del Real Decreto 39/1997.
Duraci�n 50 horas lectivas.
2013 T�tulo de T�cnico en Pre-impresi�n y Artes Gr�ficas.
Formaci�n Profesional de Grado Medio en Baleares y en Asturias.
Formaci�n Complementaria.
2010 T�tulo Oficial de �rbitro de Futbol.
Concedido por el Comit� Balear de �rbitros de F�tbol (C.A.F.I.B.).
2010 Curso Te�rico Pr�ctico de Utilizaci�n del Desfibrilador y R.C.P. en Baleares.

	 */
	
	public void FormacionAcademica() {
		Scanner sc= new Scanner(System.in);
		System.out.println("A�o deseado: ");
		int fecha=sc.nextInt();
		FormAcadA�o(fecha);
	}
	private String FormAcadA�o(int fecha){
		if (fecha==2018) {
			return "T�tulo de T�cnico Superior en Desarrollo de Aplicaciones Multiplataforma."
					+ "(Formaci�n Profesional de Grado Superior en Asturias.)";
		} else if(fecha==2017){
			return "Vigilante de Seguridad Privada y Vigilante de proteccion de Explosivos."
					+ "(Certificacion de Profesionalidad de Vigilante de Seguridad y Vigilante de Explosivos en la academia de seguridad privada AFA.)";
		} else if(fecha==2015){
			return "Certificado de Profesionalidad en Montaje y reparaci�n de equipos inform�ticos en SERESCO.";
		} else if(fecha==2014){
			return "T�cnico superior en Proyectos de Edificaci�n."
					+ "(Primer Curso de Formaci�n Profesional de Grado Superior en Oviedo.)";
		} else if(fecha==2013){
			return "Prueba de Acceso a Grado Superior en Asurias."
					+ "(Certificado de superaci�n positivo.)";
		} else if(fecha==2013){
			return "Curso de Prevenci�n de Riesgos Laborales."
					+ "(T�cnico en Riesgos Laborales, conforme al Anexo IV del Real Decreto 39/1997.)"
					+ "Duraci�n 50 horas lectivas.";
		} else if(fecha==2013){
			return "T�tulo de T�cnico en Pre-impresi�n y Artes Gr�ficas."
					+ "(Formaci�n Profesional de Grado Medio en Baleares y en Asturias.)"
					+ "Formaci�n Complementaria.";
		} else if(fecha==2010){
			return "T�tulo Oficial de �rbitro de Futbol."
					+ "(Concedido por el Comit� Balear de �rbitros de F�tbol (C.A.F.I.B.).)";
		} else if(fecha==2010){
			return "Curso Te�rico Pr�ctico de Utilizaci�n del Desfibrilador y R.C.P. en Baleares.";
		} else
			return "Sin prisa pero sin pausa.";
	}
	
	
	
	/**
	 * Experiencia Laboral
	2015-17 Auxiliar de Vigilante de Seguridad.
	En la empresa SABICO
	2013 Pr�cticas de Pre-impresi�n en Artes Gr�ficas.
	En Imprentas Narcea.
	2013 Publicidad de Citroen Espa�a.
	Para concesionarios de las Islas Baleares.
	2010 �rbitro de F�tbol en Baleares.
	�rbitro de F�bol desde Categor�a de Prebenjam�n hasta la Categor�a de 2� Regional Amateur. �rbitro asistente hasta la categor�a de 3� Divisi�n. Duraci�n 3 a�os.
	2009 Talleres Cugar S.L. en Oviedo.
	Ayudante Aprend�z en Talleres Mec�nicos CUGAR S.L. de Autom�viles y Veh�culos Industriales.
	 */
	public void ExperienciaLaboral() {
		Scanner sc= new Scanner(System.in);
		System.out.println("A�o deseado: ");
		int fecha=sc.nextInt();
		ExpLaboA�o(fecha);
	}
	private String ExpLaboA�o(int fecha){
		if (fecha==2017||fecha==2016||fecha==2015) {
			return "Auxiliar de Vigilante de Seguridad.( SABICO )";
		} else if(fecha==2013){
			return "Pr�cticas de Pre-impresi�n en Artes Gr�ficas.(Imprentas Narcea.)"
					+ "\n" + "Publicidad de Citroen Espa�a. (Islas Baleares)";
		}else if(fecha==2012||fecha==2011||fecha==2010){
			return "�rbitro de F�tbol en Baleares.";
		}else if (fecha==2009){
			return "Ayudante Aprend�z en Talleres Cugar S.L. en Oviedo.";
		}else
		return null;
	}
	
	
}



/**
 *  Inform�tica
 Lenguajes: Java,Visual Basic, SQL, PL/SQL,Python,Html, CSS, XML.
 Programas: Eclipse, Android Studio, SqlDeveloper, Visual Studio, Paquete office
 (Word, Excel, Outlook,...), Adobe Acrobat Pro, Adobe Distiller, Adobe
 Illustrator, Adobe InDesign, Adobe Photoshop, AutoCAD, MDT, QuarkXPress,
 Freehand
 Nivel avanzado en los Sistemas Operativos: Macintosh, Windows, Linux.
 */

class Informatica {
	private boolean programador;
	private boolean preimpresor;

	public String necesidad() {
		if (programador == true) {
			return " Lenguajes: Java,Visual Basic, SQL, PL/SQL,Python,Html, CSS, XML. " + "\n"
					+ " Programas: Eclipse, Android Studio, SqlDeveloper, Visual Studio ";
		} else if (preimpresor == true) {
			return " Programas:  Adobe Illustrator, Adobe InDesign,"
					+ " Adobe Photoshop, AutoCAD, MDT, QuarkXPress, "
					+ "Freehand, Paquete office (Word, Excel, Outlook,...),"
					+ " Adobe Acrobat Pro, Adobe Distiller  "	+ "\n";
		} else
			return "Con ganas de aprender aun mucho m�s!";
	}

}
