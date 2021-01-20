import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class AccesoBD {
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	static Session sesion=null;
	public static void inicializarConexion()
	{
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		sesion=sf.openSession();
	}
	
	public static void grabarAlumno(Alumno a) {
		Transaction t = sesion.beginTransaction();
		sesion.save(a);
		t.commit();
	}

	public static void grabarProfesor(Profesor p) {
		Transaction t = sesion.beginTransaction();
		sesion.save(p);
		t.commit();		
	}

	public static ArrayList<Profesor> listarProfesores() {
		Query q = sesion.createQuery("FROM Profesor");
		ArrayList<Profesor> profesores = (ArrayList<Profesor>) q.getResultList();
		return profesores;
	}

	public static Profesor buscarPId(int idProf) {
		Query q = sesion.createQuery("FROM Profesor where id="+idProf);
		Profesor profesor = (Profesor) q.getResultList().get(0);
		return profesor;
	}

	public static ArrayList<Alumno> buscarPId(ArrayList<Integer> idAl) {
		ArrayList<Alumno> alum = new ArrayList();
		for (Integer integer : idAl) {
			Query q = sesion.createQuery("FROM Alumno where id="+integer);
			alum.add((Alumno) q.getResultList().get(0));
		}
		
		
		return alum;
	}

	public static void updateProfesor(Profesor pr) {
		Transaction t = sesion.beginTransaction();
		sesion.update(pr);
		t.commit();		
	}

	public static ArrayList<Alumno> listarAlumnos() {
		Query q = sesion.createQuery("FROM Alumno");
		ArrayList<Alumno> alumnos = (ArrayList<Alumno>) q.getResultList();
		return alumnos;
	}

	public static ArrayList<Profesor> buscarPNombre(String nombre) {
		Query q = sesion.createQuery("FROM Profesor where nombre='"+nombre+"'");
		ArrayList<Profesor> profess = (ArrayList<Profesor>) q.getResultList();
		return profess;
	}

}
