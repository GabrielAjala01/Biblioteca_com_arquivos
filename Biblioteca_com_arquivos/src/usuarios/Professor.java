package usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Professor extends Pessoa implements Serializable {
	
	private String matricula;
	private double salario;
	
	public Professor() {
	
	}
	public Professor(int id, String nome, int idade, String sexo, String telefone, String matricula, double salario, int tipo, int limite) {
		super(id, nome, idade, sexo, telefone, tipo, limite);
		setMatricula(matricula);
		setSalario(salario);
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public static void cadastroProfessor() {
		Scanner scan = new Scanner(System.in);
		Professor professor = new Professor();
		System.out.println("\nDefina um ID: ");
		professor.setId(scan.nextInt());
		scan.nextLine();
		System.out.println("\nNome: ");
		professor.setNome(scan.nextLine());
		System.out.println("\nIdade: ");
		professor.setIdade(scan.nextInt());
		scan.nextLine();
		System.out.println("\nSexo: ");
		professor.setSexo(scan.nextLine());
		System.out.println("\nTelefone: ");
		professor.setTelefone(scan.nextLine());
		System.out.println("\nMatricula: ");
		professor.setMatricula(scan.nextLine());
		System.out.println("\nSalario: ");
		professor.setSalario(scan.nextDouble());
		professor.setTipo(1);
		professor.setLimite(9);
		listaPessoas.add(professor);
		professor.gravar();
		System.out.println(professor.toString() + "\n");
	}
	
	@Override
	public String toString() {
		return "Professor [Nome: " + getNome() + ", Idade: " + getIdade() +", Sexo: " + getSexo() + ", Telefone: " + getTelefone() + ", Matricula: " + matricula + ", Salario: " + salario + "]";
	}
	
	@Override
	public String gravar() {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		String resultado = "Arquivo salvo!";
		String content = toString();
		try {
			FileWriter file = new FileWriter(local+"Professor - "+getId());
			file.write(content);
			file.close();
		} catch (Exception erro) {
			resultado = "Falha ao salvar!";
		}
		return resultado;
	}
	
	public Professor ler(int id) {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		try {
			File file = new File(local+"Professor - "+id);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}catch (Exception erro) {
			System.out.println("Falha na leitura \n "+ erro.toString());
		}
		return null;
	}
	
	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	
	

}
