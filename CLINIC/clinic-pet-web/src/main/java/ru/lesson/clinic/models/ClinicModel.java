package ru.lesson.clinic.models;

import ru.lesson.console_clinic.Client;
import ru.lesson.console_clinic.Clinic;
import ru.lesson.console_clinic.UserException;

import java.util.List;

public class ClinicModel {
    //Единственный экземпляр
    public static final ClinicModel CLINIC_MODEL = new ClinicModel();

    //Клиника
    private final Clinic clinic = new Clinic(10);

    public static ClinicModel getInstance() {
        return CLINIC_MODEL;
    }

    //Получить список клиентов
    public List<Client> getClients() {
        return clinic.clients;
    }

    //Добавить клиента
    public void addClient(final Client client) {
        clinic.addClient(client);
    }

    //Найти клиента по имени
    public int findClientPositionByName(final String name) {
        try {
            return clinic.findClientByName(name);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Client getClient(int position) {
        try {
            return clinic.getClient(position);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editClientPet(int position, String newPetName) {
        try {
            this.clinic.getClient(position).getPet().changeName(newPetName);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public void delClient(String clientName) {
        this.clinic.delClient(clientName);
    }
}
