<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<fieldset>

		<legend>Suscripciones  <b>VIP</b></legend>

		<c:if test="${error != null}">
			<div class="alert alert-danger">
  				<strong>Error!</strong> ${error}
			</div>
		</c:if>
		<c:if test="${info != null}">
			<div class="alert alert-info">
  				<strong>Información!</strong> ${info}
			</div>
		</c:if>
		<br>
	
	<!-- Button -->
	<c:choose>
		<c:when test="${rolUser.nombre == 'Administrador'}">
			<div class="form-group">
			  <div class="col-md-3 text-center pull-right">
			  	<a class='btn btn-success' href="/admin/suscripcion/crear">
					Crear Suscripción
				</a>
			  </div>
			</div>
			
			<br>
			<br>
		</c:when>
	</c:choose>
					
  <c:forEach items="${suscripciones}" var="suscripcion">
        		<div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
        	<c:choose>
					<c:when test="${suscripcion.estado == 'A'}">
						<div class="well well-sm">
					</c:when>
					<c:when test="${suscripcion.estado == 'I'}">
						<div class="well well-sm" style="background-color: rgba(169, 68, 66, 0.35)">
					</c:when>
			</c:choose>
                <div class="row">
                	<div class="col-sm-6 col-md-4">
	                    <img class="img-responsive" style="width:200px; height:160px" src="/resources/images/vip-icon.png">
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h4>
                           ${suscripcion.descripcion}
                        </h4>
                        <small><b class="text-primary"> Precio: </b>$ ${suscripcion.precio}</small>
                        <br />
                        <small><b class="text-primary"> Cantidad estampas: </b> ${suscripcion.cantidad}</small>
                        <br />
                        <small><b class="text-primary"> Estado: </b> ${suscripcion.estadoDesc}</small>
                    </div>
                    <div class="col-md-3 text-center pull-right">
	                    <c:choose>
							<c:when test="${rolUser.nombre == 'Administrador' && suscripcion.estado == 'A'}">
								<form action="/admin/suscripcion/inactivar" method="post">
									<input type="hidden" name="id" value="${suscripcion.idSuscripcion}">
									<button class='btn btn-danger '><span class="glyphicon glyphicon-remove"></span>Inactivar</button>
								</form>
							</c:when>
							<c:when test="${rolUser.nombre == 'Artista'}">
								<form action="/suscripcion/comprar" method="post">
									<input type="hidden" name="id" value="${suscripcion.idSuscripcion}">
									<button class='btn btn-warning'>Comprar</button>
								</form>
							</c:when>
						</c:choose>
					 </div>
                </div>
            </div>
        </div>
    </div>

        	</c:forEach>
        	
      </fieldset>
      
</div>