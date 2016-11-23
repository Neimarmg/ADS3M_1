import static java.lang.System.*;
import java.io.IOException;
import java.io.Console;
public class Login {
	public static void main(String[] args)throws IOException {
		
		Console c = console();
		
		
		if (c == null ){err.print("Sem Consule"); }
		out.print("User name");
		String userrName = new String(c.readLine());
		
		out.print("Password");
		String password = new String(c.readPassword());
		
		out.print("User:" +userrName);
		out.print("Senha:" +password);


	}

}
