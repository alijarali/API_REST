package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Error400;
import controller.Error404;

@WebServlet("/GestionCensoServlet")
	public class GestionCensoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
	    public GestionCensoServlet() {
	        super();
	    }
	    public static void testApiKey(HttpServletRequest request, HttpServletResponse response) {
	    	String key = request.getParameter("API_KEY");
	    	if(key == "123ABC") {
	    		
	    	}if(key == "ABC123") {
	    		
	    	}
	    	
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				response.getWriter().append(logic.Get.doGet(request));
			}catch(Error400 e){
				System.out.println("Se ha producido un error 400");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}catch(Error404 e){
				System.out.println("Se ha producido un error 404");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{logic.Post.doPost(request);
			}catch(Error400 e){
				System.out.println("Se ha producido un error 400");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
		}
		
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{logic.Put.doPut(request);
		}catch(Error400 e){
			System.out.println("Se ha producido un error 400");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
	}
		}
		
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			logic.Delete.doDelete(request);
		}catch(Error404 e){
			System.out.println("Se ha producido un error 404");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}
		}

