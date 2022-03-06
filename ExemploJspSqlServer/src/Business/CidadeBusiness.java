package Business;

import java.util.List;

import Dao.CidadeDAO;
import Dto.CidadeDTO;

public class CidadeBusiness {

	private CidadeDAO cidadeDAO = new CidadeDAO();

	public List<CidadeDTO> Listar() throws Exception {
		List<CidadeDTO> produto = null;

		try
		{
			if(!cidadeDAO.VerifiqueConexao())
				throw new Exception("Conexão não estabelecida");

			produto = cidadeDAO.Listar();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return produto;
	}
	
	public CidadeDTO BuscaRegistro(int codigo) throws Exception {
		try
		{
			return cidadeDAO.BuscaRegistro(codigo);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public Boolean Incluir(CidadeDTO cidadeDTO) throws Exception {
		try
		{
			cidadeDAO.Incluir(cidadeDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}

	public Boolean Alterar(CidadeDTO cidadeDTO) throws Exception {
		try
		{
			cidadeDAO.Alterar(cidadeDTO);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	public Boolean Excluir(int codigo) throws Exception {
		try
		{
			return cidadeDAO.Excluir(codigo);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
}
