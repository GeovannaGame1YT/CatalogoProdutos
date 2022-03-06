package Servlets.Cidade;

import java.io.IOException;
import java.lang.reflect.Type;
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
 * Servlet implementation class Gravar
 */
@WebServlet("/AtualizarCidade")
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext ctx = getServletContext();

		CidadeDTO cidadeDTO = null;
		Vector<String> vectorErros = new Vector<String>();

		int codigo = 0;
		String nome = request.getParameter("nome");
		String categoria = request.getParameter("categoria");
		int preco = Integer.parseInt(request.getParameter("preco"));
		String acao = request.getParameter("acao");

		String proximaPagina = "";
		switch(acao)
		{
		case "Alteracao": proximaPagina="/Cidade/Alterar.jsp"; break;
		case "Inclusao": proximaPagina="/Cidade/Inserir.jsp"; break;
		case "Exclusao": proximaPagina="/Cidade/Excluir.jsp"; break;
		}

		if(!acao.equals("Inclusao"))
			codigo = Integer.parseInt(request.getParameter("codigo"));

		if(!acao.equals("Exclusao"))
		{
			if(nome == null || nome.isEmpty())
				vectorErros.add("Nome deve ser informado");
			
			
			if(categoria == null || categoria.isEmpty())
				vectorErros.add("Categoria deve ser informada");
		}

		if(vectorErros.size() > 0)
		{
			String[] stringErros = (String[])vectorErros.toArray(new String[vectorErros.size()]);
			request.setAttribute("erros", stringErros);
			request.getRequestDispatcher(proximaPagina).forward(request, response);
		}
		else
		{
			cidadeDTO = new CidadeDTO(codigo, nome, categoria, preco);
			CidadeBusiness cidadeBusiness = new CidadeBusiness();
			try{
				Boolean retornoAtualizacao = false;
				switch(acao)
				{
				case "Inclusao": retornoAtualizacao = cidadeBusiness.Incluir(cidadeDTO); break;
				case "Alteracao": retornoAtualizacao = cidadeBusiness.Alterar(cidadeDTO); break;
				case "Exclusao": retornoAtualizacao = cidadeBusiness.Excluir(codigo); break;
				}

				if(retornoAtualizacao)
					response.sendRedirect("/ExemploJspSqlServer/ListarCidades");
			}
			catch(Exception e)
			{
				ctx.setAttribute("errMsg", e.getMessage());
				response.sendRedirect("/ExemploJspSqlServer/Util/PaginaDeErro.jsp");
			}
		}
	}

}
