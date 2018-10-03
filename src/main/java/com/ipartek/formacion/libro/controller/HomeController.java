package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	private Pagina mostrar_pagina;

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
	 * /**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Alert alert = new Alert();
		HttpSession session = request.getSession();

		try {

			paginas = new ArrayList<Pagina>();
			paginas = (ArrayList<Pagina>) dao.getAll();
			
			int numeracion = paginas.indexOf(mostrar_pagina);
			String numPagina = request.getParameter("numPagina");
			
			request.setAttribute("numPaginas", paginas.size());

			if (mostrar_pagina == null) {

				mostrar_pagina = paginas.get(0);
				

			} else {

				String op = request.getParameter("op");
				
				if (op != null) {
					switch (op) {
					case "siguiente":
									
							if (numeracion == paginas.size() - 1) { 
								alert.setTexto("Es la ultima página ");
								alert.setTipo(Alert.PRIMARY);
								session.setAttribute("alert", alert);
							} else {
								numeracion++;
							}
					
						mostrar_pagina = paginas.get(numeracion);
						break;
					case "anterior":
						if (numeracion == 0) { 
							alert.setTexto("Es la primera página ");
							alert.setTipo(Alert.PRIMARY);
							session.setAttribute("alert", alert);
						} else {
							numeracion--;
						}
						mostrar_pagina = paginas.get(numeracion);
						break;
					default:
						break;
					}

				} else {
					
					
					if (numPagina != null && !numPagina.isEmpty()) {
						
						numeracion = Integer.valueOf(numPagina);
						numeracion--;	
						mostrar_pagina = paginas.get(numeracion);
							
						
					}
				}

			}

		} catch (Exception e) { 

			e.printStackTrace();

		} finally {
			request.setAttribute("numPaginas", paginas.size());
			request.setAttribute("mostrar_pagina", mostrar_pagina);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}



}
