package Aplicacao;
import java.io.IOException;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import Utilitarios.Formatos;
import Arquivos.Ficheiro;
import Estruturas.ListaOrdenada;

public class acoes {
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	ListaOrdenada r = new ListaOrdenada<>();
	Ficheiro f = new Ficheiro();
	
	private void InsereDado() {
		r.insereRegistro(var.next());
	}
	
	
	private void cadastra()throws Exception {
		i.msgl();
		i.msg("\nNome Contato: ");
		InsereDado();
		i.msg("Telefone: ");
		InsereDado();
		i.msgl();
	}	
	
	
	private void informaArquivo() throws IOException {
		String comando,arquivo;
		i.msgb("OPÇÕES DE COMANDO: \n"	
			+"\t= NOVO\n"
			+"\t= EXISTENTE\n");
		i.msg("\nComando: ");
		comando = var.next();
		i.msg("\nNome do aquvixo: ");
		arquivo = var.next();
		f.executaComando(comando,arquivo);
	}
	
	/**
	 * Metodo de seleção de comandos do programa.	
	 * @param comando
	 * @throws Exception 
	 */
	private void SelecionaComandos(String comando) throws Exception {
		
		String c = comando.toLowerCase();
	
		switch (c) {
		
		case "consulta":
			
			break;
			
		case "cadastra":
			cadastra();
			break;
			
		case "imprimi":
			
			break;
		case "arquivo":
			informaArquivo();
			
			break;
			
		default: 
			i.msgOpcaoInvalida();
			ExecutaComandos();
			break;
		}
	}
	
	
	
	public void ExecutaComandos() throws Exception  {	
		i.msg("Comando: ");		
		SelecionaComandos(var.next());
	}
}
