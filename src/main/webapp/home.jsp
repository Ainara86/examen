<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="/include/header.jsp" %>


<%@ include file="/include/navbar.jsp" %>

	<main class="container mt-5" role="main">
		<%@include file="/include/alert.jsp" %>
	
	
	<section>
		
		<div class="row mt-2">
		
		<nav>
			<div class="col pagina">		
				<form action="inicio">
					<div class="form-group row">
					    
						<label for="numPagina" class="col-form-label">Ir a la Página</label>
					    
					    <div class="col-xs-2">
					      <input type="text" class="form-control ml-2" name="numPagina" value="${mostrar_pagina.num_pagina+1 }">
					    </div>
					    
					    <button type="submit" class="btn btn-primary ml-2">Ir</button>
					</div>		  
				</form>	
				
			</div> <!-- / .col -->	
		</nav>		
					
		</div>	<!-- / .row -->	
		
		<!-- AVANZAR PÁGINA CON FLECHAS -->
		<nav>
			<div class="row">
				<div class="col d-flex justify-content-center">
					<a type="button" class="btn btn-info" href="inicio?op=anterior"><i class="fas fa-backward"></i></a>
					<a type="button" class="btn btn-info" href="inicio?op=siguiente"><i class="fas fa-forward"></i></a>	
				</div>	
			</div>
		</nav>
		
		<div class="row justify-content-center">
			<div class="col">
			
				<div class="card">
				
				  <div class="card-header">
				  	
				   	<h4 class="h4 text-right">${mostrar_pagina.num_pagina+1 } de ${numPaginas} Páginas</h4>
				  </div>
				  
				  <div class="card-body">
				    <blockquote class="blockquote mb-0">
				      <p class="text-justify">${mostrar_pagina.contenido}</p>
				      <footer class="blockquote-footer">Autor: ${mostrar_pagina.autor}</footer>
				    </blockquote>
				  </div>
				</div> <!-- / .card -->	
					
			</div>	<!-- / .col -->			
		</div>	<!-- / .row -->	
		
		<!-- AVANZAR PÁGINA CON FLECHAS -->
		<nav>
			<div class="row">
				<div class="col d-flex justify-content-center">
					<a type="button" class="btn btn-info" href="inicio?op=anterior"><i class="fas fa-backward"></i></a>
					<a type="button" class="btn btn-info" href="inicio?op=siguiente"><i class="fas fa-forward"></i></a>	
				</div>	
			</div>
		</nav>
		
	</section>	
	
</main>

	<!-- Pie de Página -->
	<div class="row align-center fixed-bottom">
		<div class="col-md-12 color-primary">
			<%@ include file="/include/footer.jsp" %>
		</div>
	</div>