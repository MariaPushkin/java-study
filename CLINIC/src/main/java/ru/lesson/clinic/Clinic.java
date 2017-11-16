package ru.lesson.clinic;
/*
	Клиника
	дата 14.11.17
*/
public class Clinic {
	public final Client[] clients;
	//текущее количество клиентов
	private int currCol;
	private int maxSize;
	
	public Clinic(final int size) {
		this.clients = new Client[size];
		this.maxSize = size;
		this.currCol = 0;
	}
	
	public int getCurrCol() {
		return this.currCol;
	}
	
	/*
		Добавление клиента
	*/
	public void addClient(final Client client) throws UserException {
		if(currCol == maxSize)
			throw new UserException("Cant add more clients. Max size of clients base achieved");
		else {
			this.clients[currCol] = client;
			this.currCol++;
		}
	}
	
	/*
		Нахождение клиента по имени его питомца
	*/
	public Client[] findClientByPetName(final String name) {
		Client[] foundClients = new Client[10];
		int foundCol = 0;
		for(int i = 0; i < this.currCol; i++){
			if(name.equals(this.clients[i].getPet().getName())) {
				foundClients[foundCol] = clients[i];
				foundCol++;
			}
		}
		Client[] foundClients2 = new Client[foundCol];
		for(int j = 0; j < foundCol; j++)
			foundClients2[j] = foundClients[j];
		return foundClients2;
	}
	
	/*
		Удаление клиента
	*/
	public boolean delClient(String name) {
		for(int i = 0; i < this.currCol; i++) 
			if(name.equals(this.clients[i].getId())) {
				for(int j = i; j < currCol - 1; j++) 
					clients[j] = clients[j + 1];
				currCol--;
				return true;
			}
		return false;
	}

	/*
		Показать клиента с определенной позиции
		дата 15.11.17
	*/
	public Client getClient(int position) throws UserException{
		if(position >= currCol)
			throw new UserException("No such person exists");
		else
			return clients[position];
	}

	/*
		Поиск клиента по имени
		дата 15.11.17
	*/
	public int findClientByName(final String name) throws UserException{
		for(int i = 0; i < this.currCol; i++){
			if(name.equals(this.clients[i].getId())) {
				return i;
			}
		}
		throw new UserException("No such person exists");
	}

	public boolean checkClientByName(final String name) {
		for(int i = 0; i < this.currCol; i++){
			if(name.equals(this.clients[i].getId())) {
				return true;
			}
		}
		return false;
	}
}

