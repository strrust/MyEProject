package main.java.entities;

public class Race {
    private int RaceID;
    private int RaceResult;

    public Race (int RID, int RR)
    {
        this.RaceResult = RR;
        this.RaceID = RID;
    }

    public int getRaceID() {
        return RaceID;
    }

    public int getRaceResult() {
        return RaceResult;
    }

}
