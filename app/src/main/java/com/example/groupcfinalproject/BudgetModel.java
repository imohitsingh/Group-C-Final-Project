package com.example.groupcfinalproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

    public String getDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        return formattedDate;
    }


    @Override
    public String toString() {
        return name + " - $" + amount + " " + getDate();
    }

}
