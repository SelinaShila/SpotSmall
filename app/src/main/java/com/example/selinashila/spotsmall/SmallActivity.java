package com.example.selinashila.spotsmall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SmallActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView welcomView, pointView;
    private Button btnOne, btnTwo, btnThree,btnRestart,btnEnd;
    int IncValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small);

        btnRestart=(Button) findViewById(R.id.btn_restart);
        btnRestart.setOnClickListener(this);
        btnEnd=(Button) findViewById(R.id.btn_end);
        btnEnd.setOnClickListener(this);

        WelcomeArea();
        RandomArea();
        PointViewArea();
    }

    private void WelcomeArea() {
        welcomView = (TextView) findViewById(R.id.welcomView);

        welcomView.setText("Welcome: "+getIntent().getStringExtra("passName"));
    }

    private void RandomArea() {
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);


        Random random = new Random();
        int pickedNumber1 = random.nextInt(999);
        int pickedNumber2 = random.nextInt(999);
        int pickedNumber3 = random.nextInt(999);


        btnOne.setText(String.valueOf(pickedNumber1));
        btnTwo.setText(String.valueOf(pickedNumber2));
        btnThree.setText(String.valueOf(pickedNumber3));

    }

    private void PointViewArea() {
        pointView = (TextView) findViewById(R.id.pointView);

        pointView.setText(String.valueOf("Point: " + IncValue));

        if (IncValue == 5) {
            btnOne.setBackgroundColor(Color.WHITE);
            btnTwo.setBackgroundColor(Color.WHITE);
            btnThree.setBackgroundColor(Color.WHITE);
        } else if (IncValue == 10) {
            btnOne.setBackgroundColor(Color.BLUE);
            btnTwo.setBackgroundColor(Color.BLUE);
            btnThree.setBackgroundColor(Color.BLUE);
        } else if (IncValue == 15) {
            btnOne.setBackgroundColor(Color.RED);
            btnTwo.setBackgroundColor(Color.RED);
            btnThree.setBackgroundColor(Color.RED);
        } else if (IncValue == 20) {
            btnOne.setBackgroundColor(Color.YELLOW);
            btnTwo.setBackgroundColor(Color.YELLOW);
            btnThree.setBackgroundColor(Color.YELLOW);
        }
    }


    public void buttonOne(View view) {
        int btn1 = Integer.valueOf(btnOne.getText().toString());
        int btn2 = Integer.valueOf(btnTwo.getText().toString());
        int btn3 = Integer.valueOf(btnThree.getText().toString());

        if (btn1 < btn2 && btn1 < btn3){
            Toast.makeText(this, "Correct...", Toast.LENGTH_SHORT).show();
            IncValue++;
        }else {
            Toast.makeText(this, "Wrong...", Toast.LENGTH_SHORT).show();
            IncValue--;
        }
        RandomArea();
        PointViewArea();
    }

    public void buttonTwo(View view) {
        int btn1 = Integer.valueOf(btnOne.getText().toString());
        int btn2 = Integer.valueOf(btnTwo.getText().toString());
        int btn3 = Integer.valueOf(btnThree.getText().toString());

        if (btn2 < btn1 && btn2 < btn3){
            Toast.makeText(this, "Correct...", Toast.LENGTH_SHORT).show();
            IncValue++;
        }else {
            Toast.makeText(this, "Wrong...", Toast.LENGTH_SHORT).show();
            IncValue--;
        }
        RandomArea();
        PointViewArea();
    }

    public void buttonThree(View view) {
        int btn1 = Integer.valueOf(btnOne.getText().toString());
        int btn2 = Integer.valueOf(btnTwo.getText().toString());
        int btn3 = Integer.valueOf(btnThree.getText().toString());

        if (btn3 < btn1 && btn3 < btn2  ){
            Toast.makeText(this, "Correct...", Toast.LENGTH_SHORT).show();
            IncValue++;
        }else {
            Toast.makeText(this, "Wrong...", Toast.LENGTH_SHORT).show();
            IncValue--;
        }
        RandomArea();
        PointViewArea();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_end){

        SharedPreferences preferences=getSharedPreferences("PREF", 0);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("LastScore",IncValue);
        editor.apply();

        Intent intent = new Intent(this, BestActivity.class);

        startActivity(intent);
        finish();}

        if(v.getId()==R.id.btn_restart){
            Intent intent = new Intent(this, SmallActivity.class);

            startActivity(intent);
            finish();
        }

    }
}
