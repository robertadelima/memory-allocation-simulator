import java.util.ArrayList;

public class Memoria {

	private int tamanho;
	private int[] posicoes;   
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

	//FIRST FIT: Busca o primeiro espaço vazio contiguo na memoria e aloca
	public boolean firstFit(Processo p) {
		boolean encontrouEspaco = false;
		int espaco = 0;
		for(int i = 0; i < posicoes.length; i++) {
			if(posicoes[i] == 0) espaco++; //se encontra, soma um espaço vazio
			else espaco = 0; //senão, quebra a continuidade

			if(espaco == p.getTamanho()) { //se encontrar um espaço suficiente pro processo
				p.setBitInicio(i - (p.getTamanho() - 1));
				encontrouEspaco = true;
				break;				
			}
		}
		if(encontrouEspaco) {
			for(int j = p.getBitInicio(); j < (p.getBitInicio() + p.getTamanho()); j++) {
				posicoes[j] = p.getNumero();
			}
			return true;
		}
		return false;
	}

	public void atualizaProcessosAlocados(int cicloAtual){
		ArrayList<Processo> processosFinalizados = new ArrayList<>();
		for(Processo p : processosAlocados){
			if(p.getCicloDeInicio() + p.getCiclos() == cicloAtual) {
				for(int j = p.getBitInicio(); j < p.getBitInicio() + p.getTamanho(); j++) {
					posicoes[j] = 0; //liberando o espaço da memória
				}
				processosFinalizados.add(p);
			}
		}
		//remover da lista de atualmente alocados
		for(Processo p : processosFinalizados) {
			processosAlocados.remove(p);
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

	public int getQtdProcessosAlocados() {
		return qtdProcessosAlocados;
	}

	public int getQtdProcessosNaoAlocados() {
		return qtdProcessosNaoAlocados;
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

	public int[] getPosicoes() {
		return posicoes;
	}

	public int getPosicao(int index) {
		return posicoes[index];
	}

	public ArrayList<Processo> getProcessosAlocados() {
		return processosAlocados;
	}

	public ArrayList<Processo> getProcessosNaoAlocados() {
		return processosNaoAlocados;
	}

}
