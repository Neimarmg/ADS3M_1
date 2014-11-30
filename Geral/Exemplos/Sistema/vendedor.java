public class vendedor extends funcionario {    
    private double comissao, vendasMes;
    
    public vendedor(String nome){
        super(nome,00.0);//quando ha dois metodos na classe o super encontra o construtor com os parametro existentes 
        this.comissao = 00.0;
        this.vendasMes = 00.0;   
    }
    
    public void setComissao(double value){
        if (value >= 0){
            this.comissao = value;
        }    
    }
    
    public void setVendasMes(double value){
        if (value >= 0){
            this.vendasMes = value;
        }    
    }
    
   @Override
     public double getRendimentos(){
         
        double totalComissao = (comissao * vendasMes)/100;
        return totalComissao + super.getRendimentos();
  
    }
}
