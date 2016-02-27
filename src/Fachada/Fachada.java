package Fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import Produto.Produto;
import Repositorio.RepositorioNfe;
import Repositorio.RepositorioProduto;

public class Fachada {

	private static Fachada instance;
	private RepositorioProduto repositorioProduto;
	private RepositorioNfe repositorioNfe;
	
	private Fachada() throws ClassNotFoundException{
		this.repositorioProduto = new RepositorioProduto();
		this.repositorioNfe = new RepositorioNfe();
	}
	
	public static Fachada getInstance() throws ClassNotFoundException{
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	public void cadastrarProduto(Produto produto) throws SQLException {
		repositorioProduto.cadastrar(produto);

	}

	public void atualizarProduto(Produto produto) throws SQLException {
		repositorioProduto.atualizar(produto);

	}

	public void removerProduto(int id) throws SQLException {
		repositorioProduto.remover(id);

	}

	public Produto procurarProduto(String nome) throws SQLException {

		return repositorioProduto.procurar(nome);
	}

	public boolean existeProduto(int id) throws SQLException {

		return repositorioProduto.existe(id);
	}

	public ArrayList<Produto> listarProduto() throws SQLException {

		return repositorioProduto.listar();
	}
//--------------------------------------------------------------------------------nfe---------------------------	
	public void cadastrarNfe(int id) throws SQLException {
		repositorioNfe.cadastrarNfe(id);
	}
	public void cadastrarNfeQuantidade(int idE,int idP,int quantidade) throws SQLException {
		repositorioNfe.cadastrarNfeQuantidade(idE, idP, quantidade);
	}

	public void atualizar(int quantidade, int id) throws SQLException {
		repositorioNfe.atualizar(quantidade, id);
	}

	
}
