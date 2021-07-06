package br.agn.cervejaria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cervejaria {
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private static ArrayList<Produto> produtos = new ArrayList<>();
	private static ArrayList<Venda> vendas = new ArrayList<>();

	public static void main(String[] args) {
		Teclado t = new Teclado();

		// int proximoId = 0;

		while (true) {
			System.out.println("************************************");
			System.out.println("*        Cervejaria Online         *");
			System.out.println("************************************");
			System.out.println("* 1.  Cadastrar Funcionario        *");
			System.out.println("* 2.  Atualizar Salario            *");
			System.out.println("* 3.  Listar Funcionarios          *");
			System.out.println("* 4.  Remover Funcionario          *");
			System.out.println("* 5.  Cadastrar Cerveja            *");
			System.out.println("* 6.  Atualizar Preço              *");
			System.out.println("* 7.  Listar Cervejas              *");
			System.out.println("* 8.  Remover Cerveja              *");
			System.out.println("* 9.  Vender                       *");
			System.out.println("* 10. Atualizar Vendas             *");
			System.out.println("* 11. Listar Vendas                *");
			System.out.println("* 12. Remover Venda                *");
			System.out.println("* 0.  Sair                         *");
			System.out.println("************************************");

			int opcao = t.numeroInt("Selecione uma opção: ");

			if (opcao == 0) {
				System.out.println("Obrigado! ");// sair
				break;
			}
			// int matricula;
			// String nome;
			// float salario;
			Funcionario f = new Funcionario();
			Produto p = new Produto();
			Venda v = new Venda();

			if (opcao == 1) {
				// Cadastrar livro
				int Matricula = t.numeroInt("Matricula: ");
				String Nome = t.lerTexto("Nome: ");
				float Salario = t.numeroFloat("Salario: ");

				f.setMatricula(Matricula);
				f.setNome(Nome);
				f.setSalario(Salario);

				FuncionarioDAO funcionarioDAO = null;
				try {
					funcionarios.add(f);
					funcionarioDAO = new FuncionarioDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				funcionarioDAO.cadastrarFuncionario(f);

			} else if (opcao == 2) {// Cadastrar livro
				int Matricula = t.numeroInt("Matricula: ");
				float Salario = t.numeroFloat("Novo Salario: ");
				f.setMatricula(Matricula);
				f.setSalario(Salario);

				FuncionarioDAO funcionarioDAO = null;
				try {
					funcionarioDAO = new FuncionarioDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				funcionarioDAO.atualizarSalario(f);
			} else if (opcao == 3) {// Cadastrar livro
				FuncionarioDAO funcionarioDAO = null;
				try {
					funcionarioDAO = new FuncionarioDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				List<Funcionario> listaFunc = funcionarioDAO.todosFuncionarios();
				for (Funcionario func : listaFunc) {
					System.out.println(func);
				}
			} else if (opcao == 4) {
				int matricula = t.numeroInt("Matricula: ");
				f.setMatricula(matricula);

				FuncionarioDAO funcionarioDAO = null;
				try {
					funcionarioDAO = new FuncionarioDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				funcionarioDAO.deletarFuncionario(f);
			} else if (opcao == 5) {
				int codigo = t.numeroInt("Codigo do produto: ");
				String Descricao = t.lerTexto("Descrição: ");
				float preco = t.numeroFloat("Preço: ");
				int Qtd = t.numeroInt("Quantidade em Estoque: ");

				p.setCodigo(codigo);
				p.setDescricao(Descricao);
				p.setPreco(preco);
				p.setQuantidade(Qtd);

				ProdutoDAO produtoDAO = null;
				try {
					produtoDAO = new ProdutoDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				produtoDAO.cadastrarProduto(p);
			} else if (opcao == 6) {
				int codigo = t.numeroInt("Codigo do Produto: ");
				float preco = t.numeroFloat("Novo Preço: ");
				p.setCodigo(codigo);
				p.setPreco(preco);

				ProdutoDAO produtoDAO = null;
				try {
					produtoDAO = new ProdutoDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				produtoDAO.atualizarPreco(p);
			} else if (opcao == 7) {
				ProdutoDAO produtoDAO = null;
				try {
					produtoDAO = new ProdutoDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				List<Produto> listaComProdutos = produtoDAO.todosProdutos();
				for (Produto pro : listaComProdutos) {
					System.out.println(pro);
				}
			} else if (opcao == 8) {
				int codigo = t.numeroInt("Codigo do Produto: ");
				p.setCodigo(codigo);

				ProdutoDAO produtoDAO = null;
				try {
					produtoDAO = new ProdutoDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				produtoDAO.deletarProduto(p);
			} else if (opcao == 9) {
				int numero = t.numeroInt("Número da venda: ");
				int vendedor = t.numeroInt("Vendedor: ");
				int produto = t.numeroInt("Codigo do produto: ");
				int quantidade = t.numeroInt("Quantidade vendida: ");

				v.setNumero(numero);
				v.setMatfunc(vendedor);
				v.setCodpro(produto);
				v.setQuantidade(quantidade);

				VendaDAO vendaDAO = null;
				if (v.getQuantidade() > p.getQuantidade() || p.getQuantidade() == 0)
					try {
						vendaDAO = new VendaDAO();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				vendaDAO.realizarVenda(v);

			} else if (opcao == 10) {
				int numero = t.numeroInt("Numero da venda: ");
				int quantidade = t.numeroInt("Nova Quantidade: ");
				v.setNumero(numero);
				v.setQuantidade(quantidade);

				VendaDAO vendaDAO = null;
				try {
					vendaDAO = new VendaDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				vendaDAO.atualizarQuantidade(v);

			} else if (opcao == 11) {
				VendaDAO vendaDAO = null;
				try {
					vendaDAO = new VendaDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				List<Venda> listaDeVendas = vendaDAO.listarVendas();
				for (Venda ven : listaDeVendas) {
					System.out.println(ven);
				}
			} else if (opcao == 12) {
				int numero = t.numeroInt("Número da venda: ");
				v.setNumero(numero);

				VendaDAO vendaDAO = null;
				try {
					vendaDAO = new VendaDAO();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				vendaDAO.deletarVenda(v);
			}
		}
	}
}
