package  Controller.Arquivos;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.nio.file.Path;
import model.Utilitarios.Include;
import Aplicacao.Prints;

public class Ficheiro {
	Include in =  new Include();
	Memoria memoria =  new Memoria();

	
	/**
	 * Verificador de mem�ria
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			Prints.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica mem�ria ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo),true);
				Prints.msgb("Novo arquivo criado: " + fw);
				fw.close();
			} else {
				Prints.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			Prints.msgb("N�o foi possiv�l criar um novo arquivo.");
		}		
	}
	

	/** 
	 * M�todo de remo��o de arquivo com verifica��o da exist�ncia do arquivo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) { 
		File file = new File(nomeArquivo); 
		if (file.exists()) { 
			file.delete();
			Prints.msgr("O aquivo " + nomeArquivo + " foi removido com sucesso.");			
		} else {			
			Prints.msgb("Arquivo n�o encontrado!\nN�o � poss�vel remover.");
		}
	} 
	
	
	/**
	 * @param nomeAquivo
	 */
	public static void validadaArquivo(final String nomeAquivo) {
		Path p = Paths.get(nomeAquivo);				
		Prints.msg("Arquivo encontrado: " + p.toFile());
	}
	
}