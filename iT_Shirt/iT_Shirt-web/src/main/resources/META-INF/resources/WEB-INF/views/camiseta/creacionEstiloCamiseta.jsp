<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	
		<fieldset>
			<!-- Form Name -->
			<legend>Creación de <b>Estilos de Camisetas</b></legend>

			<c:if test="${error != null}">
			<div class="alert alert-danger">
  				<strong>Error!</strong> ${error}
			</div>
			</c:if>
			
			<br>
			
		<form:form method="POST" modelAttribute="camisetaForm" class="form-horizontal" enctype="multipart/form-data">

	        <spring:bind path="nombre">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="nombre">Referencia:</label>  
			  		<div class="col-md-7">
	                <form:input type="text" path="nombre" required="required" class="form-control" placeholder="Nombre"
	                            autofocus="true"/>
	                <form:errors path="nombre"/>
	                </div>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="material">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="descripcion">Material:</label>  
			  		<div class="col-md-7">
	                <form:input type="text" path="material" required="required" class="form-control" placeholder="Material"/>
	                <form:errors path="material"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="precio">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for=precio>Precio:</label>  
			  		<div class="col-md-7">
	                <form:input type="number" path="precio" required="required" class="form-control"  placeholder="Precio camiseta"/>
	                <form:errors path="precio"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="estilo">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for=idTema>Estilo:</label>  
			  		<div class="col-md-7">
	                <form:select path="estilo" class="form-control"  required="required">
	                	<form:option value="" label="--- Seleccione ---"/>
   						<form:options items="${estilos}" />
	                </form:select>
	                <form:errors path="estilo"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="file">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="file">Seleccionar estilo:</label>  
			  		<div class="col-md-7">
	                <form:input type="file" path="file" required="required" class="form-control btn btn-default btn-file"/>
	                <form:errors path="file"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <br>
	        <br>
	
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-12 text-center">
			    <button class="btn btn-primary">Guardar</button>
			    <button class="btn btn-info">Cancelar</button>
			  </div>
			</div>

	        
	    </form:form>
    
    </fieldset>

</div>