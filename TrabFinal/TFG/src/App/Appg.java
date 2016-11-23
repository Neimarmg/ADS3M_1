package App;
import C.Interacao;
import C.Menus;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Dia;
import M.Utilitarios.Informacoes;
import V.View;

/**
 * Classe da app do programa
 * @author Grupo *
 */
public class Appg {
		
	Dia dia = new Dia();	

	
	//==============================<< Método testador >>==========================================
	
	/**
	 * Método para facilitar testes temporários do programa durante implementação 
	 * @throws Exception 
	 */
	private void testaObjetos() throws Exception {		
		//Tests??????
		View.msge("\nSem testes insidos no momento?");
		
	}
	
	//==============================================================================================	
	
			
	private void escreveCabecalho() {
	    View.msgb("			CAIXEIRO VIAJANTE\n\n		     	    GRAFOS");
	}
	
	
	/**
	 * Método de incialização do programa
	 * @throws Exception
	 */
	public void executaPrograma() throws Exception {
		Menus.menuMaim();
		
		switch (Auxiliar.digita("")) {
			
		case "iniciar":
			Interacao.iniciaTarefas();
			break;

		case "info":
			Informacoes.selecionaInfo();
			break;
	
		case "t":
			testaObjetos();			
			break;
						
		case "sair":
			View.sair();
			break;
			
		default:
			View.opcaoInvalida();
			executaPrograma();
			break;
		}		
	}
	
	
	/**
	 * @throws Exception
	 */
	public void run() throws Exception {
		escreveCabecalho();
		Dia.defineSaudacao();
		executaPrograma();
	}
	

	public static void main(String[] args)throws Exception {
		new Appg().run();    
	}
	
}