
public class Processo {
	
	private int id;
	private int tamanho; 
	private int ciclos; 
	private int bitInicio;
	private int cicloDeInicio;

	public Processo(int processoId, int cicloAtual) {
		this.tamanho = (int)(Math.random() * 40) + 10;  
		this.ciclos = (int)(Math.random() * 5) + 5;
		this.id = processoId;
		this.cicloDeInicio = cicloAtual;
	}

	public void setBitInicio(int bitInicio) {
		this.bitInicio = bitInicio;
	}

	public void imprimir() {
		System.out.println("Processo " + id + "- Tamanho: " + tamanho + 
				", Ciclos: " + ciclos);
	}
	
	public int getNumero() {
		return id;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getCiclos() {
		return ciclos;
	}

	public int getBitInicio() {
		return bitInicio;
	}

	public int getCicloDeInicio() {
		return cicloDeInicio;
	}



}
