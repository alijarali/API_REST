package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import controller.Error400;
import dbm.HibernateUtil;
import model.Censo;

public class Post {

	public static void doPost(HttpServletRequest request) throws Error400{

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
		
	}


