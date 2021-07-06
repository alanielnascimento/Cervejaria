package br.agn.cervejaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	private Connection conexao;

	public ProdutoDAO() throws SQLException, ClassNotFoundException {
		conexao = Conecta.criarConexao();
	}

	// classe DAO(Todos os precessamentos)
	public void cadastrarProduto(Produto produto) {
		String sql = "INSERT INTO produto(codigo, descricao, preco, quantidade) " + "VALUES(?,?,?,?)";

		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, produto.getCodigo());
			preparador.setString(2, produto.getDescricao());
			preparador.setFloat(3, produto.getPreco());
			preparador.setFloat(4, produto.getQuantidade());

			preparador.execute();
			preparador.close();
			System.out.println("Inserção Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// ATUALIZAÇÃO
	public void atualizarPreco(Produto produto) {
		String sql = "UPDATE produto SET preco = ? WHERE codigo = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setFloat(1, produto.getPreco());
			preparador.setInt(2, produto.getCodigo());
			preparador.execute();
			preparador.close();
			System.out.println("Alteração Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// DELEÇÂO
	public void deletarProduto(Produto produto) {
		String sql = "DELETE FROM produto WHERE codigo = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, produto.getCodigo());
			preparador.execute();
			preparador.close();
			System.out.println("Produto Deletado!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// EXIBIR RESULTADOS DE SELECT
	public List<Produto> todosProdutos() {
		String sql = "SELECT * FROM produto";
		List<Produto> lista = new ArrayList<>();
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Produto pro = new Produto();
				pro.setCodigo(resultados.getInt("Codigo"));
				pro.setDescricao(resultados.getString("Descricao"));
				pro.setPreco(resultados.getFloat("Preco"));
				pro.setQuantidade(resultados.getInt("Quantidade"));

				lista.add(pro);
			}
		} catch (SQLException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		return lista;
	}
}
