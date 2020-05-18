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

	public static void main(String[] args) {
		
		int tamMemoria = 200;
		Memoria memoria = new Memoria(tamMemoria);
		
		int totalDeCiclos = 100;
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
					memoria.processosEmMemoria.add(p1);
					System.out.println("Alocado. Tamanho: " + p1.tamanho + ", Ciclos: " + p1.ciclos + ", bit início: " + p1.bitInicio);
				}
				else {
					memoria.processosNaoAlocados.add(p1);
					System.out.println("Não Alocado");
				}
			}
			memoria.atualizaProcessosAlocados(cicloAtual);
			memoria.imprimirPosicoes();
		}
	}
	
	
	

	

}
