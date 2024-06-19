package com.example.myapplication.ListClasses;

public class ListCreateCompetition {

    private  int id;
    private String NewCompetClientName;
    private String NewCompetClienSName;

    public ListCreateCompetition(int id, String newCompetClientName, String newCompetClienSName) {
        this.id = id;
        NewCompetClientName = newCompetClientName;
        NewCompetClienSName = newCompetClienSName;
    }

    public String getNewCompetClientName() {
        return NewCompetClientName;
    }

    public void setNewCompetClientName(String newCompetClientName) {
        NewCompetClientName = newCompetClientName;
    }

    public String getNewCompetClienSName() {
        return NewCompetClienSName;
    }

    public void setNewCompetClienSName(String newCompetClienSName) {
        NewCompetClienSName = newCompetClienSName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
