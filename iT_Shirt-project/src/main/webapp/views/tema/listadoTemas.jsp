<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<h1 class="page-header">Listado de Temas</h1>

		<!-- Button -->
		<div class="form-group">
		  <div class="col-md-12 text-right">
		    <input type="button"  class="btn btn-success" onclick="location.href='/tema/crearTema'" value="Crear nuevo Tema" >
		  </div>
		</div>
</div>