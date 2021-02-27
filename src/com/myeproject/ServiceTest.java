package com.myeproject;

import org.testng.Assert;

import static org.testng.Assert.*;
import java.util.*;

public class ServiceTest {
    private Service S = new Service();

    @org.testng.annotations.Test
    public void testGetAllClients()
    {
        DaoClient DC = new DaoClient();
        List<Client> resList = DC.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }

    @org.testng.annotations.Test
    public void testGetAllRaces()
    {
        DaoRace DR = new DaoRace();
        List<Race> resList = DR.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }

    @org.testng.annotations.Test
    public void testMakeBet() {
        //проверка того, что ставка с указанными параметрами есть в бд
        //S.makeBet
        DaoClient DC = new DaoClient();
        DaoBet DB = new DaoBet();
        String ClientName = "TestClient";
        int Amount = 1000;
        int RID = 4;
        int Horse = 5;
        boolean Check = false;
        Client TC = new Client(ClientName, 999);
        DC.addEntity(TC);
        Bet TB = new Bet(Amount, Horse, TC.getClientID(), RID);
        DB.addEntity(TB);
        DaoBet NewDB = new DaoBet();
        List<Bet> BetsList = NewDB.getAllEntities();
        for (Bet B: BetsList)
        {
            if (B.getRaceID() == TB.getRaceID() && B.getClientID() == TB.getClientID() &&
                    B.getHorse() == TB.getHorse() && B.getBetAmount() == TB.getBetAmount())
            {
                Check = true;
                break;
            }
        }
        DC.deleteEntity(TC);
        Assert.assertTrue(Check);
    }

    @org.testng.annotations.Test
    public void testDeleteClient() {
        //проверка того, что удаляемого клиента в базе нет
        //S.deleteClient();
        DaoClient DC = new DaoClient();
        String ClientName = "TestClient";
        boolean Check = false;
        Client TC = new Client(ClientName, 999);
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

    @org.testng.annotations.Test
    public void testUpdateClientName() {
        //проверка того, что по указанному айди представлено новое имя
        //S.updateClientName();
        DaoClient DC = new DaoClient();
        String ClientName = "TestClient";
        boolean Check = false;
        Client TC = new Client(ClientName, 999);
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