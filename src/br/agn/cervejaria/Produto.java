package br.agn.cervejaria;

public class Produto {
	private int codigo;
	private String descricao;
	private float preco;
	private int quantidade;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		String output = "" + "\n";
		output += "Código: " + this.getCodigo() + "\n";
		output += "Descrição: " + this.getDescricao() + "\n";
		output += "Preço: " + this.getPreco() + "\n";
		output += "Quantidade: " + this.getQuantidade() + "\n";
		return output;
	}
}
