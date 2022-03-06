package Servlets.Cidade;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.CidadeBusiness;
import Dto.CidadeDTO;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/BuscarCidade")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext ctx = getServletContext();
		
		String acao = request.getParameter("acao");
		String codigo = request.getParameter("codigo");
		CidadeBusiness cidadeBusiness = new CidadeBusiness();

		try{
			CidadeDTO cidadeDTO = cidadeBusiness.BuscaRegistro(Integer.parseInt(codigo));
			request.setAttribute("cidadeDTO", cidadeDTO);
			if(acao.equals("Alterar"))
				request.getRequestDispatcher("/Cidade/Alterar.jsp").forward(request, response);
			else
				request.getRequestDispatcher("/Cidade/Excluir.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			ctx.setAttribute("errMsg", e.getMessage());
			response.sendRedirect("/ExemploJspSqlServer/Util/PaginaDeErro.jsp");
		}
	}

}
