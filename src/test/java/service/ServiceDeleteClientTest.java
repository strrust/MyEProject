package test.java.service;

import main.java.dao.DaoClient;
import main.java.entities.Client;
import main.java.service.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ServiceDeleteClientTest {
    private Service S = new Service();
    @Test
    public void testDeleteClient() {
        //проверка того, что удаляемого клиента в базе нет
        //S.deleteClient();
        DaoClient DC = new DaoClient();
        boolean Check = false;
        Client TC = new Client("TestClient", 999);
        DC.addEntity(TC);
        DaoClient NewDC = new DaoClient();
        List<Client> ClientsList = NewDC.getAllEntities();
        for (Client C: ClientsList)
        {
            if (C.getClientID() == TC.getClientID() && C.getClientName() == TC.getClientName())
            {
                Check = true;
                break;
            }
        }
        DC.deleteEntity(TC);
        Assert.assertTrue(!Check);
    }
}