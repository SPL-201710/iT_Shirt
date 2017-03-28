<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<h1 class="page-header">Personalización de Camiseta</h1>
	<fieldset>
			<!-- Form Name -->
			Id estampa seleccionada: ${session.idEstampaSeleccionada}
			<br>
			Id estilo: ${session.idEstiloSeleccionado}
			
		<form:form method="POST" modelAttribute="personalizacionForm" class="form-horizontal">

	        <spring:bind path="talla">
	            <div class="form-group">
	            	<label class="col-md-3 control-label" for=idTema>Talla:</label>  
			  		<div class="col-md-7">
		                <form:select path="talla" class="form-control"  required="required">
		                	<form:option value="" label="--- Seleccione Talla---"/>
	   						<form:option value="S" label="S"/>
	   						<form:option value="M" label="M"/>
	   						<form:option value="L" label="L"/>
	   						<form:option value="XL" label="XL"/>
		                </form:select>
		                <form:errors path="talla"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="color">
	            <div class="form-group">
	            	<label class="col-md-3 control-label" for=idTema>Color:</label>  
			  		<div class="col-md-7">
		                <form:select path="color" class="form-control"  required="required">
		                	<form:option value="" label="--- Seleccione Color ---"/>
	   						<form:option value="Rojo" label="Rojo"/>
	   						<form:option value="Azul" label="Azul"/>
	   						<form:option value="Verde" label="Verde"/>
	   						<form:option value="Amarillo" label="Amarillo"/>
		                </form:select>
		                <form:errors path="color"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="textoConfigurado">
	            <div class="form-group">
	            	<label class="col-md-3 control-label" for=idTema>Texto:</label>  
			  		<div class="col-md-7">
		                <form:input type="text" path="textoConfigurado" required="required" class="form-control" placeholder="Texto" autofocus="false"/>
		                <form:errors path="textoConfigurado"></form:errors>
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

