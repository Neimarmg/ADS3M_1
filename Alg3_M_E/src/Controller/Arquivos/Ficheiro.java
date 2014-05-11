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
	 * Verificador de memória
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			Prints.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica memória ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo),true);
				Prints.msgb("Novo arquivo criado: " + fw);
				fw.close();
			} else {
				Prints.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			Prints.msgb("Não foi possivél criar um novo arquivo.");
		}		
	}
	

	/** 
	 * Método de remoção de arquivo com verificação da existência do arquivo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) { 
		File file = new File(nomeArquivo); 
		if (file.exists()) { 
			file.delete();
			Prints.msgr("O aquivo " + nomeArquivo + " foi removido com sucesso.");			
		} else {			
			Prints.msgb("Arquivo não encontrado!\nNão é possível remover.");
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