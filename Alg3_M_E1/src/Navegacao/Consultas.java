package Navegacao;

import Utilitarios.Formatos;

public class Consultas {
	Formatos f =  new Formatos();
	
	/**
	 * @param nomeArquivo
	 * @param navega
	 * @param especifica
	 */
	public void	define(String nomeArquivo,Boolean navega, Boolean especifica){
		if (navega == true){
				
		}else{
			especifica(nomeArquivo,especifica);
		}

	}	

	
	/**
	 * @param nomeArquivo
	 * @param especifica
	 */
	public void especifica(String nomeArquivo,Boolean especifica){
		if (especifica == true){ //Percorre toda a lista navegando um a um conforme o comando
		
			
		}else{ //Imprime todos os registros
		
		
		}
	}
	
	
	public void carrega(){
		try {
			f.menuConsultaArquivo();
					
			switch (f.comando("COMANDO CONSULTA: ")) {
			
			case "navegar":
				f.naoImplementado();
				carrega();
				break;

			case "filtrar":
				f.naoImplementado();
				carrega();
				break;
				
			case "imprimir":
				f.naoImplementado();
				carrega();
				break;
				
			case "sair":
				f.sair();
				break;
			default:
				f.opcaoInvalida();
				carrega();
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
