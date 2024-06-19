package com.example.myapplication.ListClasses;

public class ListClients {

    private  int id;
    private String ClientName;
    private String ClientSName;

    public ListClients(int id, String clientName, String clientSName) {
        this.id = id;
        ClientName = clientName;
        ClientSName = clientSName;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientSName() {
        return ClientSName;
    }

    public void setClientSName(String clientSName) {
        ClientSName = clientSName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
