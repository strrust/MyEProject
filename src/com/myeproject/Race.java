package com.myeproject;

public class Race {
    private int RaceID;
    private int RaceResult;

    Race (int RID, int RR)
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
