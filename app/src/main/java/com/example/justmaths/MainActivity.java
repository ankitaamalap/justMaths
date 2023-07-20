package com.example.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton shareBtn = findViewById(R.id.shareBtn);
        ImageButton playBtn = findViewById(R.id.playBtn);
        ImageButton closeBtn = findViewById(R.id.closeBtn);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implicit Intent
                Intent intent = new Intent(Intent.ACTION_SEND);

                //calls action processing apps
                intent.setType("text/plain");

                //Set Subject and body
                String shareSub = "Your subject here";
                String shareBody = "Your body here";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);

                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }
}
