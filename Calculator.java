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
		for(Integer param : params) {
			this.result -= param;
		}
	}
	
	//умножение
	public void mult(int ... params) {
		for(Integer param : params) {
			this.result *= param;
		}
	}
		
	//деление
	public void div(int ... params) {
		for(Integer param : params) {
			if(param != 0)
				this.result /= param;
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