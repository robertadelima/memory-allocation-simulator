
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
	
	//método que busca o primeiro espaço vazio contiguo na memoria e aloca
	public boolean firstFit(Memoria memoria) {
		boolean encontrouEspaco = false;
		int espaco = 0;
		int posicao = 0;
		for(int i = 0; i < memoria.getPosicoes().length; i++) {
			if(memoria.getPosicoes()[i] == 0) espaco++; //se encontra um espaço vazio
			else espaco = 0; //senão, quebra a continuidade
				
			if(espaco == this.tamanho) {
				this.bitInicio = i - (this.tamanho - 1);
				encontrouEspaco = true;
				posicao = i;
				break;				
			}
		}
		if(encontrouEspaco) {
			for(int j = bitInicio; j < posicao; j++) {
				memoria.getPosicoes()[j] = this.numero;
			}
			return true;
		}
		return false;
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
