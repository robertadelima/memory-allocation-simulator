import java.util.ArrayList;

public class Memoria {

	private int tamanho;
	private int[] posicoes;   
	private ArrayList<Processo> processosAlocadosAtualmente;
	private ArrayList<Processo> processosNaoAlocados;

	public Memoria(int tamanho) {
		this.tamanho = tamanho;
		this.posicoes = new int[tamanho];
		this.processosAlocadosAtualmente = new ArrayList<>();
		this.processosNaoAlocados = new ArrayList<>();
	}

	//FIRST FIT: Busca o primeiro espa�o vazio contiguo na memoria e aloca
	public boolean firstFit(Processo p) {
		boolean encontrouEspaco = false;
		int espaco = 0;
		for(int i = 0; i < posicoes.length; i++) {
			if(posicoes[i] == 0) espaco++; //se encontra, soma um espa�o vazio
			else espaco = 0; //sen�o, quebra a continuidade

			if(espaco == p.getTamanho()) { //se encontrar um espa�o suficiente pro processo
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
	
	//BEST FIT: Busca espa�o que mais se aproxima do tamanho do processo a ser alocado
	public boolean bestFit(Processo p) {
		
		int inicioBestFit = 0; 
		int espacoBestFit = tamanho+1; //inicializando com o tamanho da mem�ria +1 (maior do que o m�ximo)
		int inicio = 0;
		int espaco = 0;
		for(int i = 0; i < posicoes.length; i++) {
			if(posicoes[i] == 0) espaco++; //se encontra, soma um espa�o vazio
			else {
				if(espaco >= p.getTamanho() && espaco < espacoBestFit) {
					espacoBestFit = espaco;
					inicioBestFit = inicio;
				}
				espaco = 0; //sen�o, quebra a continuidade
				inicio = i+1; //comeca a contar a partir do pr�ximo
			}
			if(i == posicoes.length - 1) { //se chegar no final
				if(espaco >= p.getTamanho() && espaco < espacoBestFit) {
					espacoBestFit = espaco;
					inicioBestFit = inicio;
				}
			}
		}
		if(espacoBestFit != tamanho+1) {  //se encontrou um espa�o
			p.setBitInicio(inicioBestFit);
			for(int j = p.getBitInicio(); j < (p.getBitInicio() + p.getTamanho()); j++) {
				posicoes[j] = p.getNumero();
			}
			return true;
		}
		return false;
	}

	//WORST FIT: Busca espa�o com maior tamanho
		public boolean worstFit(Processo p) {
			
			int inicioBestFit = 0; 
			int espacoBestFit = 0; //inicializando com o menor tamanho poss�vel (0)
			int inicio = 0;
			int espaco = 0;
			for(int i = 0; i < posicoes.length; i++) {
				if(posicoes[i] == 0) espaco++; //se encontra, soma um espa�o vazio
				else {
					if(espaco >= p.getTamanho() && espaco > espacoBestFit) {
						espacoBestFit = espaco;
						inicioBestFit = inicio;
					}
					espaco = 0; //sen�o, quebra a continuidade
					inicio = i+1; //comeca a contar a partir do pr�ximo
				}
				if(i == posicoes.length - 1) { //se chegar no final
					if(espaco >= p.getTamanho() && espaco > espacoBestFit) {
						espacoBestFit = espaco;
						inicioBestFit = inicio;
					}
				}
			}
			if(espacoBestFit != 0) {  //se encontrou um espa�o
				p.setBitInicio(inicioBestFit);
				for(int j = p.getBitInicio(); j < (p.getBitInicio() + p.getTamanho()); j++) {
					posicoes[j] = p.getNumero();
				}
				return true;
			}
			return false;
		}
	
	public void atualizaProcessosAlocados(int cicloAtual){
		ArrayList<Processo> processosFinalizados = new ArrayList<>();
		for(Processo p : processosAlocadosAtualmente){
			if(p.getCicloDeInicio() + p.getCiclos() == cicloAtual) {
				for(int j = p.getBitInicio(); j < p.getBitInicio() + p.getTamanho(); j++) {
					posicoes[j] = 0; //liberando o espa�o da mem�ria
				}
				processosFinalizados.add(p);
			}
		}
		//remover da lista de atualmente alocados
		for(Processo p : processosFinalizados) {
			processosAlocadosAtualmente.remove(p);
		}
	}

	public void adicionarEmProcessosAlocados(Processo p) {
		this.processosAlocadosAtualmente.add(p);
	}

	public void adicionarEmProcessosNaoAlocados(Processo p) {
		this.processosNaoAlocados.add(p);
	}

	public void imprimirPosicoes() {
		for(int i = 0; i < posicoes.length; i++) {
			System.out.print(posicoes[i] + " ");
			if(i % 50 == 0 && i != 0) System.out.println("");
		}
		System.out.println("");
	}

	public void imprimirProcessosAlocados() {
		for(Processo p: processosAlocadosAtualmente) {
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
		return processosAlocadosAtualmente;
	}

	public ArrayList<Processo> getProcessosNaoAlocados() {
		return processosNaoAlocados;
	}

}
