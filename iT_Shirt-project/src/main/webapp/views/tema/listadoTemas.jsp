<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<h1 class="page-header">Listado de Temas</h1>
	
		<form:form method="POST" modelAttribute="temaForm" class="form-horizontal">

	        <spring:bind path="nombre">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<label class="col-md-4 control-label" for="estaNombreCorto">Nombre del tema:</label>  
			  		<div class="col-md-5">
	                <form:input type="text" path="nombre" required="required" class="form-control" placeholder="Nombre"
	                            autofocus="true"/>
	                <form:errors path="nombre"/>
	                </div>
	                <!-- Button -->
					<div class="form-group">
					  <div class="col-md-3 text-center">
					  	<button class="btn btn-success">Crear nuevo tema</button>
					  </div>
					</div>
	            </div>
	        </spring:bind>
	        
			
	    </form:form>

	<div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
        <tr>
            <th>Nombre del tema</th>
            <th class="text-center">Acciones</th>
        </tr>
    </thead>
    	<c:forEach items="${temas}" var="t">
    		<tr>
                <td>${t.nombre}</td>
                <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Editar</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Eliminar</a></td>
            </tr>
    	</c:forEach>
    </table>
    </div>
</div>