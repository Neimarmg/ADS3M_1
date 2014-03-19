package Navegacao;

public class Consultas {
	
	/**
	 * 
	 * @param nomeArquivo
	 * @param navega
	 * @param especifica
	 */
	public void	defineBusca(String nomeArquivo,Boolean navega, Boolean especifica){
		if (navega == true){
				
		}else{
			especificaConsulta(nomeArquivo,especifica);
		}

	}	

	
	/**
	 * 
	 * @param nomeArquivo
	 * @param especifica
	 */
	public void especificaConsulta(String nomeArquivo,Boolean especifica){
		if (especifica == true){ //Percorre toda a lista navegando um a um conforme o comando
		
			
		}else{ //Imprime todos os registros
		
		
		}
	}		
}
