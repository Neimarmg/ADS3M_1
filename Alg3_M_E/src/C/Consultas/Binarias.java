package C.Consultas;

import App.View;
import C.Arquivos.Ficheiro;
import M.Dados;
import M.Utilitarios.Auxiliar;

/**
 * Classe de busca binaria
 * @author moises
 */
public class Binarias {

		int vet[] = new int [Ficheiro.getVetor().length];
		int i, inicio = 0, meio, fim = Ficheiro.getVetor().length;
	    boolean localizador = false;


	    /**
		 * Imprime resultado da busca bin�ria
		 * @param campo
		 */
		private void imprimeBuscaBinaria(int campo) {
			if (localizador == true) {
				View.msgb("RESULTADO DE BUSCA BIN�RIA\n"
					+ "\nRegistro encontrado\n"
					+ "\n\nPosi��o [" + meio + "] " + Dados.vetor[meio]
					+ "\n\nTotal de compara��es:" + Auxiliar.getContador() + "\n");
					Auxiliar.setContador(false); // Limpa vari�vel contadora

			} else {
			   	View.msge("\nN�mero n�o encontrado");
			}
		}


		/**
		 * Realiza busca bin�ria dentro do vetor carregado do arquivo
		 * @param campo
		 */
		private void executaBuscaBinaria(int campo) {
		    i = 0;
		    meio = (inicio + fim) / 2;

		    while (inicio <= fim && localizador == false) {
		    	if (vet[meio] == campo) {
		    		localizador = true;
		    		Auxiliar.setContador(true);
		    	} else {
		    		Auxiliar.setContador(true);
		        	if (campo < vet[meio]) {
		        		fim = meio - 1;
		        		Auxiliar.setContador(true);
		            } else {
		            	inicio = meio + 1;
		            	Auxiliar.setContador(true);
		            }
		        	meio = (inicio + fim) / 2;
		       }
		   }
		}


		/**
		 * M�todo respons�vel pelo carregamento do arquivo
		 * @param nomeArquivo
		 * @param campo
		 * @throws Exception
		 */
		public void carregaBuscaBinaria(String nomeArquivo, int campo) throws Exception {
			Ficheiro.leArquivo(nomeArquivo, true, "", false, false);

			if (campo <= Dados.getVetor().length) {

				for (i = 0; i < Dados.getVetor().length; i++) {
					vet[i] = i;
					View.msg("\nId: " + i +" " + Dados.vetor[i]);
				}

				executaBuscaBinaria(campo);
				imprimeBuscaBinaria(campo);

			} else {
				View.msge("\nId inexistente.");
			}

			Dados.setIndex(0); // Limpa vetor para pr�xima consulta
		}

}