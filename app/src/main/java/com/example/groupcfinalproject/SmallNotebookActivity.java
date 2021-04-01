package com.example.groupcfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SmallNotebookActivity extends AppCompatActivity {

    Button save, dateBtn;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText inputText, inputNum, date;
    String saveDate;
    TextView sumNum;
    ListView show;
    DatabaseHelper databaseHelper;
    ArrayAdapter budgetArrayAdapter;

    double sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_notebook);

        inputText = (EditText)findViewById(R.id.editTextThing);
        inputNum = (EditText)findViewById(R.id.editTextMoney);
        sumNum = (TextView)findViewById(R.id.sumText);
        date = (EditText)findViewById(R.id.editTextDate);
        show = (ListView)findViewById(R.id.expenses);
        save =(Button)findViewById(R.id.saveBtn);
        //dateBtn = (Button)findViewById(R.id.dateBtn);

        databaseHelper = new DatabaseHelper(SmallNotebookActivity.this);

        showItemsOnListView(databaseHelper);


        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                BudgetModel budgetModel;
                try {
                    budgetModel = new BudgetModel(-1, inputText.getText().toString(), Integer.parseInt(inputNum.getText().toString()));
                    Toast.makeText(SmallNotebookActivity.this, budgetModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(SmallNotebookActivity.this, "Error creating entry!", Toast.LENGTH_SHORT).show();
                    budgetModel = new BudgetModel(-1, "error", 0);
                }

                DatabaseHelper databaseHelper=new DatabaseHelper(SmallNotebookActivity.this);
                boolean success = databaseHelper.addOne(budgetModel);
                Toast.makeText(SmallNotebookActivity.this, "Success= "+success, Toast.LENGTH_SHORT).show();

                showItemsOnListView(databaseHelper);


            }
        });
/*
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Make sure user insert date into edittext in this format.

                Date dateObject;

                try{
                    String dob_var=(date.getText().toString());

                    dateObject = formatter.parse(dob_var);

                    saveDate = new SimpleDateFormat("dd/MM/yyyy").format(dateObject);
                }

                catch (java.text.ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Log.i("E11111111111", e.toString());
                }

                Toast.makeText(SmallNotebookActivity.this, saveDate, Toast.LENGTH_LONG).show();
            }
        });*/
    }

    private void showItemsOnListView(DatabaseHelper databaseHelper2) {
        budgetArrayAdapter = new ArrayAdapter<BudgetModel>(SmallNotebookActivity.this, android.R.layout.simple_list_item_1, databaseHelper2.getEveryone());
        show.setAdapter(budgetArrayAdapter);
    }

    public void goTo_HomeActivity(View view) {
        Intent home_intent = new Intent(this, MainActivity.class);
        startActivity(home_intent);
    }

    public void goTo_BigNotebookActivity(View view) {
        Intent bignotebook_intent = new Intent(this, BigNotebookActivity.class);
        startActivity(bignotebook_intent);
    }


}