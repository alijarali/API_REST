package logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.google.gson.Gson;

import dbm.HibernateUtil;

import model.Censo;

public class Get {
	public static List<Censo> lstCenso = new ArrayList<Censo>();

	public static String doGet(HttpServletRequest request) throws IndexOutOfBoundsException, IllegalArgumentException {
		
		String ciudad;
		String pais;
		Integer poblacion;
		Long from;
		Long to;
		String sort;
		Long indice;
		System.out.println("entrando en doGet");
		if (request.getParameter("ciudad") != null) {
			ciudad = request.getParameter("ciudad");
		} else {
			ciudad = null;
		}
		if (request.getParameter("poblacion") != null) {
			poblacion = Integer.parseInt(request.getParameter("poblacion"));
		} else {
			poblacion = null;
		}
		if (request.getParameter("pais") != null) {
			pais = request.getParameter("pais");
		} else {
			pais = null;
		}
		
		sort = request.getParameter("sort");
		
		if (request.getParameter("from") != null) {
			from = Long.parseLong(request.getParameter("from"));
		} else {
			from = null;
		}
		if (request.getParameter("to") != null) {
			to = Long.parseLong(request.getParameter("to"));
		} else {
			to = null;
		}
		if (request.getParameter("indice") != null) {
			indice = Long.parseLong(request.getParameter("indice"));
		} else {
			indice = null;
		}
		


		Session Session = HibernateUtil.getSession();
		if (indice != null) {
			Censo c = Session.get(Censo.class, indice);
			if (c == null) {
				throw new IndexOutOfBoundsException();
			}
		}
		if (sort != null) {
			if (!sort.equals("ciudad") && !sort.equals("poblacion") && !sort.equals("pais")) {
				throw new IllegalArgumentException();
			}
		}

		
		String queryString = "";

		if (indice != null) {
			
			queryString = "FROM Censo C WHERE C.indice =:indice";
		} else {
			
			queryString = "FROM Censo C WHERE 1=1";

			if (ciudad != null)
				queryString += " and C.ciudad =:ciudad";
			if (pais != null)
				queryString += " and C.pais =:pais";
			if (poblacion != null)
				queryString += " and C.poblacion =:poblacion";
			if (from != null) {
				
				queryString += " and C.indice >=:from";
			}
			if (to != null)
				queryString += " and C.indice <=:to";
			if (sort != null)
				queryString += " ORDER BY C." + sort + " ASC";
		}
		Query query = Session.createQuery(queryString);
		if (indice != null) {
			query.setParameter("indice", indice);
		} else {
			if (ciudad != null)
				query.setParameter("ciudad", ciudad);
			if (pais != null)
				query.setParameter("pais", pais);
			if (poblacion != null)
				query.setParameter("poblacion", poblacion);
			if (from != null) {
				
				query.setParameter("from", from);
			}
				
			if (to != null)
				query.setParameter("to", to);
		}
		
		List<Censo> lista = query.list();
		
		Session.close();
		if (lista.size() == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			return new Gson().toJson(lista);
		}
		
	}

}
