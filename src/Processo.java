
public class Processo {
	
	int numero;
	int tamanho; //varia de 10kb at� 50kb
	int ciclos; //ficam na mem�ria de 5 a 10 ciclos
	int bitInicio;
	int cicloDeInicio;
	
	public Processo(int processoNum, int cicloAtual) {
		this.tamanho = (int)(Math.random() * 40) + 10;
		this.ciclos = (int)(Math.random() * 5) + 5;
		this.numero = processoNum;
		this.cicloDeInicio = cicloAtual;
	}
	
	//m�todo que busca o primeiro espa�o vazio contiguo na memoria e aloca
	public boolean firstFit(int[] memoria) {
		boolean encontrouEspaco = false;
		int inicioDoEspaco = 0;
		int espaco = 0;
		int posicao = 0;
		for(int i = 0; i < memoria.length; i++) {
			if(memoria[i] == 0) espaco++; //se encontra um espa�o vazio
			else espaco = 0; //sen�o, quebra a continuidade
				
			if(espaco == this.tamanho) {
				inicioDoEspaco = i - (this.tamanho - 1);
				encontrouEspaco = true;
				posicao = i;
				break;				
			}
		}
		if(encontrouEspaco) {
			for(int j = inicioDoEspaco; j < posicao; j++) {
				memoria[j] = this.numero;
			}
			return true;
		}
		return false;
	}
	
	
	public void imprimir() {
		System.out.println("Tamanho: " + tamanho);
		System.out.println("N� Ciclos: " + ciclos);
	}
	


}
