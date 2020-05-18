import java.util.ArrayList;

/*EXERCÍCIO
Faça um simulador de alocação de memória.
Considere que:
- Sua memória tem 1000 Bytes
- Você tem processos com tamanhos que variam de 
10 a 50 bytes.
- Esses processos ficam na memória de 5 a 10 ciclos
- Novos processos são criados a cada 6 ciclos.
- Um novo processo precisa ocupar uma área contigua, se não houver, o mesmo deve ser descartado.
- Apresente de forma visual a fragmentação externa causada por esse processo a cada ciclo que um processo é alocado, 
indicando o local de alocação do mesmo.
- Cada vez que um processo for alocado deve ser indicado também a quantidade de memória disponível (ainda que não contigua)
- Rode esse programa por 1000 ciclos.
- Ao final indique quantos processos deixaram de ser alocados.*/


public class Main {
	
	static ArrayList<Processo> processosEmMemoria = new ArrayList<>();
	static ArrayList<Processo> processosNaoAlocados = new ArrayList<>();

	public static void main(String[] args) {
		
		int tamMemoria = 1000;
		int[] memoria = new int[tamMemoria]; //array que representa casa posição na memória
		int totalDeCiclos = 30;
		int cicloAtual = 0;
		int processoNum = 0;
		boolean alocacaoBemSucedida = false;

		while(cicloAtual <= totalDeCiclos) {
			cicloAtual++;
			System.out.println("-------- CICLO " + cicloAtual + " --------");
			
			if(cicloAtual % 6 == 0) { //a cada 6 ciclos, gera um processo novo
				processoNum++;
				Processo p1 = new Processo(processoNum, cicloAtual);
				System.out.println("Processo " + processoNum + " criado!");
				alocacaoBemSucedida = p1.firstFit(memoria);
				if(alocacaoBemSucedida) {
					processosEmMemoria.add(p1);
					System.out.println("Alocado. Tamanho: " + p1.tamanho + ", Ciclos: " + p1.ciclos + ", bit início: " + p1.bitInicio);
				}
				else {
					processosNaoAlocados.add(p1);
					System.out.println("Não Alocado");
				}
			}
			imprimirMemoria(memoria);
		}
	}
	
	public static void atualizaProcessosNaMemoria(int cicloAtual, int[] memoria){
		for(Processo p: processosEmMemoria){ //
			if(p.cicloDeInicio + p.ciclos == cicloAtual) {
				for(int i = p.bitInicio; i < p.bitInicio + p.tamanho; i++) {
					memoria[i] = 0; //liberando o espaço da memória
				}
			}
			processosEmMemoria.remove(p);
		}
	}
	
	public static void imprimirMemoria(int[] memoria) {
		for(int i = 0; i < memoria.length; i++) {
			System.out.print(memoria[i] + " ");
		}
		System.out.println("");
	}
	

}
