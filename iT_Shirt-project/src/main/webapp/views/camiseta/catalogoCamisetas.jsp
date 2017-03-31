<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	
	<fieldset>
			<!-- Form Name -->
			<legend>Catálogo de <b>Camisetas</b></legend>
			
		<c:if test="${rolUsuario == 'Administrador'}">
		<!-- Button -->
		<div class="form-group">
		  <div class="col-md-12 text-right">
		    <input type="button"  class="btn btn-success" onclick="location.href='/camisetas/agregarCamiseta'" value="Crear nuevo estilo" >
		  </div>
		</div>
		</c:if>
		<!-- Projects Row -->
        <div class="row">
        	
        	<c:forEach items="${camisetas}" var="e">
        	
	        	<div class="col-md-4 portfolio-item">
	                <a href="${contextPath}/camisetas/detalleCamiseta/?es=${e.idEstilo}">
	                    <img class="img-responsive" data-toggle="tooltip" data-placement="right" style="max-width:200px" 
	                    	title="${e.nombre}" src="/resources/images/icono-camiseta.jpg" alt="${e.nombre}">
	                </a>
	                <div class="col-md-10">
						<label class="txt-primary">Referencia: ${e.nombre}</label> 
					</div>
					<div class="col-md-10">
						<label class="txt-success">Precio: $ ${e.precio}</label> 
					</div>
					<c:if test="${rolUsuario == 'Comprador'}">
						<a href="${contextPath}/personalizacion/?es=${e.idEstilo}">Seleccionar</a>
					</c:if>
	            </div>
        	
        	</c:forEach>
        	
        </div>
        
      </fieldset> 
       
</div>