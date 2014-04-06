package Controller;

import java.util.InputMismatchException;

import Controller.Utilitarios.Prints;
import Model.SoldadoMod;
import View.SoldadosView;

public class SoldadoCont extends SoldadoMod {
	SoldadosView sv = new SoldadosView();
	
	/**
	 * Método insert para editar dados do pessoais do soldado
	 */
	public void AddNovo(){
		try {
			setNomeSoldado(Prints.comando("Nome soldado "));
			setPontuacaoInicial(Prints.digitaNumero("Pontuação inicial "));
		} catch (InputMismatchException e) {
			Prints.msgb("O campo esperava um valor numério!\n digite nevamente?");
			AddNovo();
		}
	
	}
	
	/**
	 * @param imprimir
	 * @throws Exception 
	 */
	public void executa(boolean imprimir) throws Exception{
		if (imprimir == true){
			AddNovo();
			sv.imprime();
		}else{
			AddNovo();
		}	
	}
}
