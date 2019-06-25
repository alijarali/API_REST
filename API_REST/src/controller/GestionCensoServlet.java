package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.IndexNotEspecified;
import exceptions.NegativePopulationException;


@WebServlet("/GestionCensoServlet")
public class GestionCensoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionCensoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (util.CheckApiKey.isApiKey1(request.getParameter("API_KEY"))
				|| util.CheckApiKey.isApiKey2(request.getParameter("API_KEY"))) {

			try {
				System.out.println("Recibido");
				response.getWriter().append(logic.Get.doGet(request));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Se ha producido un error 404");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} catch (IllegalArgumentException e) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			} 
			catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

			} 
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NegativePopulationException {
		if (util.CheckApiKey.isApiKey2(request.getParameter("API_KEY"))) {
			try {
				System.out.println("Recibido");
				logic.Post.doPost(request);
			} catch (NegativePopulationException e) {
				System.out.println("Se ha producido un error 400, la población introducida es <0");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			}catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

			} 
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (util.CheckApiKey.isApiKey2(request.getParameter("API_KEY"))) {

			try {
				logic.Put.doPut(request);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Se ha producido un error 404, el elemento no ha sido encontrado");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);

			}

			catch (NegativePopulationException e) {
				System.out.println("Se ha producido un error 400, la población introducida es <0");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			}
			catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

			} 

		}

		else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (util.CheckApiKey.isApiKey2(request.getParameter("API_KEY"))) {
			try {
				System.out.println("Recibido");
				logic.Delete.doDelete(request);
			}catch (IndexNotEspecified e) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);

			} 
			catch (IndexOutOfBoundsException e) {
				System.out.println("Se ha producido un error 404, el elemento no ha sido encontrado");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				
			}catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

			} 

		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		}
	}

}
