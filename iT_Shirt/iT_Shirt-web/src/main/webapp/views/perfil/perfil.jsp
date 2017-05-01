<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">

	<form:form method="POST" modelAttribute="perfilForm" class="form-horizontal">
		
		<fieldset>
			<!-- Form Name -->
			<legend>Perfil de <b>Usuario</b></legend>
		
		 <c:if test="${error != null}">
			<div class="alert alert-danger col-md-5">
  				<strong>Error!</strong> ${error}
			</div>
		</c:if>
		 <c:if test="${msgExitoso != null}">
			<div class="alert alert-success col-md-5">
  				${msgExitoso}
			</div>
		</c:if>
			<spring:bind path="nombres">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-3 control-label" for=nombres>Nombres:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="text" path="nombres" required="required" class="form-control" placeholder="Nombres"/>
                	 <form:errors path="nombres"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="apellidos">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-3 control-label" for=apellidos>Apellidos:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="text" path="apellidos" required="required" class="form-control" placeholder="Apellidos"/>
                	 <form:errors path="apellidos"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-3 control-label" for=apellidos>Correo electrónico:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="email" path="email" required="required" class="form-control" placeholder="Correo electrónico"/>
                	 <form:errors path="email"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="genero">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-3 control-label" for=sexo>Género:</label>  
		  		<div class="col-md-4">
	                <form:select path="genero" class="form-control"  required="required">
	                	<form:option value="" label="--- Seleccione ---"/>
	  					<form:options items="${sexos}" />
	                </form:select>
	                <form:errors path="genero"></form:errors>
                </div>
            </div>
        </spring:bind>
        
        	<spring:bind path="telefono">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-3 control-label" for=apellidos>Celular:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="tel" path="telefono" required="required" class="form-control" placeholder="Número de celular"/>
                	 <form:errors path="telefono"></form:errors>
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
        
		</fieldset>
		
	</form:form>




</div>