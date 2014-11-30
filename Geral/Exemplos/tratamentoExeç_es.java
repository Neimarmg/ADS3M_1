package ProgsAlgo2;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;
		
public class tratamentoExeções {

	
	public void geraExeception()throws Exception{ 
		//metodo que gera uma exeção		
		throw new Exception("Ops......");	
	}
			
			
	public static void main(String[] args) {
				int avancar;
				int voltar;
				int carregar;
				int descarregar;

		try { //quando gera exeção""
			File t = new File("c:\teste");
			
			//geraExeception();
			
			//throw new Exception("Ops....");forcar um erro
			
		}catch(NullPointerException e){ 
			System.out.print("Null Error");

		}catch (Exception e1) {
			{System.err.print(e1.getMessage());
		}e1.printStackTrace(System.err);
		//--------------------------------------------------
		try{ //qunado nao gera uma exeção sempre executa 
			
			System.exit(0); //nunca executa com exit
			}finally{System.out.print("hall");
				
		}
	}

				}
}
		