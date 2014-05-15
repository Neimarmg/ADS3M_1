package Controller;

import java.util.InputMismatchException;

import Controller.Inimigo;
import Model.MapaMod;
import Model.NiveisMod;
import View.MapaView;
import View.NiveisView;
import Model.Utilitarios.Prints;

/**
 * Classe de execu��o do jogo, bem como controladora de passagens de fase do jogo
 * @author Neimar, Aur�lio
 */
public class Batalha {
	private static int addn = 0;
	int n1=0, n2=0, n3=0,n4=0;
	
	Inimigo inimigo = new Inimigo();
	MapaMod mapaMod = new MapaMod();
	MapaView mapaView =  new MapaView();
	NiveisView naviosView = new NiveisView();
	Estrategia estrategia = new Estrategia();
	
	
	/**
	 * M�todo de inicializa��o do mapaMod na fase 1
	 * @throws Exception
	 */
	public void iniciaMapa() throws Exception {
		addn++;
		MapaMod.setLinha(NiveisMod.getMapanivel1());
		MapaMod.setColuna(NiveisMod.getMapanivel1());
		MapaMod.criaMapa();
		naviosView.executa(true, NiveisMod.getNivel1());
		mapaView.imprime(true,"");
	}
	
	
	/**
	 * M�todo de execu��o a partir da 2� fase do jogo, avan�a para pr�ximo n�vel
	 * @throws Exception
	 */
	protected void pulaFase() throws Exception {			
		
		if (addn == NiveisMod.getNivel2()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel2());
			MapaMod.setColuna(NiveisMod.getMapanivel2());
			MapaMod.criaMapa();
			naviosView.executa(true, NiveisMod.getNivel2());
			mapaView.imprime(true,"");	
		}
		
		
		if (addn == NiveisMod.getNivel3()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel3());
			MapaMod.setColuna(NiveisMod.getMapanivel3());
			MapaMod.criaMapa();
			naviosView.executa(true, NiveisMod.getNivel3());
			mapaView.imprime(true,"");
		}
		
		
		if (addn == NiveisMod.getNivel4()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel4());
			MapaMod.setColuna(NiveisMod.getMapanivel4());
			MapaMod.criaMapa();
			naviosView.executa(true, NiveisMod.getNivel4());
			mapaView.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel5()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel5());
			MapaMod.setColuna(NiveisMod.getMapanivel5());
			MapaMod.criaMapa();
			naviosView.executa(true, NiveisMod.getNivel5());
			mapaView.imprime(true,"");		
		}		
	
	}
	
	
	public static int getAddn() {
		return addn;
	}
	
	
	/**
	 * M�todo de processamento de estrat�gia
	 * @throws Exception
	 */
	protected void executaFase() throws Exception {
		mapaView.setLetra('A');
		pulaFase();
		Estrategia.setNivel(getAddn());
		estrategia.tatica();
	}
	
	
	/**
	 * Imprime mensagem quando o jogador passou de n�vel
	 * @param nroFase
	 * @throws Exception
	 */
	protected void informaVitoria(int nroFase) throws Exception {	
		Prints.msgb("PARAB�NS, VOC� VENCEU A FASE "+addn);
	}
	
	/**
	 * Avalia��o para passagem das fases.
	 * @throws Exception
	 */
	protected void avalia() throws Exception {		
		
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton1()) {			
			if (n1 == 0) {
				n1++;
				informaVitoria(addn);
				addn++;					
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton2()) {			
			if (n2 == 0) {
				n2++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}		
		if (Inimigo.getAcertos() == NiveisMod.getPonton3()) {
			if (n3 == 0) {	
				n3++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton4()) {
			if (n4 == 0) {	
				n4++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton5()) {
			Prints.msge(
				"\n\nPARAB�NS, VOC� VENCEU A FASE 5\n"
				+ "SUPEROU TODOS OS DESAFIOS PROPOSTOS NO JOGO.\n");
		}	
	}
	
	
	/**
	 * Contador de chances que o jogador ainda tem durante o jogo
	 * @throws Exception
	 */
	public void contaFase() throws Exception {
		
		if (Inimigo.getChances()>0) {
			Prints.msg("Chances: " +Inimigo.getChances()+"\nPontua��o: " + Inimigo.getAcertos());
			avalia();	
		} else {
			Prints.msg("\nChances: " + Inimigo.getChances() + "\nPontua��o: " + Inimigo.getAcertos());
			Prints.msge(					
				"\nVOC� PERDEU O JOGO.\n"
				+"Suas chances de jogo foram esgotadas.\n"
				+"Inicie o jogo novamente. \n");				
		}			
	}

	
	/**
	 * M�todo respons�vel pela capta��o da coordenada
	 * @throws Exception
	 */
	public void atira() throws Exception {
		try {
			Prints.msgl();
			inimigo.ValidaAlvo(Prints.digitaNumero("Nro. linha"),
			Prints.digitaNumero("Nro. coluna" ),"O");
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um d�gito como coordenada!");
		}
		contaFase();
	}

}