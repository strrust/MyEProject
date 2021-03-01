package test.java.service;

import main.java.dao.DaoBet;
import main.java.dao.DaoClient;
import main.java.entities.Bet;
import main.java.entities.Client;
import main.java.service.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ServiceMakeBetTest {
    private Service S = new Service();
    @Test
    public void testMakeBet() {
        //проверка того, что ставка с указанными параметрами есть в бд
        //S.makeBet()
        DaoClient DC = new DaoClient();
        DaoBet DB = new DaoBet();
        int Amount = 1000;
        int RID = 4;
        int Horse = 5;
        boolean Check = false;
        Client TC = new Client("TestClient", 999);
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
}