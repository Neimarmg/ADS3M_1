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

	
	//==============================<< M�todo testador >>==========================================
	
	/**
	 * M�todo para facilitar testes tempor�rios do programa durante implementa��o 
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
	 * M�todo de incializa��o do programa
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