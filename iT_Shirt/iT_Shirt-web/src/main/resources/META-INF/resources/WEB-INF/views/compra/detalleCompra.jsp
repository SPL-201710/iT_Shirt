<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">

	<fieldset>
		<legend>Detalle de <b>Compra</b> <b class="text-success">No. Transacci�n: </b>${idOrdenCompra}</legend>

		<br>
		
		<c:if test="${MsgCalificar != null}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			  <strong>Mensaje!</strong> ${MsgCalificar}
			</div>
		</c:if>
		
        	<c:forEach items="${detallesOrden}" var="deto">
        		<div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <a href="${contextPath}/detalleEstampa/?es=${deto.estampa.idEstampa}">
		                    <img class="img-responsive" data-toggle="tooltip" data-placement="right" style="width:200px; height:160px" 
		                    	title="${deto.estampa.estaNombreCorto}" src="/resources/estampas/${deto.estampa.source}" alt="${deto.estampa.estaNombreCorto}">
		                </a>
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h4>
                           ${deto.estampa.estaNombreCorto}</h4>
                        	<i class="glyphicon glyphicon-user"></i><small><b class="text-primary"> Artista </b>$ ${deto.estampa.artista.nombresCompletos}</small>
                        <p>
                            <i class="glyphicon glyphicon-envelope"></i> ${deto.estampa.artista.email}
                            <br />
                            <i class="glyphicon glyphicon-usd"></i><small><b class="text-primary"> Precio camiseta: </b>$ ${deto.precioCamiseta}</small>
                            <br />
                            <i class="glyphicon glyphicon-usd"></i><small><b class="text-primary"> Precio estampa: </b>$ ${deto.precioEstampa}</small>
                            <br />
                            <i class="glyphicon glyphicon-usd"></i><small><b class="text-primary"> Total: </b>$ ${deto.precioTotalCalculado}</small>
                        <!-- Split button -->
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary">
                                Compartir en Redes Sociales</button>
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span><span class="sr-only">Compartir en Redes Sociales</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Twitter</a></li>
                                <li><a href="#">Google +</a></li>
                                <li><a href="#">Facebook</a></li>
                                <li><a href="#">Instagram</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6">
                        	<!-- Load Facebook SDK for JavaScript -->
	  
						  <div id="fb-root"></div>
							<script>(function(d, s, id) {
							  var js, fjs = d.getElementsByTagName(s)[0];
							  if (d.getElementById(id)) return;
							  js = d.createElement(s); js.id = id;
							  js.src = "//connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.9";
							  fjs.parentNode.insertBefore(js, fjs);
							}(document, 'script', 'facebook-jssdk'));</script>
						
						  <!-- Your share button code -->
						  <div class="fb-share-button" data-href="http://localhost:8080/compras/detalle?es=${idOrdenCompra}" data-layout="button_count" data-size="small" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8080%2Fcompras%2Fdetalle%3Fes%3D16&amp;src=sdkpreparse">Compartir</a></div>
                        	<a href="https://twitter.com/share" class="twitter-share-button" data-via="WilmerFabianT" data-lang="es">Twittear</a> <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
                        </div>	  
                        <c:if test="${ratingVar}">
	                        <form action="calificarEstampa" method="post">	
								<input type="hidden" name="est" value="${deto.estampa.idEstampa}">
								<input type="hidden" name="ord" value="${idOrdenCompra}">
								<input id="calif" name="calif" class="rating rating-loading" value="0" data-min="0" data-max="5" data-step="1" data-size="xs">
								<button class='btn btn-primary btn-xs'><span class="glyphicon glyphicon-star-empty"></span>Calificar</button>
							</form>
						</c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

        	</c:forEach>
        	
       	<c:forEach items="${detallesOrdenVIP}" var="deto">
       			<div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
			<div class="well well-sm">
                <div class="row">
                	<div class="col-sm-6 col-md-4">
	                    <img class="img-responsive" style="width:200px; height:160px" src="/resources/images/vip-icon.png">
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h4>
                           ${deto.suscripcion.descripcion}
                        </h4>
                        <small><b class="text-primary"> Precio: </b>$ ${deto.suscripcion.precio}</small>
                        <br />
                        <small><b class="text-primary"> Cantidad estampas: </b> ${deto.suscripcion.cantidad}</small>
                        <br />
                        <small><b class="text-primary"> Estado: </b> ${deto.suscripcion.estadoDesc}</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
       	</c:forEach>
        	
      </fieldset>
      
</div>