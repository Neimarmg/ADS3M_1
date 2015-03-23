package C;

import M.veiculos;
import V.View;

public class cadastroVeiculos extends scaner {

		
	public static void InsereNome(){		
		try {
			veiculos.setNome(digita("Nome do veículo"));
		
		} catch (NumberFormatException e) {
			View.dadoInvalido();
			InsereNome();
		}	
	}
	
	
	public static void InsereCapacidadeTanque(){
		try {
			veiculos.setCapacidadeTanque(Integer.parseInt(digita("Capacidade do tanque")));
		
		} catch (NumberFormatException e) {
			View.dadoInvalido();
			InsereCapacidadeTanque();
		}		
	}
	
	
	public static void InserePotencia(){
		try {
			veiculos.setPotencia(Float.parseFloat(digita("Potência")));
		
		} catch (NumberFormatException e) {
			View.dadoInvalido();
			InserePotencia();
		}
	}
	
	
	/*Casdstro de todos os intens*/
	public static void cadastraNovo(boolean imprimircadastro){
		
		InsereNome();
		InserePotencia();
		InsereCapacidadeTanque();
		
		if (imprimircadastro == true){
			imprime();
		}
	}

	
	public static void imprime(){
		View.msg("\nVeículo: "+veiculos.getNome()
				+"\nPotencia: "+veiculos.getPotencia()+"CV"
				+"\nCapacidade tanque: "+veiculos.getCapacidadeTanque()+"L");
	}
}
