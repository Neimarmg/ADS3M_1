package M;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Classe respons�vel pela defini��o das estruturas para a execu��o de arquivos
 * @author moises
 */
public class Buffers {
	static String linha;
	static FileReader file;
	static BufferedReader buff;	

	public static void setBuff(BufferedReader buff) {
		Buffers.buff = buff;
	}

	public static BufferedReader getBuff() {
		return buff;
	}

	public static void setFile(FileReader file) {
		Buffers.file = file;
	}

	public static FileReader getFile() {
		return file;
	}

	public static void setLinha(String linha) {
		Buffers.linha = linha;
	}

	public static String getLinha() {
		return linha;
	}
}