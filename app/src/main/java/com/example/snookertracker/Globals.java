package com.example.snookertracker;

import android.app.Application;

/**
 * Created by shreyagarge on 2/5/18.
 */

public class Globals extends Application {
    private int colid=0;

    public int getColid(){
        return this.colid;
    }

    public void setColid(int d){
        this.colid=d;
    }

}
