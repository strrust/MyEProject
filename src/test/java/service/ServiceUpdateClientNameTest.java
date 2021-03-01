package test.java.service;

import main.java.dao.DaoClient;
import main.java.entities.Client;
import main.java.service.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ServiceUpdateClientNameTest {
    private Service S = new Service();
    @Test
    public void testUpdateClientName() {
        //проверка того, что по указанному айди представлено новое имя
        //S.updateClientName();
        DaoClient DC = new DaoClient();
        boolean Check = false;
        Client TC = new Client("TestClient", 999);
        DC.addEntity(TC);
        Client NewTC = new Client("ClientTest", 999);
        DC.updateEntity(NewTC);
        DaoClient NewDC = new DaoClient();
        List<Client> ClientsList = NewDC.getAllEntities();
        for (Client C: ClientsList)
        {
            if (C.getClientID() == 999)
            {
                if (C.getClientName().equals(NewTC.getClientName()))
                {
                    Check = true;
                }
                else
                {
                    break;
                }
            }

        }
        if (Check)
        {
            NewDC.deleteEntity(NewTC);
        }
        else
        {
            NewDC.deleteEntity(TC);
        }
        Assert.assertTrue(Check);
    }
}