package Dto;

import java.io.Serializable;
import java.util.Date;

public class CidadeDTO implements Serializable {
	private int codigo;
	private String nome;
	private String categoria;
	private int preco;
	
	public CidadeDTO() { 
		this.codigo = 0;
		this.nome = "";
		this.categoria = "";
		this.preco = 0;
	}
	
	public CidadeDTO(int codigo, String nome, String categoria, int preco)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}
	
	public CidadeDTO(String nome, String categoria, int preco)
	{
		this.nome = nome;
		this.categoria = categoria;;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	

}
