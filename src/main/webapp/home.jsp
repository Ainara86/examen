<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="/include/header.jsp" %>


<%@ include file="/include/navbar.jsp" %>

	<main class="container mt-5" role="main">
		<%@include file="/include/alert.jsp" %>
	
	
	<section>
		
		<div class="row mt-2">
		
		
			<div class="col pagina">
				<div class="form-group row">		
					<form action="inicio" class="form-inline">
						<input type="text" class="form-control" name="numPagina" value="${mostrar_pagina.num_pagina+1 }">
					    <button type="submit" class="btn ml-2">Ir a página</button>
					</form>	
				</div>
				
					<div class="form-group row">
						<form action="buscar" class="form-inline">
				    
				    		<input class="form-control" type="text" name="palabra" placeholder="¿Que quieres buscar?" aria-label="Cuadro de búsqueda">
					 		<button type="submit" class="btn ml-2">Buscar Palabra</button>
						</form>
					</div>	  
						
				
			</div> <!-- / .col -->	
			
		</div>	<!-- / .row -->	
		
		
			<div class="row">
				<div class="col">
					<i class="fas fa-less-than"></i><a href="inicio?op=anterior"> Anterior</a>	
				</div>
				<div class="col">
						<a href="inicio?op=siguiente"> Siguiente</a><i class="fas fa-greater-than"></i>	
				</div>	
			</div>
		
		
		<div class="row justify-content-center">
			<div class="col">
				  
				  <textarea id="desc" class="form-control" name="libro" placeholder="" rows="10" />
				   ${mostrar_pagina.num_pagina+1 } de ${numPaginas} Páginas
				   <hr>
			                        ${mostrar_pagina.contenido}
			    
			                        Autor: ${mostrar_pagina.autor}
		          </textarea>
		
				</div> <!-- / .card -->	
					
			</div>	<!-- / .col -->			
		</div>	<!-- / .row -->	
		
		
			<div class="row">
				<div class="col">
					<i class="fas fa-less-than"></i><a href="inicio?op=anterior"> Anterior</a>	
				</div>
				<div class="col">
						<a href="inicio?op=siguiente"> Siguiente</a><i class="fas fa-greater-than"></i>	
				</div>	
			</div>
		
	</section>	
	
</main>

	
	<div class="row align-center fixed-bottom">
		<div class="col-md-12 color-primary">
			<%@ include file="/include/footer.jsp" %>
		</div>
	</div>