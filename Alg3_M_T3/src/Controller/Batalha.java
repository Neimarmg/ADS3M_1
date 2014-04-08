
package Controller;


import java.util.InputMismatchException;

import Controller.Inimigo;
import Model.MapaMod;
import Model.NiveisMod;
import View.MapaView;
import View.NiveisView;
import View.Utilitarios.Prints;

/**
 * Classe de execução do jogo e controladora de passagens de fase do jogo
 * @author Neimar,Airélio
 */
public class Batalha {
	private static int addn = 0;
	int n1=0, n2=0, n3=0,n4=0;
	
	Inimigo c = new Inimigo();
	MapaMod m = new MapaMod();
	MapaView mv =  new MapaView();
	NiveisView n = new NiveisView();
	Estrategia e = new Estrategia();
	
	
	/**
	 * Método de inicialização do mapa na fase 1
	 * @throws Exception
	 */
	public void iniciaMapa() throws Exception{
		addn++;
		MapaMod.setLinha(NiveisMod.getMapanivel1());
		MapaMod.setColuna(NiveisMod.getMapanivel1());
		m.criaMapa();
		n.executa(true, NiveisMod.getNivel1());
		mv.imprime(true,"");
	}
	
	
	/**
	 * Método de execução partir da 2ª fase do jogo
	 * @throws Exception
	 */
	protected void pulaFase() throws Exception{			
		
		if (addn == NiveisMod.getNivel2()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel2());
			MapaMod.setColuna(NiveisMod.getMapanivel2());
			m.criaMapa();
			mv.imprime(true,"");	
		}
		
		
		if (addn == NiveisMod.getNivel3()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel3());
			MapaMod.setColuna(NiveisMod.getMapanivel3());
			m.criaMapa();
			mv.imprime(true,"");
		}
		
		
		if (addn == NiveisMod.getNivel4()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel4());
			MapaMod.setColuna(NiveisMod.getMapanivel4());
			m.criaMapa();
			mv.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel5()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel5());
			MapaMod.setColuna(NiveisMod.getMapanivel5());
			m.criaMapa();
			mv.imprime(true,"");		
		}		
	
	}
	
	
	public static int getAddn() {
		return addn;
	}
	
	
	/**
	 * Método de proscessamento do estrategia
	 * @throws Exception
	 */
	protected void executaFase() throws Exception{
		mv.setLetra('A');
		pulaFase();
		Estrategia.setNivel(getAddn());
		e.tatica();
	}
	
	
	/**
	 * Imprime mensagem quando o jogador passou de nivel
	 * @param nroFase
	 * @throws Exception
	 */
	protected void informaVitoria(int nroFase) throws Exception{	
		Prints.msgb("PARABENS VOCÊ VENCEU A FASE "+addn);
	}
	
	/**
	 * Avaliação para passagem das fases.
	 * @throws Exception
	 */
	protected void avalia() throws Exception{		
		
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton1()) {			
			if (n1 == 0){
				n1++;
				informaVitoria(addn);
				addn++;					
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton2()) {			
			if (n2 == 0){
				n2++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}		
		if (Inimigo.getAcertos() == NiveisMod.getPonton3()) {
			if (n3 == 0){	
				n3++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton4()) {
			if (n4 == 0){	
				n4++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton5()) {
			Prints.msge(
				"\n\nPARABENS VOCÊ VENCEU A FASE 5\n"
				+"SUPEROU TODOS OS DESAFIOS PROPOSTOS NO JOGO.\n");
		}	
	}
	
	
	/**
	 * Contado da chances que o jogador aida tem durante o jogo!
	 * @throws Exception
	 */
	public void contaFase() throws Exception{
		
		if (Inimigo.getChances()>0) {
			Prints.msg("Chances: " +Inimigo.getChances()+"\nPontuação: " +Inimigo.getAcertos());
			avalia();	
		}else{
			Prints.msg("\nChances: " +Inimigo.getChances()+"\nPontuação: " +Inimigo.getAcertos());
			Prints.msge(					
				"\nVOCÊ PERDEU O JOGO.\n"
				+"Suas chances de jogo foram esgotadas.\n"
				+"Inicie O jogo novamete. \n");				
		}			
	}

	
	/**
	 * Método responsavel pela captação da cordenada.
	 * @throws Exception
	 */
	public void atira() throws Exception{
		try {
			Prints.msgl();
			c.ValidaAlvo(Prints.digitaNumero("Nro linha"),
						 Prints.digitaNumero("Nro coluna" ),"O");
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um dígito como cordenáda!");
		}
		contaFase();
	}

}






