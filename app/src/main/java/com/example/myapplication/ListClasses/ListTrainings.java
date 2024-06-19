package com.example.myapplication.ListClasses;

import java.time.LocalDate;

public class ListTrainings {
    private  int id;
    private String clientName;
    private String clientSName;
    private LocalDate date;

    public ListTrainings(int id, String clientName, String clientSName, LocalDate date) {
        this.id = id;
        this.clientName = clientName;
        this.clientSName = clientSName;
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSName() {
        return clientSName;
    }

    public void setClientSName(String clientSName) {
        this.clientSName = clientSName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
