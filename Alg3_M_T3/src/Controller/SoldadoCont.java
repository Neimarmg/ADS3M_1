package Controller;

import java.util.InputMismatchException;

import Model.SoldadoMod;
import Model.Utilitarios.Prints;

public class SoldadoCont extends SoldadoMod {

	
	public void editaChances() {
		try {
			setPontuacaoInicial(Prints.digitaNumero("Chances de jogo"));
			if (getPontuacaoInicial() <= 15) {
				Prints.msge("\nO Nro. de chances deve ser maior que 15!\n");
				editaChances();
			} 
		 } catch (InputMismatchException e) {
			 Prints.msge("\nEra esperado um n�mero!\n");
		 }
	}
		
	
	public void nomeia() {
		setNomeSoldado(Prints.digita("Nome do soldado"));		
		if (getNomeSoldado().equals(" ")) {
			Prints.msge("\nO nome n�o pode estar em branco!\n");
			nomeia();
		}		
	}
	
	
	public void editaDados() {
		nomeia();
		editaChances();
	}
	
}