import java.util.Scanner;

public class Controle {

	public static void main(String[] args) {
		String tipo;
		Pessoa pessoa = new Pessoa();
		Aluno aluno = new Aluno();
		Professor professor = new Professor();
		
		Scanner objLeitura = new Scanner(System.in);
		
		/*Pessoa
		System.out.print("Digite o nome completo: ");
		pessoa.setNome(objLeitura.nextLine());
		System.out.print("Digite o endereco: ");
		pessoa.setEndereco(objLeitura.nextLine());
		System.out.print("Digite o telefone: ");
		pessoa.setTel(objLeitura.nextLine());
		System.out.print("Digite o CPF: ");
		pessoa.setCPF(objLeitura.nextLine());*/
		
		System.out.println("Qual o tipo de cadastro? \nA - Aluno\nP - Professor");
		tipo = objLeitura.next();
		
		switch(tipo){
			case "A": 
				System.out.print("\nDigite o nome completo: ");
				aluno.setNome(objLeitura.nextLine());
				System.out.print("Digite o endereco: ");
				aluno.setEndereco(objLeitura.nextLine());
				System.out.print("Digite o telefone: ");
				aluno.setTel(objLeitura.nextLine());
				System.out.print("Digite o CPF: ");
				aluno.setCPF(objLeitura.nextLine());
				System.out.print("Digite o curso: ");
				aluno.setCurso(objLeitura.nextLine());
				System.out.print("Digite a nota: ");
				aluno.setNota(objLeitura.nextDouble());
			
			case "P":
				System.out.print("\nDigite o nome completo: ");
				professor.setNome(objLeitura.nextLine());
				System.out.print("Digite o endereco: ");
				professor.setEndereco(objLeitura.nextLine());
				System.out.print("Digite o telefone: ");
				professor.setTel(objLeitura.nextLine());
				System.out.print("Digite o CPF: ");
				professor.setCPF(objLeitura.nextLine());
				System.out.print("Digite o departamento: ");
				professor.setDepto(objLeitura.nextLine());
				System.out.print("Digite o nome do curso: ");
				professor.setNome_curso(objLeitura.nextLine());
				System.out.print("Digite o salario: ");
				professor.setSalario(objLeitura.nextDouble());
				
		}
		
		
	}

}
