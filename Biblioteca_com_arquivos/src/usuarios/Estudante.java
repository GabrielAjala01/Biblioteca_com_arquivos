package usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.Livros;

public class Estudante extends Pessoa {
	
	private String matricula;
	
	public Estudante() {
		
	}

	public Estudante(int id, String nome, int idade, String sexo, String telefone, String matricula, int tipo, int limite) {
		super(id, nome, idade, sexo, telefone, tipo, limite);
		setMatricula(matricula);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public static void cadastrarEstudante() {
		System.out.println("\nCadastro de estudante");
		Scanner scan = new Scanner(System.in);
		Estudante estudante = new Estudante();
		System.out.println("\nDefina um ID: ");
		estudante.setId(scan.nextInt());
		scan.nextLine();
		System.out.println("\nNome: ");
		estudante.setNome(scan.nextLine());
		System.out.println("\nIdade: ");
		estudante.setIdade(scan.nextInt());
		scan.nextLine();
		System.out.println("\nSexo: ");
		estudante.setSexo(scan.nextLine());
		System.out.println("\nTelefone: ");
		estudante.setTelefone(scan.nextLine());
		System.out.println("\nMatricula: ");
		estudante.setMatricula(scan.nextLine());
		estudante.setTipo(3);
		estudante.setLimite(3);
		Pessoa.listaPessoas.add(estudante);
		System.out.println(estudante.toString() + "\n");
	}

	@Override
	public String toString() {
		return "Estudante [Nome: " + getNome() + ", Idade: " + getIdade() +", Sexo: " + getSexo() + ", Telefone: " + getTelefone() + ", Matricula: " + matricula + "]";
	}

	@Override
	public String gravar() {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		String resultado = "Arquivo salvo!";
		try {
			FileOutputStream file = new FileOutputStream(local+"Estudante - "+this.getMatricula());
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(this);
			stream.flush();
			stream.close();
		} catch (Exception erro) {
			resultado = "Falha ao salvar!";
		}
		return resultado;
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa ler(int matricula) {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		try {
			FileInputStream file = new FileInputStream(local+"Estudante - "+ matricula);
			ObjectInputStream stream = new ObjectInputStream(file);
			return (Estudante) stream.readObject();
		}catch (Exception erro) {
			System.out.println("Falha na leitura \n "+ erro.toString());
			return null;
		}
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
