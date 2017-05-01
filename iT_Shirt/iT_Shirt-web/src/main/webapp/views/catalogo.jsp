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
			${busqueda.tipoBusqueda}
			
			<div class="container">
	<div class="row">
		<div class="col-md-12">
            <div class="input-group" id="adv-search">
                <input type="text" class="form-control" placeholder="Search for snippets" />
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form class="form-horizontal" role="form">
                                  <div class="form-group">
                                    <label for="filter">Filter by</label>
                                    <select class="form-control">
                                        <option value="0" selected>All Snippets</option>
                                        <option value="1">Featured</option>
                                        <option value="2">Most popular</option>
                                        <option value="3">Top rated</option>
                                        <option value="4">Most commented</option>
                                    </select>
                                  </div>
                                  <div class="form-group">
                                    <label for="contain">Author</label>
                                    <input class="form-control" type="text" />
                                  </div>
                                  <div class="form-group">
                                    <label for="contain">Contains the words</label>
                                    <input class="form-control" type="text" />
                                  </div>
                                  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                </form>
                            </div>
                        </div>
                        <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                    </div>
                </div>
            </div>
          </div>
        </div>
	</div>
</div>

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
											<a href="#" class="btn btn-danger btn-xs"> 
												<span class="glyphicon glyphicon-remove"></span> Eliminar
											</a>
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