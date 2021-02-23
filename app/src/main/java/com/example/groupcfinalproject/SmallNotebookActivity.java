package com.example.groupcfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SmallNotebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_notebook);
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