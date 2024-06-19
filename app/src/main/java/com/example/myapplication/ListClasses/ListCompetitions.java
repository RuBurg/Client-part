package com.example.myapplication.ListClasses;

import java.time.LocalDate;

public class ListCompetitions {

    private  int id;
    private String CompetName;
    private LocalDate date;

    public ListCompetitions(int id, String competName, LocalDate date) {
        this.id = id;
        CompetName = competName;
        this.date = date;
    }

    public String getCompetName() {
        return CompetName;
    }

    public void setCompetName(String competName) {
        CompetName = competName;
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
