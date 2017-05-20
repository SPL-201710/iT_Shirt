<div class="container-fluid">
	<h1 class="page-header">Detalle estilo de camiseta</h1>
	
	<div class="col-lg-12 text-center">
	 	<img src="/resources/images/icono-camiseta.jpg" alt="${estiloCamiseta.nombre}" 
	 		data-toggle="tooltip" data-placement="right" title="${estiloCamiseta.nombre}" height="160" width="160"> 
	</div>
	
	<div class="col-lg-6">
		<label>Referencia:</label>
		${estiloCamiseta.nombre}
	</div>
	<div class="col-lg-6">
		<label>Precio</label>
		$ ${estiloCamiseta.precio}
	</div>
	<div class="col-lg-6">
		<label>Estilo</label>
		${estiloCamiseta.estiloDescripcion}
	</div>
	<div class="col-lg-6">
		<label>Material</label>
		${estiloCamiseta.material}
	</div>
	
</div>