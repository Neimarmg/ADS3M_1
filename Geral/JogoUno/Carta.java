public class Carta {
	
	private int valor;
	private Naipe naipe;
	
	public Carta(Naipe naipe, int valor) throws Exception{		
		if(!validaValor(valor)){
			throw new Exception("Valor invalido!");
		}
		
		this.naipe = naipe;
		this.valor = valor;
	}
	
	//tem bug no char n = carta.charAt *******
	public Carta(String carta) throws Exception{
		if(carta == null){
			throw new Exception("Descricao de carta invalida!");
		}
		
		char n = carta.charAt(carta.length() - 1);
		String v = carta.substring(0, carta.length() - 1);
		
		this.naipe = Naipe.converteNaipe(n);
		this.valor = converteValor(v);
		
		if(!validaValor(this.valor)){
			throw new Exception("Valor invalido!");
		}		
	}
	
	private static boolean validaValor(int valor) {
		boolean t1 = valor > 0;
		boolean t2 = valor <= 13;
		boolean t3 = t1 && t2;
		return t3;
	}

	private int converteValor(String v) throws Exception{
		switch(v.charAt(0)){
		case 'A': return 1;
		case 'J': return 11;
		case 'Q': return 12;
		case 'K': return 13;
		default: return Integer.parseInt(v);
		}
	}

	public int getValor(){
		return this.valor;
	}
	
	public Naipe getNaipe(){
		return this.naipe;
	}
	
	public boolean equals(Object comp){
		Carta carta;
		
		if(comp instanceof Carta){
			carta = ((Carta) comp);
		}		
		else if(comp instanceof String){
			try{
				carta = new Carta((String)comp);
			}
			catch(Exception e){
				return false;
			}
		}		
		else{
			return false;
		}		
		return valor == carta.valor && naipe == carta.naipe;
	}
	
	public String toString(){
		String result;
		
		switch (this.valor){
		case 1: result = "A"; break;
		case 11: result = "J"; break;
		case 12: result = "Q"; break;
		case 13: result = "K"; break;
		default: result = String.format("%d", this.valor);
		}
		
		return result = result + this.naipe;
	}	
}