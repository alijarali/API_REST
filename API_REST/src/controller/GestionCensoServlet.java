package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GestionCensoServlet")
	public class GestionCensoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
	    public GestionCensoServlet() {
	        super();
	    }
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(util.CheckApiKey.isApiKey1(request.getParameter("API_KEY"))) {
			
			try {
				System.out.println("Recibido");
				response.getWriter().append( logic.Get.doGet(request) );
			}catch(IndexOutOfBoundsException e){
				System.out.println("Se ha producido un error 400");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			}else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{System.out.println("Recibido");
				logic.Post.doPost(request);
			}catch(IndexOutOfBoundsException e){
				System.out.println("Se ha producido un error 400");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
		}
		
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{System.out.println("Recibido");
				logic.Put.doPut(request);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Se ha producido un error 400");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
	}
		}
		
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {System.out.println("Recibido");
			logic.Delete.doDelete(request);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Se ha producido un error 404");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}
		}

