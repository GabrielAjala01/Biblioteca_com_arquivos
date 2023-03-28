package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import biblioteca.*;
import interfaces.DAO;
import usuarios.*;

public class MainApplication {
	
	public static void menu() {
		System.out.println("-----MENU---------");
		System.out.println("1 -> Cadastre livro");
		System.out.println("2 -> Cadastrar usuario");
		System.out.println("3 -> Realizar emprestimo");
		System.out.println("4 -> Realizar devoluçao");
		System.out.println("5 -> Listar");
		System.out.println("6 -> Ler arquivos");
		System.out.println("7 -> Para encerrar");
		System.out.println("DIGITE SUA OPÇÃO AQUI: ");
	}
	
	public static void lerArquivos() {
		
		int op3;
		
		do {
			System.out.println("QUAL TIPO DE ARQUIVO?");
			System.out.println("1 -> Dados de usuarios");
			System.out.println("2 -> Dados de emprestimo");
			System.out.println("3 -> Voltar");
			
			Scanner ent = new Scanner(System.in);
			
			op3 = ent.nextInt();
			Scanner scan = new Scanner(System.in);
			
			switch(op3) {
			case 1:
				System.out.println("digite o id do usuario: ");
				Pessoa.percorrer(scan.nextInt());
				return;
			case 2: 
				System.out.println("digite o id do emprestimo: ");
				Emprestimos.percorrer(scan.nextInt());
				return;
			case 3:
				System.out.println("Voltando... \n");
			default:
				System.out.println("Opçao invalida... \n");
			}
		} while(op3 != 3);
	}
	
	public static void cadUsuario() {
		System.out.println("Cadastre um usuario");
		int op3;
		
		do {
			System.out.println("1- Cadastrar aluno");
			System.out.println("2- Cadastrar funcionario");
			System.out.println("3- Cadastrar professor");
			System.out.println("4- Voltar");
			Scanner ent = new Scanner(System.in);
			
			op3 = ent.nextInt();
			
			switch(op3) {
			case 1:
				Estudante.cadastrarEstudante();
				return;
			case 2: 
				Funcionario.cadastrarFuncionario();
				return;
			case 3:
				Professor.cadastroProfessor();
				return;
			case 4:
				System.out.println("Voltando... \n");
			default:
				System.out.println("Opçao invalida... \n");
			}
		} while(op3 != 4);
	}

	public static void fazerDev() {
		System.out.println("Devolva um livro ");
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEmprestimos ativos: ");
		int i = 0;
		for(Emprestimos emprestimo : Emprestimos.listaEmprestimos) {
			System.out.printf("\n%d - %s", i, emprestimo.getLivro().getTitulo());
			i++;
		}
		System.out.println("\nQual livro deseja devolver: ");
		Emprestimos.listaEmprestimos.get(scan.nextInt()).devolverLivro();
	}
	
	public static void listar() {
		int op2;
		
		do {
			System.out.println("1- Listar livros");
			System.out.println("2- Listar usuarios");
			System.out.println("3- Listar emprestimos");
			System.out.println("4- Voltar");
			Scanner ent = new Scanner(System.in);
			
			op2 = ent.nextInt();
			
			switch(op2) {
			case 1:
				listarLivros();
				return;
			case 2: 
				listarUsuarios();
				return;
			case 3:
				listarEmprestimos();
				return;
			case 4:
				System.out.println("Voltando... \n");
			default:
				System.out.println("Opçao invalida... \n");
			}
		} while(op2 != 4);
	}
	
	public static void listarLivros() {
		System.out.println("Lista de livros: \n");
		for(Livros livro : Obra.listaLivros) {
			System.out.println(livro.toString());
		}
	}
	
	public static void listarUsuarios() {
		System.out.println("Lista de usuarios: \n");
		for(Pessoa pessoa : Pessoa.listaPessoas) {
			System.out.println(pessoa.toString());
		}
	}
	
	public static void listarEmprestimos() {
		System.out.println("Lista de emprestimos: \n");
		for(Emprestimos emprestimo : Emprestimos.listaEmprestimos) {
			System.out.println(emprestimo.toString());
		}
	}
	
	public static <E> void main(String[] args) {		
		
		Professor profTeste = new Professor(10, "Gabriel", 22, "masc", "92752317", "2020101", 1500, 1, 9);
		Livros livroTeste = new Livros(1, "Assombrando Adeline", "Mylele", 2020, "suspense", "mik", "3a", 900, 90);
		Emprestimos emprestimoTeste = new Emprestimos(100, "28/03", "17:25", livroTeste, profTeste);

		Emprestimos.listaEmprestimos.add(emprestimoTeste);
		Pessoa.listaPessoas.add(profTeste);
		Obra.listaLivros.add(livroTeste);
		
		int op;
		Scanner ent = new Scanner(System.in);
		
		System.out.println("Biblioteca\n");
		
		do {
			menu();
			op = ent.nextInt();
			
			switch(op) {
			case 1:
				Livros.cadastrarLivro();
				break;
			case 2:
				cadUsuario();
				break;
			case 3:
				Emprestimos.cadastrarEmprestimo();
				break;
			case 4:
				fazerDev();
				break;
			case 5:
				listar();
				break;
			case 6:
				lerArquivos();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Opçao invalida.");
			}
		} while(op != 0);
		
	}

}
