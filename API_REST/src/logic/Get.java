package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.google.gson.Gson;


import dbm.HibernateUtil;
import model.Censo;

public class Get {
	public static String doGet(HttpServletRequest request) throws IndexOutOfBoundsException {
		Long indice = 1L;
		String datosCenso = null;
		//lenguaje nativo de consulta mirar
		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		session.close();
		
		
		return datosCenso;
		

	}

	@SuppressWarnings("unused")
	public static String ListJSON(String datosCenso) {

		Session mySession = HibernateUtil.getSession();
		// ObjectMapper mapper = new ObjectMapper();
		// String jsonString = mapper.writeValueAsString(datosCenso);

		return datosCenso;

	}
}
