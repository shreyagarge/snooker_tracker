package com.example.snookertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class settingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void submitch(View view) {
        Spinner fspin = findViewById(R.id.fontsz);
        Spinner cspin =  findViewById(R.id.colrval);
        float fs;
        fs = Float.parseFloat(fspin.getSelectedItem().toString());
        String colr = cspin.getSelectedItem().toString();
        Globals g = (Globals)getApplication();
        if(colr.equalsIgnoreCase("RED")) g.setColid(1);
        else if(colr.equalsIgnoreCase("BLUE")) g.setColid(2);
        else if(colr.equalsIgnoreCase("GRAY")) g.setColid(3);
        else g.setColid(0);
//        Globals g = (Globals)getApplication();
//        g.setFontsz(fs);
            CustomTextView.updateFontSize(settingsActivity.this, fs);
            Intent backintent = new Intent(this, SetupPlayers.class);
            startActivity(backintent);


    }

}
