import java.util.ArrayList;

public class ClasePrincipal {
	public static void main(String[] args) {
		boolean continu = true;
		AccesoBD.inicializarConexion();
		while (continu) {
			ArrayList<Alumno> alumnos = new ArrayList();
			ArrayList<Profesor> profesores = new ArrayList();
			int opcion = EntradaSalida.pedirOpcionPrincipal();
			switch (opcion) {
			case EntradaSalida.INSERTARA:
				Alumno a = EntradaSalida.pedirAlumno();
				AccesoBD.grabarAlumno(a);
				break;
			case EntradaSalida.INSERTARP:
				Profesor p = EntradaSalida.pedirProfesor();
				AccesoBD.grabarProfesor(p);
				break;
			case EntradaSalida.ASOCIAR:
				profesores = AccesoBD.listarProfesores();
				EntradaSalida.mostrarProfesores(profesores);
				int idProf = EntradaSalida.pedirProfesor(profesores);
				Profesor pr = AccesoBD.buscarPId(idProf);
				alumnos = AccesoBD.listarAlumnos();
				EntradaSalida.mostrarAlumnos(alumnos);
				ArrayList<Integer> idAl = EntradaSalida.pedirAlumno(alumnos);
				ArrayList<Alumno> alumns = AccesoBD.buscarPId(idAl);
				pr.setAlumnos(alumns);
				AccesoBD.updateProfesor(pr);
				break;
			case EntradaSalida.LISTARP:
				profesores = AccesoBD.listarProfesores();
				EntradaSalida.mostrarProfesores(profesores);
				break;
			case EntradaSalida.BUSCARP:
				String nombre = EntradaSalida.pedirPABuscar();
				ArrayList<Profesor> profes = AccesoBD.buscarPNombre(nombre);
				EntradaSalida.mostrarProfesores(profes);
				break;
			case EntradaSalida.SALIR:
				continu = false;
				break;
			}
		}
	}
}
