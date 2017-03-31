<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	
		<fieldset>
			<!-- Form Name -->
			<legend>Creación de <b>Estampas</b></legend>

			<c:if test="${error != null}">
			<div class="alert alert-danger">
  				<strong>Error!</strong> ${error}
			</div>
			</c:if>
			
			<br>
			
		<form:form method="POST" modelAttribute="estampaForm" class="form-horizontal" enctype="multipart/form-data">

	        <spring:bind path="estaNombreCorto">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="estaNombreCorto">Nombre corto:</label>  
			  		<div class="col-md-7">
	                <form:input type="text" path="estaNombreCorto" required="required" class="form-control" placeholder="Nombre corto"
	                            autofocus="true"/>
	                <form:errors path="estaNombreCorto"/>
	                </div>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="descripcion">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="descripcion">Descripción:</label>  
			  		<div class="col-md-7">
	                <form:textarea type="text" path="descripcion" required="required" class="form-control" placeholder="Descripción"></form:textarea>
	                <form:errors path="descripcion"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="file">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for="file">Seleccionar estampa:</label>  
			  		<div class="col-md-7">
	                <form:input type="file" path="file" required="required" class="form-control btn btn-default btn-file"
	                            placeholder="Seleccionar estampa"/>
	                <form:errors path="file"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="precio">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for=precio>Precio:</label>  
			  		<div class="col-md-7">
	                <form:input type="number" path="precio" required="required" class="form-control"  placeholder="Precio estampa"/>
	                <form:errors path="precio"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="idTema">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-3 control-label" for=idTema>Tema:</label>  
			  		<div class="col-md-7">
	                <form:select path="idTema" class="form-control"  required="required" placeholder="Tema estampa">
	                	<form:option value="" label="--- Seleccione ---"/>
   						<form:options items="${temas}" />
	                </form:select>
	                <form:errors path="idTema"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <br>
	        <br>
	
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-12 text-center">
			    <button class="btn btn-primary">Guardar</button>
			    <button class="btn btn-info" onclick="location.href='/'">Cancelar</button>
			  </div>
			</div>

	        
	    </form:form>
    
    </fieldset>

</div>