package test.java.service;

import main.java.dao.DaoClient;
import main.java.entities.Client;
import main.java.service.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ServiceGetAllClientsTest {
    private Service S = new Service();
    @Test
    public void testGetAllClients() {
        //S.getAllClients();
        DaoClient DC = new DaoClient();
        List<Client> resList = DC.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }
}