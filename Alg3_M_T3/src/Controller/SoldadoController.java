
package Controller;
import Model.SoldadoModel;

public class SoldadoController {
	SoldadoModel s = new SoldadoModel();
	private int somaPontos = 0;
	
	public void atira(){
		s.setPontuacaoInicial(false, 0);
	}
	

	public int consome(int perde ){
		
		return perde;
	}
	
	
	public int pontua(int somaAcertos){
		return somaAcertos;

	}
	
	
	public void recua(){
		
	}
	
	
	public void setSomaPontos(int somaPontos) {
		this.somaPontos = somaPontos;
	}

	
	public int getSomaPontos() {
		return somaPontos;
	}	
}
