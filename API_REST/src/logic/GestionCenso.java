package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class GestionCenso {
//No estoy seguro de que la lista deba iniciarse aquí


	public static void addCenso(HttpServletRequest request) {

		Censo c = new Censo();
		c.setCiudad("Unknown!!!!");
		c.setPais("Unknown!!!!");
		c.setPoblacion(00000000000000);

		Session session = HibernateUtil.getSession();

		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("Un censo ha sido agregado a la BBDD: " + c);
	}
	public static void getCenso(HttpServletRequest request) {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		session.close();

		System.out.println("El valor de este censo vale: " + c);
	}
	public static void edtCenso(HttpServletRequest request) {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		//Aquí faltan cosas seguro, no estamos editando nada si se mira detenidamente

		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("Censo editado: " + c);
	}
	public static void delCenso(HttpServletRequest request) {
		Integer indice = Integer.parseInt(request.getParameter("indice"));

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);

		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("El censo seleccionado ha sido eliminado: " + c);
	}
	
}


	