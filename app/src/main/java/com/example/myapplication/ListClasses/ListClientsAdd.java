package com.example.myapplication.ListClasses;

public class ListClientsAdd {

    private  int id;
    private String ClientNameCheck;
    private String ClientSNameCheck;

    public ListClientsAdd(int id, String clientNameCheck, String clientSNameCheck) {
        this.id = id;
        ClientNameCheck = clientNameCheck;
        ClientSNameCheck = clientSNameCheck;
    }

    public String getClientNameCheck() {
        return ClientNameCheck;
    }

    public void setClientNameCheck(String clientNameCheck) {
        ClientNameCheck = clientNameCheck;
    }

    public String getClientSNameCheck() {
        return ClientSNameCheck;
    }

    public void setClientSNameCheck(String clientSNameCheck) {
        ClientSNameCheck = clientSNameCheck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
