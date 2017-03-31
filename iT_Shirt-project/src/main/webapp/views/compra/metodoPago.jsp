<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">

<div class="row">
		<div class="paymentCont">
						<div class="headingWrap">
								<h3 class="headingTop text-center">Seleccione su Método de Pago</h3>	
								<p class="text-center">Compre y pague seguro.</p>
						</div>
						<div class="paymentWrap">
							<div class="btn-group paymentBtnGroup btn-group-justified" data-toggle="buttons">
					            <label class="btn paymentMethod active">
					            	<div class="method visa"></div>
					                <input type="radio" name="options" checked> 
					            </label>
					            <label class="btn paymentMethod">
					            	<div class="method master-card"></div>
					                <input type="radio" name="options"> 
					            </label>
					            <label class="btn paymentMethod">
				            		<div class="method amex"></div>
					                <input type="radio" name="options">
					            </label>
					             <label class="btn paymentMethod">
				             		<div class="method vishwa"></div>
					                <input type="radio" name="options"> 
					            </label>
					            <label class="btn paymentMethod">
				            		<div class="method ez-cash"></div>
					                <input type="radio" name="options"> 
					            </label>
					         
					        </div>        
						</div>
						<div class="footerNavWrap clearfix">
							 <button type="button" class="btn btn-default pull-left btn-fyi" onclick="location.href='/catalogo'">
	                            <span class="glyphicon glyphicon-shopping-cart"></span> Continuar comprando
	                        </button>
							<button type="button" class="btn btn-success pull-right btn-fyi" onclick="location.href='/carrito/pago'">
		                            Checkout <span class="glyphicon glyphicon-play"></span>
		                    </button>
						</div>
					</div>
		
	</div>

</div>