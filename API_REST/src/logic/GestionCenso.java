package logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class GestionCenso {
//No estoy seguro de que la lista deba iniciarse aquí
	private static List<Censo> lstCenso = new ArrayList<Censo>();

	public static void addCenso() {

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
	public static void getCenso() {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		session.close();

		System.out.println("El valor de este censo vale: " + c);
	}
	public static void edtCenso() {
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
	public static void delCenso() {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);

		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("El censo seleccionado ha sido eliminado: " + c);
	}
	
}


	