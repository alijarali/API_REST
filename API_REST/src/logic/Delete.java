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
if(c ==null) {
	throw new IllegalArgumentException();
}else {
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		
		

		System.out.println("El censo seleccionado ha sido eliminado: " + c);
		session.close();
}

}
}
