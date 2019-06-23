package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Censo;

public class Put {

	public static void doPut(HttpServletRequest request) throws IllegalArgumentException, Exception{

		Long indice = (long) Integer.parseInt(request.getParameter("indice"));

		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
	
		if(request.getParameter("ciudad")!=null) {
			c.setCiudad(request.getParameter("ciudad"));
		}else {
		
		}
		
		if(request.getParameter("pais")!=null) {
			c.setPais(request.getParameter("pais"));
		}else {
		
		}
		
		if(request.getParameter("poblacion")!=null) {
			
			if(Integer.parseInt(request.getParameter("poblacion"))<0) {
			throw new Exception();}
			else {
				c.setPoblacion(Integer.parseInt(request.getParameter("poblacion")));
				}}else {}
			
		
		
	
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();

		session.close();

		System.out.println("Censo editado: " + c);
	}

}
