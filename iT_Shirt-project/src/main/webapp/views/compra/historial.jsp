<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">

	<fieldset>

		<legend>Historial de <b>Compras</b></legend>

		<br>
		
		<div class="row col-md-10 col-md-offset-2 custyle" style="margin-left: 8.66666667% !important;">
			<table class="table table-striped custab">
				<thead>
					<tr>
						<th>No. Transacción</th>
						<th>Fecha compra</th>
						<th>Estado</th>
						<th>Total</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<c:forEach items="${compras}" var="c">
					<tr>
						<td>${c.idOrdenCompra}</td>
						<td>${c.fecha}</td>
						<td>${c.estadoDescripcion}</td>
						<td>$${c.total}</td>
						<td class="text-center">
							<a class='btn btn-info btn-xs' href="${contextPath}/compras/detalle/?es=${c.idOrdenCompra}">
								<span class="glyphicon glyphicon-tags"></span> Ver detalle
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</fieldset>
</div>