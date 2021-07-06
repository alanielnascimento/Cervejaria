package br.agn.cervejaria;

public class Funcionario {
	private int matricula;
	private String nome;
	private float salario;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		String output = "" + "\n";
		output += "Matricula: " + this.getMatricula() + "\n";
		output += "Nome: " + this.getNome() + "\n";
		output += "Salario: " + this.getSalario() + "\n";
		return output;
	}

}
