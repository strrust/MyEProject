package main.java.dao;

import main.java.entities.Client;

import java.util.*;
import java.sql.*;

public class DaoClient implements Dao<Client> {
    private List<Client> Clients = new ArrayList<Client>();
    public final String DB_URL = "jdbc:sqlserver://MSI\\SQL_EXPRESS:52262;database=HorseRacingDB;integratedSecurity=true;";
    public final String DB_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public DaoClient()
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Clients";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                int CID = resultSet.getInt("ClientID");
                String CN = resultSet.getString("ClientName");
                Client C = new Client(CN, CID);
                Clients.add(C);
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

    public List<Client> getAllEntities()
    {
        return Clients;
    }

    public void addEntity(Client Entity)
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Clients ([ClientID], [ClientName]) VALUES ('" +
                    Entity.getClientID() + "' , '" + Entity.getClientName() + "')";
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

    public void deleteEntity(Client Entity)
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Clients WHERE [ClientID] = " + Entity.getClientID();
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

    public void updateEntity(Client Entity)
    {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Clients SET [ClientName] = '" + Entity.getClientName() +
                    "' WHERE [ClientID] = '" + Entity.getClientID() + "'";
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
}
