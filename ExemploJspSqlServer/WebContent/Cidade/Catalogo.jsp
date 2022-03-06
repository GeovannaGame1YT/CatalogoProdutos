<%@page import="Business.CidadeBusiness"%>
<%@page import="Dto.CidadeDTO"%>
<%@page import="java.util.List"%>
<link rel=stylesheet type="text/css"
	href="/ExemploJspSqlServer/Content/estilos/Mylayout.css" />
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalgo</title>
</head>
<body>
<p>
		<a href="/ExemploJspSqlServer/ListarCidades">listaCidades</a>
	</p>
	<%
		List<CidadeDTO> cidades = (List<CidadeDTO>) getServletContext().getAttribute("listaCidades");
	%>
	<table id="obTable" style="margin: 5px;">
		<tr>
			<td class="dbaseFrameHolder" width="100%" valign="top">
				<table id="obRightHeader" cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<td><p class="tituloCadastro">Catalogo</p></td>
						</tr>
						<tr>
							<td><input class="htmldbButton" type='button' value='Inicio'
								onclick='window.location="/ExemploJspSqlServer/index.jsp"'>
								<input class="htmldbButton" type='button' value='Novo'
								onclick='window.location="/ExemploJspSqlServer/Cidade/Inserir.jsp"'></td>
						</tr>
						<tr>
							<td>
								<%
											if (cidades.size() > 0) {
										%>
								<div style="height: 450px; width: 318px; overflow: auto">
									<table class="htmldbStandard3" cellspacing="0" cellpadding="0"
										border="0">
										<thead>
											<tr>
												<th id="COL02">NOME</th>
												<th id="COL03">CATEGORIA</th>
												<th id="COL04">PRECO</th>
												<th id="COL05"><</th>
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
												<td id="COL05"></td>
											</tr>
											<%
														}
													%>
										</tbody>
									</table>
								</div> <%
 	} else {
 %>
								<p>Nenhuma Produto encotrado</p> <%
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