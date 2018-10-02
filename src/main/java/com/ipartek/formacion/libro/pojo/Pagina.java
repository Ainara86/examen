package com.ipartek.formacion.libro.pojo;

import java.util.StringTokenizer;

public class Pagina {

	private static final int TEXTO_MINIMO=25;
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


	public String palabras() {
		
		String texto = this.contenido;	
		StringTokenizer tokens = new StringTokenizer(texto, " ");
		
		if (tokens.countTokens() > TEXTO_MINIMO) {	// Si el texto es mayor que LONGITUD_TEXTO_ABREVIADO
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < TEXTO_MINIMO; i++) {
				sb.append(tokens.nextToken() + " ");
			}
			
			texto = sb.toString();
		} 	
		
		return texto;	
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
