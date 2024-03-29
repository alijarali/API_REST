package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import exceptions.NegativePopulationException;
import model.Censo;

public class Post {

	public static void doPost(HttpServletRequest request) throws NegativePopulationException {

		Censo c = new Censo();

		if (request.getParameter("ciudad") == null) {
			c.setCiudad("");
		} else {
			c.setCiudad(request.getParameter("ciudad"));
		}

		if (request.getParameter("pais") == null) {
			c.setPais("");
		} else {
			c.setPais(request.getParameter("pais"));
		}
		if (request.getParameter("poblacion") == null) {
			c.setPoblacion(0);
		} else if (Integer.parseInt(request.getParameter("poblacion")) < 0) {
			throw new NegativePopulationException();
		}

		else {
			c.setPoblacion(Integer.parseInt(request.getParameter("poblacion")));
		}

		Session session = HibernateUtil.getSession();

		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("Un censo ha sido agregado a la BBDD: " + c);
	}

}
