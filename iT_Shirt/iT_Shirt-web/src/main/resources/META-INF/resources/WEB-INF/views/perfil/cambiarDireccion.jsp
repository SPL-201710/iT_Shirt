<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">

	
		
		<fieldset>
			<!-- Form Name -->
			<legend>Cambio de <b>Dirección</b></legend>
			
			<div class="col-md-12">
				<c:if test="${error != null}">
				<div class="alert alert-danger col-md-12">
	  				<strong>Error!</strong> ${error}
				</div>
				</c:if>
				 <c:if test="${msgExitoso != null}">
					<div class="alert alert-success col-md-12">
		  				${msgExitoso}
					</div>
				</c:if>
			</div>
			<br>
		
			<form:form method="POST" modelAttribute="cambioDireccionForm" class="form-horizontal">
			
			<spring:bind path="idUsuario">
	               <form:hidden path="idUsuario"/>
	        </spring:bind>
	        
			<spring:bind path="direccion">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="direccion">Dirección:</label>  
			  		<div class="col-md-4">
			  			 <form:input type="text" path="direccion" required="required" class="form-control" placeholder="Dirección"/>
	                	 <form:errors path="direccion"></form:errors>
			  		</div>
	            </div>
        	</spring:bind>
        
        	<!-- Button -->
			<div class="form-group">
			  <label class="col-md-2 control-label" for="btnGuardar"></label>
			  <div class="col-md-4 text-center">
			    <button id="btnGuardar" name="btnGuardar" class="btn btn-primary">Guardar</button>
			  </div>
			</div>
		</form:form>
        
		</fieldset>
		
	

</div>