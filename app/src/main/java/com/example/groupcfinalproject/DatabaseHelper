package com.example.groupcfinalproject;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String BUDGET_TABLE = "BUDGET_TABLE";
    public static final String COLUMN_BUDGET_NAME = "BUDGET_NAME";
    public static final String COLUMN_BUDGET_AGE = "BUDGET_AGE";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "budget.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + BUDGET_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BUDGET_NAME + " TEXT, " + COLUMN_BUDGET_AGE + " INT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean addOne(BudgetModel budgetModel)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_BUDGET_NAME, budgetModel.getName());
        cv.put(COLUMN_BUDGET_AGE, budgetModel.getAmount());

        long insert = db.insert(BUDGET_TABLE, null, cv);
        if(insert==-1)
            return false;

        return true;
    }

    public boolean deleteOne(BudgetModel budgetModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM "+ BUDGET_TABLE+ "WHERE "+ COLUMN_ID+" = "+ budgetModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
            return true;
        return false;

    }

    public List<BudgetModel> getEveryone()
    {
        List<BudgetModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM "+ BUDGET_TABLE;
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            //loop to rest , creating and insert
            do{
                int budgetID= cursor.getInt(0);
                String budgetName = cursor.getString(1);
                int budgetAmt = cursor.getInt(2);

                BudgetModel newBudget = new BudgetModel(budgetID,budgetName,budgetAmt);
                returnList.add(newBudget);

            }while(cursor.moveToNext());

        }
        else
        {
            //fail, do not do anything
        }
        cursor.close();
        db.close();

        return returnList;
    }
}
