package logic;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.google.gson.Gson;

import dbm.HibernateUtil;

import model.Censo;



public class Get {
	private static List<Censo> LstCenso = new ArrayList<Censo>();
	
	 public static String doGet(HttpServletRequest request) throws IndexOutOfBoundsException {
		String datosCenso ="";
		
		if(request.getParameter("pos") != null) {
			int indice = Integer.parseInt(request.getParameter("pos"));
			datosCenso = new Gson().toJson(lstCenso.get(indice));
		}else {
			datosCenso = new Gson().toJson(lstCenso);
		}
		return datosCenso;

	 Session mySession = HibernateUtil.getSession();
	 query = mySession.createQuery("CONSULTA A LA BD");
	 List<Censo> lista = query.list();
	 mySession.close();
	}

}
