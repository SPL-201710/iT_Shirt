<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Sistema iT_Shirt | <a onclick="document.forms['logoutForm'].submit()">Salir</a></h2>

    
    <div class="container-fluid">
  
  <h1>Bienvenido!</h1>
  <p class="lead">Le damos la bienvenida al sistema de personalización y compras de camisetas <a href="#"><strong>iT_Shirt</strong></a>.</p>
  
  <div class="row-fluid">
    <div class="span10">
    	<div class="well">
    	En el menú izquierdo contará con el acceso a las diferentes funcionalidades que tiene disponible sobre el sistema.
        <br><br>
        	<div class="text-center">
        <button class="btn btn-primary btn-large">Ver Ayuda</button>
        </div>
    	</div>
    </div>
    <div class="span2">
      	<!--<div id="carbonads-container pull-right"><div class="carbonad"><div id="azcarbon"></div></div></div>
 -->   </div>
  </div>
  <hr>
  <h4>Recientes estampas</h4>
  <div id="posts" class="row-fluid">
  	<div class="span3">
      <div class="well">
        <h4>
          <a href="/60084" target="_parent">Estampa animales</a>
        </h4>
        <a href="/60084" target="_parent"><img class="thumbnail" src="//www.screenshot-service.com/8d2331e97ed3407f341daca4cd11d4ed"></a>
        <div class="info">
          <span class="badge">193 <i class="icon-chevron-up"></i></span>
          <span class="badge">34 <i class="icon-heart"></i></span>
        </div>
      </div>
  	</div>
    
    <div class="span3">
      <div class="well">
        <h4>
          <a href="/65566" title="Bootstrap 3.0 RC full page example" target="_parent">Estampa caricatura</a>
        </h4>
        <a href="/65566" target="_parent"><img class="thumbnail" src="//www.screenshot-service.com/b7996363ad91743f2a5deba19c09c7b8"></a>
        <div class="info">
          <span class="badge">49 <i class="icon-chevron-up"></i></span>
          <span class="badge">2 <i class="icon-heart"></i></span>
        </div>
      </div>
  	</div>
    
  </div>
</div>
    
    </c:if>

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

	</div>
