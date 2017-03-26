<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="pt-BR" id="ng-app" ng-app="">
<head>
        <title><tiles:getAsString name="title" /></title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
      	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css">
      	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/menu.js">
        <script src="<%=request.getContextPath()%>/webjars/jquery/2.2.4/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/webjars/angularjs/1.6.2/angular.min.js"></script>
		
    </head>
    <body>
        <div class="container">
            	<tiles:insertAttribute name="header" />
			 	<tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </body>
</html>