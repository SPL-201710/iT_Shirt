<div class="container">
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Perfil de usuario</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="txtNombres">Nombres:</label>  
  <div class="col-md-4">
  <input id="txtNombres" name="txtNombres" type="text" placeholder="Primer y segundo nombre" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="txtApellidos">Apellidos:</label>  
  <div class="col-md-4">
  <input id="txtApellidos" name="txtApellidos" type="text" placeholder="Primer y segundo apellido" class="form-control input-md">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-2 control-label" for="slcCiudad">G�nero:</label>
  <div class="col-md-4">
    <select id="slcGenero" name="slcGenero" class="form-control">
      <option value="">Seleccione...</option>
      <option value="M">Masculino</option>
      <option value="F">Femenino</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="txtCorreo">Correo electr�nico:</label>  
  <div class="col-md-4">
  <input id="txtCorreo" name="txtCorreo" type="text" placeholder="Correo electr�nico" class="form-control input-md">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-2 control-label" for="slcCiudad">Ciudad:</label>
  <div class="col-md-4">
    <select id="slcCiudad" name="slcCiudad" class="form-control">
      <option value="">Seleccione...</option>
      <option value="1">Bogot�</option>
      <option value="2">Medell�n</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="txtDirDomicilio">Direcci�n domicilio:</label>  
  <div class="col-md-4">
  <textarea class="form-control" id="txtDirDomicilio" name="txtDirDomicilio" placeholder="Direcci�n de domicilio"></textarea>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="txtDirDomicilio">Celular:</label>  
  <div class="col-md-4">
  <input id="txtCelular" name="txtCelular" type="text" placeholder="N�mero de celular" class="form-control input-md">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-2 control-label" for="btnGuardar"></label>
  <div class="col-md-4 text-center">
    <button id="btnGuardar" name="btnGuardar" class="btn btn-primary">Guardar</button>
  </div>
</div>

</fieldset>
</form>

</div>