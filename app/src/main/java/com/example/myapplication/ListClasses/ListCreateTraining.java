package com.example.myapplication.ListClasses;

public class ListCreateTraining {

    private  int id;
    private String NewExeName;
    private String NewExeLink;

    public ListCreateTraining(int id, String newExeName, String newExeLink) {
        this.id = id;
        NewExeName = newExeName;
        NewExeLink = newExeLink;
    }

    public String getNewExeName() {
        return NewExeName;
    }

    public void setNewExeName(String newExeName) {
        NewExeName = newExeName;
    }

    public String getNewExeLink() {
        return NewExeLink;
    }

    public void setNewExeLink(String newExeLink) {
        NewExeLink = newExeLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
