package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConexao {

	private static Connection conexao = null;

	static public Connection getConexao() throws Exception
	{
		String url;
		String userName   = "sa";
		String passName   = "123456";
		//url = "jdbc:sqlserver://GILCOSTA;databaseName=catalogo;user=sa;password=123456;";
		url = "jdbc:sqlserver://GILCOSTA;databaseName=catalogo;";
		//url = "jdbc:sqlserver://localhost;databaseName=catalogo;integratedSecurity=true;";

		if(conexao == null)
		{
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conexao = DriverManager.getConnection(url, userName,  passName);
			} catch( SQLException e ) {
				e.printStackTrace();
				conexao = null;
				throw new Exception("Não foi possível abrir conexão com o banco de dados: " + e.getMessage());
			} catch ( ClassNotFoundException e ) {
				e.printStackTrace();
				conexao = null;
				throw new Exception("Não foi possível abrir conexão com o banco de dados: " + e.getMessage());
			}
		}

		return conexao; 
	}

	static public void Desconectar() throws SQLException
	{
		if(conexao != null)
		{
			try
			{
				conexao.close();
			} 
			catch (SQLException e) 
			{
				throw new SQLException("Não foi possível abrir conexão com o banco de dados: " + e.getMessage());
			}
		}
	}
}
