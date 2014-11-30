
import java.util.Scanner;
public class TravessiaNoDeserto {
	public static void main(String[] args) {
		int carregar,avancar,descarregar,recarregar=0,i,acumCombustivel = 0,recuarAte=0;
		int mapa=0 ,capacidadeTanque=0, combustivelQt=0;
		String conv,convj,b,j;

		Scanner var = new Scanner(System.in);
		System.out.println("\nBEM VINDO AO JOGO TRAVESSIA NO DESERTO.\n"+
		"\n==============================================="+
		"\nDefinindo crit�rios do jogo"+
		"\nJogo din�mico ou st�tico (Conforme o exerc�cio)" +
		"\n===============================================\n");

		System.out.print("Iniciar o jogo modo st�tico! ou din�mico!: ");
		j = var.next();
		System.out.println("===============================================");
		convj = j.toUpperCase(); //Convers�o do valor da variav�l para caracteres mauisculos!

		if (convj.equals("STATICO")){ //modo definido conforme o exercicio solicitado
			b ="AVANCAR";
			System.out.println("===============================================");
			mapa = 10;
			System.out.print("\nPercuso:" +mapa);
			capacidadeTanque = 6;
			System.out.print("\nCapacidade tanque:" +capacidadeTanque);

		}else if(convj.equals("DINAMICO")){ //modo dinamico de jogo com acr�cimo do outras funcionalidades
			do{ //La�o de valida��o de valores param�tro para defini��o de jogo

				System.out.println("Informe as defini��es para jogar.\n");
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

		System.out.print("\nInforma��es do percuso!\n" +
				"\nCaminho a ser percorrido com "+mapa +" posi��es\n\n");
		System.out.print("Mapa: ");

		for (i = 0; i < mapa; i++) {//La�o de impress�o do caminho a ser percorrido
			v[i]+=0;
			System.out.print("[" +v[i] +"]" +" ");
		}
		System.out.print("\n\n===============================================");

		do{	//La�o de rodagem do logo
			System.out.print("\nAvancar ou sair: ");
			b = var.next();
			conv = b.toUpperCase();
			System.out.println("===============================================");

			if (conv.equals("AVANCAR")){ //Comando de acumula��o combustivel

				System.out.print("Carregar: ");
				carregar = var.nextInt();

				System.out.print("Decarregar em: ");
				descarregar =var.nextInt();

				if(convj.equals("DINAMICO")){ //Condi��o para controle de cobustivel apenas para modo din�mico.
					acumCombustivel += carregar;
				}
				//Condi��o para para iniciar o registro de valores no vetor
				if (convj.equals("STATICO") ||(combustivelQt >= acumCombustivel && convj.equals("DINAMICO"))){

					System.out.print("\nRecuar � posis�o zero! Sim ou N�o: ");//Op��o retorno ao inicio
					b = var.next();
					conv = b.toUpperCase();
					//Condi��o de valida��o de valores
					if (conv.equals("NAO")||conv.equals("SIM") && (capacidadeTanque>=carregar && mapa > descarregar)){

						for (i = 0; i < mapa; i++) {//la�o acumulador de valores!
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
						"\nOp��o invalida de de jogo: \n");
						conv = "SAIR";
					}
				}else {
					System.out.print("\n-----------------------------------------------" +
						"\nReserva de combustivel esgota!: \n");
						conv = "SAIR";
					}

			}else{
				System.out.print("\n-----------------------------------------------" +
				"\nOp��o invalida de de jogo: \n");
				conv = "SAIR";
			}
		while(conv.equals("NAO")){//Laco de acumulo de valores em primeiro ist�gio com referecia ao ponto zero

				if (conv.equals("NAO")){
					System.out.print("\nMapa1: "); //Impress�o mapa
					for (i = 0; i < mapa; i++) {//LA�O GERADOR DE VETOR
						v[i]= v[i];
						System.out.print(v[i] +" | ");
					}
						System.out.print("\n==============================================="+
						"\nSeguir ou recuar a outra posis�o? Sim! ou N�o! : ");
						b = var.next();
						conv = b.toUpperCase();

					if (conv.equals("NAO")||conv.equals("SIM")){
						// defini��o de condi��es de navega��o dentro dentro do vetor

						if (conv.equals("SIM")){
							System.out.print("Recarregar em: ");
							recarregar = var.nextInt();

							System.out.print("Carregar: ");
							carregar = var.nextInt();

							System.out.print("Decarregar em : ");
							descarregar =var.nextInt();

							if(capacidadeTanque>=carregar && mapa > descarregar){//vali��o de valores

								for (i = 0; i < mapa; i++) { // Lo�o acumulador
									if (recarregar < descarregar){
										if (i == recarregar){
											v[i]+= -carregar;
										}
										if(v[i]>0){conv = "NAO";}else{conv = "SIM";}//Condi��o contimuar
										if(v[i]<0){conv = "SAIR";};	//coni��o de jogo perdido
									}else {
										if (i == descarregar){
											v[i]+= -carregar;
										}
										if(v[i]>0){conv = "NAO";}else{conv = "SIM";}
										if(v[i]<0){conv = "SAIR";};
									}
								}
								for (i = 0; i < mapa; i++) { // la�o acumulador  de recuo
									if (recarregar < descarregar){
										if (i == descarregar){
											v[i]+= carregar - (descarregar - recarregar);
											if(v[i]>0){conv = "NAO";}else{conv = "SIM";}//Condi��o contimuar
											if(v[i]<0){conv = "SAIR";};
											if(i == 9 && v[i]>=1){conv = "VENCEU";};
										}
									}else
										if (i == recarregar){
										v[i]+= carregar - (recarregar - descarregar);
										if(v[i]>0){conv = "NAO";}else{conv = "SIM";}
										if(v[i]<0){conv = "SAIR";};//coni��o de jogo perdido
										if(i == 9 && v[i]>=1){conv = "VENCEU";};
									}
								}
							}else{
								System.out.print("\n-----------------------------------------------" +
								"\nOp��o invalida de de jogo: \n");
								conv = "SAIR";
							}
						}else{
							System.out.print("\n-----------------------------------------------" +
							"\nOp��o invalida de de jogo: \n");
							conv = "SAIR";
						}
					}
				}
			}
			if (convj.equals("DINAMICO")){ // Crit�rio de controle de conbustivel
				System.out.print("\n-----------------------------------------------" +
				"\nCombustivel: " +acumCombustivel);
			}else{
				System.out.print("\n-----------------------------------------------" +
				"\nSem controle de conb�stivel");
			}
			System.out.print("\nSitua��o atual do percuso!"+
			"\nMapaF: ");

			for (i = 0; i < mapa; i++) {//La�o desmostrativo de situa��o do camimho
				v[i]= v[i];
				System.out.print(v[i] +" | ");
			}

			for (i = 0; i < mapa; i++) {  //La�o impressor de resultados do jogo!
				if (v[i] < 0){
					System.out.println(
					"\n    =================================" +
					"\n    V O C �  P E R D E U  O  J O G O!"+
					"\n    =================================");
					conv = "SAIR";

				}else if(i == 9 && v[i]>=1){//avali��o de jogo vencido
					System.out.println("\n"+
					"\n    =================================" +
					"\n    P A R A B E N S  V O C �  V E N C E U  O  J O G O!"+
					"\n    =================================");
					System.out.print("\n===============================================");
					conv = "SAIR";
				}
			}
			System.out.print("\n===============================================");
		}while(!conv.equals("SAIR") ); // condi��o sair e enserar jogo
		System.out.print("\n==============================================="  +
		"\nFim de jogo! obrigado!: ");
	}
}

/*	Implementar um jogo , com interce grafica por consule, em java o objetivo do jogo
� fazer com que um caminh�o, com tanque de TAM = 6 atrevesse um caminho de 10posi��es
O jogador vai inserir comandos: AVANCAR,VOLTO,CARREGAR E DESCARREGAR.
avan�ar e voltar movem o caminha uma posi��o que e gastam 1 combistivel carregar e descarregar
alteram o combustivel do caminh�o e do caminho.
Na posi��o 0 o combustivel infenito � infinito o jogo termia quando chegar na ultima posi��o do
caminhp, ou quando acabar o combustivel no meio
do caminho */
