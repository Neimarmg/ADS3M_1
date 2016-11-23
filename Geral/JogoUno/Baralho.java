public class Baralho{
	
	private  Pilha<Carta> cartas;
	
	public Baralho(int valores) throws Exception{
		int numCartas = 4 * valores;
		
		Carta[] c = new Carta[numCartas];
		cartas = new Pilha<Carta> (4 * valores);
		
		char[] naipes =  {'C', 'O', 'E', 'P'};
		int contadorNaipe = 0;
		
		for(char naipeChar : naipes){
			Naipe naipe = Naipe.converteNaipe(naipeChar);
			
			for(int valor = 1; valor < valores; valor ++){
				c[contadorNaipe * valores + (valor - 1)] = new Carta(naipe, valor);
			}
			contadorNaipe ++;
		}
		
		embaralhar(c);
	}

	private void embaralhar(Carta[] cartas) throws PilhaCheia{
		for(int numCartas = cartas.length; numCartas > 0; numCartas --){
			int ndx = (int) (Math.random() * numCartas);
			Carta carta = cartas[ndx];
			this.cartas.push(carta);
			cartas[ndx] = cartas[numCartas - 1];
		}
	}
	
	public Carta compra() throws PilhaVazia{
		return cartas.pop();
	}
	
	
	
}