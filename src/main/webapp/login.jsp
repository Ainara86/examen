<!-- Cabecera -->
<%@ include file="include/header.jsp" %>

<!-- Navbar -->
<%@ include file="include/navbar.jsp" %>

<main class="container" role="main">
	
	<!-- Gesti�n de alertas -->
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
		    <input type="text" class="form-control" id="usuarioNombre" name="usuarioNombre" placeholder="M�nimo 5 caracteres" >
		  </div>
		  
		  <div class="form-group">
		    <label for="psw">Contrase�a</label>
		    <input type="password" class="form-control" id="pass" name="pass" placeholder="M�nimo 5 caracteres" min="5">
		  </div>
		  
		
		  <button type="submit" class="btn btn-primary">Acceder</button>
		  
		</form>
        </div> <!--  ./col -->
    </div> <!--  ./row -->
</main>

<!-- Pie de P�gina -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="include/footer.jsp" %>
	</div>
</div>