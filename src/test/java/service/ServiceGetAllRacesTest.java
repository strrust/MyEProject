package test.java.service;

import main.java.dao.DaoRace;
import main.java.entities.Race;
import main.java.service.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ServiceGetAllRacesTest {
    private Service S = new Service();
    @Test
    public void testGetAllRaces() {
        //S.getAllRaces();
        DaoRace DR = new DaoRace();
        List<Race> resList = DR.getAllEntities();
        Assert.assertNotEquals(resList.size(), 0);
    }
}