package com.example.selinashila.spotsmall;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private ImageView btnPlay;
    private EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);


        editName = (EditText) findViewById(R.id.editName);
    }

    @Override
    public void onClick(View v) {
        String passValue = editName.getText().toString();
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.button_sound );

        if (v.getId() == R.id.btnPlay) {
            if (passValue.equals("")) {
                Toast.makeText(getApplicationContext(), "Insert Your Name...", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, SmallActivity.class);
                intent.putExtra("passName", passValue);
                startActivity(intent);
            }

        }
    }
}
