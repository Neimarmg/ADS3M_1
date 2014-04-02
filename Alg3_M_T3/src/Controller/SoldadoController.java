package Controller;

import Controller.Utilitarios.Prints;
import Model.SoldadoModel;
import View.SoldadosView;

public class SoldadoController extends SoldadoModel {
	Prints p = new Prints();
	SoldadosView sv = new SoldadosView();
	
	
	public void insertDados(){
		setNomeSoldado(p.comando("Nome soldado "));
		setPontuacaoInicial(p.digitaNumero("Pontua��o inicial "));
	}
	
	/**
	 * @param imprimir
	 */
	public void dados(boolean imprimir){
		if (imprimir == true){
			insertDados();
			sv.imprime();
		}else{
			insertDados();
		}	
	}
}
