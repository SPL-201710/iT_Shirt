<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="pt-BR" id="ng-app" ng-app="">
<head>
        <title><tiles:getAsString name="title" /></title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    	<!-- /container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${contextPath}/resources/js/angular.min.js"></script>
    </head>
    <body>
        <div class="container">
            	<tiles:insertAttribute name="header" />
			 	<tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </body>
</html>