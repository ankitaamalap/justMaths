package com.example.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ImageButton closeBtn = findViewById(R.id.closeBtn);
        ImageButton replayBtn = findViewById(R.id.replayBtn);

        TextView txtScore = findViewById(R.id.txtScore);
        int score = getIntent().getIntExtra("score", 0);
        txtScore.setText("SCORE: " + score);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quit app and put it in back stack(open in back)
                //moveTaskToBack(true);

                //Quit app
                finish();
            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, OperationActivity.class);
                startActivity(intent);
            }
        });

    }
}
