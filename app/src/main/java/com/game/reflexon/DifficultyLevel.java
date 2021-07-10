package com.game.reflexon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DifficultyLevel extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level2);
        Spinner spinner = (Spinner) findViewById(R.id.levelsSpinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.levels_array, R.layout.my_spinner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {



        // An item was selected. You can retrieve the selected item using
        level= parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void gotoGame(View view) {
        Intent intent = new Intent(getApplicationContext(), gamescreen.class);

        intent.putExtra("key", level);
        startActivity(intent);
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);

    }
}