package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class Get {
	public static void doGet(HttpServletRequest request) {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		session.close();

		System.out.println("El valor de este censo vale: " + c);
	}
}
