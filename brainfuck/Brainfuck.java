package brainfuck;

import java.util.ArrayList;
import java.util.Scanner;

public class Brainfuck {
	char[] cells;
	int pointer, instruction;
	Scanner scanner;
	
	ArrayList<Character> instructions = new ArrayList<>();
	ArrayList<Integer> beginningLoops = new ArrayList<>();
	
	public Brainfuck(ArrayList<Character> commands, Scanner scanner) {
		this.cells = new char[30000];
		this.pointer = 0;
		this.instruction = 0;
		this.scanner = scanner;
	}
	
	public void runCommands(ArrayList<Character> commands) {
		while(instruction < commands.size()) {
			switch(commands.get(this.instruction)) {
			case '>': ++pointer; break;
			case '<': --pointer; break;
			case '+': ++cells[pointer]; break;
			case '-': --cells[pointer]; break;
			case '.': {
				System.out.print(this.cells[this.pointer]);
				break;
			}
			case ',': {
				System.out.print("Input a character: ");
				String input = this.scanner.nextLine();
				cells[pointer] = input.charAt(0);
				System.out.println();
				break;
			}
			case '[': {
				beginningLoops.add(this.instruction);
				break;
			}
			case ']': {
				if(cells[pointer] != 0) {
					while(this.instruction > beginningLoops.get(beginningLoops.size()-1)) --this.instruction;
				} else beginningLoops.remove(beginningLoops.size()-1);
				break;
				}
			}
			++this.instruction;
		}
	}
}
