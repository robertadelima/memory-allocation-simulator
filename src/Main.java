import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int tamanhoMemoria = 100;
		Memoria memoriaFirstFit = new Memoria(tamanhoMemoria, "First Fit");
		Memoria memoriaBestFit = new Memoria(tamanhoMemoria, "Best Fit");
		Memoria memoriaWorstFit = new Memoria(tamanhoMemoria, "Worst Fit");
		
		ArrayList<Memoria> memorias = new ArrayList<>();
		memorias.add(memoriaFirstFit);
		memorias.add(memoriaBestFit);
		memorias.add(memoriaWorstFit);
		
		int totalCiclos = 100;
		int taxaGeracaoProcessos = 2; //a cada x ciclos, gera um processo novo
		
		int processoId = 0;

		for(int i = 1; i < totalCiclos; i++) {
			System.out.println("-------- CICLO " + i + " --------");
			
			if(i % taxaGeracaoProcessos == 0) { 
				processoId++;
				Processo p = new Processo(processoId, i);
				System.out.print("Processo " + processoId + " criado. ");
				p.imprimir();
				
				for(Memoria memoria : memorias) {
					if(memoria.alocar(p)) {
						memoria.adicionarEmProcessosAlocados(p);
						System.out.println(memoria.getAlgoritmo() + ": Alocado. ");
					}
					else {
						memoria.adicionarEmProcessosNaoAlocados(p);
						System.out.println(memoria.getAlgoritmo() + ": Não Alocado. ");
					}
				}
			}
			for(Memoria memoria : memorias) {
				memoria.atualizaProcessosAlocados(i);
				memoria.imprimirPosicoes();
			}
		}
		
		for(Memoria memoria : memorias) {
			System.out.println("------ Algoritmo " + memoria.getAlgoritmo() + " ------");
			System.out.println("Total de Processos Gerados: " + (processoId));
			System.out.println("Nº Processos Alocados: " + (processoId - memoria.getProcessosNaoAlocados().size()));
			System.out.println("Nº Processos Não Alocados: " + memoria.getProcessosNaoAlocados().size());
			System.out.println("");
		}
	}
	
	
	

	

}
