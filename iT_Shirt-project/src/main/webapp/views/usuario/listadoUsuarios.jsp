<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	
	<fieldset>
			<!-- Form Name -->
			<legend>Administración de <b>Usuarios</b></legend>

		<div class="row col-md-6 col-md-offset-2 custyle">
			<table class="table table-striped custab">
				<thead>
					<tr>
						<th>Nombre usuario</th>
						<th>Nombres</th>
						<th>Correo electónico</th>
						<th class="text-center">Acciones</th>
					</tr>
				</thead>
				<c:forEach items="${usuarios}" var="u">
					<tr>
						<td>${u.username}</td>
						<td>${u.nombresCompletos}</td>
						<td>${u.email}</td>
						<td class="text-center">
							<a class='btn btn-warning btn-xs' href="#">
								<span class="glyphicon glyphicon-thumbs-down"></span>
								Dar de baja
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</fieldset>

</div>