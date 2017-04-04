<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

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
		top: 105px;
		left: 55px;
	}
	
		.product_text {
	position: absolute;
	bottom: 100px;
	left: 65px;
	width: 100%;
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
        	
	        	<div class="col-md-4 portfolio-item">
	                <a href="${contextPath}/camisetas/detalleCamiseta/?es=${e.idEstilo}">
	                    <img class="img-responsive camisetaTransparente imgColorPreview" data-toggle="tooltip" data-placement="right" style="max-width:200px" 
	                    	title="${e.nombre}" src="/resources/camisetas/${e.source}" alt="${e.nombre}" id="imgColorPreview_" >
	                  <!-- <img class="img-responsive" data-toggle="tooltip" data-placement="right" style="max-width:200px" 
	                    	title="${e.nombre}" src="/resources/images/icono-camiseta.jpg" alt="${e.nombre}"> -->	
	               <c:if test="${rolUsuario == 'Comprador'}">
	               <img border="0" src="/resources/estampas/${url}" class="estampa" width="25%" />
	               <div class="product_text" ></div>
	               </c:if>
	                </a>
	                <div class="col-md-10">
						<label class="txt-primary">Referencia: ${e.nombre}</label> 
					</div>
					<div class="col-md-10">
						<label class="txt-success">Precio: $ ${e.precio}</label> 
					</div>
					<c:if test="${rolUsuario == 'Comprador'}">
						<a href="${contextPath}/personalizacion/?es=${e.idEstilo}">Seleccionar</a>
					</c:if>
	            </div>
        	
        	</c:forEach>
        	
        </div>
        
      </fieldset> 
       
</div>

    <br />
    <c:if test="${rolUsuario == 'Comprador'}">
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
    	<div class="product_wrapper" ">
 
		<div class="product_image" >
		<!--<div class="product_text" ></div>
		<!-- end product_text -->
 
 		</div>
		<!-- end product_image -->
 		<form class="input_text" name="input_text" action="" >
		<label for="text">Inserta el Texto<br />
		<input class="text" type="text"><br />
		<input type="submit" class="submit" value="submit" />
		</label>
		</form>
	</div>
    
    
    </c:if>