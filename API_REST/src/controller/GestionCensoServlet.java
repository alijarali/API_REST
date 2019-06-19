package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.GestionCenso;

@WebServlet("/GestionCenso")
	public class GestionCensoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		
	    public GestionCensoServlet() {
	        super();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//response.getWriter().append(GestionCenso.getCenso(request).toString());
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			logic.Post.doPost(request);
			//lanzamiento de errores al cliente
			 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			logic.Put.doPut(request);
		}
		
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			logic.Delete.doDelete(request);
		}

	}

