import java.util.*;
import static java.lang.System.out;
public class Sistema{
    public static void main(String[]args){
        double salario;
        String nome;
        
        Scanner sc = new Scanner(System.in);
        nome = sc.nextLine();
        salario = sc.nextDouble();
        
        //out.print("Nome: " +nome +" Saário: " +salario);
        
        vendedor f = new vendedor(nome);
        f.setSalario(salario);
        f.setComissao(2.0);  
        f.setVendasMes(50.0);
        out.println(f.getSalario() +"" +f.getRendimentos());
    }
}
