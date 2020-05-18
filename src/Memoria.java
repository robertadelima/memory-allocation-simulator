import java.util.ArrayList;

public class Memoria {

	int tamanho;
	int[] posicoes;   //array que representa cada posição
	ArrayList<Processo> processosEmMemoria = new ArrayList<>();
	ArrayList<Processo> processosNaoAlocados = new ArrayList<>();
	
	public Memoria(int tamanho) {
		this.tamanho = tamanho;
		this.posicoes = new int[tamanho];
	}
	
	public void atualizaProcessosAlocados(int cicloAtual){
		System.out.println("Entrou aqui!!!");
		Processo p;
		for(int i = 0; i < processosEmMemoria.size(); i++){ //
			System.out.println("FOR");
			p = processosEmMemoria.get(i);
			if(p.cicloDeInicio + p.ciclos == cicloAtual) {
				for(int j = p.bitInicio; j < p.bitInicio + p.tamanho; j++) {
					posicoes[j] = 0; //liberando o espaço da memória
				}
			}
			System.out.println("AtualizaProcessosEmMemoria");
			System.out.println("Memoria: ");
			imprimirPosicoes();
			processosEmMemoria.remove(i);
		}
	}
	
	public void imprimirPosicoes() {
		for(int i = 0; i < posicoes.length; i++) {
			System.out.print(posicoes[i] + " ");
			if(i % 60 == 0 && i != 0) System.out.println("");
		}
		System.out.println("");
	}
	
}
