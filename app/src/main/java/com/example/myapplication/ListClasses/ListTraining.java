package com.example.myapplication.ListClasses;

public class ListTraining {
    private  int id;
    private String ExeName;
    private String ExeLink;

    public ListTraining(int id, String exeName, String exeLink) {
        this.id = id;
        ExeName = exeName;
        ExeLink = exeLink;
    }

    public String getExeName() {
        return ExeName;
    }

    public void setExeName(String exeName) {
        ExeName = exeName;
    }

    public String getExeLink() {
        return ExeLink;
    }

    public void setExeLink(String exeLink) {
        ExeLink = exeLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
