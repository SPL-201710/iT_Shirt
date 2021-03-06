<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tilesx"
	uri="http://tiles.apache.org/tags-tiles-extras"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container-fluid">
	<fieldset>

		<legend>
			Catalogo de <b>Estampas</b>
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
		<c:choose>
			<c:when test="${advancedSearch == false}">
				<div class="col-md-3">
	            	<div class="">
		            	<div class="btn-group">
							  <button type="button" class="btn btn-primary dropdown-toggle"	data-toggle="dropdown">
							    Filtro por Tema <span class="caret"></span>
							  </button>
							 
							  <ul class="dropdown-menu" role="menu">
							  	<li><a href="catalogo">Todos</a></li>
							  <c:forEach items="${temas}" var="t">
							  	<li><a href="catalogo?id=${ t.idTema }&filter=0&nom=">${ t.nombre }</a></li>
							  </c:forEach>
							  </ul>
						</div>
	            	</div>
	            </div>
			</c:when>
		</c:choose>                        
             
            <c:if test="${advancedSearch}">
	            <div class="col-md-3">
		            <div class="input-group" id="adv-search">
		                <input type="text" class="form-control" placeholder="B�squeda avanzada" />
		                <div class="input-group-btn">
		                    <div class="btn-group" role="group">
		                        <div class="dropdown dropdown-lg">
		                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
		                            <div class="dropdown-menu dropdown-menu-right" role="menu">
		                                <form class="form-horizontal" role="form">
		                                  <div class="form-group">
		                                    <label for="filter">Filtrar por</label>
		                                    <select name="filter" class="form-control">
		                                        <option value="0" selected>Todos</option>
		                                        <option value="1">Mas populares</option>
		                                    </select>
		                                  </div>
		                                  <div class="form-group">
		                                    <label for="contain">Tema</label>
		                                    <select name="id" class="form-control">
		                                        <option value="0" selected>Todos</option>
		                                        <c:forEach items="${temas}" var="t">
												  	<option value="${ t.idTema }">${ t.nombre }</option>
												</c:forEach>
		                                    </select>
		                                  </div>
		                                  <div class="form-group">
		                                    <label for="contain">Contiene las palabras</label>
		                                    <input class="form-control" type="text" name="nom"/>
		                                  </div>
		                                  
		                                  
		                                  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
		                                </form>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
	            </div>
            </c:if>
        </div>
    </div>
    
</div>
</div>
<br>

			<c:forEach items="${estampas}" var="e">
				
				<div class="col-md-2 portfolio-item">
					<a href="${contextPath}/detalleEstampa/?es=${e.idEstampa}"> <img
						class="img-responsive" data-toggle="tooltip"
						data-placement="right" style="width: 200px; height: 160px"
						title="${e.nombreCorto}" src="${contextPath}/resources/estampas/${e.source}"
						alt="${e.nombreCorto}">
						<c:if test="${ratingVar}"> 
							<input readonly id="calif" name="calif" class="rating rating-loading" value="${e.rating}" data-min="0" data-max="5" data-step="1" data-size="xs">
							<label>Calificada: ${e.calificada}</label>
						</c:if>		
						<br>
					</a>
					<label>${e.nombreCorto}</label><br>
					<c:if test="${e.destacada == 'S' and VIP}">
						<div style="position: absolute; left: 0px; top: 0px;"> 
							<img src="${contextPath}/resources/images/rotstar2_e0.gif" title="Estampa destacada" alt="Estampa destacada">
					 	</div> 
					 </c:if>
					<label></label>
					<c:choose>
						<c:when test="${roluser.nombre == 'Comprador'}">							
							<a href="${contextPath}/seleccionCamiseta/?es=${e.idEstampa}&url=${e.source}">Seleccionar</a>
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
											<c:if test="${suscripcion != null and VIP}">
												<form action="destacarEstampa" method="post">
													<input type="hidden" name="idEst" value="${e.idEstampa}">
													<button class='btn btn-primary btn-xs'><span class="glyphicon glyphicon-star-empty"></span>Destacar</button>
												</form>
											</c:if>
										</td>
									</tr>
									<tr>
										<td class="text-center">
										<c:choose>
											<c:when test="${e.estado == 'I'}">
												<p><strong><span class="label label-warning">Rechazada</span></strong></p>	
											</c:when>
										</c:choose>
										</td>
									</tr>
								</table>
							</div>
						</c:when>
						<c:when test="${roluser.nombre == 'Administrador'}">
							<div class="row col-md-6 col-md-offset-2 custyle">
								<table class="table table-striped custab">
									<tr>
										<td class="text-center">
											<form action="rechazarEstampa" method="post">
												<input type="hidden" name="es" value="${e.idEstampa}">
												<button class='btn btn-danger btn-xs'><span class="glyphicon glyphicon-remove"></span> Rechazar</button>
											</form>
										</td>
									</tr>
									<tr>
										<td class="text-center">
											<c:choose>
												<c:when test="${e.estado == 'I'}">
													La estampa ha sido rechazada.
												</c:when>
											</c:choose>
										</td>
									</tr>					
								</table>
							</div>
						</c:when>
					</c:choose>
				</div>
			</c:forEach>
	</fieldset>
	
</div>