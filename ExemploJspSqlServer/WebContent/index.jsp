<%@page import="Business.CidadeBusiness"%>
<%@page import="Dto.CidadeDTO"%>
<%@page import="Login.Login"%>
<%@page import="java.util.List"%>
<link rel=stylesheet type="text/css"
	href="/ExemploJspSqlServer/Content/estilos/Mylayout.css" />
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Styleshee" href="tela.css">
</head>
<body>
	<from>
	<h1>Seja bem vindo</h1>
	<p>
	<a href="login.html">Realizar login</a>
	<form action="#" method="post">
		<br>
	</form>
	
	</p>
	</from>
	
	<%
		List<CidadeDTO> cidades = (List<CidadeDTO>) getServletContext().getAttribute("listaCidades");
	%>
	<table id="obTable" style="margin: 80px;">
		<tr>
			<td class="dbaseFrameHolder" width="100%" valign="top">
				<table id="obRightHeader" cellspacing="2" cellpadding="2" border="2">
					<tbody>
						<tr>
							<td><h1 class="tituloCadastro">Produtos</h1></td>
						</tr>
						<tr>
							
						</tr>

						<tr>
							<td>
								<%
											if (cidades.size() > 0) {
										%>
								<div style="height: 500px; width: 380px; overflow: auto">
									<table class="htmldbStandard3" cellspacing="20" cellpadding="10"
										border="-50">
										<thead>
											<tr>
												<th id="COL02">NOME</th>
												<th id="COL03">CATEGORIA</th>
												<th id="COL04">PRECO</th>
											</tr>
										</thead>
										<tbody>
											<%
														for (CidadeDTO cidadeDTO : cidades) {
													%>
											<tr>
												<td id="COL02"><%=cidadeDTO.getNome()%></td>
												<td id="COL03"><%=cidadeDTO.getCategoria()%></td>
												<td id="COL04"><%=cidadeDTO.getPreco()%></td>
											</tr>
											<%
														}
													%>
										</tbody>
									</table>
								</div> <%
 	} else {
 %>
								<h2>Nenhuma Produto cadastrada</h2> <%
 	}
 %>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		</tbody>
	</table>
</body>
</html>