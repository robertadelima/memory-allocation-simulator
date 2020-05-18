
public class Main {

	public static void main(String[] args) {
		
		int tamMemoria = 1000;
		Memoria memoria = new Memoria(tamMemoria);
		
		int totalCiclos = 1000;
		
		int cicloAtual = 0;
		int processoNum = 0;
		boolean alocacaoBemSucedida = false;

		while(cicloAtual <= totalCiclos) {
			cicloAtual++;
			System.out.println("-------- CICLO " + cicloAtual + " --------");
			
			if(cicloAtual % 6 == 0) { //a cada 6 ciclos, gera um processo novo
				processoNum++;
				Processo p1 = new Processo(processoNum, cicloAtual);
				System.out.println("Processo " + processoNum + " criado!");
				alocacaoBemSucedida = p1.firstFit(memoria);
				if(alocacaoBemSucedida) {
					memoria.adicionarEmProcessosAlocados(p1);
					System.out.print("Alocado. ");
					p1.imprimir();
				}
				else {
					memoria.adicionarEmProcessosNaoAlocados(p1);
					System.out.print("Não Alocado. ");
					p1.imprimir();
				}
			}
			memoria.atualizaProcessosAlocados(cicloAtual);
			memoria.imprimirPosicoes();
		}
	}
	
	
	

	

}
