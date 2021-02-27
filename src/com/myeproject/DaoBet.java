package com.myeproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoBet implements Dao<Bet> {
    private List<Bet> Bets = new ArrayList<Bet>();
    public final String DB_URL = "jdbc:sqlserver://MSI\\SQL_EXPRESS:52262;database=HorseRacingDB;integratedSecurity=true;";
    public final String DB_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public DaoBet()
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Bets";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                int Amount = resultSet.getInt("Amount");
                int Horse = resultSet.getInt("Horse");
                int ClientID = resultSet.getInt("ClientID");
                int RaceID = resultSet.getInt("RaceID");
                Bet B = new Bet(Amount, Horse, ClientID, RaceID);
                Bets.add(B);
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

    public void addEntity(Bet Entity)
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Bets ([Amount], [Horse], [ClientID], [RaceID]) VALUES ('" +
                    Entity.getBetAmount() + "' , '" + Entity.getHorse() + "' , '" +
                    Entity.getClientID() + "' , '" + Entity.getRaceID() + "')";
            statement.executeUpdate(sql);
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

    public List<Bet> getAllEntities()
    {
        return Bets;
    }
    public void deleteEntity(Bet Entity) {}
    public void updateEntity(Bet Entity) {}
}
