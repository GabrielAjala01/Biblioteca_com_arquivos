package biblioteca;

public class MidiaAudio extends Obra {
	
	private String tempo;
	
	public MidiaAudio() {
	
	}
	
	public MidiaAudio(String titulo, String autor, int ano, double mb, String tempo) {
		super(ano, titulo, autor, ano, mb);
		setTempo(tempo);
	}
	
	public String getTempo() {
		return tempo;
	}
	
	public void setTempo(String tempo) {
		this.tempo = tempo;
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
