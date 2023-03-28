package usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Funcionario extends Pessoa {

	private String cartao;
	
	public Funcionario() {
		
	}

	public Funcionario(int id, String nome, int idade, String sexo, String telefone, String cartao, int tipo, int limite) {
		super(id, nome, idade, sexo, telefone, tipo, limite);
		setCartao(cartao);
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	
	public static void cadastrarFuncionario() {
		System.out.println("\nCadastro de funcionario");
		Scanner scan = new Scanner(System.in);
		Funcionario funcionario = new Funcionario();
		System.out.println("\nNome: ");
		funcionario.setNome(scan.nextLine());
		System.out.println("\nIdade: ");
		funcionario.setIdade(scan.nextInt());
		scan.nextLine();
		System.out.println("\nSexo: ");
		funcionario.setSexo(scan.nextLine());
		System.out.println("\nTelefone: ");
		funcionario.setTelefone(scan.nextLine());
		System.out.println("\nMatricula: ");
		funcionario.setCartao(scan.nextLine());
		funcionario.setTipo(2);
		funcionario.setLimite(6);
		Pessoa.listaPessoas.add(funcionario);
		System.out.println(funcionario.toString() + "\n");
	}

	@Override
	public String toString() {
		return "Funcionario [Nome: " + getNome() + ", Idade: " + getIdade() +", Sexo: " + getSexo() + ", Telefone: " + getTelefone() + ", Cartao: " + cartao + "]";
	}

	@Override
	public String gravar() {
		String local = "C:\\Users\\Gabriel\\Documents\\teste\\";
		String resultado = "Arquivo salvo!";
		try {
			FileOutputStream file = new FileOutputStream(local+"Funcionario - "+this.getCartao());
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
	public Pessoa ler(int cartao) {
		String local = "C:\\Users\\kaior\\Desktop\\ARQUIVOS ECLIPSE\\atv-poo\\arquivos\\";
		try {
			FileInputStream file = new FileInputStream(local+"Funcionario - "+ cartao);
			ObjectInputStream stream = new ObjectInputStream(file);
			return (Funcionario) stream.readObject();
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
