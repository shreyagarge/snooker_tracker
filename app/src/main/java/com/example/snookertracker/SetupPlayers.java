package com.example.snookertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetupPlayers extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="com.example.snookertracker.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_players);
    }

    public void updateNames(View view){
        EditText n1 = findViewById(R.id.name_1);
        String name1 = n1.getText().toString();
        EditText n2 = findViewById(R.id.name_2);
        String name2 = n2.getText().toString();
        EditText n3 = findViewById(R.id.name_3);
        String name3 = n3.getText().toString();
        EditText n4 = findViewById(R.id.name_4);
        String name4 = n4.getText().toString();
        String message = name1+"*"+name2+"*"+name3+"*"+name4;
        Intent intent = new Intent(this, scoreBoard.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);




    }
}
