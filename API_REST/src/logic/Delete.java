package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class Delete {
	

	public static void doDelete(HttpServletRequest request) throws IllegalArgumentException{
		Long indice = (long) Integer.parseInt(request.getParameter("indice"));

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);

		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("El censo seleccionado ha sido eliminado: " + c);
}
}
