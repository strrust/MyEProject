package main.java.entities;

public class Bet {
    private int Amount;
    private int Horse;
    private int ClientID;
    private int RaceID;

    public Bet (int A, int H, int CID, int RID)
    {
        this.Amount = A;
        this.Horse = H;
        this.ClientID = CID;
        this.RaceID = RID;
    }

    public int getBetAmount() { return Amount; }

    public int getHorse() { return Horse; }

    public int getClientID() { return ClientID; }

    public int getRaceID() { return RaceID; }
}
