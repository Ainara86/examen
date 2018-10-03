package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Servlet implementation class BuscaController
 */
@WebServlet("/buscar")
public class BusquedaController extends HttpServlet {
	
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palabra = request.getParameter("palabra");
		
		if(palabra != null) {
			request.setAttribute("palabra", buscarTexto(palabra));
		}
		
		request.getRequestDispatcher("resultados.jsp").forward(request, response);
	}
	
	public String buscarTexto(String palabra) {
		String mostrarBus= "No se ha encontrado nada!";
        int id;
        for( int i = 0 ; i  < paginas.size(); i++){
            if(paginas.get(i).getContenido().equals(palabra)){
                paginas.get(i).getContenido();
                mostrarBus += "n"+"n";
            }                        
       }
	        return mostrarBus;
	        
	        
	       
    }
}