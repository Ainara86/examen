package com.ipartek.formacion.libro.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libro.pojo.Pagina;
import com.ipartek.formacion.libro.pojo.Usuario;

public class PaginaArrayListDAO implements CrudAble<Pagina> {

	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> paginas = null;

	private PaginaArrayListDAO() {
		paginas = new ArrayList<Pagina>();
		try {

			crearPagsMock();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void crearPagsMock() {

		paginas.add(new Pagina(0 , "Érase una vez..." , "Anonimo"));
		paginas.add(new Pagina(1 , "una niña que era muy querida por su abuelita, a la que visitaba con frecuencia aunque vivía al otro lado del bosque. Su madre que sabía coser muy bien le había hecha una bonita caperuza roja que la niña nunca se quitaba, por lo que todos la llamaban Caperucita roja." , "William"));
		paginas.add(new Pagina(2 , "Una tarde la madre la mandó a casa de la abuelita que se encontraba muy enferma, para que le llevara unos pasteles recién horneados, una cesta de pan y mantequilla. “Caperucita anda a ver cómo sigue tu abuelita y llévale esta cesta que le he preparado”, –le dijo. Además le advirtió: –“No te apartes del camino ni hables con extraños, que puede ser peligroso”." , "Pablo"));

	}

	public static synchronized PaginaArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PaginaArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pojo) {
		return paginas.add(pojo);
	}

	@Override
	public List<Pagina> getAll() {
		return paginas;
	}

	@Override
	public Pagina getById(int num_pag) {
		Pagina resul = null;
		for (Pagina pag : paginas) {
			if (num_pag == pag.getNum_pagina()) {
				resul = pag;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Pagina pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		boolean resul = false;
		return resul;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagina getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
