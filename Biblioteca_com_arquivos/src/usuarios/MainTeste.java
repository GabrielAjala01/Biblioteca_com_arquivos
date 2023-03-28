package usuarios;

import java.util.Scanner;

public class MainTeste {
	
	public static void main(String[] args) {
		
		Professor professor = new Professor();
		
		professor.cadastroProfessor();
		professor.listaPessoas.get(0).gravar();
		
		System.out.println("Qual a matricula? ");
		Scanner scan = new Scanner(System.in);
		int mat = scan.nextInt();
		
		try {
			professor.ler(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
