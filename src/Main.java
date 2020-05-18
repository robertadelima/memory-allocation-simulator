
public class Main {

	public static void main(String[] args) {
		
		int tamanhoMemoria = 100;
		Memoria memoria = new Memoria(tamanhoMemoria);
		
		int totalCiclos = 100;
		int taxaDeGeracaoDeProcessos = 2; //a cada x ciclos, gera um processo novo
		
		int processoNum = 0;

		for(int i = 1; i < totalCiclos; i++) {
			System.out.println("-------- CICLO " + i + " --------");
			
			if(i % taxaDeGeracaoDeProcessos == 0) { 
				processoNum++;
				Processo p = new Processo(processoNum, i);
				System.out.println("Processo " + processoNum + " criado!");
				
				if(memoria.firstFit(p)) {
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
		System.out.println("Total de Processos Gerados: " + (memoria.getQtdProcessosAlocados() + memoria.getQtdProcessosNaoAlocados()));
		System.out.println("Nº Processos Alocados: " + memoria.getQtdProcessosAlocados());
		System.out.println("Nº Processos Não Alocados: " + memoria.getQtdProcessosNaoAlocados());
	}
	
	
	

	

}
