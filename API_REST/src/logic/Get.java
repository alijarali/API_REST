package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.google.gson.Gson;


import dbm.HibernateUtil;
import model.Censo;
import util.Map;

public class Get {
	 public static String doGet(HttpServletRequest request) throws IndexOutOfBoundsException {
		Session session = HibernateUtil.getSession();
		Censo c = session.get(Censo.class, indice);
		
		Map<String, String[]> mapaPar = request.getParameterMap();
		Integer indice = null;
		String ciudad = request.getParameter("ciudad");
		String pais = request.getParameter("pais");
		Integer poblacion = null;
		Integer from = null;
		Integer to=null;
		
		if(mapaPar.containsKey("indice")) {
			indice=Integer.parseInt(request.getParameter("indice"));
		}
		
		if(mapaPar.containsKey("poblacion")) {
			if(poblacion=Integer.parseInt(request.getParameter("poblacion"))<0) {
				throw new Exception("Poblacion no valida");
			}else {
				c.setPoblacion(Integer.parseInt(request.getParameter("poblacion")));	
		}}else {
		}
		
		if(mapaPar.containsKey("from")) {
			from=Integer.parseInt(request.getParameter("from"));
		}
		if(mapaPar.containsKey("to")) {
			to=Integer.parseInt(request.getParameter("to"));
		}
		
		return ListJSON(indice, ciudad, pais, poblacion, to, from);
	 }
		
		/*Long indice = 1L;
		String datosCenso = null;*/
		//lenguaje nativo de consulta mirar
		
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
