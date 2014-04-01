package View;
import Controller.Utilitarios.Prints;
import Model.NaviosModel;

public class NaviosView {
	String nome =" ";
	Prints p = new Prints();
	
	/**
	 * Método que encontra um navio espeífico ou lista todos 
	 * dependendo do parêmetro filtrar
	 * @param filtrar
	 * @param parametro
	 */
	private void encontraNavio(boolean filtrar, String parametro){
		if (parametro.equals("portaAvioes") && filtrar == true || filtrar == false) {
			nome = nome +"\nPortaAvioes tamanho " 
				+NaviosModel.getPortaAvioes() +"m "
				+"Qt: " +NaviosModel.getQtPortaAvioes()+"\n";
		} 
			
		if (parametro.equals("destroyers")&& filtrar == true || filtrar == false) {
			nome = nome +"\nDestroyers tamanho " 
				+NaviosModel.getDestroyers() +"m "
				+"Qt: " +NaviosModel.getQtDestroyers()+"\n";
		}
			
		if (parametro.equals("fragatas")&& filtrar == true || filtrar == false) {
			nome = nome +"\nFragatas tamanho " 
				+NaviosModel.getFragatas() +"m "
				+"Qt: " +NaviosModel.getQtFragatas() +"\n";
		}
				
		if (parametro.equals("torpedeiros")&& filtrar == true || filtrar == false) {
			nome = nome +"\nTorpedeiros Tamanho " 
				+NaviosModel.getTorpedeiros()  +"m "
				+"Qt: " +NaviosModel.getQtTorpedeiros()+"\n";;
		} 
		
		if (parametro.equals("submarinos")&& filtrar == true || filtrar == false) {
			nome = nome +"\nSubmarinos tamanho " 
				+NaviosModel.getSubmarinos() +"m "
				+"Qt: " +NaviosModel.getQtSubmarinos()+"\n";;
		}	
	}
	
	
	/**
	 * Método de avalição de retorno de parâmetro
	 * @param filtrar
	 * @param parametro
	 */
	private void avaliaNavios(boolean filtrar, String parametro){
		encontraNavio(filtrar, parametro);
		p.msg(nome);
		
		if (filtrar == true && nome.equals(" ")) {
			p.msgb("Não foi encontrado nenhum navio com nome de " +parametro);
		}else{
			encontraNavio(filtrar, parametro);			
		}
	}
	
	
	/**
	 * Método de impressão de navios inimigo
	 * @param filtrar
	 */
	public void imprimeNavios(boolean filtrar){
		if (filtrar == true) {
			avaliaNavios(filtrar,p.comando("Nome do navio "));
		}else{
			avaliaNavios(filtrar, " ");
		}
	}
}