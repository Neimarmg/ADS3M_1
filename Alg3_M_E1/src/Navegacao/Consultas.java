package Navegacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Arquivos.Ficheiro;
import Utilitarios.Prints;

public class Consultas {
	public int contador = 0;
	Ficheiro ficheiro = new Ficheiro();
	private BufferedReader br;
	
	/**
	 * Método que realiza ficheiro navegação entre os registros 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		Prints.objetoNaoImplementado();
	}	

	
	/**
	 * @param nomeArquivo
	 * @param especifica
	 * @throws IOException 
	 */
	public void especifica(String nomeArquivo,String campo) throws IOException {
		try {
			FileReader r = new FileReader(nomeArquivo);
			br = new BufferedReader(r);
			String linha = br.readLine();
			Prints.msgb("Registro(pressagios) encontrado(pressagios):");
			while(linha != null ){
				linha = br.readLine();
				if (linha.equals(campo)){	
					Prints.msg("> " +linha +"\n");
					contador++;
				}
			}
			
			
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
	}
	
	
	public void carrega() {
		try {
			Prints.menuConsultaArquivo();
					
			switch (Prints.digita("")) {
			
			case "navegar":
				navega(Prints.digita("Nome do arquivo"));
				carrega();
				break;

			case "filtrar":				
				especifica(Prints.digita("Nome do arquivo"),Prints.digita("Contato"));
				carrega();
				break;
				
			case "todos":
				ficheiro.imprime(Prints.digita("Nome do arquivo"));
				carrega();
				break;
				
			case "sair":
				Prints.sair();
				break;
			default:
				Prints.opcaoInvalida();
				carrega();
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Realiza busaca bunária dentro do arquivo
	 * @param nomeArquivo
	 * @param campo
	 * @throws IOException
	 */
	public void buscaBinaria(String nomeArquivo,String campo) throws IOException {
		
		
		
		
		
	}
}