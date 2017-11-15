package ru.lesson.clinic;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClinicTest {
    @Test
    public void addClient() throws Exception {
        Clinic testClinic = new Clinic(10);
        Client testClient = new Client("Ann",new Cat("Sandy"));
        testClinic.addClient(0,testClient);
        Assert.assertEquals(testClient,testClinic.getClient(0));
    }

    @Test
    public void findClientByPetName() throws Exception {
        Clinic testClinic = new Clinic(10);
        Client testClient1 = new Client("Ann",new Cat("Sandy"));
        Client testClient2 = new Client("Kap",new Cat("Sandy"));
        testClinic.addClient(0,testClient1);
        testClinic.addClient(1,testClient2);
        Client[] foundClients = testClinic.findClientByPetName("Sandy");
        Assert.assertEquals(foundClients[0].getId(),"Ann");
        Assert.assertEquals(foundClients[1].getId(),"Kap");
    }

    @Test
    public void delClient() throws Exception {
        Clinic testClinic = new Clinic(10);
        Client testClient1 = new Client("Ann",new Cat("Sandy"));
        Client testClient2 = new Client("Kap",new Cat("Sandy"));
        testClinic.addClient(0,testClient1);
        testClinic.addClient(1,testClient2);
        Assert.assertTrue(testClinic.delClient("Ann"));
        Assert.assertFalse(testClinic.delClient("Jon"));
    }

}