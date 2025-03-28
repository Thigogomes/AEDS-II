package concursos;

public class Concurso {
	private int codigoDoConcurso;
	private String nomeConcurso;
	private String categoria;
	private String banca;
	private String localizacao;
	
	public Concurso() {
		this.codigoDoConcurso = -1;
		this.nomeConcurso = "";
		this.categoria = "";
		this.banca = "";
		this.localizacao = "";
	}
	
	public Concurso(int codigoDoConcurso, String nomeConcurso, String categoria, String banca, String localizacao) {
		this.codigoDoConcurso = codigoDoConcurso;
		this.nomeConcurso = nomeConcurso;
		this.categoria = categoria;
		this.banca = banca;
		this.localizacao = localizacao;
	}
	
	public int getCodigoConcurso() {
		return codigoDoConcurso;
	}
	
	public void setCodigoConcurso(int codigoDoConcurso) {
		this.codigoDoConcurso =  codigoDoConcurso;
	}
	 
	public String getNomeConcurso() {
		return nomeConcurso;
	}
	
	public void setNomeConcurso(String nomeConcurso) {
		this.nomeConcurso = nomeConcurso;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getBanca() {
		return banca;
	}
	
	public void setBanca(String banca) {
		this.banca= banca;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@Override
	public String toString() {
	    return "Concurso [codigo=" + getCodigoConcurso() + ", nome=" + getNomeConcurso() + ", categoria=" + getCategoria() + ", banca=" + getBanca() + ", localizacao=" + getLocalizacao() + "]";
	}

}
