<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
	<form:form method="POST" modelAttribute="usuarioTema" class="form-horizontal">
		<fieldset>
			<!-- Form Name -->
			<legend>Temas favoritos</legend>
        <spring:bind path="tema">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<label class="col-md-3 control-label" for=sexo>Seleccione los temas de su preferencia:</label>  
		  		<div class="col-md-4">
	                <form:select path="tema" class="form-control"  required="required">
	                	<form:option value="" label="--- Seleccione ---"/>
	  					<form:options items="${selecttemas}" />
	                </form:select>
	                <form:errors path="tema"></form:errors>
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
	<div style="width: 750px">
		<table class="table table-bordered">
			<tr>
				<th>Temas preferidos por el usuario</th>
			</tr>
			<c:forEach items="${temas}" var="t">
				<tr>
					<td>${ t.nombre }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>