package biblioteca.C;
import java.util.ArrayList;
import biblioteca.M.Usuario;
import biblioteca.V.View;


public class CrudUsuario<usuario> extends Usuario{
    
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
      
        public Usuario criaUsuario(){
            Usuario usuario= new Usuario(
            View.digitaString("Cod"),
            View.digitaString("Senha"),
            View.digitaString("Email"),
            View.digitaString("Tipo"),
            View.digitaString("Status")
            );  
            return usuario;
        }
        
	public void insere() {
            usuarios.add(criaUsuario()); 
	}
	
	
	public void exclui() {
            busca();
            usuarios.remove(View.digitaNumero("Posição: "));
	}

	
	public void atualiza() {
            busca();  
            usuarios.add(View.digitaNumero("Posição: "), criaUsuario());
	}
	
	
	public void busca() {
            for (int i = 0; i < usuarios.size(); i++) {
                View.msg("Posição: "+i+" "+usuarios.get(i));
            }
	}
	
	
        public static void imprime() {
			}
        
        
	private void paramentroInvalido() {
		View.msgcr("Ação invalida!");	
	}

	
	public void executaCrudUsuario(String acao){
            View.msgcr("Dados cadastrais");
            switch (acao) {
                case "inserir":	
                        insere();
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

