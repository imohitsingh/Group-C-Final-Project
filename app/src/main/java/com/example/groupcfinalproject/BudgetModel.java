package com.example.groupcfinalproject;

public class BudgetModel {
    private int id;
    private String name;
    private int amount;

    //cons


    public BudgetModel(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public BudgetModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BudgetModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
