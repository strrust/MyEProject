package main.java;

import main.java.service.Service;

import java.util.*;

public class Main {

    public static void printMenu()
    {
        System.out.println("\nHello, dear user! Welcome to HRA (Horse Racing Application)!");
        System.out.println("   Menu:");
        System.out.println("1. List all clients");
        System.out.println("2. List all races");
        System.out.println("3. Make bet");
        System.out.println("4. Delete client");
        System.out.println("5. Update client name");
        System.out.print(">");
    }

    public static void main(String[] args) {
        boolean isExit = false;
        int menuPoint;
        Service mainService = new Service();
        Scanner input = new Scanner(System.in);

        while (!isExit)
        {
            printMenu();
            menuPoint = input.nextInt();
            switch (menuPoint)
            {
                case 1:
                    mainService.getAllClients();
                    break;
                case 2:
                    mainService.getAllRaces();
                    break;
                case 3:
                    mainService.makeBet();
                    break;
                case 4:
                    mainService.deleteClient();
                    break;
                case 5:
                    mainService.updateClientName();
                    break;
                default:
                    isExit = true;
                    input.close();
            }
        }
    }
}
