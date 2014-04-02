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
	private void pesquisa(boolean filtrar, String parametro){
		if (parametro.equals("portaAvioes") && filtrar == true || filtrar == false) {
			nome += "\nPortaAvioes " 
				+NaviosModel.getPortaAvioes()
				+" de " +NaviosModel.getUnidPortaAvioes() +" unidades\n";
		} 
			
		if (parametro.equals("destroyers")&& filtrar == true || filtrar == false) {
			nome += "\nDestroyers " 
				+NaviosModel.getDestroyers()
				+" de " +NaviosModel.getUnidTorpedeiros() +" unidades\n";
		}
			
		if (parametro.equals("fragatas")&& filtrar == true || filtrar == false) {
			nome += "\nFragatas " 
				+NaviosModel.getFragatas()
				+" de " +NaviosModel.getUnidFragatas() +" unidades\n";
		}
				
		if (parametro.equals("torpedeiros")&& filtrar == true || filtrar == false) {
			nome += "\nTorpedeiros " 
				+NaviosModel.getTorpedeiros()
				+" de " +NaviosModel.getUnidTorpedeiros() +" unidades\n";;
		} 
		
		if (parametro.equals("submarinos")&& filtrar == true || filtrar == false) {
			nome += "\nSubmarinos " 
				+NaviosModel.getSubmarinos()
				+" de " +NaviosModel.getUnidSubmarinos() +" unidades\n";
		}	
	}
	
	
	/**
	 * Método de avalição de retorno de parâmetro
	 * @param filtrar
	 * @param parametro
	 */
	private void executa(boolean filtrar, String parametro){
		pesquisa(filtrar, parametro);
		p.msg(nome);
		
		if (filtrar == true && nome.equals(" ")) {
			p.msgb("Não foi encontrado nenhum navio com nome de " +parametro);
		}else{
			pesquisa(filtrar, parametro);			
		}
	}
	
	
	/**
	 * Método de impressão de navios inimigo
	 * @param filtrar
	 */
	public void imprime(boolean filtrar){
		if (filtrar == true) {
			executa(filtrar,p.comando("Nome do navio "));
		}else{
			executa(filtrar, " ");
		}
	}
}