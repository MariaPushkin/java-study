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
				System.out.println("Enter argument: ");
				String args = reader.next();
				switch (action) {
				case "a": 
					calc.add(Integer.valueOf(args));
					break;
				case "r":
					calc.remove(Integer.valueOf(args));
					break;
				case "m":
					calc.mult(Integer.valueOf(args));
					break;
				case "d":
					calc.div(Integer.valueOf(args));
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