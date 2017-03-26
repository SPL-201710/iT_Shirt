<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="col-md-3">
	<div class="profile-sidebar">
		<!-- SIDEBAR USERPIC -->
		<div class="profile-userpic">
			<img src="<%=request.getContextPath()%>/resources/images/person-flat.png" 
				class="img-responsive" alt="avatar" style="width: 50%">
		</div>
		<!-- END SIDEBAR USERPIC -->
		<!-- SIDEBAR USER TITLE -->
		<div class="profile-usertitle">
			<div class="profile-usertitle-name">
				${pageContext.request.userPrincipal.name}
			</div>
			<div class="profile-usertitle-job">
				Artista
			</div>
		</div>
		<!-- END SIDEBAR USER TITLE -->
		<!-- SIDEBAR BUTTONS -->
		<div class="profile-userbuttons">
			<button type="button" class="btn btn-success btn-sm">Comprar</button>
			<button type="button" class="btn btn-danger btn-sm" onclick="redirect:/${contextPath}/">Salir</button>
		</div>
		<!-- END SIDEBAR BUTTONS -->
		<!-- SIDEBAR MENU -->
		<div class="profile-usermenu">
			<ul class="nav">
				<li class="active">
					<a href="${contextPath}/home">
					<i class="glyphicon glyphicon-home"></i>
					Inicio </a>
				</li>
				<li>
					<a href="${contextPath}/perfil/">
					<i class="glyphicon glyphicon-user"></i>
					Perfil de usuario </a>
				</li>
				<li>
					<a href="${contextPath}/verCatalogo/">
					<i class="glyphicon glyphicon-search"></i>
					Catálogo </a>
				</li>
				<li>
					<a href="/personalizacion-web/personalizacion/">
					<i class="glyphicon glyphicon-tag"></i>
					Personalizar camiseta </a>
				</li>
				<li>
					<a href="#">
					<i class="glyphicon glyphicon-shopping-cart"></i>
					Carrito de compras </a>
				</li>
				<li>
					<a href="#">
					<i class="glyphicon glyphicon-usd"></i>
					Compras realizadas </a>
				</li>
				<li>
					<a href="#">
					<i class="glyphicon glyphicon-folder-open"></i>
					Reportes </a>
				</li>
				<li>
					<a href="#">
					<i class="glyphicon glyphicon-wrench"></i>
					Cambiar contraseña </a>
				</li>
				
				<li>
					<a href="#">
					<i class="glyphicon glyphicon-flag"></i>
					Ayuda </a>
				</li>
			</ul>
		</div>
		<!-- END MENU -->
	</div>
</div>
