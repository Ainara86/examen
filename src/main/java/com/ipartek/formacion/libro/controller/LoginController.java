package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libro.model.UsuarioArrayListDAO;
import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Usuario;

/**
 * Servlet para gestionar el inicio de sesión del usuario.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario>usuarios;
	private static UsuarioArrayListDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioArrayListDAO.getInstance();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				usuarios=(ArrayList<Usuario>) dao.getAll();
				Alert alert = new Alert();
				HttpSession session = request.getSession();
		try {

			
				String usuarioNombre = request.getParameter("usuarioNombre");
				String pass = request.getParameter("pass");
				
				for (Usuario u : usuarios) {
					if (u.getNombre().equalsIgnoreCase(usuarioNombre) && u.getPass().equalsIgnoreCase(pass)) {
						
						alert.setTexto("Bienvenido " + usuarioNombre );
						alert.setTipo(Alert.PRIMARY);
						
						session.setAttribute("usuario", u);
						session.setMaxInactiveInterval(60*5);
						break;
					}else{
					
					alert.setTexto("Credenciales incorrectas" );
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.setAttribute("alert", alert);	
			request.getRequestDispatcher("/inicio").forward(request, response);


		}
	}
}
