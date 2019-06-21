package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.google.gson.Gson;

import controller.Error400;
import controller.Error404;
import dbm.HibernateUtil;
import model.Censo;

public class Get {
	public static String doGet(HttpServletRequest request) throws Error400, Error404{
		Long indice = 1L;
		String datosCenso = null;
		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		session.close();

		System.out.println("El valor de este censo vale: " + c);
	
		return datosCenso;
	}
@SuppressWarnings("unused")
public static String ListJSON(String datosCenso) {		
		
		Session mySession = HibernateUtil.getSession();
		//ObjectMapper mapper = new ObjectMapper();
		//String jsonString = mapper.writeValueAsString(datosCenso);
		
		return datosCenso;
		
	}
}
