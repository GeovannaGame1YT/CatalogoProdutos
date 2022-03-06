package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.CidadeDTO;

public class CidadeDAO {

	private Connection conexao = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	private String comandoSql = "";

	public Boolean VerifiqueConexaoTeste() throws Exception {
		return true;
	}

	public Boolean VerifiqueConexao() throws Exception {
		try
		{
			conexao = DbConexao.getConexao();
			if(conexao == null)
				return false;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return true;
	}

	public List<CidadeDTO> Listar() throws Exception {
		CidadeDTO cidadeDTO;
		List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();

		try
		{
			if(!VerifiqueConexao())
				return cidades;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE ORDER BY cid_nome";
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cidadeDTO = new CidadeDTO();
				cidadeDTO.setCodigo(rs.getInt("cid_codigo"));
				cidadeDTO.setNome(rs.getString("cid_nome"));
				cidadeDTO.setCategoria(rs.getString("cid_categoria"));
				cidadeDTO.setPreco(rs.getInt("cid_preco"));
				cidades.add(cidadeDTO);
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return cidades;
	}

	public CidadeDTO BuscaRegistro(int codigo) throws Exception, SQLException {

		CidadeDTO cidadeDTO = null;
		try
		{
			if(!VerifiqueConexao())
				return cidadeDTO;

			Statement st = (Statement)conexao.createStatement();
			comandoSql =  "SELECT * FROM CIDADE WHERE cid_codigo = " + codigo;
			rs = st.executeQuery(comandoSql);
			while(rs.next())
			{
				cidadeDTO = new CidadeDTO();
				cidadeDTO.setCodigo(rs.getInt("cid_codigo"));
				cidadeDTO.setNome(rs.getString("cid_nome"));
				cidadeDTO.setCategoria(rs.getString("cid_categoria"));
				cidadeDTO.setPreco(rs.getInt("cid_preco"));
			}
		}
		catch(SQLException e)
		{
			throw new Exception(e.getMessage());
		}

		return cidadeDTO;
	}

	public Boolean Incluir(CidadeDTO cidadeDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "INSERT INTO CIDADE(cid_nome,cid_categoria,cid_preco) VALUES (?,?,?)";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setString(1, cidadeDTO.getNome());
			pst.setString(2, cidadeDTO.getCategoria());
			pst.setInt(3, cidadeDTO.getPreco());
			return (pst.executeUpdate() > 0 ? true : false);
		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public Boolean Alterar(CidadeDTO cidadeDTO) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "UPDATE CIDADE SET cid_nome=?,cid_categoria=?,cid_preco=? WHERE cid_codigo = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(4, cidadeDTO.getCodigo());
			pst.setString(1, cidadeDTO.getNome());
			pst.setString(2, cidadeDTO.getCategoria());
			pst.setInt(3, cidadeDTO.getPreco());
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

	public Boolean Excluir(int codigo) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			comandoSql = "DELETE FROM CIDADE WHERE cid_codigo = ?";
			pst = (PreparedStatement)conexao.prepareStatement(comandoSql);
			pst.setInt(1, codigo);
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + comandoSql + ". ERRO: " + e);
		}
	}

}
