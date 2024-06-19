package com.example.myapplication.ListClasses;

import java.time.LocalDate;

public class ListMeasure {
        private  int id;
        private LocalDate date;
        private  double weight;
        private  double arm;
        private  double chest;
        private  double waist;
        private  double hip;

    public ListMeasure(int id, LocalDate date, double weight, double arm, double chest, double waist, double hip) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.arm = arm;
        this.chest = chest;
        this.waist = waist;
        this.hip = hip;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
