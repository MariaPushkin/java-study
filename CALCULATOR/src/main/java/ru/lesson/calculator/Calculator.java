package ru.lesson.calculator;

public class Calculator {
	private int result;
	
	//суммирование
	public void add(int ... params) {
		for(Integer param : params) {
			this.result += param;
		}
	}
	
	//вычитание
	public void remove(int ... params) {
		this.result = params[0] - params[1];
	}
	
	//умножение
	public void mult(int ... params) {
		this.result = params[0] * params[1];
	}
		
	//деление
	public void div(int ... params) {
		if (params[1] != 0) {
			this.result = params[0]/params[1];
		}
		else this.result = 0;
	}
	
	//получение результата
	public int getResult() {
		return this.result;
	}
	
	//очищение результата
	public void cleanResult() {
		this.result = 0;
	}
}