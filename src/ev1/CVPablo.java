package ev1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class CVPablo {

	public static void main(String[] args) {
		try {
			BufferedWriter salida = new BufferedWriter(new FileWriter(".\\Curriculum.txt"));
			salida.write("Pablo Diaz Rubio");
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int Edad = 23;
	private String FechaNacimiento = "27/03/1994";
	private String Direccion = "C/Mateo Llana Nº3, 1ºB. Oviedo";
	private String Telefono = "644 393 493";
	private String email = "pablodiazsjm@hotmail.com";

	public void Idiomas() {
		HashMap<String, String> Idiomas = new HashMap<String, String>();
		Idiomas.put("Castellano", "C2(Nativo)");
		Idiomas.put("Ingles", "B2");
		Idiomas.put("Catalan", "B1");
	}

	public void FormacionAcademica() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Año deseado: ");
		int fecha = sc.nextInt();
		FormAcadAño(fecha);
	}

	private String FormAcadAño(int fecha) {
		if (fecha == 2018) {
			return "Título de Técnico Superior en Desarrollo de Aplicaciones Multiplataforma."
					+ "(Formación Profesional de Grado Superior en Asturias.)";
		} else if (fecha == 2017) {
			return "Vigilante de Seguridad Privada y Vigilante de proteccion de Explosivos."
					+ "(Certificacion de Profesionalidad de Vigilante de Seguridad y Vigilante de Explosivos en la academia de seguridad privada AFA.)";
		} else if (fecha == 2015) {
			return "Certificado de Profesionalidad en Montaje y reparación de equipos informáticos en SERESCO.";
		} else if (fecha == 2014) {
			return "Técnico superior en Proyectos de Edificación."
					+ "(Primer Curso de Formación Profesional de Grado Superior en Oviedo.)";
		} else if (fecha == 2013) {
			return "Prueba de Acceso a Grado Superior en Asurias." + "(Certificado de superación positivo.)";
		} else if (fecha == 2013) {
			return "Curso de Prevención de Riesgos Laborales."
					+ "(Técnico en Riesgos Laborales, conforme al Anexo IV del Real Decreto 39/1997.)"
					+ "Duración 50 horas lectivas.";
		} else if (fecha == 2013) {
			return "Título de Técnico en Pre-impresión y Artes Gráficas."
					+ "(Formación Profesional de Grado Medio en Baleares y en Asturias.)" + "Formación Complementaria.";
		} else if (fecha == 2010) {
			return "Título Oficial de Árbitro de Futbol."
					+ "(Concedido por el Comité Balear de Árbitros de Fútbol (C.A.F.I.B.).)";
		} else if (fecha == 2010) {
			return "Curso Teórico Práctico de Utilización del Desfibrilador y R.C.P. en Baleares.";
		} else
			return "Sin prisa pero sin pausa.";
	}

	public void ExperienciaLaboral() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Año deseado: ");
		int fecha = sc.nextInt();
		ExpLaboAño(fecha);
	}

	private String ExpLaboAño(int fecha) {
		if (fecha == 2017 || fecha == 2016 || fecha == 2015) {
			return "Auxiliar de Vigilante de Seguridad.( SABICO )";
		} else if (fecha == 2013) {
			return "Prácticas de Pre-impresión en Artes Gráficas.(Imprentas Narcea.)" + "\n"
					+ "Publicidad de Citroen España. (Islas Baleares)";
		} else if (fecha == 2012 || fecha == 2011 || fecha == 2010) {
			return "Árbitro de Fútbol en Baleares.";
		} else if (fecha == 2009) {
			return "Ayudante Aprendíz en Talleres Cugar S.L. en Oviedo.";
		} else
			return null;
	}
}

class Informatica {
	private boolean programador;
	private boolean preimpresor;

	public String necesidad() {
		if (programador == true) {
			return " Lenguajes: Java,Visual Basic, SQL, PL/SQL,Python,Html, CSS, XML. " + "\n"
					+ " Programas: Eclipse, Android Studio, SqlDeveloper, Visual Studio ";
		} else if (preimpresor == true) {
			return " Programas:  Adobe Illustrator, Adobe InDesign," + " Adobe Photoshop, AutoCAD, MDT, QuarkXPress, "
					+ "Freehand, Paquete office (Word, Excel, Outlook,...)," + " Adobe Acrobat Pro, Adobe Distiller  "
					+ "\n";
		} else
			return "Con ganas de aprender aun mucho más!";
	}
}