package com.example.myapplication.ListClasses;

public class ListCompetition {

    private  int id;
    private String ClientNameCompet;
    private String ClientSNameCompet;

    public ListCompetition(int id, String clientNameCompet, String clientSNameCompet) {
        this.id = id;
        ClientNameCompet = clientNameCompet;
        ClientSNameCompet = clientSNameCompet;
    }

    public String getClientNameCompet() {
        return ClientNameCompet;
    }

    public void setClientNameCompet(String clientNameCompet) {
        ClientNameCompet = clientNameCompet;
    }

    public String getClientSNameCompet() {
        return ClientSNameCompet;
    }

    public void setClientSNameCompet(String clientSNameCompet) {
        ClientSNameCompet = clientSNameCompet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
