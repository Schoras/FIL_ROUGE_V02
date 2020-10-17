package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class End_activity extends AppCompatActivity {

    private Button exitButton, sendButton;
    private EditText inputmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity);

        exitButton = (Button) findViewById(R.id.exitButton);
        sendButton = (Button) findViewById(R.id.sendButton);
        inputmail = (EditText) findViewById(R.id.inputAge);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}