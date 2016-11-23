package M;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Classe responsável pela definição das estruturas para a execução de arquivos
 * @author Neimar
 */
public class Buffers {
	
	private static String linha;
	private static FileReader file;
	private static BufferedReader buff;	
	private static Boolean append = false;
	
    
    public static String getLinha() {
		return linha;
	}
	
    
    public static void setLinha(String linha) {
		Buffers.linha = linha;
	}
	
    
    public static FileReader getFile() {
		return file;
	}
	
    
    public static void setFile(FileReader file) {
		Buffers.file = file;
	}
	
    
    public static BufferedReader getBuff() {
		return buff;
	}
	
    
    public static void setBuff(BufferedReader buff) {
		Buffers.buff = buff;
	}
	
    
    public static Boolean getAppend() {
		return append;
	}
	
    
    public static void setAppend(Boolean append) {
		Buffers.append = append;
	}
    
}