/*
package biblioteca.C;
import biblioteca.V.View;

public class gerenciador {
	CrudPessoa pessoa = new CrudPessoa();
        CrudUsuario usuario = new CrudUsuario();
	
	private void crudInvalido() {
		View.msgcr("Opção invalida!");
		carregaCruds(
				View.digitaString("Nome do formulario")
				,View.digitaString("Ação"));
	}
	
	
	public void carregaCruds(String nomeCrud, String acao){
		switch (nomeCrud) {
		case "pessoa":
			
			pessoa.executaCrudPessoa(acao);
			break;
			
		case "obra":
			
			CrudObras.executaCrudObras(acao);
			break;			
			
		case "usuario":	
			
			usuario.executaCrudUsuario(acao);
			//break;	
			
		default:
			crudInvalido();		
			break;
		}
	}
}
*/