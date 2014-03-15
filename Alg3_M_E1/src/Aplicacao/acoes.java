package Aplicacao;
import java.io.IOException;
import java.util.Scanner;
import Utilitarios.Formatos;
import Arquivos.Ficheiro;
import Estruturas.ListaOrdenada;

public class acoes {
	String comando;
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	ListaOrdenada r = new ListaOrdenada<>();
	Ficheiro f = new Ficheiro();
	

	public void cadastraInten()throws Exception {	
		i.msgb("OPÇÕES DE COMANDO: \n"	
				+"\t= NOVO\n"
				+"\t= SAIR");
			i.msg("\nComando: ");		
			comando = var.next().toLowerCase();
			
			switch (comando) {
			
			case "novo":					
				String nomeAquivo = "lt.txt"; 
				r.insereRegistro(nomeAquivo);
				break;

			case "sair":
				i.msg("Você saiu do cadastro.");
				break;
			
			default:
				i.msgOpcaoInvalida();
				break;
			}
			
	}	
	
	
	public void informaArquivo() throws Exception {
		i.msgb("OPÇÕES DE COMANDO: \n"	
			+"\t= NOVO\n"
			+"\t= EXISTENTE\n");
		i.msg("\nComando: ");
		comando = var.next();
		f.executaComando(comando);
	}
	
	
	private void SelecionaComandos(String comando) throws Exception {
		
		String c = comando.toLowerCase();
	
		switch (c) {
		
		case "consultar":
			
			break;
			
		case "cadastrar":
			cadastraInten();
			break;
			
		case "imprimir":

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
		i.msg("COMANDO: ");		
		SelecionaComandos(var.next());
	}
}
