
public class DefineSaudacao {
	int responde, hora;
	ImprimeMensage m = new ImprimeMensage(); 
	
	public void setResponde(int responde) {
		this.responde = responde;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public void horario(){
		
		if (hora >= 1 && hora<=12)  {
			bomDia();
		}		
		
		if (hora >= 12 && hora<=18)  {
			boaTarde();
		}	
		
		if (hora >= 18 && hora<=24)  {
			boaNoite();
		}	
	}
	
	public void bomDia() {
		m.msg("\n" +"Ola!!! Bom dia!");
	}
	
	public void boaTarde() {
		m.msg("\n" +"Ola!!! Boa tarde!");
	}
	
	public void boaNoite() {
		m.msg("\n" +"Ola!!! Boa noite!");
	}
}
