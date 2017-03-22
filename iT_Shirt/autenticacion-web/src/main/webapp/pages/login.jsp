<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					Ingreso al sistema <strong>iT_Shirt</strong>
				</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px">
					<a href="#">Olvido su contraseña?</a>
				</div>
			</div>
			<div style="padding-top: 30px" class="panel-body">
				<div style="color: red">
    Your login attempt was not successful, try again.<br /> Caused :
    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>

				<div style="display: none" id="login-alert" class="alert alert-danger col-sm-12"></div>
				
				<form:form modelAttribute="login" action="/autenticacion-web/j_spring_security_check" method="post" class="form-horizontal">
					Usuario:<form:input name="username" path="username" class="form-control"/>
					Contraseña:<form:input name="password" path="password" class="form-control"/>
					<div style="margin-top: 10px" class="form-group text-center">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<form:button id="btn-login" class="btn btn-success" >Ingresar</form:button>
							<input type="submit" value="Submit"/>
							<form:button id="btn-fblogin" href="#" class="btn btn-primary">Ingresar con Facebook</form:button>
							<form:button id="btn-twlogin" href="#" class="btn btn-warning">Ingresar con Twitter</form:button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12 control">
							<div
								style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
								No tienes una cuenta! <a href="#"> Registrar aquí </a>
							</div>
						</div>
					</div>
				</form:form>
				
			</div>

	</div>
</div>