package com.myeproject;

public class Client {
    private String ClientName;
    private int ClientID;

    Client(String CN, Integer CID)
    {
        this.ClientID = CID;
        this.ClientName = CN;
    }

    public String getClientName()
    {
        return ClientName;
    }

    public Integer getClientID()
    {
        return ClientID;
    }
}
