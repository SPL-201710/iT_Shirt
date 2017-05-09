<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tilesx"
	uri="http://tiles.apache.org/tags-tiles-extras"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container-fluid">
	<fieldset>

		<legend>
			Cat�logo de <b>Estampas</b>
		</legend>

		<br>

		<!-- Projects Row -->
		<div class="row">
		
<c:if test="${errorDelete != null}">
	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
	  <strong>Mensaje!</strong> ${errorDelete}
	</div>
</c:if>


<div class="container">
	<div class="row">
		<div class="col-md-12">                        
            <div class="col-md-6">
            	<div class="">
	            	<div class="btn-group">
						  <button type="button" class="btn btn-primary dropdown-toggle"	data-toggle="dropdown">
						    Filtro por Tema <span class="caret"></span>
						  </button>
						 
						  <ul class="dropdown-menu" role="menu">
						  	<li><a href="catalogo">Todos</a></li>
						  <c:forEach items="${temas}" var="t">
						  	<li><a href="catalogo?id=${ t.idTema }">${ t.nombre }</a></li>
						  </c:forEach>
						  </ul>
					</div>
            	</div>
            </div> 
          </div>
        </div>
	</div>
</div>
<br>

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
											
											<td class="text-center">
											<a href="${contextPath}/estampa/editar/?es=${e.idEstampa}" class='btn btn-info btn-xs'> 
												<span class="glyphicon glyphicon-edit"></span> Editar
											</a> 
											<form action="eliminaEstampa" method="post">
												<input type="hidden" name="es" value="${e.idEstampa}">
												<button class='btn btn-danger btn-xs'><span class="glyphicon glyphicon-remove"></span>Eliminar</button>
											</form>
											<form action="destacarEstampa" method="post">
												<input type="hidden" name="es" value="${e.idEstampa}">
												<button class='btn btn-danger btn-xs'><span class="glyphicon glyphicon-star-empty"></span>Destacar</button>
											</form>
											</td>
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