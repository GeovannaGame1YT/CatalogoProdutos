<%@page import="Login.Login"%>
<%@page import="Business.CidadeBusiness"%>
<%@page import="Dto.CidadeDTO"%>
<%@page import="java.util.List"%>
<link rel=stylesheet type="tela/css"
	href="/ExemploJspSqlServer/Content/estilos/Mylayout.css" />
	<link rel=stylesheet type="tela/css"
	href="/ExemploJspSqlServer/Content/estilos/tela.css" />
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% request.getRequestDispatcher("Login.java").forward(request, response); %>
			<p class="titulologin">Logar-se</p>
				<input class="htmldbButton" type='button' value='login'
				onclick='window.location="/ExemploJspSqlServer/login.html"'>
</html>