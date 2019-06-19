package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class GestionCenso {



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
		
	}
	public static void delCenso(HttpServletRequest request) {
		
	}
	
}


	