import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int tamanhoMemoria = 100;
		Memoria memoria = new Memoria(tamanhoMemoria);
		
		int totalCiclos = 100;
		int taxaGeracaoProcessos = 2; //a cada x ciclos, gera um processo novo
		
		/*int escolha = -1;
		Scanner sc = new Scanner(System.in);
		while(1 > escolha || escolha > 3) {
			System.out.println("Qual algoritmo deseja utilizar? 1.FirstFit, 2.BestFit, 3.WorstFit");
			escolha = sc.nextInt();
		}*/
		
		int processoId = 0;

		for(int i = 1; i < totalCiclos; i++) {
			System.out.println("-------- CICLO " + i + " --------");
			
			if(i % taxaGeracaoProcessos == 0) { 
				processoId++;
				Processo p = new Processo(processoId, i);
				System.out.println("Processo " + processoId + " criado!");
				
				if(memoria.bestFit(p)) {
					memoria.adicionarEmProcessosAlocados(p);
					System.out.print("Alocado. ");
					p.imprimir();
				}
				else {
					memoria.adicionarEmProcessosNaoAlocados(p);
					System.out.print("Não Alocado. ");
					p.imprimir();
				}
				
			}
			memoria.atualizaProcessosAlocados(i);
			memoria.imprimirPosicoes();
		}
		System.out.println("Total de Processos Gerados: " + (processoId));
		System.out.println("Nº Processos Alocados: " + (processoId - memoria.getProcessosNaoAlocados().size()));
		System.out.println("Nº Processos Não Alocados: " + memoria.getProcessosNaoAlocados().size());
	}
	
	
	

	

}
