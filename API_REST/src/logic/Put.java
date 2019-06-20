package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import controller.Error400;
import dbm.HibernateUtil;
import model.Censo;

public class Put {

	public static void doPut(HttpServletRequest request) throws Error400{

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

}
