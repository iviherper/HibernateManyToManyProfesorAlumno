import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	final static int INSERTARP = 1;
	final static int INSERTARA = 2;
	final static int ASOCIAR = 3;
	final static int LISTARP = 4;
	final static int BUSCARP = 5;
	final static int SALIR = 0;
	static Scanner sc = new Scanner(System.in);
	public static int pedirOpcionPrincipal() {
		System.out.println("Introduce el numero de opcion que desea realizar:");
		System.out.println(INSERTARP+"- Insertar profesor");
		System.out.println(INSERTARA+"- Insertar Alumno");
		System.out.println(ASOCIAR+"- Asociar profesor-alumno");
		System.out.println(LISTARP+"- Listar profesores");
		System.out.println(BUSCARP+"- Buscar profesor");
		System.out.println(SALIR+"- Salir");
		int opcion = Integer.parseInt(sc.nextLine());
		return opcion;
	}
	public static Alumno pedirAlumno() {
		System.out.println("Introduce el nombre del alumno");
		String nombre = sc.nextLine();
		Alumno a = new Alumno();
		a.setNombre(nombre);
		return a;
	}
	public static Profesor pedirProfesor() {
		System.out.println("Introduce el nombre del profesor");
		String nombre = sc.nextLine();
		Profesor p = new Profesor();
		p.setNombre(nombre);
		return p;
	}
	public static int pedirProfesor(ArrayList<Profesor> profesores) {
		System.out.println("Escribe el id del profesor al que quiere asignar alumnos");
		int idprof = Integer.parseInt(sc.nextLine());
		return idprof;
	}
	public static ArrayList<Integer> pedirAlumno(ArrayList<Alumno> alumnos) {
		System.out.println("Escribe los ids de los alumnos que desea asignar al profesor, separados por comas");
		String ids= sc.nextLine();
		String idsAlums[] =  ids.replaceAll(" ", "").split(",");
		System.out.println(idsAlums.toString());
		ArrayList<Integer> idsInts = new ArrayList();
		for (String string : idsAlums) {
			idsInts.add(Integer.parseInt(string));
		}
		System.out.println(idsInts);
		return idsInts;
	}
	public static void mostrarProfesores(ArrayList<Profesor> profesores) {
		for (Profesor profesor : profesores) {
			System.out.println(profesor);
		}
		
	}
	public static String pedirPABuscar() {
		System.out.println("Introduce el nombre del profesor a buscar");
		String nomProf=sc.nextLine();
		return nomProf;
	}
	public static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
		
	}
	
}
