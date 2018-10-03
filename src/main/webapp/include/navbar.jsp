<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header class="mb-3">
	<!-- HEADER NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="inicio">Imagen</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
       		<span class="navbar-toggler-icon"></span>
     	</button>
	
	   	<div class="collapse navbar-collapse" id="navbar">
	    	<ul class="navbar-nav mr-auto">
	          <li class="nav-item">
	            <a class="nav-link text-white" href="inicio"><i class="fas fa-home"></i>Inicio </a>
	          </li>
	          	<!-- Usuario logueado (panel de backoffice) -->
	          	<!-- usuario logeado -->
			    <c:if test="${not empty sessionScope.usuario}">
		    		<ul class="navbar-nav mr-auto">
		      			<li class="nav-item active">
		        			<a class="nav-link"><i class="fas fa-user">${usuario.nombre}</i></a>
		      			</li>
		      			<li class="nav-item">
		        			<a class="nav-link" href="backoffice/editar.jsp">Escribir Página</a>
		      			</li>
		      			<li class="nav-item">
		        			<a class="nav-link disabled" href="logout">Cerrar Session</a>
		      			</li>
		    		</ul>
				</c:if>        
		        <!-- Usuario no logueado (link de acceso) -->
		        <c:if test="${empty sessionScope.usuario}">
						<ul class="navbar-nav mr-auto">
		      			<li class="nav-item active">
		        			<a class="nav-link" href="inicio">Leer Libro</a>
		      			</li>
		      			<li class="nav-item">
		        			<a class="nav-link" href="login.jsp">Iniciar sesion</a>
		      			</li>
		    		</ul>
			       </c:if>   
	        </ul>
	      </div>
	</nav>    
</header>