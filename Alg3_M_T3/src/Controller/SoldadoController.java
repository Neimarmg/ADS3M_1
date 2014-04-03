package Controller;

import java.util.InputMismatchException;

import Controller.Utilitarios.Prints;
import Model.SoldadoModel;
import View.SoldadosView;

public class SoldadoController extends SoldadoModel {
	SoldadosView sv = new SoldadosView();
	
	/**
	 * M�todo insert para editar dados do pessoais do soldado
	 */
	public void insertDados(){
		try {
			setNomeSoldado(Prints.comando("Nome soldado "));
			setPontuacaoInicial(Prints.digitaNumero("Pontua��o inicial "));
		} catch (InputMismatchException e) {
			Prints.msgb("O campo esperava um valor num�rio!\n digite nevamente?");
			insertDados();
		}
	
	}
	
	/**
	 * @param imprimir
	 * @throws Exception 
	 */
	public void dados(boolean imprimir) throws Exception{
		if (imprimir == true){
			insertDados();
			sv.imprime();
		}else{
			insertDados();
		}	
	}
}
