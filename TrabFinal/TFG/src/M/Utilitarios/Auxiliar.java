package M.Utilitarios;

import java.util.Scanner;

/**
 * Classe com métodos globais de apoio à execução do programa
 * @author Neimar, Aurélio
 */
public class Auxiliar {
	
	static Scanner var = new Scanner(System.in);
	static String acumulador; // Acumulardor global de string 
	static int contador = 0; // Variável global contadora de ações
	static String Aux; // Variável global de apoio aos acumuladores
	static boolean abilita = false; // Variável global 
	int posicao; // Variével global de auto incremento e decremento de posições
	
	
	/**
	 * Método acumulador
	 * @param acumular
	 */
	public static void setAcumulador(String acumular) {
		Auxiliar.acumulador += acumular;
	}


	public static String getAcumulador() {
		return acumulador;
	}

	
	/**
	 * Acumula a partir de um parâmetro recebido
	 * @param aux
	 * @param acumular
	 */
	public static void setAux(String aux, boolean acumular) {
		if (acumular == true) {
			Auxiliar.Aux += aux;
		} else {
			Auxiliar.Aux = aux;
		}
	}

	
	public static String getAux() {
		return Aux;
	}
	
	
	/**
	 * @param abilita
	 */
	public static void setAbilita(boolean abilita) {
		Auxiliar.abilita = abilita;
	}
	
	
	public static boolean getAbilita() {
		return abilita;
	}
	
		
	/**
	 * Método global de contagem sequecial
	 * @param contar
	 */
	public static void setContador(boolean contar) {
		if (contar == true) {
			Auxiliar.contador++; // Conta ações em tempo de execução
		} else {
			Auxiliar.contador = 0; // Limpa variável contadora
		}
	}

	
	public static int getContador() {
		return contador;
	}


	/*
	 * Metodo de comando
	 */
	public void setPosicao(int ponterio) {
		this.posicao = ponterio;
	}
		
	
	/**
	 * Metodo de retorno dinâmico com parâmtetros auto incremento
	 *  1 = Incrementa valor de retorno
	 * -1 = Decrementa valor de retorno
	 *  0 = Retorna velor atual
	 *  2 = Incrementa antes de atrubuir valor de retorno
	 * -2 = Decrementa antes de atrubuir valor de retorno
	 * e "0" para manter o estado atual do ponteiro ou 2 para in
	 * @param IncrementarRetorno
	 * @return
	 */
	public int getPosicao(int IncrementarRetorno) {
		if (IncrementarRetorno == -1){
			return posicao--;
			
		} else if (IncrementarRetorno == 1) {
			return posicao++;
		
		} else if (IncrementarRetorno == 2) {
			return ++posicao;
		
		} else if (posicao == -2) {
			return --posicao;
			
		} else { //parâmetro "0"
			return posicao;
		}
			
	}		
	
			
	/**
	 * Método de definição de "status" das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status, int sucesso, int percentual, Boolean MostrarPersentual) {
		String r, s;

		if (sucesso == 7) { // Avaliação de sucesso da atividade
			s = "com sucesso!";
		} else if (sucesso == -1) {
			s = "sem sucesso";
		} else {
			s = "...";
		}
		
		switch (status) { // Definidor de "status" da atividade

		case -1:r = "Pendente " + s;
			break;
		case 0:	r = "Não definido " + s;
			break;
		case 1:	r = "Planejamento " + s;
			break;
		case 2:	r = "Desenvolvimento " + s;
			break;
		case 3:	r = "Testes " + s;
			break;
		case 4:	r = "Revisão " + s;
			break;
		case 5:	r = "Concluído parcialmente " + s;
			break;
		case 6:	r = "Concluído " + s;
			break;
		case 7:	r = "Finalizado " + s;
			break;		
		case 9:	r = "Aguarda atividade " + s;
			break;
		default:
			r = ""; break;
		}
		
		if (MostrarPersentual = true) {
			r += percentual +"% Efetivado";
		}
		
		return r ;
	}


//============================<< Litores de scanner globais >>==========================	

	/**
	 * Método de "Label" dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		V.View.msg("\n");
		if (label.equals("")) {
			V.View.msg("COMANDO: ");
		} else {
			V.View.msg(label +": ");
		}
	}

	
	/**
	 * Valores boleanos
	 * @param label
	 * @return
	 */
	public static int digitaNumero(String label) {
		paleta(label);
		return var.nextInt();
	}

	
	/**
	 * Método de retorno que recebe ficheiro "label" com parâmetro,
	 * retorna uma "string" para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
}