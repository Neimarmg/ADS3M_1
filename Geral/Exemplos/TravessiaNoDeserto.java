
import java.util.Scanner;
public class TravessiaNoDeserto {
	public static void main(String[] args) {
		int carregar,avancar,descarregar,recarregar=0,i,acumCombustivel = 0,recuarAte=0;
		int mapa=0 ,capacidadeTanque=0, combustivelQt=0;
		String conv,convj,b,j;

		Scanner var = new Scanner(System.in);
		System.out.println("\nBEM VINDO AO JOGO TRAVESSIA NO DESERTO.\n"+
		"\n==============================================="+
		"\nDefinindo critérios do jogo"+
		"\nJogo dinâmico ou stático (Conforme o exercício)" +
		"\n===============================================\n");

		System.out.print("Iniciar o jogo modo stático! ou dinâmico!: ");
		j = var.next();
		System.out.println("===============================================");
		convj = j.toUpperCase(); //Conversão do valor da variavél para caracteres mauisculos!

		if (convj.equals("STATICO")){ //modo definido conforme o exercicio solicitado
			b ="AVANCAR";
			System.out.println("===============================================");
			mapa = 10;
			System.out.print("\nPercuso:" +mapa);
			capacidadeTanque = 6;
			System.out.print("\nCapacidade tanque:" +capacidadeTanque);

		}else if(convj.equals("DINAMICO")){ //modo dinamico de jogo com acrécimo do outras funcionalidades
			do{ //Laço de validação de valores paramêtro para definição de jogo

				System.out.println("Informe as definições para jogar.\n");
				if(mapa <= 0){
					System.out.print("Percuso:");
					mapa = var.nextInt();
				}
				if(combustivelQt <= 0){
					System.out.print("Qt Conbustivel:");
					combustivelQt = var.nextInt();
				}
				if(capacidadeTanque <= 0){
					System.out.print("Capacidade tanque:");
					capacidadeTanque = var.nextInt();
				}
				if(mapa <= 0 || combustivelQt <= 0 || capacidadeTanque <= 0 ){
					System.out.print("\nObs.Todos os valores devem ser maior que zero!.\n");
				}
			}while(mapa <= 0 || combustivelQt <= 0 || capacidadeTanque <= 0 );
		}


		System.out.print("\n===============================================");

		int v[] = new int[mapa];

		System.out.print("\nInformações do percuso!\n" +
				"\nCaminho a ser percorrido com "+mapa +" posições\n\n");
		System.out.print("Mapa: ");

		for (i = 0; i < mapa; i++) {//Laço de impressão do caminho a ser percorrido
			v[i]+=0;
			System.out.print("[" +v[i] +"]" +" ");
		}
		System.out.print("\n\n===============================================");

		do{	//Laço de rodagem do logo
			System.out.print("\nAvancar ou sair: ");
			b = var.next();
			conv = b.toUpperCase();
			System.out.println("===============================================");

			if (conv.equals("AVANCAR")){ //Comando de acumulação combustivel

				System.out.print("Carregar: ");
				carregar = var.nextInt();

				System.out.print("Decarregar em: ");
				descarregar =var.nextInt();

				if(convj.equals("DINAMICO")){ //Condição para controle de cobustivel apenas para modo dinâmico.
					acumCombustivel += carregar;
				}
				//Condição para para iniciar o registro de valores no vetor
				if (convj.equals("STATICO") ||(combustivelQt >= acumCombustivel && convj.equals("DINAMICO"))){

					System.out.print("\nRecuar à posisão zero! Sim ou Não: ");//Opção retorno ao inicio
					b = var.next();
					conv = b.toUpperCase();
					//Condição de validação de valores
					if (conv.equals("NAO")||conv.equals("SIM") && (capacidadeTanque>=carregar && mapa > descarregar)){

						for (i = 0; i < mapa; i++) {//laço acumulador de valores!
							if (i != descarregar){
								v[i]+=0;
							}else if (i == descarregar && conv.equals("SIM")){
								v[i]+= carregar - descarregar*2;
							}else if(i == descarregar && conv.equals("NAO")){
								v[i]+= carregar - descarregar;
							}
						}
					}else{
						System.out.print("\n-----------------------------------------------" +
						"\nOpção invalida de de jogo: \n");
						conv = "SAIR";
					}
				}else {
					System.out.print("\n-----------------------------------------------" +
						"\nReserva de combustivel esgota!: \n");
						conv = "SAIR";
					}

			}else{
				System.out.print("\n-----------------------------------------------" +
				"\nOpção invalida de de jogo: \n");
				conv = "SAIR";
			}
		while(conv.equals("NAO")){//Laco de acumulo de valores em primeiro istágio com referecia ao ponto zero

				if (conv.equals("NAO")){
					System.out.print("\nMapa1: "); //Impressão mapa
					for (i = 0; i < mapa; i++) {//LAÇO GERADOR DE VETOR
						v[i]= v[i];
						System.out.print(v[i] +" | ");
					}
						System.out.print("\n==============================================="+
						"\nSeguir ou recuar a outra posisão? Sim! ou Não! : ");
						b = var.next();
						conv = b.toUpperCase();

					if (conv.equals("NAO")||conv.equals("SIM")){
						// definição de condições de navegação dentro dentro do vetor

						if (conv.equals("SIM")){
							System.out.print("Recarregar em: ");
							recarregar = var.nextInt();

							System.out.print("Carregar: ");
							carregar = var.nextInt();

							System.out.print("Decarregar em : ");
							descarregar =var.nextInt();

							if(capacidadeTanque>=carregar && mapa > descarregar){//valição de valores

								for (i = 0; i < mapa; i++) { // Loço acumulador
									if (recarregar < descarregar){
										if (i == recarregar){
											v[i]+= -carregar;
										}
										if(v[i]>0){conv = "NAO";}else{conv = "SIM";}//Condição contimuar
										if(v[i]<0){conv = "SAIR";};	//conição de jogo perdido
									}else {
										if (i == descarregar){
											v[i]+= -carregar;
										}
										if(v[i]>0){conv = "NAO";}else{conv = "SIM";}
										if(v[i]<0){conv = "SAIR";};
									}
								}
								for (i = 0; i < mapa; i++) { // laço acumulador  de recuo
									if (recarregar < descarregar){
										if (i == descarregar){
											v[i]+= carregar - (descarregar - recarregar);
											if(v[i]>0){conv = "NAO";}else{conv = "SIM";}//Condição contimuar
											if(v[i]<0){conv = "SAIR";};
											if(i == 9 && v[i]>=1){conv = "VENCEU";};
										}
									}else
										if (i == recarregar){
										v[i]+= carregar - (recarregar - descarregar);
										if(v[i]>0){conv = "NAO";}else{conv = "SIM";}
										if(v[i]<0){conv = "SAIR";};//conição de jogo perdido
										if(i == 9 && v[i]>=1){conv = "VENCEU";};
									}
								}
							}else{
								System.out.print("\n-----------------------------------------------" +
								"\nOpção invalida de de jogo: \n");
								conv = "SAIR";
							}
						}else{
							System.out.print("\n-----------------------------------------------" +
							"\nOpção invalida de de jogo: \n");
							conv = "SAIR";
						}
					}
				}
			}
			if (convj.equals("DINAMICO")){ // Critério de controle de conbustivel
				System.out.print("\n-----------------------------------------------" +
				"\nCombustivel: " +acumCombustivel);
			}else{
				System.out.print("\n-----------------------------------------------" +
				"\nSem controle de conbústivel");
			}
			System.out.print("\nSituação atual do percuso!"+
			"\nMapaF: ");

			for (i = 0; i < mapa; i++) {//Laço desmostrativo de situação do camimho
				v[i]= v[i];
				System.out.print(v[i] +" | ");
			}

			for (i = 0; i < mapa; i++) {  //Laço impressor de resultados do jogo!
				if (v[i] < 0){
					System.out.println(
					"\n    =================================" +
					"\n    V O C Ê  P E R D E U  O  J O G O!"+
					"\n    =================================");
					conv = "SAIR";

				}else if(i == 9 && v[i]>=1){//avalição de jogo vencido
					System.out.println("\n"+
					"\n    =================================" +
					"\n    P A R A B E N S  V O C Ê  V E N C E U  O  J O G O!"+
					"\n    =================================");
					System.out.print("\n===============================================");
					conv = "SAIR";
				}
			}
			System.out.print("\n===============================================");
		}while(!conv.equals("SAIR") ); // condição sair e enserar jogo
		System.out.print("\n==============================================="  +
		"\nFim de jogo! obrigado!: ");
	}
}

/*	Implementar um jogo , com interce grafica por consule, em java o objetivo do jogo
é fazer com que um caminhão, com tanque de TAM = 6 atrevesse um caminho de 10posições
O jogador vai inserir comandos: AVANCAR,VOLTO,CARREGAR E DESCARREGAR.
avançar e voltar movem o caminha uma posição que e gastam 1 combistivel carregar e descarregar
alteram o combustivel do caminhão e do caminho.
Na posição 0 o combustivel infenito é infinito o jogo termia quando chegar na ultima posição do
caminhp, ou quando acabar o combustivel no meio
do caminho */
