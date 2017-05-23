<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="col-md-3">

	 <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
     </c:if>
     
	<div class="profile-sidebar">
		<!-- SIDEBAR USERPIC -->
		<div class="profile-userpic">
			<c:if test="${genero == 'M'}">
				<img src="<%=request.getContextPath()%>/resources/images/person-flat.png" 
					class="img-responsive" alt="avatar" style="width: 50%">
			</c:if>
			<c:if test="${genero == 'F'}">
				<img src="<%=request.getContextPath()%>/resources/images/person-girl-flat.png" 
					class="img-responsive" alt="avatar" style="width: 50%">
			</c:if>
		</div>
		<!-- END SIDEBAR USERPIC -->
		<!-- SIDEBAR USER TITLE -->
		<div class="profile-usertitle">
			<div class="profile-usertitle-name">
				${nombreCompleto}
			</div>
			<div class="profile-usertitle-job">
				${rol}
			</div>
		</div>
		
		<!-- END SIDEBAR USER TITLE -->
		<!-- SIDEBAR BUTTONS -->
		<div class="profile-userbuttons">
			<button type="button" class="btn btn-danger btn-sm" onclick="document.forms['logoutForm'].submit()">Salir</button>
		</div>
		<!-- END SIDEBAR BUTTONS -->
		<!-- SIDEBAR MENU -->
		<div class="profile-usermenu">
			<ul class="nav">
				
				<c:forEach items="${menus}" var="m">
					<li class="active">
					<a href="${contextPath}${m.peticion}">
					<i class="glyphicon ${m.icono}"></i>
					${m.nombre} </a>
					</li>
    				
				</c:forEach>

<!-- 				<li class="active"> -->
<%-- 					<a href="${contextPath}/welcome"> --%>
<!-- 					<i class="glyphicon glyphicon-home"></i> -->
<!-- 					Inicio </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<%-- 					<a href="${contextPath}/perfil/"> --%>
<!-- 					<i class="glyphicon glyphicon-user"></i> -->
<!-- 					Perfil de usuario </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<%-- 					<a href="${contextPath}/verCatalogo/"> --%>
<!-- 					<i class="glyphicon glyphicon-search"></i> -->
<!-- 					Cat�logo </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="/personalizacion-web/personalizacion/"> -->
<!-- 					<i class="glyphicon glyphicon-tag"></i> -->
<!-- 					Personalizar camiseta </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"> -->
<!-- 					<i class="glyphicon glyphicon-shopping-cart"></i> -->
<!-- 					Carrito de compras </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"> -->
<!-- 					<i class="glyphicon glyphicon-usd"></i> -->
<!-- 					Compras realizadas </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"> -->
<!-- 					<i class="glyphicon glyphicon-folder-open"></i> -->
<!-- 					Reportes </a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"> -->
<!-- 					<i class="glyphicon glyphicon-wrench"></i> -->
<!-- 					Cambiar contrase�a </a> -->
<!-- 				</li> -->
				
<!-- 				<li> -->
<!-- 					<a href="#"> -->
<!-- 					<i class="glyphicon glyphicon-flag"></i> -->
<!-- 					Ayuda </a> -->
<!-- 				</li> -->
			</ul>
		</div>
		<!-- END MENU -->
	</div>
</div>
