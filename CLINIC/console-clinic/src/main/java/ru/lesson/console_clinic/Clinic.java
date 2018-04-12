package ru.lesson.console_clinic;


import java.util.ArrayList;

/*
	Клиника
	дата 14.11.17
*/
public class Clinic {
	public ArrayList<Client> clients;
	
	public Clinic(final int size) {
		this.clients = new ArrayList<Client>(size);
	}
	
	public int getCurrCol() {
		return this.clients.size();
	}
	
	/*
		Добавление клиента
	*/
	public boolean addClient(final Client client)  {
		if(!this.checkClientByName(client.getId())) {
			this.clients.add(client);
			return true;
		}
		return false;
	}
	
	/*
		Нахождение клиента по имени его питомца
	*/
	public Client[] findClientByPetName(final String name) {
		Client[] foundClients = new Client[10];
		int foundCol = 0;
		for(int i = 0; i < this.clients.size(); i++){
			if(name.equals(this.clients.get(i).getPet().getName())) {
				foundClients[foundCol] = this.clients.get(i);
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
		if(this.checkClientByName(name)) {
			for (int i = 0; i < this.clients.size(); i++) {
				if (name.equals(this.clients.get(i).getId())) {
						this.clients.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	/*
		Показать клиента с определенной позиции
		дата 15.11.17
	*/
	public Client getClient(int position) throws UserException {
		if(position >= this.clients.size())
			throw new UserException("No such person exists");
		else
			return clients.get(position);
	}

	/*
		Поиск клиента по имени
		//TODO change with check method
		дата 15.11.17
	*/
	public int findClientByName(final String name) throws UserException{
		for(int i = 0; i < this.clients.size(); i++){
			if(name.equals(this.clients.get(i).getId())) {
				return i;
			}
		}
		throw new UserException("No such person exists");
	}

	public boolean checkClientByName(final String name) {
		for(int i = 0; i < this.clients.size(); i++){
			if(name.equals(this.clients.get(i).getId())) {
				return true;
			}
		}
		return false;
	}

}

