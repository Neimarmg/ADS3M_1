package C;

import java.util.Scanner;

import V.View;

public class scaner {
	
		static Scanner var = new Scanner(System.in);

		/**
		 * M�todo de "Label" dos comandos do sistema
		 * @param label
		 */
		public static void tituloPaleta(String label) {
			View.msg("\n");
			if (label.equals("")) {
				View.msg("COMANDO: ");
			} else {
				View.msg(label +": ");
			}
		}

		
		/**
		 * Valores boleanos
		 * @param label
		 * @return
		 */
		public static int digitaNumero(String label) {
			tituloPaleta(label);
			return var.nextInt();
		}


		/**
		 * M�todo de retorno que recebe ficheiro "label" com par�metro,
		 * retorna uma "string" para filtros
		 * @param label
		 * @return
		 */
		public static String digita(String label) {
			tituloPaleta(label);
			return var.next().toLowerCase();
		}

}
