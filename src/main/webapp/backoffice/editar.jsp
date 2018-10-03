<!-- Cabecera -->
<%@ include file="../include/header.jsp" %>

<!-- Navbar -->
<%@ include file="../include/navbar.jsp" %>

<main class="container" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${not empty sessionScope.alert}">
		<div class="row align-middle">
	        <div class="col color-primary">	
				<%@include file="../include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<form action="editar" method="post">
 
	  <div class="form-group">
	    <label for="contenido">Escribe una nueva pagina</label>
	    <textarea class="form-control" name="contenido" rows="5" placeholder="Mínimo 25 palabras."></textarea>
	  </div>
	  
	  <button type="submit" class="btn btn-primary btn-block">Publicar</button>
	</form>
	
</main>


		<%@ include file="../include/footer.jsp" %>
