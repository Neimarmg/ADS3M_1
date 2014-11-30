public enum Naipe {
	
	COPAS("C"),
	PAUS("P"),
	ESPADA("E"),
	OURO("O");
	
	private String naipe;
	
	private Naipe(String naipe){
		this.naipe = naipe;
	}
	
	public static Naipe converteNaipe(char n) throws Exception{
		
		switch (n){
		case 'C': return COPAS;
		case 'P': return PAUS;
		case 'E': return ESPADA;
		case 'O': return OURO;
		default:
			throw new Exception("Naipe invalido!");
		}
	}
	
	public String toString(){
		return this.naipe;
	}

}