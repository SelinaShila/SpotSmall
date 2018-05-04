package com.example.selinashila.spotsmall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BestActivity extends AppCompatActivity {

    TextView tv_score;
    int LastScore;
    int best1,best2,best3,best4,best5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best);
        tv_score=(TextView)findViewById(R.id.tv_score);
        SharedPreferences preferences=getSharedPreferences("PREF", 0);

        LastScore=preferences.getInt("LastScore",0);
        best1=preferences.getInt("best1",0);
        best2=preferences.getInt("best2",0);
        best3=preferences.getInt("best3",0);
        best4=preferences.getInt("best4",0);
        best5=preferences.getInt("best5",0);

        if(LastScore>best5){
            best5=LastScore;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best5",best5);
            editor.apply();
        }
        if(LastScore>best4){
            int temp = best4;
            best4=LastScore;
            best5= temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best5",best5);
            editor.putInt("best4",best4);
            editor.apply();
        }
        if(LastScore>best3){
            int temp = best3;
            best3=LastScore;
            best4= temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best4",best4);
            editor.putInt("best3",best3);
            editor.apply();
        }
        if(LastScore>best2){
            int temp = best2;
            best2=LastScore;
            best3= temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best3",best3);
            editor.putInt("best2",best2);
            editor.apply();
        }
        if(LastScore>best1){
            int temp = best1;
            best1=LastScore;
            best2= temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best2",best2);
            editor.putInt("best1",best1);
            editor.apply();
        }


        tv_score.setText("LAST SCORE: " + LastScore + "\n" +
        "BEST1 " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + best3 + "\n" +
                        "BEST4: " + best4 + "\n" +
                        "BEST5: " + best5 + "\n"
        );

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, SmallActivity.class);

        startActivity(intent);
        finish();
    }
}
