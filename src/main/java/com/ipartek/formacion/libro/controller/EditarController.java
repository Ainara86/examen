package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Pagina;
import com.ipartek.formacion.libro.pojo.Usuario;

/**
 * Servlet implementation class PublicarController
 */
@WebServlet("/editar")
public class EditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int MINIMO_PALABRAS = 25; 

	private PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	private Pagina pagina_escrita;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = PaginaArrayListDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcces(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcces(request, response);
	}

	private void doProcces(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Alert alert = new Alert();

		try {
			String contenido = request.getParameter("contenido");

			Usuario u = (Usuario) request.getSession().getAttribute("usuario");

			if (u != null) {
				if (palabras(contenido)) {
					pagina_escrita = new Pagina(dao.getAll().size(), contenido , u.getNombre());
				}
			}
			
			if (pagina_escrita != null) {
				dao.insert(pagina_escrita);
				alert.setTexto("Enhorabuena "+ u.getNombre() + " ha publicado una página. Gracias por su colaboración");
				alert.setTipo(Alert.PRIMARY);
			}else {
				alert.setTexto(u.getNombre() + " no has publicado nada. La longitud minima del texto ha de ser " + MINIMO_PALABRAS );
				alert.setTipo(Alert.PRIMARY);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			
			request.getSession().setAttribute("alert", alert);
			request.setAttribute("numPaginas", dao.getAll().size());
			request.getRequestDispatcher("backoffice/editar.jsp").forward(request, response);
		}

	}

	/*Contar palabras*/
	private boolean palabras(String contenido) {

		StringTokenizer tokens = new StringTokenizer(contenido, " ");
		if (tokens.countTokens() > MINIMO_PALABRAS) {	
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < MINIMO_PALABRAS; i++) {
				sb.append(tokens.nextToken() + " ");
			}
			
			return true;
		} 	
		
		return false;
	}

}