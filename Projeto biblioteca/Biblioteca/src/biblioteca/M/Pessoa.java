package biblioteca.M;

public class Pessoa {
	 String codPessoa;
	 String nome;
	 String codTipo;
	 String sexo;

         
        public Pessoa(String codPessoa, String nome, String tipo, String sexo) {
            this.codPessoa = codPessoa;
            this.nome = nome;
            this.codTipo = tipo;
            this.sexo = sexo;
    }


      @Override
       public String toString() {
           return "Pessoa{ codPessoa=" + getCodPessoa() +"Nome=" +getNome()+ "Tipo=" +getCodTipo()+ "Sexo=" +getSexo()+'}';
       }
        
	public String getCodPessoa() {
		return codPessoa;
	}
	
	
	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCodTipo() {
		return codTipo;
	}
	
	
	public void setCodTipo(String codTipo) {
		this.codTipo = codTipo;
	}
	
	
	public String getSexo() {
		return sexo;
	}
	
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}	
}
