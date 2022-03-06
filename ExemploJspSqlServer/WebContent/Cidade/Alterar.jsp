<%@page import="Dto.CidadeDTO"%>
<jsp:useBean id="cidadeDTO" scope="request" class="Dto.CidadeDTO"></jsp:useBean>
<jsp:setProperty property="*" name="cidadeDTO" />
<link rel=stylesheet type="text/css"
	href="/ExemploJspSqlServer/Content/estilos/Mylayout.css" />
<%@page errorPage="/Util/PaginaDeErro.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

	<%
		String[] erros = (String[]) request.getAttribute("erros");
		if (erros != null && erros.length > 0) {
	%>
	<div class="htmldbNotification">
		<ul>
			<%
				for (int i = 0; i < erros.length; i++) {
			%>
			<li><%=erros[i]%> <%
 	}
 %>
		</ul>
	</div>
	<%
		}
	%>

	<table id="obTable" style="margin: 5px;">
		<tbody>
			<tr>
				<td><p class="tituloCadastro">Alterar Produto</p></td>
			</tr>
			<tr>
				<td>
					<form action="/ExemploJspSqlServer/AtualizarCidade" method="post">
						<input type="hidden" name="acao" value="Alteracao">
						<table class="htmldbStandard3" cellspacing="0" cellpadding="0"
							border="0">
							<tr>
								<td class="htmldbFD">Código:</td>
								<td><input type="text" name="codigo" readonly="readonly"
									value='<jsp:getProperty property="codigo" name="cidadeDTO"/>'
									size=10></td>
							</tr>
							<tr>
								<td class="htmldbFD">Nome:</td>
								<td><input type="text" name="nome"
									value='<jsp:getProperty property="nome" name="cidadeDTO"/>'
									size=50 maxlength="50"></td>
							</tr>
							<tr>
								<td class="htmldbFD">Categoria:</td>
								<td><input type="text" name="categoria"
									value='<jsp:getProperty property="categoria" name="cidadeDTO"/>'
									size=50 maxlength="50"></td>
							</tr>
							<tr>
								<td class="htmldbFD">Preco:</td>
								<td><input type="text" name="preco" 
								value='<jsp:getProperty property="preco" name="cidadeDTO"/>'
								size=30 maxlength="50">
								<!-- <select name="categoria">
								</select> -->
								</td>
							</tr>
								<!--  <td><select name="categoria">
										<option value=""
											<= (cidadeDTO.getCategoria().equals("SP") ? "selected" : "") %>>São
											Paulo</option>
										<option value="RJ"
											<= (cidadeDTO.getCategoria().equals("RJ") ? "selected" : "") %>>Rio
											de Janeiro</option>
								</select></td>-->
							<tr>
								<td colspan="2"><input class="htmldbButton" type="submit"
									value="Gravar"> <input class="htmldbButton"
									type='button' value='Produto'
									onclick='window.location="/ExemploJspSqlServer/Cidade/Index.jsp"'>
									<input class="htmldbButton" type='button' value='Inicio'
									onclick='window.location="/ExemploJspSqlServer/index.jsp"'>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</BODY>
</HTML>