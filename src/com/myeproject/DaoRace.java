package com.myeproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoRace implements Dao<Race> {
    private List<Race> Races = new ArrayList<Race>();
    public final String DB_URL = "jdbc:sqlserver://MSI\\SQL_EXPRESS:52262;database=HorseRacingDB;integratedSecurity=true;";
    public final String DB_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public DaoRace()
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Races";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                int RID = resultSet.getInt("RaceID");
                int RR = resultSet.getInt("RaceResult");
                Race R = new Race(RID, RR);
                Races.add(R);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC driver not found!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error!");
        }

    }

    public List<Race> getAllEntities()
    {
        return Races;
    }

    public void addEntity(Race Entity) { }

    public void deleteEntity(Race Entity) { }

    public void updateEntity(Race Entity) { }
}
