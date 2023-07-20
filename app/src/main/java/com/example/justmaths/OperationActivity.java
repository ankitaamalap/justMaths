package com.example.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Random;

public class OperationActivity extends AppCompatActivity {

    private int seconds = 30;
    private int score = 0;
    private boolean isResultCorrect = true;
    //boolean answer = true;
    private TextView txtViewQuestion, txtViewResult, txtScore, txtTime;

    ImageButton checkBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        txtViewQuestion = findViewById(R.id.txtViewQuestion);
        txtViewResult = findViewById(R.id.txtViewResult);
        txtScore = findViewById(R.id.txtScore);
        txtTime = findViewById(R.id.txtTime);
        checkBtn = findViewById(R.id.checkBtn);
        clearBtn = findViewById(R.id.clearBtn);

        timer();
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(true);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(false);
            }
        });
        generateQuestion();
    }

    private void generateQuestion() {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int result = a + b;
        //int sum = result;
        float f = random.nextFloat();
        if (f > 0.5f) {
            result = random.nextInt(100);
            isResultCorrect = false;
        }
        txtViewQuestion.setText(a + " + " + b);
        txtViewResult.setText(String.valueOf(result));
    }

    private void verifyAnswer(boolean answer) {
//        if (checkBtn.isPressed() || clearBtn.isPressed()) {
//            if (answer == isResultCorrect) {
//                score += 5;
//                txtScore.setText("SCORE: " + score);
//            }
//        }


        if (answer == isResultCorrect) {
            score += 5;
            txtScore.setText("SCORE: " + score);
        }
        else {
            //Phone Vibration
            Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
        }
        generateQuestion();
    }

    private void timer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (seconds > 0) {
                    seconds--;
                    handler.postDelayed(this, 1000);
                    txtTime.setText("TIME: " + seconds);
                } else {
                    Intent intent = new Intent(OperationActivity.this, ScoreActivity.class);
                    intent.putExtra("score", +score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
