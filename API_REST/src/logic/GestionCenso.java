package logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Censo;

public class GestionCenso {

	private static List<Censo> lstCenso = new ArrayList<Censo>();

	public static Censo getCenso(HttpServletRequest request) {
		int index = Integer.parseInt(request.getParameter("pos"));
		return lstCenso.get(index);
	}

	public static void addCenso(HttpServletRequest request) {
		String ciudad = request.getParameter("ciudad");
		String pais = request.getParameter("pais");
		Integer poblacion = Integer.parseInt(request.getParameter("poblacion"));
		Censo c = new Censo(ciudad, pais, poblacion);
		lstCenso.add(c);
	}

	public static void edtCenso(HttpServletRequest request) {
		int index = Integer.parseInt(request.getParameter("pos"));
		String ciudad = request.getParameter("ciudad");
		String pais = request.getParameter("pais");
		Integer poblacion = Integer.parseInt(request.getParameter("poblacion"));
		Censo c = lstCenso.get(index);
		if (ciudad != null) {
			c.setCiudad(ciudad);
		}
		if (pais != null) {
			c.setPais(pais);
		}
		if (poblacion != null) {
			c.setPoblacion(poblacion);
		}
		lstCenso.set(index, c);
	}

	public static void delPersona(HttpServletRequest request) {
		int index = Integer.parseInt(request.getParameter("pos"));
		lstCenso.remove(index);
	}
	}