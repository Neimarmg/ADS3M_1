package Controller;

import java.util.InputMismatchException;

import Model.SoldadoMod;
import View.Utilitarios.Prints;

public class SoldadoCont extends SoldadoMod{

	
	public void editaChances(){
		try{
			setPontuacaoInicial(Prints.digitaNumero("Chances de jogo"));
			if (getPontuacaoInicial() <= 15){
				Prints.msge("\nO Nro de chances deve ser maior doque 15!\n");
				editaChances();
			} 
		 }catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um numero!\n");
		}
	}
		
	
	public void nomeia(){
		setNomeSoldado(Prints.digita("Nome do soldado"));		
		if (getNomeSoldado().equals(" ")){
			Prints.msge("\nO nome não pode estar embranco!\n");
			nomeia();
		}		
	}
	
	
	public void editaDados(){
		nomeia();
		editaChances();
	}
}
