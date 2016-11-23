package C;

/**
 * Classe execu��o da rotas dentro de grafo
 * @author Grupo
 */
import M.Coodenadas;
import V.View;

public class Carregador {
	
	/**
	 * M�todo principal de carregamento de dados do arquivo e convers�o 
	 * para a insers�o na estruturas do grafo.
	 * @param dado
	 * @return
	 */
	public static void carregaDados(String dado) {
		int valor;
		if (!dado.equals("vertices")){
			valor = Integer.parseInt(dado);		
			GrafoControle.criaGrafo(valor, false);
		}	
	}
	
	
	/**
	 * M�todo de coleta dados de origem de destino
	 * @param origem
	 * @param destino
	 */
	public static void coletaCordenadas(int origem, int destino) {
		Coodenadas.setX(origem);
		Coodenadas.setY(destino);
		procuraRotas(false);
		
	}
	
	
	/**
	 * M�todo de busca de rotas
	 */
	public static void procuraRotas(boolean imprimir) {
		View.objetoNaoImplementado();
	
				
	}
	
	/**
	 * M�todo e avali��o de custos em rotas
	 */
	public static void avaliaCustos(boolean imprimir) {
		
		
		
	}
	
	
	/**
	 * meto de de impress�o da rotas encontrado
	 */
	public static void imprimeRota() {
		
		
	}
	
}