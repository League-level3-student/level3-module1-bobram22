package _04_HangMan;

import java.util.Stack;

import javax.swing.JOptionPane;

public class HangMan{
		static Stack<String> s = new Stack<String>();
	public static void main(String[] args) {
		String sNum = JOptionPane.showInputDialog("How many words would you like to guess?");
		int num = Integer.parseInt(sNum);
		Utilities.readRandomLineFromFile("dictionary.txt");
		
	}
	
}
