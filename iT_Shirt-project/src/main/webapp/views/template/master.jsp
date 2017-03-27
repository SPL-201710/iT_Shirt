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
    	<!-- /container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${contextPath}/resources/js/angular.min.js"></script>
    </head>
    <body>
        <div class="container">
    		<div class="row profile">
            	<tiles:insertAttribute name="header" />
            	<div class="col-md-9">
		            <div class="profile-content">
					 	 <tiles:insertAttribute name="body" />
		            </div>
				</div>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />
        
        <script>
			$(document).ready(function(){
			    $('[data-toggle="tooltip"]').tooltip();   
			});
		</script>
    </body>
</html>