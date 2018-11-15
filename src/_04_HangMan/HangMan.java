package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HangMan implements KeyListener {
	Stack<String> s = new Stack<String>();
	String cword;
	StringBuilder hword;
	int numLives = 10;
	int numRound;
	int numSWords;
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	JLabel lives = new JLabel();
	JLabel livesText = new JLabel();

	public static void main(String[] args) {
		new HangMan();
	}

	public HangMan() {
		while(numRound<=0) {
			String sNum = JOptionPane.showInputDialog("How many words would you like to guess? (Insert Numbers)");
			try {
				numRound = Integer.parseInt(sNum);
			} catch( Exception e )
			{
			
			}
			if(numRound <= 0)
			{
				JOptionPane.showMessageDialog(null, "Invalid number");
			}
		}
		jf.add(jp);
		jp.add(jl);
		jp.add(livesText);
		jp.add(lives);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.addKeyListener(this);
		jf.setSize(300, 15);
		newGame();

	}

	void newGame() {
		cword = Utilities.readRandomLineFromFile("dictionary.txt");
		hword = new StringBuilder();
		for (int i = 0; i < cword.length(); i++) {
			hword.append("_");
		}
		jl.setText(hword.toString());

		livesText.setText("Number of Lives left:");
		lives.setText("" + numLives);
		System.out.println(cword);

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
		if (cword.contains(Character.toString(e))) {

			for (int i = 0; i < cword.length(); i++) {
				if (cword.charAt(i) == e) {
					System.out.println("kjjhgjjh");
					hword.setCharAt(i, e);
				}

			}
			jl.setText(hword.toString());

		} else {
			numLives--;
			lives.setText("" + numLives);
			if(numLives==0) {
				JOptionPane.showMessageDialog(null, "Game Over");
				System.exit(0);
			}
		}
		if (!hword.toString().contains("_")) {
			if (numRound > numSWords) {

				numSWords++;
				JOptionPane.showMessageDialog(null, "Congrats");
				newGame();
			} else {
				JOptionPane.showMessageDialog(null, "Good job, Play again later :)");
			}
		}
	}

}
