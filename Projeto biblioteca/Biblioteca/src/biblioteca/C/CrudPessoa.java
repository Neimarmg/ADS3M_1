package biblioteca.C;
import java.util.ArrayList;
import biblioteca.V.View;
import biblioteca.M.Pessoa;


public class CrudPessoa {
    String continuar;

   ArrayList<Pessoa> pessoa = new ArrayList<>();	 
  
    public Pessoa CriaPessoa() {	
        Pessoa p = new Pessoa(                    
            View.digitaString("Cod"),
            View.digitaString("Nome"),
            View.digitaString("Tipo"),
            View.digitaString("Sexo")		
         );            
        return p;
    }

    @SuppressWarnings("unchecked")
    public void insere() {
            pessoa.add(CriaPessoa());	

    }


    	public void exclui() {
            busca();
            pessoa.remove(View.digitaNumero("Posição: "));
	}

	
	public void atualiza() {
            busca();  
            pessoa.add(View.digitaNumero("Posição: "), CriaPessoa());
	}
	
	
	public void busca() {
            for (int i = 0; i < pessoa.size(); i++) {
                View.msg("Posição: "+i+" "+pessoa.get(i));
            }
	}

    private void paramentroInvalido() {
            View.msgcr("Ação invalida!");	
    }


    private void carregaNovaAcao() {
            executaCrudPessoa(View.digitaString("Ação"));
    }


    public void executaCrudPessoa(String acao){
            View.msgcr("Dados cadastrais");
            switch (acao) {
                    case "inserir":	
                            insere();
                            continuar =  "nao"; //"View.digitaString("Continuar inserindo");
                            if (continuar.equals("sim")){
                                    executaCrudPessoa(acao);
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

                    default:
                            paramentroInvalido();
                            break;
            }
    }
	
}
