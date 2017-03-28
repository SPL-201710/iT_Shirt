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
		
		${elementosCarrito}
		
		<br>
			
	    <div class="row">
	        <div class="col-sm-12 col-md-12 col-md-offset-1" style="margin-left:0 !important;">
	            <table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th>Producto</th>
	                        <th class="text-center">Precio camiseta</th>
	                        <th class="text-center">Precio estampa</th>
	                        <th class="text-center">Total</th>
	                        <th> </th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td class="col-sm-8 col-md-6">
	                        <div class="media">
	                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
	                            <div class="media-body">
	                                <h4 class="media-heading"><a href="#">Product name</a></h4>
	                                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
	                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
	                            </div>
	                        </div></td>
	                        <td class="col-sm-1 col-md-1 text-center"><strong>$4.87</strong></td>
	                        <td class="col-sm-1 col-md-1 text-center"><strong>$4.87</strong></td>
	                        <td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
	                        <td class="col-sm-1 col-md-1">
	                        <button type="button" class="btn btn-danger">
	                            <span class="glyphicon glyphicon-remove"></span> Eliminar
	                        </button></td>
	                    </tr>
	                    <tr>
	                        <td class="col-md-6">
	                        <div class="media">
	                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
	                            <div class="media-body">
	                                <h4 class="media-heading"><a href="#">Product name</a></h4>
	                                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
	                                <span>Status: </span><span class="text-warning"><strong>Leaves warehouse in 2 - 3 weeks</strong></span>
	                            </div>
	                        </div></td>
	                        <td class="col-md-1" style="text-align: center">
	                        <input type="email" class="form-control" id="exampleInputEmail1" value="2">
	                        </td>
	                        <td class="col-md-1 text-center"><strong>$4.99</strong></td>
	                        <td class="col-md-1 text-center"><strong>$9.98</strong></td>
	                        <td class="col-md-1">
	                        <button type="button" class="btn btn-danger">
	                            <span class="glyphicon glyphicon-remove"></span> Eliminar
	                        </button></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td><h5>Subtotal</h5></td>
	                        <td class="text-right"><h5><strong>$24.59</strong></h5></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td><h5>Estimated shipping</h5></td>
	                        <td class="text-right"><h5><strong>$6.94</strong></h5></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td><h3>Total</h3></td>
	                        <td class="text-right"><h3><strong>$31.53</strong></h3></td>
	                    </tr>
	                    <tr>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>   </td>
	                        <td>
	                        <button type="button" class="btn btn-default">
	                            <span class="glyphicon glyphicon-shopping-cart"></span> Continuar comprando
	                        </button>
	                        </td>
	                        <td>
		                        <button type="button" class="btn btn-success" onclick="location.href='/carrito/metodoPago'">
		                            Checkout <span class="glyphicon glyphicon-play"></span>
		                        </button>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
	    </div>
    </fieldset>
</div>