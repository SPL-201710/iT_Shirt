<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">

	<fieldset>

		<legend>Cambio de <b>Contraseña</b></legend>

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
		
		<form:form method="POST" modelAttribute="credencialesForm" class="form-horizontal">
		
			<spring:bind path="actualPassword">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-4 control-label" for=actualPassword>Contraseña Actual:</label>  
			  		<div class="col-md-4">
	                	<form:input type="password" path="actualPassword" required="required" class="form-control" placeholder="Contraseña actual"></form:input>
	                	<form:errors path="actualPassword"></form:errors>
	                </div>
	            </div>
	        </spring:bind>
	        
			<spring:bind path="newPassword">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-4 control-label" for=newPassword>Nueva Contraseña:</label>  
			  		<div class="col-md-4">
	                	<form:input type="password" path="newPassword" required="required" class="form-control" placeholder="Contraseña"></form:input>
	                	<form:errors path="newPassword"></form:errors>
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
			    <button class="btn btn-primary" type="submit">Cambiar contraseña</button>
			  </div>
			</div>

    	</form:form>
		
	</fieldset>
</div>