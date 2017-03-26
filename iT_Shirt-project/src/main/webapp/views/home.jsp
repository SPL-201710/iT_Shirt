<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br>
<br>

<c:if test="${pageContext.request.userPrincipal == null}">
	<div class="container">
		<div class="jumbotron">
			<h1><a>iT_Shirt</a></h1>
			<p> Bienvenido al sistema de personalización y compras de camisetas</p>
		</div>
		<c:if test="${pageContext.request.userPrincipal == null}">
		<div style="margin-top: 10px" class="form-group text-center">
			<!-- Button -->
			<div class="col-sm-12 controls">
				<a href="${contextPath}/login/" class="btn btn-success">Ingresar</a>
			</div>
		</div>
		</c:if>
	</div>
	<!--container close-->
</c:if>