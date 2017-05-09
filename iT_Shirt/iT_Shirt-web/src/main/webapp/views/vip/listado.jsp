<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<fieldset>

		<legend>Suscripciones  <b>VIP</b></legend>

		<br>
	
	<!-- Button -->
	<div class="form-group">
	  <div class="col-md-3 text-center pull-right">
	  	<button class="btn btn-success">Crear Suscripción</button>
	  </div>
	</div>
	
	<br>
	<br>
					
  <c:forEach items="${suscripciones}" var="suscripcion">
        		<div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <div class="well well-sm">
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
                        <small><b class="text-primary"> Estado: </b> ${suscripcion.estado}</small>
                    </div>
                    <div class="col-md-3 text-center pull-right">
	                    <c:choose>
							<c:when test="${rolUser.nombre == 'Administrador' && suscripcion.estado == 'A'}">
								<button class="btn btn-primary">Inactivar</button>
							</c:when>
							<c:when test="${rolUser.nombre == 'Artista'}">
								<button class="btn btn-warning">Agregar al carrito</button>
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