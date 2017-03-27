<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Crear cuenta</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-horizontal">
    
        <h2 class="form-signin-heading">Creación de cuenta</h2>
        
        <c:if test="${error != null}">
			<div class="alert alert-danger">
  				<strong>Error!</strong> ${error}
			</div>
		</c:if>
			
       	<spring:bind path="rolUsuario">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=rolUsuario>Tipo usuario:</label>  
		  		<div class="col-md-4">
	                <form:select path="rolUsuario" class="form-control"  required="required">
	                	<form:option value="" label="--- Seleccione ---"/>
	  					<form:options items="${roles}" />
	                </form:select>
	                <form:errors path="rolUsuario"></form:errors>
                </div>
            </div>
        </spring:bind>
	        
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=rolUsuario>Nombre de usuario:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="text" path="username" class="form-control" placeholder="Nombre usuario"
                            autofocus="true" required="required"></form:input>
                	 <form:errors path="username"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="nombres">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=nombres>Nombres:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="text" path="nombres" required="required" class="form-control" placeholder="Nombres"/>
                	 <form:errors path="nombres"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="apellidos">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=apellidos>Apellidos:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="text" path="apellidos" required="required" class="form-control" placeholder="Apellidos"/>
                	 <form:errors path="apellidos"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=apellidos>Correo electrónico:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="email" path="email" required="required" class="form-control" placeholder="Correo electrónico"/>
                	 <form:errors path="email"></form:errors>
		  		</div>
            </div>
        </spring:bind>
        
        <spring:bind path="sexo">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=sexo>Sexo:</label>  
		  		<div class="col-md-4">
	                <form:select path="sexo" class="form-control"  required="required">
	                	<form:option value="" label="--- Seleccione ---"/>
	  					<form:options items="${sexos}" />
	                </form:select>
	                <form:errors path="sexo"></form:errors>
                </div>
            </div>
        </spring:bind>
        
        <spring:bind path="telefono">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=apellidos>Celular:</label>  
		  		<div class="col-md-4">
		  			 <form:input type="tel" path="telefono" required="required" class="form-control" placeholder="Número de celular"/>
                	 <form:errors path="telefono"></form:errors>
		  		</div>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=apellidos>Contraseña:</label>  
		  		<div class="col-md-4">
                	<form:input type="password" path="password" required="required" class="form-control" placeholder="Contraseña"></form:input>
                	<form:errors path="password"></form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-4 control-label" for=apellidos>Confirmar contraseña:</label>  
		  		<div class="col-md-4">
	                <form:input type="password" path="passwordConfirm" required="required" class="form-control"
	                            placeholder="Confirmar contraseña"></form:input>
	                <form:errors path="passwordConfirm"></form:errors>
                </div>
            </div>
        </spring:bind>

		<!-- Button -->
		<div class="form-group">
		  <div class="col-md-12 text-center">
		    <button class="btn btn-primary" type="submit">Registrar</button>
		    <button class="btn btn-info">Cancelar</button>
		  </div>
		</div>

    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
