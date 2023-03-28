package biblioteca;

import java.util.ArrayList;

import interfaces.DAO;

public abstract class Obra implements DAO {
	
	private int id;
	private String titulo;
	private String autor;
	private int ano;
	private double mb;
	
	public static ArrayList<Livros> listaLivros = new ArrayList<Livros>();
	
	public Obra() {
		
	}

	public Obra(int id, String titulo, String autor, int ano, double mb) {
		super();
		setId(id);
		setTitulo(titulo);
		setAutor(autor);
		setAno(ano);
		setMb(mb);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getMb() {
		return mb;
	}

	public void setMb(double mb) {
		this.mb = mb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public static void ler() {
	}
	
	public static void percorrer(int valor) {
		int i = 0;
		while(valor != Obra.listaLivros.get(i).getId()) {
			i = i+1;
		}
		Obra.listaLivros.get(i).ler(valor);
	}
}
