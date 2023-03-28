package biblioteca;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.DAO;
import usuarios.*;

public class Emprestimos implements DAO, Serializable {
	
	private int id;
	private String dataEmprestimo;
	private String horaEmprestimo;
	private Livros livro;
	private Pessoa pessoa;
	private int dias;
	
	public static ArrayList<Emprestimos> listaEmprestimos = new ArrayList<Emprestimos>();
	
	public Emprestimos() {
		
	}
	
	public Emprestimos(int id, String dataEmprestimo, String horaEmprestimo, Livros livro, Pessoa pessoa) {
		super();
		setId(id);
		setDataEmprestimo(dataEmprestimo);
		setHoraEmprestimo(horaEmprestimo);
		setLivro(livro);
		setPessoa(pessoa);
	}
	
	public static void percorrer(int valor) {
		int i = 0;
		while(valor != listaEmprestimos.get(i).getId()) {
			i = i+1;
		}
		listaEmprestimos.get(i).ler(valor);
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getHoraEmprestimo() {
		return horaEmprestimo;
	}

	public void setHoraEmprestimo(String horaEmprestimo) {
		this.horaEmprestimo = horaEmprestimo;
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(Pessoa pessoa) {
		int dias;
		if(pessoa.getTipo()==1) {
			dias = 30;
			this.dias = dias;
		} else if(pessoa.getTipo()==2) {
			dias = 15;
			this.dias = dias;
		} else {
			dias = 7;
			this.dias = dias;
		}
	}

	public void devolverLivro() {
		livro.setEmprestimo(true);
		livro.setStatus("LIVRO DEVOLVIDO");
	}
	
	public static void cadastrarEmprestimo() {
		System.out.println("Faça um emprestimo");
		Scanner scan = new Scanner(System.in);
		Emprestimos emprestimo = new Emprestimos();
		System.out.println("\nDefina um ID: ");
		emprestimo.setId(scan.nextInt());
		scan.nextLine();
		System.out.println("\nUsuario: ");
		emprestimo.setPessoa(Pessoa.listaPessoas.get(scan.nextInt()));
		System.out.println("\nLivro: ");
		emprestimo.setLivro(Obra.listaLivros.get(scan.nextInt()));
		scan.nextLine();
		System.out.println("\nData do emprestimo: ");
		emprestimo.setDataEmprestimo(scan.nextLine());
		System.out.println("\nHora do emprestimo: ");
		emprestimo.setHoraEmprestimo(scan.nextLine());
		emprestimo.setDias(emprestimo.getPessoa());
		if(emprestimo.getPessoa().meusLivros.size() < emprestimo.getPessoa().getLimite()) {
			listaEmprestimos.add(emprestimo);
			emprestimo.getPessoa().meusLivros.add(emprestimo.getLivro());
			System.out.println(emprestimo.toString() + "\n");
			emprestimo.gravar();
		} else {
			System.out.println("\nLimite de emprestimo atingido para esse usuario.");
		}	
	}

	@Override
	public String toString() {
		return "Detalhes do emprestimo: [Usuario: " + pessoa.getNome() + ", Livro: " + livro.getTitulo() + ", Data do emprestimo: " + dataEmprestimo + ", Tempo: " + dias +" dias]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String gravar() {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		String resultado = "Arquivo salvo!";
		String content = toString();
		try {
			FileWriter file = new FileWriter(local+"Emprestimo - "+getId());
			file.write(content);
			file.close();
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
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
	
	public static void ler(int id) {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		try {
			File file = new File(local+"Emprestimo - "+id);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}catch (Exception erro) {
			System.out.println("Falha na leitura \n "+ erro.toString());
		}
	}

	
}
