package biblioteca.C;

import M.Obra;
import biblioteca.V.View;
import java.util.ArrayList;

public class CrudObras extends Obra{
		
	static String continuar;
        static Obra obra = new Obra();
	
        static ArrayList<Obra> listaObras = new ArrayList<Obra>();
       

        //------------------------------------------------------------------------
        
    public static void criaObra(){
            
        //recebe informacoes da view e seta nas models
                  
    }
        
        //------------------------------------------------------------------------  
	public static void insere() {
		
		   //insere tudo na classe Obra
	        
           
	        //adiciona a obra na lista     
            
	}
	
	
	public static void exclui() {
                  
		
            listaObras.remove(obra);
            
		View.objetoNaoImplementado();
	}

	
	public static void atualiza() {
		
            
		View.objetoNaoImplementado();
	}
	
	
	public static void imprime() {
		
		View.objetoNaoImplementado();
	}
	
	
	public static void busca() {
		obra.setCod(View.digitaString("Nome"));
	}
	
	
	private static void paramentroInvalido() {
		View.msgcr("Acao invalida!");	
	}
	
	private static void carregaNovaAcao() {
		executaCrudObras(View.digitaString("A��o"));
	}

    //------------------------------------------------------------------------

	public static void executaCrudObras(String acao){
		View.msgcr("Dados cadastrais");
		switch (acao) {
			case "inserir":	
				criaObra();
				continuar =  "nao"; //"View.digitaString("Continuar inserindo");
				if (continuar.equals("sim")){
					executaCrudObras(acao);
				}else{
					carregaNovaAcao();
				}
				break;
				
			case "excluir":	
				exclui();
				break;
				
			case "atualizar":	
				atualiza();
				break;
			
			case "buscar":
				busca();
				break;
				
			case "imprimir":	
				imprime();
				break;
				
			default:
				paramentroInvalido();
				break;
		}
	}
}
