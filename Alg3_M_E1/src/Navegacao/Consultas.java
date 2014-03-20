package Navegacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Arquivos.Ficheiro;
import Utilitarios.Formatos;

public class Consultas {
	Formatos i = new Formatos();
	Ficheiro f = new Ficheiro();
	
	/**Método que realiza a navegação entre os registros 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		i.naoImplementado();
	}	

	
	/**
	 * @param nomeArquivo
	 * @param especifica
	 * @throws IOException 
	 */
	public void especifica(String nomeArquivo,String campo) throws IOException {
		try {
			FileReader r = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(r);
			String linha = br.readLine();
			while(linha != null ){
				linha = br.readLine();
				if (linha.equals(campo)){					
					i.msgb("Registro encontrado: " +linha);
				}
			}
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			i.msg("Arquivo inexistente.");
		}
	}
	
	
	public void carrega() {
		try {
			i.menuConsultaArquivo();
					
			switch (i.comando("")) {
			
			case "navegar":
				navega(i.comando("Nome do arquivo"));
				carrega();
				break;

			case "filtrar":				
				especifica(i.comando("Nome do arquivo"),i.comando("Nome do contato"));
				carrega();
				break;
				
			case "todos":
				f.imprime(i.comando("Nome do arquivo"));
				carrega();
				break;
				
			case "sair":
				i.sair();
				break;
			default:
				i.opcaoInvalida();
				carrega();
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}