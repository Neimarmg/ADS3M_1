package Controller;

import java.util.InputMismatchException;

import Controller.Utilitarios.Prints;
import Model.SoldadoModel;
import View.SoldadosView;

public class SoldadoController extends SoldadoModel {
	Prints p = new Prints();
	SoldadosView sv = new SoldadosView();
	
	/**
	 * M�todo insert para editar dados do pessoais do soldado
	 */
	public void insertDados(){
		try {
			setNomeSoldado(p.comando("Nome soldado "));
			setPontuacaoInicial(p.digitaNumero("Pontua��o inicial "));
		} catch (InputMismatchException e) {
			p.msgb("O campo esperava um valor num�rio!\n digite nevamente?");
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
