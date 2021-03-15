package com.example.groupcfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SmallNotebookActivity extends AppCompatActivity {

    Button save;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText inputText, inputNum;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_notebook);

        inputText = (EditText)findViewById(R.id.editTextThing);
        inputNum = (EditText)findViewById(R.id.editTextMoney);
        show = (ListView)findViewById(R.id.expenses);
        save =(Button)findViewById(R.id.saveBtn);
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String getInputText = inputText.getText().toString();
                String getInputNum = inputNum.getText().toString();

                if(getInputText == null || getInputText.trim().equals("") || getInputNum == null || getInputNum.trim().equals("")){
                    Toast.makeText(SmallNotebookActivity.this, R.string.emptyInput, Toast.LENGTH_LONG).show();
                }

                else{
                    addArray.add(getInputText + " - $" + getInputNum);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(SmallNotebookActivity.this, android.R.layout.simple_list_item_1, addArray);
                    show.setAdapter(adapter);

                }
            }
        });
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