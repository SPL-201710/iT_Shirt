<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<!-- Website CSS style -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
	<!-- Website Font style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>Valor</th>
        <th>Descripcion</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${datos}" var="d">
	    <tr>      
	        <td>${d.value}</td>
	        <td>${d.value}</td>
	    </tr>
	</c:forEach>
    </tbody>
  </table>
</div>
		<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
		<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>