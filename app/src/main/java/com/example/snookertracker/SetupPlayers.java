package com.example.snookertracker;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetupPlayers extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.snookertracker.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_players);
        ConstraintLayout lay = findViewById(R.id.clay1);


         Globals g = (Globals)getApplication();
         int data=g.getColid();

         if(data==1) {
             lay.setBackgroundColor(Color.parseColor("#eec4d7"));
             lay.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#eec4d7")));

         }
         else if(data==2) {
             lay.setBackgroundColor(Color.CYAN);
             lay.setBackgroundTintList(ColorStateList.valueOf(Color.CYAN));

         }
         else if(data==3) {
             lay.setBackgroundColor(Color.LTGRAY);
             lay.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));

         }
//

//        TextView tv2 = findViewById(R.id.textView2);
//        tv2.setTextSize(data);
//        TextView tv3 = findViewById(R.id.textView3);
//        tv3.setTextSize(data);
//        TextView tv4 = findViewById(R.id.textView4);
//        tv4.setTextSize(data);
//        TextView tv5 = findViewById(R.id.textView5);
//        tv5.setTextSize(data);
//        TextView tv6 = findViewById(R.id.textView6);
//        tv6.setTextSize(data);
//        TextView tv7 = findViewById(R.id.textView8);
//        tv7.setTextSize(data);


    }


    public void updateNames(View view) {
        String name1 = "a";
        String name2 = "b";
        String name3 = "c";
        String name4 = "d";
        try {
            EditText n1 = findViewById(R.id.name_1);
            name1 = n1.getText().toString();
            EditText n2 = findViewById(R.id.name_2);
            name2 = n2.getText().toString();
            EditText n3 = findViewById(R.id.name_3);
            name3 = n3.getText().toString();
            EditText n4 = findViewById(R.id.name_4);
            name4 = n4.getText().toString();
            String message = name1 + "*" + name2 + "*" + name3 + "*" + name4;
            Intent intent = new Intent(this, scoreBoard.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }catch (Exception e){
            Context context = getApplicationContext();
            CharSequence text = "Please enter names of the players!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void callsettings(View view) {

        Intent intent2 = new Intent(this, settingsActivity.class);
        startActivity(intent2);
    }


}
