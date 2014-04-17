package Estruturas;

import Utilitarios.Prints;

public class Ordenadores {
	
	int v[]={1, 2, 3, 8, 4 ,6, 7, 5};
	int aux;
	boolean controle;
	
	public void bubleSort(){
		for (int i = 0; i < v.length; i++) {
			controle = true;
			for (int j = 0; j < v.length-1; j++) {
				if (v[j] > v[j+1]) {
					aux =v[j];
					v[j] =v[j+1];
					v[j+1] = aux;
					controle = false;					
				}		
			}
			if (controle == true) {
				break;
			}
		}
	}	
		
	public  void pritBubleSort(){
		for (int i = 0; i < v.length; i++) {
			Prints.msg("" +v[i] +"\n");
		}
	}
	
	
	public  void quickSort(){
	
	}
	
	/**
	 * Método responsável pela seleção dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {	
		Prints.menuOrdenadores();		
					
		switch (Prints.digita("")) {			
			
		case "buble":		
			
			selecionaOrdenador();
			break;
		
		case "quick":		
		
			selecionaOrdenador();
			break;
	
		case "comparar":		
		
			selecionaOrdenador();
			break;
		case "sair":
			Prints.sair();
			break;
				
		default:
			Prints.opcaoInvalida();
			selecionaOrdenador();
			break;
		}	
	}
}
