<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html lang="pt-BR" id="ng-app" ng-app="">
<head>
        <title><tiles:getAsString name="title" /></title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/4-col-portfolio.css">
    	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/payment-method.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/payment.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/rating.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/advance_search.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/bootstrap-social.css" rel="stylesheet">
    	<!-- /container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${contextPath}/resources/js/angular.min.js"></script>
		
		<link href="${contextPath}/resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
		<script src="${contextPath}/resources/js/star-rating.js" type="text/javascript"></script>
		
    </head>
    <body>
	<fieldset>
			<c:if test="${estampasDest != null}">
				<h1 center>Estampas Destacadas</h1>
			</c:if>
				<c:forEach items="${estampasDest}" var="est">
					<div class="col-md-2 portfolio-item">
						<a href="${contextPath}/detalleEstampa/?es=${est.idEstampa}"> <img
							class="img-responsive" data-toggle="tooltip"
							data-placement="right" style="width: 200px; height: 160px"
							title="${est.nombreCorto}" src="${contextPath}/resources/estampas/${est.source}"
							alt="${est.nombreCorto}">					
						</a>
						<label></label>
						<c:if test="${roluser.nombre == 'Comprador'}">							
							<a href="${contextPath}/seleccionCamiseta/?es=${est.idEstampa}&url=${est.source}">Seleccionar</a>
						</c:if>
					</div>
				</c:forEach>
	</fieldset>
    		<div class="row profile">
            	<tiles:insertAttribute name="header" />
            	<div class="col-md-9">
		            <div class="profile-content">
					 	 <tiles:insertAttribute name="body" />
		            </div>
				</div>
            </div>

        <tiles:insertAttribute name="footer" />
        
        <script>
			$(document).ready(function(){
				// initialize with defaults
				$("#input-id").rating();
				 
				// with plugin options
				$("#input-id").rating({min:1, max:10, step:2, size:'lg'});
				
			    $('[data-toggle="tooltip"]').tooltip();   
			});
		</script>
    </body>
</html>