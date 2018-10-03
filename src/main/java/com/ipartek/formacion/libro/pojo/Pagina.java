package com.ipartek.formacion.libro.pojo;

import java.util.StringTokenizer;

public class Pagina {

	private static final int MINIMO_PALABRAS=25;
	private int num_pagina;	
	private String contenido;
	private String autor;

		public Pagina() {
		super();
		this.num_pagina=1;
		this.contenido = "";
		this.autor = "";
	}

	public Pagina(int num_pagina, String contenido, String autor) {
		super();
		this.num_pagina=num_pagina;
		this.contenido = contenido;
		this.autor = autor;
	}
	
	public int getNum_pagina() {
		return num_pagina;
	}

	public void setNum_pagina(int num_pagina) {
		this.num_pagina = num_pagina;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public boolean palabras(String contenido) {
		
		String texto = this.contenido;	
		StringTokenizer tokens = new StringTokenizer(texto, " ");
		
		if (tokens.countTokens() > MINIMO_PALABRAS) {	// Si el texto es mayor que LONGITUD_TEXTO_ABREVIADO
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < MINIMO_PALABRAS; i++) {
				sb.append(tokens.nextToken() + " ");
			}
			
			return true;
		} 	
		
		return false;	
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
