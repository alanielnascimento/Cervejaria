package br.agn.cervejaria;

public class Venda {
	private int numero;
	private int matfunc;
	private int codpro;
	private int quantidade;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getMatfunc() {
		return matfunc;
	}

	public void setMatfunc(int matfunc) {
		this.matfunc = matfunc;
	}

	public int getCodpro() {
		return codpro;
	}

	public void setCodpro(int codpro) {
		this.codpro = codpro;
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
		output += "Número da venda: " + this.getNumero() + "\n";
		output += "Vendedor: " + this.getMatfunc() + "\n";
		output += "Código do Produto: " + this.getCodpro() + "\n";
		output += "Quantidade Comprada: " + this.getQuantidade() + "\n";
		return output;
	}

}
