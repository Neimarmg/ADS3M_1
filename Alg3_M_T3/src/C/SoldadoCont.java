package C;

import java.util.InputMismatchException;

import M.SoldadoMod;
import V.View;

public class SoldadoCont extends SoldadoMod {

	
	public void editaChances() {
		try {
			setPontuacaoInicial(View.digitaNumero("Chances de jogo"));
			if (getPontuacaoInicial() <= 15) {
				View.msge("\nO Nro. de chances deve ser maior que 15!\n");
				editaChances();
			} 
		 } catch (InputMismatchException e) {
			 View.msge("\nEra esperado um n�mero!\n");
		 }
	}
		
	
	public void nomeia() {
		setNomeSoldado(View.digita("Nome do soldado"));		
		if (getNomeSoldado().equals(" ")) {
			View.msge("\nO nome n�o pode estar em branco!\n");
			nomeia();
		}		
	}
	
	
	public void editaDados() {
		nomeia();
		editaChances();
	}
	
}