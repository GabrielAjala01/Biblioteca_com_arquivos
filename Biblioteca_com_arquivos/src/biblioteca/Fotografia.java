package biblioteca;

public class Fotografia extends Obra {
	
	private boolean cor;
	private String descricao;
	
	public Fotografia() {
		
	}
	
	public Fotografia(String titulo, String autor, int ano, boolean cor, String descricao, double mb) {
		super(ano, titulo, autor, ano, mb);
		setCor(cor);
		setDescricao(descricao);
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fotografia [Nome da foto: " + getTitulo() + ", Autor: " + getAutor() + ", Ano: " + getAno() + " cor: " + cor + ", descricao: " + descricao + ", Tamanho: " + getMb() + "MB]";
	}

	@Override
	public String gravar() {
		// TODO Auto-generated method stub
		return null;
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
