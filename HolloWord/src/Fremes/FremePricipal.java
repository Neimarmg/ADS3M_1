package Fremes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PKS.Mensagem;

public class FremePricipal extends JFrame implements ActionListener{	
	JTextField userName , senha;
	JButton Entra, Cancela;
	
	Mensagem m = new Mensagem(); 
	Container c = getContentPane();
	public FremePricipal() {
		super("PK");
		
				
		userName = new JTextField();
		userName = new JTextField();
		senha = new JTextField();
		senha = new JTextField();
		
		Entra = new JButton("Entra");
		Entra.addActionListener(this);
		
		Cancela = new JButton("Cancela"); 
		Cancela.addActionListener(this);
		
		c.setLayout(new GridLayout(3,2,1,6));
		c.add(new JLabel("Usúario: "));
		c.add(userName);
		c.add(new JLabel("Senha: "));
		c.add(senha);
		c.add(Entra);
		c.add(Cancela);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,300);	
		setLocation(100, 100);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== Entra){
			String s = "Loguin: " +userName.getText()
					+ "\n Senha: " + new String(senha.getText()); 
			m.msg(s);
			
		}else if(e.getSource()== Cancela){
			userName.setText("");
			senha.setText("");
		}
	}
}

