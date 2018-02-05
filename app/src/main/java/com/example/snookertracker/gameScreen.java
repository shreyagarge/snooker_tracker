package com.example.snookertracker;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class gameScreen extends AppCompatActivity {
    String message;
    String[] names;
    int Curplayer;
    int flag; //flag=1 indicates that the last ball potted was a red
    int redcount;// keeps track of how many red balls are potted
    int[] pot = {0, 0, 0, 0, 0, 0};//array to keep track of what all balls have been potted after all the reds have been potted
    int[] scores = {0, 0, 0, 0};
    public static final String EXTRA_MESSAGE_3 = "com.example.snookertracker.MESSAGE";

    @Override
    public void finish() {
        String scorestring = Integer.toString(scores[0]) + "*" + Integer.toString(scores[1]) + "*" + Integer.toString(scores[2]) + "*" + Integer.toString(scores[3]);
        Intent data = new Intent();
        data.putExtra("returnKey1", scorestring);
        //data.putExtra("returnKey2", "You could be better then you are. ");
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        ConstraintLayout lay = findViewById(R.id.clay3);


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

        Intent gameintent = getIntent();
        this.message = gameintent.getStringExtra(SetupPlayers.EXTRA_MESSAGE);
        this.names = this.message.split("\\*");
        TextView cpet = findViewById(R.id.cur_disp);
        cpet.setText(names[0]);
        this.Curplayer = 0;
    }

    public void setCurrentPlayer(View view) {
        int x;
        this.flag = 0;
        TextView cpet = findViewById(R.id.cur_disp);
        TextView cpscet = findViewById(R.id.score_disp);
        String cupl = cpet.getText().toString();
        if (cupl.isEmpty() || this.Curplayer == 3) {
            this.Curplayer = 0;
        } else {
            for (x = 0; x <= 3; x++) {
                if (cupl.equals(this.names[x])) {
                    break;
                }
            }
            this.Curplayer = x + 1;
        }
        cpet.setText(this.names[this.Curplayer]);
        String sco = Integer.toString(this.scores[this.Curplayer]);
        cpscet.setText(sco);
    }

    public void red(View view) {

        if (this.redcount < 15 && this.flag == 0) {
            this.flag = 1;
            this.redcount++;
            this.scores[this.Curplayer] = this.scores[this.Curplayer] + 1;
            TextView cpscet = findViewById(R.id.score_disp);
            String sco = Integer.toString(this.scores[this.Curplayer]);
            cpscet.setText(sco);
        } else if (this.redcount<15 && this.flag == 1) {
            Context context = getApplicationContext();
            CharSequence text = "it's supposed to be a colored ball's turn now!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if(this.redcount==15 && this.flag==0){
            this.flag=1;
            this.redcount++;
            Context context = getApplicationContext();
            CharSequence text = "you're out of red balls! pot the colored balls in order now!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Context context = getApplicationContext();
            CharSequence text = "you're out of red balls! pot the colored balls in order now!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void coloredball(int i) {


//        if((this.flag==1 || this.redcount>15)&&this.pot[i]==0) {
//            this.scores[this.Curplayer] = this.scores[this.Curplayer]+i+2;
//            TextView cpscet = findViewById(R.id.score_disp);
//            String sco = Integer.toString(this.scores[this.Curplayer]);
//            cpscet.setText(sco);
//            this.flag = 0;
//            if(this.redcount>15){
//                this.pot[i]=1;
//            }
//        }
//        else if( this.pot[i]==1){
//            int fl=0;
//
//            for(int x=0;x<=5;x++){
//                if(this.pot[x]==0) fl=1;
//            }
//            if(fl==0){
//                Context context = getApplicationContext();
//                CharSequence text = "all the balls have been potted. time to end the frame and view scores!";
//                int duration = Toast.LENGTH_LONG;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//
//
//            }
//            else {
//                Context context = getApplicationContext();
//                CharSequence text = "this ball is not on the table!";
//                int duration = Toast.LENGTH_LONG;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//            }
//        }
//        else {
//            Context context = getApplicationContext();
//            CharSequence text = "it's supposed to be a red ball's turn now!";
//            int duration = Toast.LENGTH_LONG;
//
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }


        if (this.redcount <= 15) {
            if (this.flag == 1) {
                //pot and add score
                this.scores[this.Curplayer] = this.scores[this.Curplayer] + i + 2;
                TextView cpscet = findViewById(R.id.score_disp);
                String sco = Integer.toString(this.scores[this.Curplayer]);
                cpscet.setText(sco);
                this.flag = 0;
            } else {
                //toast red ball's turn now
                Context context = getApplicationContext();
                CharSequence text = "it's supposed to be a red ball's turn now!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        } else {
            if (i == 0) {
                //check and add
                if (pot[i] == 0) {
                    this.scores[this.Curplayer] = this.scores[this.Curplayer] + i + 2;
                    TextView cpscet = findViewById(R.id.score_disp);
                    String sco = Integer.toString(this.scores[this.Curplayer]);
                    cpscet.setText(sco);
                    this.flag = 0;
                    this.pot[i] = 1;
                } else {
                    int fl = 0;

                    for (int x = 0; x <= 5; x++) {
                        if (this.pot[x] == 0) fl = 1;
                    }
                    if (fl == 0) {
                        Context context = getApplicationContext();
                        CharSequence text = "all the balls have been potted. time to end the frame and view scores!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();


                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "this ball is not on the table! pot the next ball in order instead";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            } else {
                int fl2 = 0;
                for (int y = 0; y < i; y++) {
                    if (pot[y] == 0) {
                        fl2 = 1;
                    }
                }
                if (fl2 == 1) {
                    //toast pot the ball in order
                    Context context = getApplicationContext();
                    CharSequence text = "oops! That's not the correct order!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    //check and pot
                    if (pot[i] == 0) {
                        this.scores[this.Curplayer] = this.scores[this.Curplayer] + i + 2;
                        TextView cpscet = findViewById(R.id.score_disp);
                        String sco = Integer.toString(this.scores[this.Curplayer]);
                        cpscet.setText(sco);
                        this.flag = 0;
                        this.pot[i] = 1;
                    } else {
                        int fl = 0;

                        for (int x = 0; x <= 5; x++) {
                            if (this.pot[x] == 0) fl = 1;
                        }
                        if (fl == 0) {
                            Context context = getApplicationContext();
                            CharSequence text = "all the balls have been potted. time to end the frame and view scores!";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();


                        } else {
                            Context context = getApplicationContext();
                            CharSequence text = "this ball is not on the table! pot the next ball in order instead";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }
                }
            }
        }


    }

    public void yellow(View view) {
        coloredball(0);
    }

    public void green(View view) {
        coloredball(1);
    }

    public void brown(View view) {
        coloredball(2);
    }

    public void blue(View view) {
        coloredball(3);
    }

    public void pink(View view) {
        coloredball(4);
    }

    public void black(View view) {
        coloredball(5);
    }

    public void foul(View view) {
        if (this.Curplayer == 3) {
            this.Curplayer = 0;
        } else {
            this.Curplayer++;
        }
        this.scores[this.Curplayer] = this.scores[this.Curplayer] + 4;
        TextView cpet = findViewById(R.id.cur_disp);
        TextView cpscet = findViewById(R.id.score_disp);
        cpet.setText(this.names[this.Curplayer]);
        String sco = Integer.toString(this.scores[this.Curplayer]);
        cpscet.setText(sco);

    }

    public void endFrame(View view) {
//        String scorestring = Integer.toString(scores[0])+"*"+Integer.toString(scores[1])+"*"+Integer.toString(scores[2])+"*"+Integer.toString(scores[3]);
//        Intent scoreintent = new Intent(this, scoreBoard.class);
//        scoreintent.putExtra(EXTRA_MESSAGE_3,scorestring);
//        startActivity(scoreintent);
        finish();

    }

}
