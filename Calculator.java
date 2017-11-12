public class Calculator {
	private int result;
	
	//суммирование
	public void add(int ... params) {
		for(Integer param : params) {
			this.result += param;
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