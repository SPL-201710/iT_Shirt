<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">

	<fieldset>

		<legend>Carrito de <b>Compras</b></legend>

		<c:if test="${error != null}">
			<div class="alert alert-danger">
  				<strong>Error!</strong> ${error}
			</div>
		</c:if>
		
		<br>
			
	    <div class="row">
	        <div class="col-sm-12 col-md-12 col-md-offset-1" style="margin-left:0 !important;">
	            <table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th>Producto</th>
	                        <th>Cantidad</th>
	                        <th class="text-center">Precio camiseta</th>
	                        <th class="text-center">Precio estampa</th>
	                        <th class="text-center">Total</th>
	                        <th> </th>
	                    </tr>
	                </thead>
	                <tbody>
	                	
	                	<c:forEach items="${elementosCarrito}" var="m">
		                	<tr>
		                        <td class="col-sm-8 col-md-6">
		                        <div class="media">
		                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
		                            <div class="media-body">
		                                <h4 class="media-heading"><a href="#">Estampa: ${m.estampa.estaNombreCorto}</a></h4>
		                                <h5 class="media-heading"> Por <a href="#">${m.estampa.artista.nombresCompletos}</a></h5>
		                                <span>Estado: </span><span class="text-success"><strong>En Stock</strong></span>
		                            </div>
		                        </div></td>
		                        <td class="col-md-1" style="text-align: center">
	                        		<input type="number" class="form-control" value="1">
	                        	</td>
		                        <td class="col-sm-1 col-md-1 text-center"><strong>$${m.estiloCamiseta.precio}</strong></td>
		                        <td class="col-sm-1 col-md-1 text-center"><strong>$${m.estampa.precio}</strong></td>
		                        <td class="col-sm-1 col-md-1 text-center"><strong>$${m.precioTotalCalculado}</strong></td>
		                        <td class="col-sm-1 col-md-1">
		                        <button type="button" class="btn btn-danger">
		                            <span class="glyphicon glyphicon-remove"></span> Eliminar
		                        </button></td>
		                    </tr>
	                	</c:forEach>
	                	
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td><h5>Subtotal</h5></td>
	                        <td class="text-right"><h5><strong>$${subTotal}</strong></h5></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td><h5>Envío estimado</h5></td>
	                        <td class="text-right"><h5><strong>$${envioEstimado}</strong></h5></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td><h3>Total</h3></td>
	                        <td class="text-right"><h3><strong>$${total}</strong></h3></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>
	                        <button type="button" class="btn btn-default" onclick="location.href='/catalogo'">
	                            <span class="glyphicon glyphicon-shopping-cart" ></span> Continuar comprando
	                        </button>
	                        </td>
	                        <c:if test="${not empty elementosCarrito}">
		                        <td>
			                        <button type="button" class="btn btn-success" onclick="location.href='/carrito/metodoPago'">
			                            Checkout <span class="glyphicon glyphicon-play"></span>
			                        </button>
		                        </td>
	                        </c:if>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
	    </div>
    </fieldset>
</div>