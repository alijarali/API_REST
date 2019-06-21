package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import controller.Error400;
import dbm.HibernateUtil;
import model.Censo;

public class Post {

	public static void doPost(HttpServletRequest request) throws Error400{

			Censo c = new Censo();
			if(request.getParameter("ciudad")=="") {
			c.setCiudad("");
			}else {
			c.setCiudad(request.getParameter("ciudad"));
			}
			
			if(request.getParameter("pais")=="") {
			c.setPais("");
			}else {
			c.setPais(request.getParameter("pais"));
			}
			if(request.getParameter("poblacion")=="") {
			c.setPoblacion(0);
			}else {
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


