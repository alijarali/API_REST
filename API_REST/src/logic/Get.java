package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import controller.Error400;
import controller.Error404;
import dbm.HibernateUtil;
import model.Censo;

public class Get {
	public static String doGet(HttpServletRequest request) throws Error400, Error404{
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		session.close();

		System.out.println("El valor de este censo vale: " + c);
		return null;
	}
}
