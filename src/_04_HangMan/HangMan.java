package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	Stack<String> s = new Stack<String>();
	String cword;
	int numLives = 10;
	public static void main(String[] args) {
		new HangMan();
	}
	
	public HangMan()
	{
		String sNum = JOptionPane.showInputDialog("How many words would you like to guess?");
		int num = Integer.parseInt(sNum);
		cword= Utilities.readRandomLineFromFile("dictionary.txt");
		JFrame jf=new JFrame();
		JPanel jp = new JPanel();
		JLabel jl = new JLabel();
		JLabel lives=new JLabel();
		JLabel livesText= new JLabel();
		String hword =  "";
		for(int i = 0; i < cword.length(); i ++) {
		hword=hword+"_";
		}
		jf.add(jp);
		jp.add(jl);
		jp.add(livesText);
		jp.add(lives);
		jl.setText(hword);
		jf.setSize(300, 15);
		livesText.setText("Number of Lives left:");
		lives.setText(""+numLives);
		jf.setVisible(true);
		System.out.println(cword);
		jp.addKeyListener(this);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		char e = event.getKeyChar();
		if(cword.contains(Character.toString(e))) {
			System.out.println("hi");
		}
	}
	
}
