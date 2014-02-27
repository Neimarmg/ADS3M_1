
public class Saudacao {
	String sauda;
	int responde, hora;
	
	
	public void setSauda(String sauda) {
		this.sauda = sauda;
	}
	public void setResponde(int responde) {
		this.responde = responde;
	}
	
	public void mesageSaudacao(String desc){
		System.out.print(desc +"\n");
	}
	
	public void setHora(int hora) {
		this.hora = hora;
	}
	

	public void horario(){
		
		if (hora >= 1 && hora<=12)  {
			bomDia();
		}		
		
		if (hora >= 12 && hora<=18)  {
			//boaTarde();
		}	
		
		if (hora >= 18 && hora<=24)  {
			//boaNoite();
		}	
	}
	
	
	public void comprimenta(){
		switch (responde) {
			
		case 1:
			mesageSaudacao("Bom dia!");
			break;
			
		case 2:
			mesageSaudacao("Tudo bem com você?");
			
			break;

		case 3:
			mesageSaudacao("Tudo?");
			mesageSaudacao("E com você?");
			break;			
		
		}		
	}
	

	public void complementa(){
		switch (responde) {
			
		case 1:
			mesageSaudacao("Bom dia!");
			break;
			
		case 2:
			mesageSaudacao("Tudo bem com você?");
			
			break;

		case 3:
			mesageSaudacao("Tudo?");
			mesageSaudacao("E com você?");
			break;			
		
		}		
	}
	
	

}
