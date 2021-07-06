package br.agn.cervejaria;

import java.util.Scanner;

public class Teclado {
	private Scanner scanner;

	public Teclado() {
		scanner = new Scanner(System.in);
	}

	public String lerTexto(String mensagem) {
		System.out.print(mensagem);
		String texto = scanner.nextLine();
		return texto;
	}

	public float numeroFloat(String mensagem) {

		float numero = 0;

		while (true) {
			System.out.print(mensagem);
			try {
				numero = Float.parseFloat(scanner.nextLine());
				break;
			} catch (NumberFormatException ex) {
				System.err.println("Digite um número válido!");
			}
		}
		return numero;
	}

	public int numeroInt(String mensagem) {

		int numero = 0;

		while (true) {
			System.out.print(mensagem);
			try {
				numero = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException ex) {
				System.err.println("Digite um número válido!");
			}
		}
		return numero;
	}

}
