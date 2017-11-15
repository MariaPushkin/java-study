package ru.lesson.calculator;
import java.util.Scanner;


//User unpit for calculatations
public class InteractRunner {
	public static void main(String[] arg) {
		Scanner reader = new Scanner(System.in);
		try {
			Calculator calc = new Calculator();
			String exit = "n";
			while (!exit.equals("y")) {
				System.out.println("What are u going to do?");
				System.out.println("a - add, r - remove, m - multiply, d - divide");
				String action = reader.next();
				System.out.println("Enter argument 1: ");
				String args1 = reader.next();
				System.out.println("Enter argument 2: ");
				String args2 = reader.next();
				switch (action) {
				case "a": 
					calc.add(Integer.valueOf(args1), Integer.valueOf(args2));
					break;
				case "r":
					calc.remove(Integer.valueOf(args1), Integer.valueOf(args2));
					break;
				case "m":
					calc.mult(Integer.valueOf(args1), Integer.valueOf(args2));
					break;
				case "d":
					calc.div(Integer.valueOf(args1), Integer.valueOf(args2));
					break;
				default:
					break;
				}
				System.out.println("Result: " + calc.getResult());
				System.out.println("Exit: y - yes/n - no ");
				exit = reader.next();
				if (exit.equals("n")) {
					System.out.println("Clean result? ");
					System.out.println("Exit: y - yes/n - no ");
					String ans = reader.next();
					if (ans.equals("y"))
						calc.cleanResult();
				}
			}
		}	finally {
				reader.close();
			}
	}
}