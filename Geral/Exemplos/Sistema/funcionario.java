
public abstract class funcionario{
        private String nome;
        private double salario;
       
        public funcionario(String nome){
            this.nome = nome;
            this.salario = 00.0;
        }
        
       public funcionario(String nome, double salario){
            this.nome = nome;
            if (this.salario > 0){
                this.salario = salario;
            }else{
                this.salario = salario;
            }
        }
        
        public String getNome(){
            return nome;
        }
        
        public double getSalario(){
            return salario;
        }
        
        public void setSalario(double value){
            if (value > 0 && value > this.salario){
                this.salario = value;
            }
        }
        
        public double getRendimentos(){
            return getSalario();
        }
}

