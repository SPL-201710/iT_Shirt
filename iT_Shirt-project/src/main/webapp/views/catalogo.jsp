<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<h1 class="page-header">Catalogo de Estampas</h1>
	<div class="col-lg-12">
		
		<div class="btn-group pull-right" style="margin-bottom: 15px">
		  <button type="button" class="btn btn-primary dropdown-toggle"
		          data-toggle="dropdown">
		    Categoría <span class="caret"></span>
		  </button>
		 
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="#">Animales</a></li>
		    <li><a href="#">Deportes</a></li>
		    <li><a href="#">Música</a></li>
		  </ul>
		</div>
	</div>
		<!-- Projects Row -->
        <div class="row">
        	
        	<c:forEach items="${estampas}" var="e">
        	
	        	<div class="col-md-4 portfolio-item">
	                <a href="${contextPath}/detalleEstampa/?es=${e.idEstampa}">
	                    <img class="img-responsive" data-toggle="tooltip" data-placement="right" style="max-width:200px" 
	                    	title="${e.nombreCorto}" src="/resources/estampas/${e.source}" alt="${e.nombreCorto}">
	                </a>
	            </div>
        	
        	</c:forEach>
        	
        </div>
</div>