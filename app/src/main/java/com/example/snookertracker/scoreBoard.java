package com.example.snookertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;

public class scoreBoard extends AppCompatActivity {
    String message;
    String[] names;
    int REQUEST_CODE=1234;
   // String[] scores={"0","0","0","0"};
    public static final String EXTRA_MESSAGE_2="com.example.snookertracker.MESSAGE";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String[] scores;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey1")) {
                String scorestring = data.getExtras().getString("returnKey1");
                scores = scorestring.split("\\*");
                TextView textView1 = findViewById(R.id.score1);
                textView1.setText(scores[0]);
                TextView textView2 = findViewById(R.id.score2);
                textView2.setText(scores[1]);
                TextView textView3 = findViewById(R.id.score3);
                textView3.setText(scores[2]);
                TextView textView4 = findViewById(R.id.score4);
                textView4.setText(scores[3]);
                TextView textView5 = findViewById(R.id.tot1);
                int team1 = Integer.parseInt(scores[0])+Integer.parseInt(scores[2]);
                textView5.setText(Integer.toString(team1));
                int team2 = Integer.parseInt(scores[1])+Integer.parseInt(scores[3]);
                TextView tv6 = findViewById(R.id.tot2);
                tv6.setText(Integer.toString(team2));
                int largest = 0;
                for ( int i = 1; i < scores.length; i++ )
                {
                    if ( Integer.parseInt(scores[i]) > Integer.parseInt(scores[largest]) ) largest = i;
                }
                TextView tv5 = findViewById(R.id.result_disp2);
                tv5.setText(this.names[largest]);
                TextView tv4 = findViewById(R.id.result_disp);
                if(team1>team2) tv4.setText("team 1");
                else if(team1 ==team2) tv4.setText("tie");
                else tv4.setText("team 2");
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        //String[] names;
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        this.message = intent.getStringExtra(SetupPlayers.EXTRA_MESSAGE);
        this.names = this.message.split("\\*");
        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.namet_1);
        textView1.setText(this.names[0]);
        TextView textView2 = findViewById(R.id.namet_2);
        textView2.setText(this.names[1]);
        TextView textView3 = findViewById(R.id.namet_3);
        textView3.setText(this.names[2]);
        TextView textView4 = findViewById(R.id.namet_4);
        textView4.setText(this.names[3]);
//        TextView textV1 = findViewById(R.id.score1);
//        textV1.setText(this.scores[0]);
//        TextView textV2 = findViewById(R.id.score2);
//        textV2.setText(this.scores[1]);
//        TextView textV3 = findViewById(R.id.score3);
//        textV3.setText(this.scores[2]);
//        TextView textV4 = findViewById(R.id.score4);
//        textV4.setText(this.scores[3]);
//        TextView textView5 = findViewById(R.id.tot1);
//        int team1 = Integer.parseInt(this.scores[0])+Integer.parseInt(this.scores[2]);
//        textView5.setText(Integer.toString(team1));
//        int team2 = Integer.parseInt(this.scores[1])+Integer.parseInt(this.scores[3]);
//        TextView tv6 = findViewById(R.id.tot2);
//        tv6.setText(Integer.toString(team2));
//        int largest = 0;
//        for ( int i = 1; i < this.scores.length; i++ )
//        {
//            if ( Integer.parseInt(this.scores[i]) > Integer.parseInt(this.scores[largest]) ) largest = i;
//        }
//
//        TextView tv5 = findViewById(R.id.result_disp2);
//        tv5.setText(names[largest]);


    }

    public void newGame(View view){
        Intent gameintent = new Intent(this, gameScreen.class);
        gameintent.putExtra(EXTRA_MESSAGE_2,this.message);
        startActivityForResult(gameintent,REQUEST_CODE);
    }
}
