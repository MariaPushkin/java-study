package ru.lesson.clinic.models;

import ru.lesson.console_clinic.Client;
import ru.lesson.console_clinic.Clinic;

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
}
