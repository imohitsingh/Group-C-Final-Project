package com.example.groupcfinalproject;



import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BudgetModel{
    private int id;
    private String name;
    private int amount;
    //cons


    public BudgetModel(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public BudgetModel() {
    }


    //toString

    @Override
    public String toString() {
        return name + " ($" + amount + ")";
    }

    // get and set
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

}
