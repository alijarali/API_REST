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
		
		if(request.getParameter("indice") != null) {
			Long indice = Long.parseLong(request.getParameter("indice"));
			datosCenso = new Gson().toJson(lstCenso.get(indice));
		}else {
			datosCenso = new Gson().toJson(lstCenso);
		}
		return datosCenso;

	 Session mySession = HibernateUtil.getSession();
	 query = mySession.createQuery("CONSULTA A LA BD");
	 List<Censo> lista = query.list();
	 mySession.close();
	
	 //Consulta a la base de datos
	 String queryString = "";
		
		if(indice != null) {
			//Consulto buscando por indice
			queryString = "FROM Censo c WHERE C.indice =:indice";
		}else {
			//Consulta generica a la que se le iran añadiendo condiciones segun el caso
			queryString = "FROM Censo C WHERE 1=1";
			
			if(ciudad != null)
				queryString += " and C.ciudad =:ciudad";
			if(pais != null)
				queryString += " and C.pais =:pais";
			if(poblacion != null)
				queryString += " and C.poblacion =:poblacion";
			if(from != null)
				queryString += " and C.indice >=:from";
			if(to != null)
				queryString += " and C.indice <=:to";
			if(sort != null)
				queryString += " ORDER BY C."+sort+" ASC";
		}

		Session mySession = HibernateUtil.getSession();
		query = mySession.createQuery(queryString);

		if(id != null) {
					query.setParameter("indice",indice);
				}else {
					if(tipo != null)
						query.setParameter("ciudad", tipo);
					if(nombre != null)
						query.setParameter("pais", pais);
					if(precio != null) 
						query.setParameter("poblacion", poblacion);
					if(from != null)
						query.setParameter("from", from);
					if(to != null)
						query.setParameter("to", to);
				}

		List<Censo> lista = query.list();
		mySession.close();
	 }

}
		
		
		
