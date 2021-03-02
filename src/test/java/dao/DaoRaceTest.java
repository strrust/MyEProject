package test.java.dao;

import main.java.dao.DaoRace;
import main.java.entities.Race;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DaoRaceTest {

    @Test
    public void testGetAllEntities() {
        DaoRace DR = new DaoRace();
        List<Race> resList = DR.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }
}