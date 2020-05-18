import java.util.ArrayList;

public class Memoria {

	private int tamanho;
	private int[] posicoes;   //array que representa cada posição
	private int qtdProcessosAlocados;
	private int qtdProcessosNaoAlocados;
	private ArrayList<Processo> processosAlocados;
	private ArrayList<Processo> processosNaoAlocados;
	
	public Memoria(int tamanho) {
		this.tamanho = tamanho;
		this.posicoes = new int[tamanho];
		this.processosAlocados = new ArrayList<>();
		this.processosNaoAlocados = new ArrayList<>();
		qtdProcessosAlocados = 0;
		qtdProcessosNaoAlocados = 0;
	}
	
	public int getQtdProcessosAlocados() {
		return qtdProcessosAlocados;
	}

	public void setQtdProcessosAlocados(int qtdProcessosAlocados) {
		this.qtdProcessosAlocados = qtdProcessosAlocados;
	}

	public int getQtdProcessosNaoAlocados() {
		return qtdProcessosNaoAlocados;
	}

	public void setQtdProcessosNaoAlocados(int qtdProcessosNaoAlocados) {
		this.qtdProcessosNaoAlocados = qtdProcessosNaoAlocados;
	}

	public void atualizaProcessosAlocados(int cicloAtual){
		Processo p;
		for(int i = 0; i < processosAlocados.size(); i++){
			p = processosAlocados.get(i);
			if(p.getCicloDeInicio() + p.getCiclos() == cicloAtual) {
				for(int j = p.getBitInicio(); j < p.getBitInicio() + p.getTamanho(); j++) {
					posicoes[j] = 0; //liberando o espaço da memória
				}
				this.processosAlocados.remove(i);
			}
		}
	}
	
	public void adicionarEmProcessosAlocados(Processo p) {
		this.processosAlocados.add(p);
		this.qtdProcessosAlocados++;
	}
	
	public void adicionarEmProcessosNaoAlocados(Processo p) {
		this.processosNaoAlocados.add(p);
		this.qtdProcessosNaoAlocados++;
	}
	
	public void imprimirPosicoes() {
		for(int i = 0; i < posicoes.length; i++) {
			System.out.print(posicoes[i] + " ");
			if(i % 50 == 0 && i != 0) System.out.println("");
		}
		System.out.println("");
	}
	
	public void imprimirProcessosAlocados() {
		for(Processo p: processosAlocados) {
			p.imprimir();
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int[] getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(int[] posicoes) {
		this.posicoes = posicoes;
	}

	public ArrayList<Processo> getProcessosAlocados() {
		return processosAlocados;
	}

	public void setProcessosAlocados(ArrayList<Processo> processosAlocados) {
		this.processosAlocados = processosAlocados;
	}

	public ArrayList<Processo> getProcessosNaoAlocados() {
		return processosNaoAlocados;
	}

	public void setProcessosNaoAlocados(ArrayList<Processo> processosNaoAlocados) {
		this.processosNaoAlocados = processosNaoAlocados;
	}

	
}
