package com.myeproject;

import java.util.*;

public class Service {
    Service() {}

    public void getAllClients()
    {
        DaoClient DC = new DaoClient();
        List<Client> resList = DC.getAllEntities();
        for (Client C: resList)
        {
            System.out.println("ClientId: " + C.getClientID() + " Name: " + C.getClientName());
        }
    }

    public void getAllRaces()
    {
        DaoRace DR = new DaoRace();
        List<Race> resList = DR.getAllEntities();
        for (Race R: resList)
        {
            System.out.print("RaceId: " + R.getRaceID());
            System.out.println(" RaceResult: " + (R.getRaceResult() == 0? "Upcoming/cancelled":("Horse number "+ R.getRaceResult()+" won")));
        }
    }

    public void makeBet()
    {
        DaoClient DC = new DaoClient();
        DaoRace DR = new DaoRace();
        DaoBet DB = new DaoBet();
        Scanner input = new Scanner(System.in);
        System.out.print("Print your name: ");
        String ClientName = input.nextLine();
        System.out.print("Print bet amount: ");
        int Amount = input.nextInt();
        System.out.println("Upcoming race list:");
        List<Race> RaceList = DR.getAllEntities();
        List<Integer> AcceptedRaceIDs = new ArrayList<Integer>();
        for (Race R: RaceList)
        {
            if (R.getRaceResult() == 0)
            {
                System.out.print("RaceId: " + R.getRaceID());
                System.out.println(" Upcoming");
                AcceptedRaceIDs.add(R.getRaceID());
            }
        }
        System.out.print("Enter id: ");
        int RID = input.nextInt();
        if (!AcceptedRaceIDs.contains(RID))
        {
            System.out.println("Wrong RaceID!");
            input.close();
            return;
        }
        System.out.print("Enter horse number (1 - 7): ");
        int Horse = input.nextInt();
        if (Horse < 0 || Horse > 7)
        {
            System.out.println("Wrong horse number!");
            input.close();
            return;
        }
        List<Client> ClientList = DC.getAllEntities();
        int AcceptedID = 0;
        boolean IsNewClient = false;
        for (Client C: ClientList)
        {
            if (C.getClientName().equals(ClientName))
            {
                AcceptedID = C.getClientID();
            }
        }
        if (AcceptedID == 0)
        {
            AcceptedID++;
            IsNewClient = true;
            for (Client C: ClientList)
            {
                if (C.getClientID() == AcceptedID)
                {
                    AcceptedID++;
                }
                else
                {
                    break;
                }
            }
        }
        Client TC = new Client(ClientName, AcceptedID);
        if (IsNewClient)
        {
            DC.addEntity(TC);
        }
        Bet TB = new Bet(Amount, Horse, TC.getClientID(), RID);
        DB.addEntity(TB);
        System.out.println("Bet accepted!");
    }

    public void deleteClient()
    {
        DaoClient DC = new DaoClient();
        Scanner input = new Scanner(System.in);
        String ClientName = new String();
        List<Client> ClientList = DC.getAllEntities();
        for (Client C: ClientList)
        {
            System.out.println("ClientId: " + C.getClientID() + " Name: " + C.getClientName());
        }
        System.out.print("Enter client id: ");
        int ClientID = input.nextInt();
        for (Client C: ClientList)
        {
            if (C.getClientID() == ClientID)
            {
                ClientName = C.getClientName();
                break;
            }
        }
        DC.deleteEntity(new Client(ClientName, ClientID));
        System.out.println("Client deleted!");
    }

    public void updateClientName()
    {
        DaoClient DC = new DaoClient();
        Scanner input = new Scanner(System.in);
        List<Client> ClientList = DC.getAllEntities();
        for (Client C: ClientList)
        {
            System.out.println("ClientId: " + C.getClientID() + " Name: " + C.getClientName());
        }
        System.out.print("Enter client id: ");
        int ClientID = input.nextInt();
        System.out.print("Enter new client name: ");
        input.nextLine();
        String newClientName = input.nextLine();
        DC.updateEntity(new Client(newClientName, ClientID));
        System.out.println("Client renamed!");
    }
}
