package Servlets.Cidade;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Business.CidadeBusiness;
import Dto.CidadeDTO;

/**
 * Servlet implementation class ListarServlet
 */
@WebServlet("/ListarCidades")
public class Listar extends HttpServlet {
	private CidadeBusiness cidadeBusiness = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext ctx = getServletContext();
		
		try
		{
			List<CidadeDTO> cidades = cidadeBusiness.Listar();
			ctx.setAttribute("listaCidades", cidades);
			request.getRequestDispatcher("/Cidade/Index.jsp").forward(request, response);
		
		}
		catch(Exception e)
		{
			ctx.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/ExemploJspSqlServer/Util/PaginaDeErro.jsp");
		}
		
	}

	
}
