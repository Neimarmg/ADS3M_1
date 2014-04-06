
package Controller;


import java.util.InputMismatchException;

import Controller.Utilitarios.Prints;
import Controller.Inimigo;
import Model.MapaMod;
import Model.NiveisMod;
import Model.SoldadoMod;
import View.MapaView;
import View.NiveisView;

public class Batalha {
	private static int addn = 1;
	
	Inimigo c = new Inimigo();
	MapaMod m = new MapaMod();
	MapaView mv =  new MapaView();
	NiveisView n = new NiveisView();
	Estrategia e = new Estrategia();
	
	
	/**
	 * M�todo de inicializa��o da mapa do jogo
	 * @throws Exception
	 */
	public void executaMapaInicial() throws Exception{
		addn++;
		MapaMod.setLinha(NiveisMod.getMapanivel1());
		MapaMod.setColuna(NiveisMod.getMapanivel1());
		m.criaMapa();
		n.executa(true, NiveisMod.getNivel1());
		mv.imprime(true,"");
	}
	
	
	/**
	 * M�todo de execu��o partir da 2� fase do jogo
	 * @throws Exception
	 */
	protected void pulaFase() throws Exception{
		
		if (addn == NiveisMod.getNivel2()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel2());
			MapaMod.setColuna(NiveisMod.getMapanivel2());
			m.criaMapa();
			n.executa(true, NiveisMod.getNivel2());
			mv.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel3()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel3());
			MapaMod.setColuna(NiveisMod.getMapanivel3());
			m.criaMapa();
			n.executa(true, NiveisMod.getNivel3());
			mv.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel4()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel4());
			MapaMod.setColuna(NiveisMod.getMapanivel4());
			m.criaMapa();
			n.executa(true, NiveisMod.getNivel4());
			mv.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel5()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel5());
			MapaMod.setColuna(NiveisMod.getMapanivel5());
			m.criaMapa();
			n.executa(true, NiveisMod.getNivel5());
			mv.imprime(true,"");		
		}
		
		addn++;
	}
	
	
	public static int getAddn() {
		return addn;
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	protected void zerarPontuacao() throws Exception{
		Inimigo.setAcertos(0);
		Inimigo.setChances(0);
		mv.setLetra('A');

	}
	
	/**
	 * 
	 * @throws Exception
	 */
	protected void executaFase() throws Exception{
		zerarPontuacao();
		pulaFase();
		Estrategia.setNivel(getAddn());
		e.tatica();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	protected void avaliaFase() throws Exception{		
		Prints.msg("A "+Inimigo.getAcertos()+" p " +NiveisMod.getPonton1()+"\n");
		if (Inimigo.getAcertos() == NiveisMod.getPonton1()) {			
			Prints.msgb("PARABENS VOC� VENCEU A FASE 1");
			executaFase();
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton2()) {			
			Prints.msgb("PARABENS VOC� VENCEU A FASE 2");
			executaFase();
		}		
		if (Inimigo.getAcertos() == NiveisMod.getPonton3()) {
			Prints.msgb("PARABENS VOC� VENCEU A FASE 3");
			executaFase();
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton4()) {
			Prints.msgb("PARABENS VOC� VENCEU A FASE 4");
			executaFase();
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton5()) {
			Prints.msgb(
				"PARABENS VOC� VENCEU A FASE 5\n"
				+"SUPEROU TODOS OS DESAFIOS PROPOSTOS NO JOGO.");
		}	
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void contaChances() throws Exception{
		
		if (Inimigo.getChances() >= SoldadoMod.getPontuacaoInicial()) {
			Prints.msgb(					
				"VOC� PERDEU O JOGO.\n"
				+"Suas chances de jogo foram esgotadas.\n"
				+"Inicie O jogo novamete. ");			
		}else{
			avaliaFase();		
		}			
	}

	
	/**
	 * M�todo responsavel pela capta��o da cordenada.
	 * @throws Exception
	 */
	public void atira() throws Exception{
		try {
			Prints.msgl();
			c.ValidaAlvo(Prints.digitaNumero("Nro linha"),
						 Prints.digitaNumero("Nro coluna" ),"O");
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um d�gito como corden�da!");
		}
		contaChances();
	}



}






