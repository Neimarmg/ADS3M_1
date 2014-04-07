
package Controller;


import java.util.InputMismatchException;

import Controller.Utilitarios.Prints;
import Controller.Inimigo;
import Model.MapaMod;
import Model.NiveisMod;
import View.MapaView;
import View.NiveisView;

public class Batalha {
	private static int addn = 0;
	int n1=0, n2=0, n3=0,n4=0;
	
	Inimigo c = new Inimigo();
	MapaMod m = new MapaMod();
	MapaView mv =  new MapaView();
	NiveisView n = new NiveisView();
	Estrategia e = new Estrategia();
	
	
	/**
	 * Método de inicialização da mapa do jogo
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
	 * Método de execução partir da 2ª fase do jogo
	 * @throws Exception
	 */
	protected void pulaFase() throws Exception{			
		
		if (addn == NiveisMod.getNivel2()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel2());
			MapaMod.setColuna(NiveisMod.getMapanivel2());
			m.criaMapa();
			//n.executa(false, NiveisMod.getNivel2());
			mv.imprime(true,"");	
		}
		
		
		if (addn == NiveisMod.getNivel3()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel3());
			MapaMod.setColuna(NiveisMod.getMapanivel3());
			m.criaMapa();
			//n.executa(false, NiveisMod.getNivel3());
			mv.imprime(true,"");
		}
		
		
		if (addn == NiveisMod.getNivel4()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel4());
			MapaMod.setColuna(NiveisMod.getMapanivel4());
			m.criaMapa();
			//n.executa(false, NiveisMod.getNivel4());
			mv.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel5()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel5());
			MapaMod.setColuna(NiveisMod.getMapanivel5());
			m.criaMapa();
			//n.executa(true, NiveisMod.getNivel5());
			mv.imprime(true,"");		
		}		
	
	}
	
	
	public static int getAddn() {
		return addn;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	protected void executaFase() throws Exception{
		mv.setLetra('A');
		pulaFase();
		Estrategia.setNivel(getAddn());
		e.tatica();
	}
	
	
	/**
	 * Avaliação para passagem do proximo nivel.
	 * @throws Exception
	 */
	protected void avaliaFase() throws Exception{		
		
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton1()) {			
			Prints.msg("\n n1 " +n1);
			if (n1 == 0){
				n1++;
				addn++;	
				Prints.msgb("PARABENS VOCÊ VENCEU A FASE 1 ");
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton2()) {			
			Prints.msg("n\n1 " +n2);
			if (n2 == 0){
				n2++;
				addn++;	
				Prints.msgb("PARABENS VOCÊ VENCEU A FASE 2 ");
				executaFase();
			}
		}		
		if (Inimigo.getAcertos() == NiveisMod.getPonton3()) {
			Prints.msg("n\n1 " +n3);
			if (n3 == 0){	
				n3++;
				addn++;	
				Prints.msgb("PARABENS VOCÊ VENCEU A FASE 3");
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton4()) {
			Prints.msg("n\n1 " +n4);
			if (n4 == 0){	
				n4++;
				addn++;	
				Prints.msgb("PARABENS VOCÊ VENCEU A FASE 4");
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
	 * Contado da chances de jogo!
	 * @throws Exception
	 */
	public void contaChances() throws Exception{
		
		if (Inimigo.getChances()>0) {
			Prints.msg("Chances: " +Inimigo.getChances()+"\nPontuação: " +Inimigo.getAcertos());
			avaliaFase();	
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
		contaChances();
	}



}






