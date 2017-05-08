<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<style>
        table.colorPicker 
        {
            border: 1px solid black;
            background-color: white;
        }
        table.colorPicker td 
        {
           border: 1px solid white;
           width: 30px;
           height: 30px;
           cursor:pointer;
        }
		
	.camisetaTransparente
	{
		position: relative;
		top: 0;
		left: 0;
	}
	.estampa
	{
		position: absolute;
		top: 80px;
		left: 80px;
	}
	
		.product_text {
	 position: absolute;
    top: 150px;
    left: 72px;
    width: 100%;
    font-size: 10px;
	color: #000;
	}
	
	.product_wrapper {
	position: absolute;

	width: 300px;
	margin: 0 auto;
	}
 
	.product_image {
	position: absolute;

	width: 300px;
	margin: 0 auto;
	position: relative;
	}
	
	.image { 
   position: relative; 
   width: 100%; /* for IE 6 */
}
	
    </style>
    
        <!--Script used-->
    <script type="text/javascript">
        //Default selected color = white
        var selectedColor = "white";

        function colorPicker_OnMouseOver(color) {
            var imgColorPreview = document.getElementsByClassName("imgColorPreview");
            var i;
            for (i = 0; i < imgColorPreview.length; i++) {
            	imgColorPreview[i].style.backgroundColor = color;
            }
        }

        function colorPicker_OnMouseOut() {
            var tblColorPalette = document.getElementById("colorPalette");
            if (tblColorPalette.style.display != "none") {
            	var imgColorPreview = document.getElementsByClassName("imgColorPreview");
                var i;
                for (i = 0; i < imgColorPreview.length; i++) {
                	imgColorPreview[i].style.backgroundColor = selectedColor;
                }
            }
        }

        function colorPicker_OnClick(color) {
            var imgColorPreview = document.getElementsByClassName("imgColorPreview");
            var i;
            for (i = 0; i < imgColorPreview.length; i++) {
            	imgColorPreview[i].style.backgroundColor = color;
            }
            selectedColor = color;
            $('#color-estampa').val(color);
        }

        function colorPicker_OnClick(color) {
            var imgColorPreview = document.getElementsByClassName("imgColorPreview");
            var i;
            for (i = 0; i < imgColorPreview.length; i++) {
            	imgColorPreview[i].style.backgroundColor = color;
            }
            selectedColor = color;
            $('#color-estampa').val(color);
        }
		
		status = 1;
		function changeStyle() {
		var text = $('.text').val();
		//Note the lowercase first letter.
		x = document.getElementById("text");

		if(status==1) {
		x.style.color = 'blue';
		status = 2;
		}
		else if(status==2) {
		x.style.color = 'red';
		status = 3;
		}	
		else if(status==3) {
		x.style.color = 'yellow';
		status = 1;
		}

		}	
    </script>
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script>
	$(document).ready(function(){
		
		$('.submit').click(function(){
			var text = $('.text').val();
			$('.product_text').html('<p>' + text + '</p>');
			return false;
		});
		
		$('input').keyup(function() {
			var text = $('.text').val();
			$('.product_text').html('<p>' + text + '</p>');
			$('#texto-camiseta').val(text);
		});
		
	});
	</script>

<div class="container-fluid">
	
	<fieldset>
			<!-- Form Name -->
			<legend>Catálogo de <b>Camisetas</b></legend>
			
		<c:if test="${rolUsuario == 'Administrador'}">
		<!-- Button -->
		<div class="form-group">
		  <div class="col-md-12 text-right">
		    <input type="button"  class="btn btn-success" onclick="location.href='/camisetas/agregarCamiseta'" value="Crear nuevo estilo" >
		  </div>
		</div>
		</c:if>
		<!-- Projects Row -->
        <div class="row">
        	
        	<c:forEach items="${camisetas}" var="e">
        		
        		<form:form method="POST" modelAttribute="personalizacionForm" class="form-horizontal" enctype="multipart/form-data">
        		
        			<spring:bind path="estiloCamiseta">
	                	<form:hidden path="estiloCamiseta" value="${e.idEstilo}"/>
	        		</spring:bind>
	        		
        			<spring:bind path="estampa">
	                	<form:hidden path="estampa"/>
	        		</spring:bind>
	        		
	        		<spring:bind path="color">
	                	<form:hidden path="color" id="color-estampa"/>
	        		</spring:bind>
	        		
	        		<spring:bind path="textoConfigurado">
	                	<form:hidden path="textoConfigurado" id="texto-camiseta"/>
	        		</spring:bind>
	        		
		        	<div class="col-md-4 portfolio-item">
		        		<div class="image">
		        			<a href="${contextPath}/camisetas/detalleCamiseta/?es=${e.idEstilo}">
						      <img src="/resources/camisetas/${e.source}" class="img-responsive camisetaTransparente imgColorPreview" 
						      	data-toggle="tooltip" data-placement="right" title="${e.nombre}" alt="${e.nombre}"/>
						      	<c:if test="${rolUsuario == 'Comprador'}">
		               				<img border="0" src="/resources/estampas/${url}" class="estampa" width="25%" />
						      		<span class="product_text"></span>
		               			</c:if>
						    </a>
						</div>
		                <div class="col-md-10">
							<label class="txt-primary">Referencia: ${e.nombre}</label> 
						</div>
						<div class="col-md-10">
							<label class="txt-success">Precio: $ ${e.precio}</label> 
						</div>
						<c:if test="${rolUsuario == 'Comprador'}">
							<div class="form-group">
							  <div class="col-md-12 text-center">
							    <button class="btn btn-primary">Seleccionar</button>
							  </div>
							</div>
						</c:if>
		            </div>
	            
	            </form:form>
        	
        	</c:forEach>
        	
        </div>
        
      </fieldset> 
      
      
    <c:if test="${rolUsuario == 'Comprador'}">
    <br />
    <div id="colorPalette" >
        Selecciona el color
        <table id="tblColorPalette" border="1" cellpadding="0" cellspacing="0" class="colorPicker">
            <tr>
                <td style="background-color:red;" onmouseover="colorPicker_OnMouseOver('red')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('red')" title="Red"></td>
                <td style="background-color:green;" onmouseover="colorPicker_OnMouseOver('green')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('green')" title="Green"></td>
                <td style="background-color:black;" onmouseover="colorPicker_OnMouseOver('black')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('black')" title="Black"></td>
                <td style="background-color:white;" onmouseover="colorPicker_OnMouseOver('white')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('white')" title="White"></td>
                <td style="background-color:brown;" onmouseover="colorPicker_OnMouseOver('brown')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('brown')" title="Brown"></td>
                <td style="background-color:beige;" onmouseover="colorPicker_OnMouseOver('beige')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('beige')" title="Beige"></td>
                <td style="background-color:magenta;" onmouseover="colorPicker_OnMouseOver('magenta')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('magenta')" title="Magenta"></td>
                <td style="background-color:navy;" onmouseover="colorPicker_OnMouseOver('navy')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('navy')" title="Navy"></td>
                <td style="background-color:pink;" onmouseover="colorPicker_OnMouseOver('pink')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('pink')" title="Pink"></td>
                <td style="background-color:tan;" onmouseover="colorPicker_OnMouseOver('tan')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('tan')" title="Tan"></td>
            </tr>
            <tr>
                <td style="background-color:blue;" onmouseover="colorPicker_OnMouseOver('blue')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('blue')" title="Blue"></td>
                <td style="background-color:maroon;" onmouseover="colorPicker_OnMouseOver('maroon')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('maroon')" title="Maroon"></td>
                <td style="background-color:yellow;" onmouseover="colorPicker_OnMouseOver('yellow')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('yellow')" title="Yellow"></td>
                <td style="background-color:gray;" onmouseover="colorPicker_OnMouseOver('gray')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('gray')" title="Gray"></td>
                <td style="background-color:gold;" onmouseover="colorPicker_OnMouseOver('gold')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('gold')" title="Gold"></td>
                <td style="background-color:aqua;" onmouseover="colorPicker_OnMouseOver('aqua')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('aqua')" title="Aqua"></td>
                <td style="background-color:silver;" onmouseover="colorPicker_OnMouseOver('silver')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('silver')" title="Silver"></td>
                <td style="background-color:orange;" onmouseover="colorPicker_OnMouseOver('orange')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('orange')" title="Beige"></td>
                <td style="background-color:olive;" onmouseover="colorPicker_OnMouseOver('olive')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('olive')" title="Olive"></td>
                <td style="background-color:purple;" onmouseover="colorPicker_OnMouseOver('purple')" onmouseout="colorPicker_OnMouseOut()" onclick="colorPicker_OnClick('purple')" title="Purple"></td>
            </tr>
        </table>
    </div>
    <br/>
    <div class="">
		<!-- end product_image -->
 		<form class="input_text" name="input_text" action="" >
			<div class="form-group">
            	<label class="col-md-3 control-label" for="texto">Texto configurable:</label>  
		  		<div class="col-md-7">
                	<input class="text form-control" placeholder="Texto configurable" type="text" id="text">
                </div>
		     </div>
		</form>
	</div>
    
    	<button type="button" onclick="javascripot:changeStyle();">Cambiar Color del Texto</button>
    
    </c:if>
     
</div>