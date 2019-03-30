package com.scanner1ex;
import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		String nome;
		int idade;
		double salario;

		Scanner objLeitura = new Scanner(System.in);

		System.out.print("Digite o nome completo: ");
		nome = objLeitura.nextLine();
		System.out.print("Digite a idade: ");
		idade = objLeitura.nextInt();
		System.out.print("Digite o valor do salario desejado: ");
		salario = objLeitura.nextDouble();

		System.out.println("\nNome: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Salario: " + salario);

	}

}
