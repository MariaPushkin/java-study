package ru.lesson.clinic;
/*
	Клиника
	дата 14.11.17
*/
public class Clinic {
	public final Client[] clients;
	//текущее количество клиентов
	private int currCol; 
	
	public Clinic(final int size) {
		this.clients = new Client[size];
		this.currCol = 0;
	}
	
	public int getCurrCol() {
		return this.currCol;
	}
	
	/*
		Добавление клиента
	*/
	public void addClient(final int position, final Client client) {
		this.clients[position] = client;
		this.currCol++;
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
				return true;
			}
		return false;
	}

	/*
		Показать клиента с определенной позиции
		дата 15.11.17
	*/
	public Client getClient(int position) {
		if(position >= currCol)
			return null;
		else
			return clients[position];
	}
}

