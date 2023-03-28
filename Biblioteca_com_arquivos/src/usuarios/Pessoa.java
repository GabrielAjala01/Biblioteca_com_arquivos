package usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import biblioteca.Livros;
import interfaces.DAO;

public abstract class Pessoa implements DAO, Serializable {
	
	private int id;
	private String nome;
	private int idade;
	private String sexo;
	private String telefone;
	private int tipo;
	private int limite;
	
	public static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	public static ArrayList<Livros> meusLivros = new ArrayList<Livros>();
	
	public Pessoa() {
		
	}
	
	public Pessoa(int id, String nome, int idade, String sexo, String telefone, int tipo, int limite) {
		super();
		setNome(nome);
		setIdade(idade);
		setSexo(sexo);
		setTelefone(telefone);
		setTipo(tipo);
		setLimite(limite);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public Pessoa ler(int matricula) {
		return null;
		// TODO Auto-generated method stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static void percorrer(int valor) {
		int i = 0;
		while(valor != Pessoa.listaPessoas.get(i).getId()) {
			i = i+1;
		}
		Pessoa.listaPessoas.get(i).ler(valor);
	}
}
