package br.agn.cervejaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
	private Connection conexao;

	public FuncionarioDAO() throws SQLException, ClassNotFoundException {
		conexao = Conecta.criarConexao();
	}

	// classe DAO(Todos os precessamentos)
	public void cadastrarFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario(matricula, nome, salario) " + "VALUES(?,?,?)";

		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, funcionario.getMatricula());
			preparador.setString(2, funcionario.getNome());
			preparador.setFloat(3, funcionario.getSalario());

			preparador.execute();
			preparador.close();
			System.out.println("Inserção Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// ATUALIZAÇÃO
	public void atualizarSalario(Funcionario funcionario) {
		String sql = "UPDATE funcionario SET salario = ? WHERE matricula = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setFloat(1, funcionario.getSalario());
			preparador.setInt(2, funcionario.getMatricula());
			preparador.execute();
			preparador.close();
			System.out.println("Alteração Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// DELEÇÂO
	public void deletarFuncionario(Funcionario funcionario) {
		String sql = "DELETE FROM funcionario WHERE matricula = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, funcionario.getMatricula());
			preparador.execute();
			preparador.close();
			System.out.println("Deleção Realizada com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// EXIBIR RESULTADOS DE SELECT
	public List<Funcionario> todosFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		List<Funcionario> lista = new ArrayList<>();
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Funcionario func = new Funcionario();
				func.setMatricula(resultados.getInt("Matricula"));
				func.setNome(resultados.getString("Nome"));
				func.setSalario(resultados.getFloat("Salario"));

				lista.add(func);
			}
		} catch (SQLException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		return lista;
	}
}
