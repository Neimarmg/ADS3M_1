package C;
import M.rotas;
import M.veiculos;
import V.View;
import V.menus;

public class processos {
	
	
	public static void camandoInvalido(){
		View.opcaoInvalida();
		View.msgl();
	}
	
	
	public static void Imprime(String comando){
		View.msgl();
		switch (comando) {
		case "veiculo":
			cadastroVeiculos.imprime();
			View.msgl();
			Imprime(scaner.digita(""));
			break;
		
		case "rota":
			cadastraRotas.imprime();
			View.msgl();
			Imprime(scaner.digita(""));
			break;
		
		case "tudo":
			cadastroVeiculos.imprime();
			cadastraRotas.imprime();
			View.msgl();
			scaner.digita(scaner.digita(""));
			break;

		case "sair":
			View.sair();
			
		default:
			camandoInvalido();
			View.msgl();
			Imprime(scaner.digita("DIGITE NOVAMENTE UM COMANDO")); 
			break;
		}
	}
	
	
	public static void executaPrograma(String comando){
		
		switch (comando) {
		case "cadastrar":
			cadastroVeiculos.cadastraNovo(false);
			cadastraRotas.insereDistancia();
			menus.menuInicial();
			executaPrograma(scaner.digita(""));
			break;
			
		case "calcular":
			calcudador.executaCalculos(veiculos.getPotencia(), rotas.getDistancia(), veiculos.getCapacidadeTanque());		
			break;

		case "imprimir":
			menus.ImprimeDados();
			Imprime(scaner.digita(""));
			break;			
		
		case "sair":
			View.sair();
			break;
		
		default:
			camandoInvalido();	
			executaPrograma(scaner.digita("DIGITE NOVAMENTE UM COMANDO")); 
			break;
		}
	}
}