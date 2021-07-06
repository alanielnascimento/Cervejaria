package br.agn.cervejaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
	private Connection conexao;

	public VendaDAO() throws SQLException, ClassNotFoundException {
		conexao = Conecta.criarConexao();
	}

	// classe DAO(Todos os precessamentos)
	public void realizarVenda(Venda venda) {
		String sql = "INSERT INTO venda(numero, matfunc, codpro, quantidade) " + "VALUES(?,?,?,?)";
		
		try {

			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, venda.getNumero());
			preparador.setInt(2, venda.getMatfunc());
			preparador.setInt(3, venda.getCodpro());
			preparador.setInt(4, venda.getQuantidade());

			preparador.execute();
			preparador.close();
			System.out.println("Venda Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void atualizarQuantidade(Venda venda) {
		String sql = "UPDATE venda SET quantidade = ? WHERE numero = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setFloat(1, venda.getQuantidade());
			preparador.setInt(2, venda.getNumero());
			preparador.execute();
			preparador.close();
			System.out.println("Alteração Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// EXIBIR RESULTADOS DE SELECT
	public List<Venda> listarVendas() {
		String sql = "SELECT * FROM venda";
		List<Venda> lista = new ArrayList<>();
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Venda ven = new Venda();
				ven.setNumero(resultados.getInt("Numero"));
				ven.setMatfunc(resultados.getInt("MatFunc"));
				ven.setCodpro(resultados.getInt("CodPro"));
				ven.setQuantidade(resultados.getInt("Quantidade"));

				lista.add(ven);
			}
		} catch (SQLException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		return lista;
	}

	public void deletarVenda(Venda venda) {
		String sql = "DELETE FROM venda WHERE numero = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, venda.getNumero());
			preparador.execute();
			preparador.close();
			System.out.println("Venda Deletada!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
