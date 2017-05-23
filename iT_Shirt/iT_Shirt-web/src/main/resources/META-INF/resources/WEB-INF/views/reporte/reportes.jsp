<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	
	<fieldset>

		<legend>Reportes de <b>Ventas</b></legend>

		<br>
		<a target="_blank" href="/pdf" class="btn btn-primary">Generate report</a> <br><br>
		
		<a target="_blank" href="/calificaciones" class="btn btn-primary">Reporte Calificaciones</a>
		
	
	</fieldset>

</div>