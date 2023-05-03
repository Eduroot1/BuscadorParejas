/**
 * 
 */
package parejas;



import java.util.Scanner;

import javax.swing.JOptionPane;


import entidades.Genero;
import entidades.Nacionalidades;
import entidades.Persona;




public class MainParejas {
	//ATRIBUTOS ESTATICOS
	public static final int TAM_MAX=100;//Numero maximo de personas en el sistema
	private static Persona[] listaPersona=new Persona[TAM_MAX];//Array donde se almacena las personas del sistema;
	public static Boolean fin;
	public static String eleccionUsuario;
	public static int contadorPersona;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		fin=false;
		contadorPersona = 0;
		Persona prueba1 = new Persona("Pepe", "Flores", 32, 80.0, Nacionalidades.ESP ,"Espanol", Genero.M,"Hetero","Diseñador3D", "Futbol");
		listaPersona[0]=prueba1;
		contadorPersona++;
		Persona prueba2 = new Persona("Laura", "Bellido", 31, 69.9,Nacionalidades.GBR, "Espanol", Genero.F, "Hetero", "Modelo", "Futbol");
		listaPersona[1]=prueba2; 
		contadorPersona++;

		while (fin==false) {
			menu();
		}
	}

	static void menu() {
		// Declaracion de variable para la elecccion del usuario para su posterior respuesta
		eleccionUsuario = JOptionPane.showInputDialog(
				"Que desea hacer\n " + "1.Añadir una nueva persona, PULSE 1\n " + "2.Buscar emparejamientos,PULSE 2\n "
						+ "3. Salir del programa,PULSE 3\n\n" + "Indique aquí a continuacion la opcion deseada");
		switch (eleccionUsuario) {
		case "1":
			altaPersona();
			break;
		case "2":
			emparejamiento();	
			break;
		case "3": 
			JOptionPane.showMessageDialog(null, "Fin del programa");
			fin=true;
			break;


		default: {
			JOptionPane.showMessageDialog(null, "Respuesta Incorrecta responda de nuevo");
			menu();
		}
		}
	}


	static void emparejamiento() {
		String eleccionUsuario;
		eleccionUsuario = JOptionPane.showInputDialog(
				"Como desea buscar?\n " + "1.Filtrando por orientacion sexual, PULSE 1\n " + "2.Personas con mas datos en comun,PULSE 2\n "
						+ "3.Personas con aficiones opuestas,PULSE 3\n " + "4.Busqueda aleatoria, PULSE 4\n " + "5.Volver al menu, PULSE 5\n\n " + "Indique aquí a continuacion la opcion deseada");
		switch (eleccionUsuario) {
		case "1":
			filtrando();
			break;
		case "2":
			buscarPersonasDatosComunes();	
			break;
		case "3":
			buscarPersonasAficionesOpuestas();	
			break;
		case "4":
			busquedaAleatoria();	
			break;
		case "5":
			menu();	
			break;
		case "6": 
			JOptionPane.showMessageDialog(null, "Fin del programa");
			fin=true;
			break;


		default: {
			JOptionPane.showMessageDialog(null, "Respuesta Incorrecta responda de nuevo");
			emparejamiento();
		}
		}
	}


	public static String elegirString(String pregunta) {
		System.out.println(pregunta);
		Scanner sc=new Scanner(System.in);
		return sc.nextLine();
	}

	//Metodo alta persona

	public static void altaPersona() {
		if (contadorPersona >= TAM_MAX) {
			System.out.println("Se ha alcanzado el número máximo de personas en el sistema.");
			menu();
			return;
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("Cual es tu nombre? ");
		String nombre = sc.nextLine();

		System.out.println("Cuales son tus apellidos? ");
		String apellidos = sc.nextLine();

		System.out.println("Cual es tu edad? ");
		int edad = sc.nextInt();

		System.out.println("Cual es tu peso (kg)? ");
		double peso = sc.nextDouble();

		System.out.println("Cual es tu nacionalidad entre ESP, GBR, USA, PTR? ");
		String nacionalidadString = sc.next();
		Nacionalidades nacionalidad = null;
		switch (nacionalidadString) {
		case "ESP":
			nacionalidad = Nacionalidades.ESP;
			break;
		case "GBR":
			nacionalidad = Nacionalidades.GBR;
			break;
		case "USA":
			nacionalidad = Nacionalidades.USA;
			break;
		case "PTR":
			nacionalidad = Nacionalidades.PTR;
			break;
		default:
			System.out.println("Nacionalidad no válida.");
			altaPersona();
			return;
		}

		System.out.println("Dime tu idioma: ");
		String idioma = sc.next();

		System.out.println("Dime tu género (M/F): ");
		String generoString = sc.next();
		Genero genero = null;
		switch (generoString) {
		case "M":
			genero = Genero.M;
			break;
		case "F":
			genero = Genero.F;
			break;
		default:
			System.out.println("Género no válido.");
			altaPersona();
			return;
		}

		System.out.println("Cual es tu orientacion sexual? ");
		String orientacionSexual = sc.next();

		System.out.println("Describete: ");
		String descripcion = sc.next();

		System.out.println("Dime tus intereses (separados por comas): ");
		String interesesString = sc.next();
		String[] intereses = interesesString.split(",");



		Persona persona = new Persona(nombre, apellidos, edad, peso, nacionalidad, idioma, genero, orientacionSexual, descripcion, interesesString);
		listaPersona[contadorPersona] = persona;
		contadorPersona++;

		System.out.println("Persona agregada correctamente.");

		menu();
	}

	// Metodo para filtrar por orientacionSexual
	private static void filtrando() {
		//Se le solicita al usuario el orientacionSexual
		String orientacionSexual=elegirString("Indica la orientacion sexual");
		boolean hayAlgunaPersona=false;
		for(int i=0;i<contadorPersona;i++) { //Recorremos todos las personas
			if(listaPersona[i].getOrientacionSexual().equals(orientacionSexual)){//Si la orientacion sexual es la misma
				//que el que estamos buscando
				hayAlgunaPersona=true;//Hay alguna persona con la misma orientacion sexual
				System.out.println(listaPersona[i].getNombre());//Se muestra el nombre por pantalla de las personas con la misma orientacion sexual

			}
		}
		if(!hayAlgunaPersona) {//Si no hay ninguna persona con dicha orientación sexual
			System.out.println("No hay ninguna persona con la misma orientacion sexual en el sistema" );

		}

	}

	//Metodo para buscar personas con mas datos en comun

	static void buscarPersonasDatosComunes() {
		if (contadorPersona < 2) {
			JOptionPane.showMessageDialog(null, "No hay suficientes personas registradas en el sistema para buscar datos en común.");
			return;
		}

		int maxDatosComunes = 0;
		Persona persona1 = null;
		Persona persona2 = null;

		for (int i = 0; i < contadorPersona - 1; i++) {
			for (int j = i + 1; j < contadorPersona; j++) {
				int datosComunes = 0;
				Persona p1 = listaPersona[i];
				Persona p2 = listaPersona[j];

				// Compara los atributos de las personas para encontrar datos en común
				if (p1.getNacionalidad() == p2.getNacionalidad()) {
					datosComunes++;
				}
				if (p1.getIdioma().equals(p2.getIdioma())) {
					datosComunes++;
				}
				if (p1.getSexo() == p2.getSexo()) {
					datosComunes++;
				}
				// Agrega más comparaciones según los atributos que desees considerar

				if (datosComunes > maxDatosComunes) {
					maxDatosComunes = datosComunes;
					persona1 = p1;
					persona2 = p2;
				}
			}
		}

		if (maxDatosComunes == 0) {
			JOptionPane.showMessageDialog(null, "No se encontraron personas con datos en común.");
		} else {
			JOptionPane.showMessageDialog(null, "Personas con más datos en común:\n" +
					"Persona 1:\n" +
					"Nombre: " + persona1.getNombre() + "\n" +
					"Apellidos: " + persona1.getApellidos() + "\n" +
					"Persona 2:\n" +
					"Nombre: " + persona2.getNombre() + "\n" +
					"Apellidos: " + persona2.getApellidos() + "\n" +
					"Cantidad de datos en común: " + maxDatosComunes);
		}
	}

	//Metodo para buscar personas con aficiones opuestas

	static void buscarPersonasAficionesOpuestas() {
		if (contadorPersona < 2) {
			JOptionPane.showMessageDialog(null, "No hay suficientes personas registradas en el sistema para buscar personas con aficiones opuestas.");
			return;
		}

		boolean encontradas = false;

		for (int i = 0; i < contadorPersona - 1; i++) {
			for (int j = i + 1; j < contadorPersona; j++) {
				Persona p1 = listaPersona[i];
				Persona p2 = listaPersona[j];

				if (!p1.getIntereses().equals(p2.getIntereses())) {
					JOptionPane.showMessageDialog(null, "Personas con aficiones opuestas:\n" +
							"Persona 1:\n" +
							"Nombre: " + p1.getNombre() + "\n" +
							"Apellidos: " + p1.getApellidos() + "\n" +
							"Intereses: " + p1.getIntereses() + "\n" +
							"Persona 2:\n" +
							"Nombre: " + p2.getNombre() + "\n" +
							"Apellidos: " + p2.getApellidos() + "\n" +
							"Intereses: " + p2.getIntereses());
					encontradas = true;
				}
			}
		}

		if (!encontradas) {
			JOptionPane.showMessageDialog(null, "No se encontraron personas con aficiones opuestas.");
		}
	}

	//Metodo para busqueda aleatoria

	static void busquedaAleatoria() {
		if (contadorPersona == 0) {
			JOptionPane.showMessageDialog(null, "No hay personas registradas en el sistema.");
			return;
		}

		int indiceAleatorio = (int) (Math.random() * contadorPersona);
		Persona personaAleatoria = listaPersona[indiceAleatorio];

		JOptionPane.showMessageDialog(null, "Persona encontrada:\n" +
				"Nombre: " + personaAleatoria.getNombre() + "\n" +
				"Apellidos: " + personaAleatoria.getApellidos() + "\n" +
				"Edad: " + personaAleatoria.getEdad() + "\n" +
				"Peso: " + personaAleatoria.getPeso() + "\n" +
				"Nacionalidad: " + personaAleatoria.getNacionalidad() + "\n" +
				"Idioma: " + personaAleatoria.getIdioma() + "\n" +
				"Sexo: " + personaAleatoria.getSexo() + "\n" +
				"Orientación sexual: " + personaAleatoria.getOrientacionSexual() + "\n" +
				"Intereses: " + personaAleatoria.getIntereses() + "\n" +
				"Descripción: " + personaAleatoria.getDescripcion());
	}
}
