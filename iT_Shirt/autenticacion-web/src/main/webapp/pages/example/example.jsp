<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	${objeto.value}
		<div class="site-wrapper">

	      <div class="site-wrapper-inner">
	
	        <div class="cover-container">
	
	          <div class="masthead clearfix">
	            <div class="inner">
	              <h3 class="masthead-brand">Cover</h3>
	              <nav class="nav nav-masthead">
	                <a class="nav-link active" href="#">Home</a>
	                <a class="nav-link" href="#">Features</a>
	                <a class="nav-link" href="#">Contact</a>
	              </nav>
	            </div>
	          </div>
	
	          <div class="inner cover">
	            <h1 class="cover-heading">Cover your page.</h1>
	            <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
	            <p class="lead">
	              <a href="#" class="btn btn-lg btn-secondary">Learn more</a>
	            </p>
	          </div>
	
	          <div class="mastfoot">
	            <div class="inner">
	              <p>Cover template for <a href="https://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
	            </div>
	          </div>
	
	        </div>
	
	      </div>
	
	    </div>
		
		<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
		<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
	</body>
</html>