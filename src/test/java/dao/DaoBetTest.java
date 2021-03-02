package test.java.dao;

import main.java.dao.DaoBet;
import main.java.dao.DaoClient;
import main.java.entities.Bet;
import main.java.entities.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DaoBetTest {

    @Test
    public void testAddEntity() {
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

    @Test
    public void testGetAllEntities() {
        DaoBet DB = new DaoBet();
        List<Bet> resList = DB.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }
}