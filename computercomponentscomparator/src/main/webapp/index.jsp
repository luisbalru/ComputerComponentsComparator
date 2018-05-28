<%@page import="java.util.ArrayList"%>
<%@page import="com.example.Producto"%>
<%@page import="com.example.CCC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CCC</title>

    <link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
  	<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
 	<link rel = "stylesheet" type = "text/css" href = "index.css" />
</head>
<body>
	
   	
   		<!--------------------------- Cabecera ---------------------------->
  <header>
		<section class="row">
			<h1 class="col-6">ComputerComponentsComparator</h1>
      		<section class="col-1 offset-4 logo">
				<img src="img/lupa.png" alt="Logo" />
			</section>
		</section>
	</header>
	<hr/>
	<!------------------------------------------------------------->





	<!------------------- Cuerpo central de la página ---------------->
	<section class="row">
		<section class="col-10 offset-1">
		    <form action="ccc" method="get"> 
		   		<section class="col-1 logo">
					<img src="img/lupa.png" alt="Searcher" />
				</section>
		    	<input style="margin-top:10px" type="text" id="query" name="query"/>
		   	</form>
	   	</section>
	   	
	   	<section class="col-2 unbox">
	   		<ul class="vertical">
	   			<li><a>Disco duro</a></li>
	   			<li><a>Procesador</a></li>
	   			<li><a>Memoria Ram</a></li>
	   			<li><a>Placa base</a></li>
	   			<li><a>Targeta gráfica</a></li>
	   			<li><a>Periféricos</a></li>
	   		</ul>
	   	</section>
	   	
	   	<section class="col-8 offset-1" style="width:72%;">   <!--  Hueco para artículos  --> 
	   		<section class="row">
	   		
	   		<%
	   			if(request.getParameter("query") == null){
	   					
	   			}else{
	   				ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("MatchedProducts");
	   				for(int i = 0; i < productos.size(); i++){ Producto p = productos.get(i);%>
		   				<article class="col-3 articulo"> <!-- ARTICULO -->       
		   					<section class="offset-1 col-10">                             
	   							<img src=<% out.print("http://"+p.getImg()); %> alt="foto-articulo" />
	   						</section>
	   						<h5 class="offset-1 col-10"><% out.print(p.getNombre()); %></h5>
<<<<<<< HEAD
	   						<% for(int j=0; j<p.getOfertas().size(); j++){ %>
						   	<h5 class="offset-2 col-6"><% out.print(p.getOfertas().get(j).getMarket()); %>  <% out.print(p.getOfertas().get(j).getPrecio()); %></h5> 
              					<% } %>
=======

						   	<h5 class="offset-2 col-6">PCC:  <% out.print(p.getOfertas().get(0).getPrecio()); %></h5> 
						   	<a class="offset-1 col-1" target="_blank" href=<% out.print("http://" + p.getOfertas().get(0).getEnlace()); %>>Ver</a>
						   	<h5 class="offset-2 col-6">Amazon: <% //out.print(productos.get(i).getOfertas().get(1).getPrecio()); %> &#8364;</h5>             
						   	<a class="offset-1 col-1" href=<% //out.print("http://" + p.getOfertas().get(2).getEnlace()); %>>Ver</a>
						   	<h5 class="offset-2 col-6">ComputerUniverse: <%  out.print(p.getOfertas().get(1).getPrecio()); %> &#8364;</h5>                   
							<a class="offset-1 col-1" href=<% out.print("http://" + p.getOfertas().get(1).getEnlace()); %>>Ver</a>
>>>>>>> branch 'master' of https://github.com/luisbalru/ComputerComponentsComparator.git
						</article> <% 
	   				}
	   			}
	   		%>	   		
	   		</section>
	   	</section>
   	</section>

   	
	<!------------------------------------------------------------->






	<!------------------- Contacto y Como se hizo ---------------->
	<footer class="row ">
		<section class="col-6">
			<h5>Contacto</h5>
      <hr/>
			<ul class="horizontal">
				<li class="offset-1"><a>Desarrollador</a></li>
				<li><a>Cómo se hizo</a></li>
				<li><a>Acerca de ComputerComponentsComparator</a></li>
			</ul>
		</section>
		<section class="col-6">
			<h5>Información legal</h5>
      <hr/>
			<ul class="horizontal">
				<li class="offset-2"><a>Términos de servicio</a></li>
				<li><a>Política de privacidad</a></li>
				<li><a>Política de cookies</a></li>
			</ul>
		</section>
	</footer>
	<!------------------------------------------------------------->
   	
</body>
</html>