<!-- Cabecera -->
<%@ include file="include/header.jsp" %>

<!-- Navbar -->
<%@ include file="include/navbar.jsp" %>

<main class="container" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${not empty sessionScope.alert}">
		<div class="row align-middle">
	        <div class="col color-primary">	
				<%@include file="../include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<div class="row align-middle">
        <div class="col-md-12 color-primary">
        <form action="login" method="post">
		  
		  <div class="form-group">
		    <label for="usuario">Usuario</label>
		    <input type="text" class="form-control" id="usuarioNombre" name="usuarioNombre" placeholder="Mínimo 5 caracteres" >
		  </div>
		  
		  <div class="form-group">
		    <label for="psw">Contraseña</label>
		    <input type="password" class="form-control" id="pass" name="pass" placeholder="Mínimo 5 caracteres" min="5">
		  </div>
		  
		
		  <button type="submit" class="btn btn-primary">Acceder</button>
		  
		</form>
        </div> <!--  ./col -->
    </div> <!--  ./row -->
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="include/footer.jsp" %>
	</div>
</div>