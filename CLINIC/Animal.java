/*
	Базовый класс для животных
	дата 14.11.17
*/
public class Animal implements Pet {
	private String name;
	//конструктор
	public Animal(final String name) {
		this.name = name;
	}
	
	//подать голос
	@Override
	public void makeSound() {
		System.out.println(String.format("%s say : %s", this.name, "beep"));
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	//Голодный питомец или нет
	private boolean isHungry() {
		//todo добавить алгоритм вычисления состояния
		return true;
	}
	
	@Override
	public boolean isCatDog() {
		return false;
	}	
	
	@Override
	public boolean isDog() {
		return false;
	}	
	
	@Override
	public boolean isCat() {
		return false;
	}	
	
	public void changeName(String newName1, String ... newName2) {
		this.name = newName1;
	}
}



/*
	Потерянный питомец
	дата 14.11.17


public abstract class LostPet {
	//опасен или нет
	public boolean isDanger() {
		return true;
	}
	
	//адрес, где поймали питомца
	abstract String getWhereCatch();
}*/







