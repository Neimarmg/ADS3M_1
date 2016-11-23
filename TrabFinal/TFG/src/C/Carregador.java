package C;

/**
 * Classe execução da rotas dentro de grafo
 * @author Grupo
 */
import M.Coodenadas;
import V.View;

public class Carregador {
	
	/**
	 * Método principal de carregamento de dados do arquivo e conversão 
	 * para a insersão na estruturas do grafo.
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
	 * Método de coleta dados de origem de destino
	 * @param origem
	 * @param destino
	 */
	public static void coletaCordenadas(int origem, int destino) {
		Coodenadas.setX(origem);
		Coodenadas.setY(destino);
		procuraRotas(false);
		
	}
	
	
	/**
	 * Método de busca de rotas
	 */
	public static void procuraRotas(boolean imprimir) {
		View.objetoNaoImplementado();
	
				
	}
	
	/**
	 * Método e avalição de custos em rotas
	 */
	public static void avaliaCustos(boolean imprimir) {
		
		
		
	}
	
	
	/**
	 * meto de de impressão da rotas encontrado
	 */
	public static void imprimeRota() {
		
		
	}
	
}