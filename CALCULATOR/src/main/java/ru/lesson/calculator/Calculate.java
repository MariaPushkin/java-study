package ru.lesson.calculator;

public class Calculate {
	public static void main(String[] arg) {
		System.out.println("Calculate...");
		double first = Double.valueOf(arg[0]);
		double second = Double.valueOf(arg[1]);
		double summ = first + second;
		double diff = first - second;
		double comp = first * second;
		double div;
		if (second != 0) 
			div = first / second;
		else div = 0;
		System.out.println("Sum - " + summ);
		System.out.println("Dif - " + diff);
		System.out.println("Comp - " + comp);
		System.out.println("Div - " + div);
	}
}