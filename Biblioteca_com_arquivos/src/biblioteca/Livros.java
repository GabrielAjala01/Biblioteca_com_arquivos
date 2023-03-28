package biblioteca;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Scanner;

import interfaces.DAO;

public class Livros extends Obra implements DAO, Serializable{
	
	private String area;
	private String editora;
	private String edicao;
	private int numPaginas;
	private boolean emprestimo;
	private String status;
	private boolean aberto;

	public Livros() {
		
	}

	public Livros(int id, String titulo, String autor, int ano, String area, String editora, String edicao, int numPaginas, double mb) {
		super(id, titulo, autor, ano, mb);
		setArea(area);
		setEditora(editora);
		setEdicao(edicao);
		setNumPaginas(numPaginas);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public boolean isEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(boolean emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public void abrirLivro() {
		if (!this.aberto) {
			setStatus("LIVRO ABERTO");
            this.aberto = true;
        } else {
        	setStatus("O LIVRO JA ESTA ABERTO");
        }
	}
	
	public void fecharLivro() {
		if (this.aberto) {
			setStatus("LIVRO FECHADO");
            this.aberto = false;
        } else {
        	setStatus("O LIVRO JA ESTA FECHADO");
        }
	}
	
	public static void cadastrarLivro() {
		System.out.println("Cadastre um livro");
		Scanner scan = new Scanner(System.in);
		Livros livro = new Livros();
		System.out.println("\nDefina um ID: ");
		livro.setId(scan.nextInt());
		scan.nextLine();
		System.out.println("\nTitulo: ");
		livro.setTitulo(scan.nextLine());
		System.out.println("\nAutor: ");
		livro.setAutor(scan.nextLine());
		System.out.println("\nArea(Categoria): ");
		livro.setArea(scan.nextLine());
		System.out.println("\nEditora: ");
		livro.setEditora(scan.nextLine());
		System.out.println("\nEdiçao: ");
		livro.setEdicao(scan.nextLine());
		System.out.println("\nNumero de paginas: ");
		livro.setNumPaginas(scan.nextInt());
		livro.setEmprestimo(false);
		System.out.println("\nTamanho MB: ");
		livro.setMb(scan.nextDouble());
		Obra.listaLivros.add(livro);
		System.out.println(livro.toString() + "\n");
		livro.gravar();
	}

	@Override
	public String toString() {
		return "Dados do livro: [Titulo: "+ getTitulo() +", Autor: "+ getAutor() +", Area: "+ getArea() +", Editora: "+ getEditora() +"]";
	}

	@Override
	public String gravar() {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		String resultado = "Arquivo salvo!";
		String content = toString();
		try {
			FileWriter file = new FileWriter(local+"Livro - "+getId());
			file.write(content);
			file.close();
		} catch (Exception erro) {
			resultado = "Falha ao salvar!";
		}
		return resultado;
	}
	
	public static void ler(int id) {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		try {
			File file = new File(local+"Livro - "+id);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}catch (Exception erro) {
			System.out.println("Falha na leitura \n "+ erro.toString());
		}
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}	
	
	
}
