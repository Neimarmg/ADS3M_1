package Controller;

import Model.SoldadoMod;
import View.Utilitarios.Prints;

public class SoldadoCont extends SoldadoMod{

	
	public void editaChances(){
		 
		setPontuacaoInicial(Prints.digitaNumero("Chances de jogo"));
		
		if (getPontuacaoInicial()<= 0){
			Prints.msge("\nO Nro de chances deve ser mair doque zero!\n");
			editaChances();
		}
	}
		
	public void nomeia(){
		
		setNomeSoldado(Prints.digita("Nome do soldado"));
		
		if (getNomeSoldado().equals(" ")){
			Prints.msge("\nO nome não pode estar embranco!\n");
			nomeia();;
		}	
	}
	
	public void editaDados(){
		nomeia();
		editaChances();
	}
}
