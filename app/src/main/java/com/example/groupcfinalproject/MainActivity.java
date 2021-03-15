package com.example.groupcfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTo_SmallNotebookActivity(View view) {
        Intent smallnotebook_intent = new Intent(this, SmallNotebookActivity.class);
        startActivity(smallnotebook_intent);
    }

    public void goTo_BigNotebookActivity(View view) {
        Intent bignotebook_intent = new Intent(this, BigNotebookActivity.class);
        startActivity(bignotebook_intent);
    }

    public void goTo_SettingsActivity(View view) {
        Intent settings_intent = new Intent(this,Settings.class);
        startActivity(settings_intent);
    }
}