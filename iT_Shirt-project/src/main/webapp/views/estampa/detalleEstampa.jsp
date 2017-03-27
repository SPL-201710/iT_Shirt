<div class="container-fluid">
	<h1 class="page-header">Detalle de estampa</h1>
	<div class="col-lg-6">
		<label>Nombre Corto</label>
		${estampa.estaNombreCorto}
	</div>
	<div class="col-lg-6">
		<label>Descripcion</label>
		${estampa.descripcion}
	</div>
	<div class="col-lg-6">
		<label>Precio</label>
		$ ${estampa.precio}
	</div>
	<div class="col-lg-6">
		<label>Artista</label>
		${estampa.artista.nombres} ${estampa.artista.apellidos}
	</div>
	
	<div class="col-lg-12">
		<label>Imagen</label>
	 	<img src="estampas/${estampa.idEstampa}/${estampa.idEstampa}.jpg" alt="estampa" height="160" width="160"> 
	</div>
</div>