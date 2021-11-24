package brainfuck;

import java.util.ArrayList;
import java.util.Scanner;

public class BrainfuckMain {

	public static void main(String[] args) {
		ArrayList<Character> instructions = new ArrayList<>();
		System.out.println("Enter your brainfuck code below!");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String input = scanner.nextLine();
			if(input.isBlank()) break;
			for(int i = 0;i < input.length();i++) {
				instructions.add(input.charAt(i));
				// This is to help with multi-line coding.
			}
		}
		Brainfuck bf = new Brainfuck(instructions, scanner);
		bf.runCommands(instructions);
		scanner.close();
	}
}