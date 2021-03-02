package test.java.dao;

import main.java.dao.DaoClient;
import main.java.entities.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DaoClientTest {

    @Test
    public void testGetAllEntities() {
        DaoClient DC = new DaoClient();
        List<Client> resList = DC.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }

    @Test
    public void testAddEntity() {
        DaoClient DC = new DaoClient();
        boolean Check = false;
        Client TC = new Client("TestClient", 999);
        DC.addEntity(TC);
        DaoClient NewDC = new DaoClient();
        List<Client> ClientsList = NewDC.getAllEntities();
        for (Client C: ClientsList)
        {
            if (C.getClientID() == 999 && C.getClientName().equals(TC.getClientName()))
            {
                Check = true;
                break;
            }
        }
        if (Check)
        {
            NewDC.deleteEntity(TC);
        }
        Assert.assertTrue(Check);
    }

    @Test
    public void testDeleteEntity() {
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

    @Test
    public void testUpdateEntity() {
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