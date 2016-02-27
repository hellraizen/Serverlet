package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



import DAL.ConectaBd;
import Produto.Produto;

public class RepositorioNfe {
	Connection conn;

	public RepositorioNfe() throws ClassNotFoundException {
		this.conn = ConectaBd.conectabd();
	}
public void cadastrarNfe(int id) throws SQLException {
		
		// Criando a String SQL
		String sql1="insert into nfe (numero_nfe) values(?)";


		// Criar o PreparedStatement, objeto para executar a query
		
		PreparedStatement preStatement1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
		// Atualizando o primeiro parametro
		
		preStatement1.setInt(1, id);
	

		preStatement1.execute();

		// Retorna um ResultSet com todas as chaves geradas
		ResultSet resultSet = preStatement1.getGeneratedKeys();
		Integer clienteId = 0;

		// Pegando o identificador gerado a partir do �ltimo insert
		while (resultSet.next()) {
			clienteId = resultSet.getInt(1);
		}
		System.out.println("ID do Insert no Banco " + clienteId);
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}
public void cadastrarNfeQuantidade(int idE,int idP,int quantidade) throws SQLException {
	
	// Criando a String SQL
	
	String sql = "insert into nfe_produto_quantidade  values (?,?,?)";

	// Criar o PreparedStatement, objeto para executar a query
	PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
	// Atualizando o primeiro parametro
	
	preStatement.setInt(1, idE);
	
	preStatement.setInt(2, idP);
	
	preStatement.setInt(3, quantidade);

	

	preStatement.execute();

		
	System.out.println("Cadastro NFE realizado com sucesso");
}

	public void atualizar(int quantidade, int id) throws SQLException {

		int quantidadeTotal=0;
		
		String sql1 = "select * from produto where id=?";

	
		PreparedStatement preStatement = conn.prepareStatement(sql1);
		
		preStatement.setInt(1, id);

		ResultSet resultSet = preStatement.executeQuery();

		
		while (resultSet.next()) {
		
			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			int quantidadex = resultSet.getInt(3);
		quantidadeTotal= quantidadex;
		}
		
		quantidadeTotal=quantidadeTotal+quantidade;
		
		// Criando a String SQL
		String sql = "update produto set quantidade=? where id = ?";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement pst;

		pst = conn.prepareStatement(sql);

		pst.setInt(1, quantidadeTotal);
		pst.setInt(2, id);
	

		// Executando o select
		pst.executeUpdate();
		
		System.out.println("Atualizado Com Sucesso");
		
	}
	
	
	
}
