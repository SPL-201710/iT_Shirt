<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tilesx"
	uri="http://tiles.apache.org/tags-tiles-extras"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container-fluid">
	<fieldset>

		<legend>
			Catálogo de <b>Estampas</b>
		</legend>

		<br>

		<!-- Projects Row -->
		<div class="row">

			<c:forEach items="${estampas}" var="e">

				<div class="col-md-4 portfolio-item">
					<a href="${contextPath}/detalleEstampa/?es=${e.idEstampa}"> <img
						class="img-responsive" data-toggle="tooltip"
						data-placement="right" style="width: 200px; height: 160px"
						title="${e.nombreCorto}" src="/resources/estampas/${e.source}"
						alt="${e.nombreCorto}">
					</a> <label></label>
					<c:choose>
						<c:when test="${roluser.nombre == 'Comprador'}">
							<a
								href="${contextPath}/seleccionCamiseta/?es=${e.idEstampa}&url=${e.source}">Seleccionar</a>
						</c:when>
						<c:when test="${roluser.nombre == 'Artista'}">
							<div class="row col-md-6 col-md-offset-2 custyle">
								<table class="table table-striped custab">
									<thead>
									</thead>
									
										<tr>
											
											<td class="text-center"><a class='btn btn-info btn-xs'
												href="#"> <span class="glyphicon glyphicon-edit"></span>
													Editar
											</a> <a href="#" class="btn btn-danger btn-xs"> <span
													class="glyphicon glyphicon-remove"></span> Eliminar
											</a></td>
										</tr>
									
								</table>
							</div>
						</c:when>
					</c:choose>
				</div>

			</c:forEach>

		</div>

	</fieldset>



</div>