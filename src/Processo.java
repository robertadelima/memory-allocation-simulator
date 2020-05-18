
public class Processo {
	
	private int numero;
	private int tamanho; //varia de 10kb até 50kb
	private int ciclos; //ficam na memória de 5 a 10 ciclos
	private int bitInicio;
	private int cicloDeInicio;

	public Processo(int processoNum, int cicloAtual) {
		this.tamanho = (int)(Math.random() * 40) + 10;
		this.ciclos = (int)(Math.random() * 5) + 5;
		this.numero = processoNum;
		this.cicloDeInicio = cicloAtual;
	}

	public void setBitInicio(int bitInicio) {
		this.bitInicio = bitInicio;
	}

	public void imprimir() {
		System.out.println("Processo " + numero + "- Tamanho: " + tamanho + ", Ciclos: " + ciclos + ", bit início: " + bitInicio);
	}
	
	public int getNumero() {
		return numero;
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
