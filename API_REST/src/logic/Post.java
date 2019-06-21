package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class Post {

	public static void doPost(HttpServletRequest request) throws Exception{

			Censo c = new Censo();
			//Solo falta el tratamiento del índice.
			if(request.getParameter("indice")==null) {
				
				}else {
				
				}
			
			
			if(request.getParameter("ciudad")==null) {
			c.setCiudad("");
			}else {
			c.setCiudad(request.getParameter("ciudad"));
			}
			
			if(request.getParameter("pais")==null) {
			c.setPais("");
			}else {
			c.setPais(request.getParameter("pais"));
			}
			if(request.getParameter("poblacion")==null) {
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


