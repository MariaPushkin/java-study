package ru.lesson.calculator;

public class Calculator {
	private int result;

	/**
	 * Сложение
	 * @param params аргументы
	 * @throws UserException если аргументы не переданы
	 */
	public void add(int ... params) throws  UserException{
		if(params.length > 0) {
			for (Integer param : params) {
				this.result += param;
			}
		}
		else {
			throw new UserException("Something wrong with arguments");
		}
	}

	/**
	 * Вычитание
	 * @param params аргументы
	 * @throws UserException если аргументы не переданы, генерируем исключение
	 */
	public void remove(int ... params) throws UserException {
		if(params.length > 0) {
			this.result = params[0] - params[1];
		}
		else {
			throw new UserException("Something wrong with arguments");
		}
	}

	/**
	 * Умножение
	 * @param params аргументы
	 * @throws UserException если аргументы не переданы, генерируем исключение
	 */
	public void mult(int ... params) throws UserException {
		if(params.length > 0) {
			this.result = params[0];
			for (Integer param : params) {
				if (param == params[0]) continue;
				this.result *= param;
			}
			//this.result = params[0] * params[1];
		}
		else {
			throw new UserException("Something wrong with arguments");
		}
	}

	/**
	 * Деление
	 * @param params аргументы
	 * @throws ArithmeticException при делении на ноль
	 * @throws UserException если аргументы не переданы
	 */
	public void div(int ... params) throws ArithmeticException, UserException {
		if(params.length > 0) {
			this.result = params[0];
			for (Integer param : params) {
				if (param == params[0]) continue;
				this.result /= param;
			}
		}
		else {
			throw new UserException("Something wrong with arguments");
		}
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