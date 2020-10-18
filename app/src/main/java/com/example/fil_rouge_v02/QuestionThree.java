package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class QuestionThree extends AppCompatActivity implements View.OnClickListener {

    private SeekBar seekBar;
    private Button btnContinue;
    private int progressValue;
    final Intent intent = new Intent(QuestionThree.this, QuestionFour.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        seekBar = (SeekBar) findViewById(R.id.activity_game_question_dolor_seekBar);
        btnContinue = (Button) findViewById(R.id.buttonContinue);
        btnContinue.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 3;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {}

            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onClick(View v) {

        /* GETTING THE PAST BUNDLE */
        Bundle objectPassthrough = this.getIntent().getExtras();

        /* ASSIGNING THE PROGRESS BAR VALUE TO THE BUNDLE */
        objectPassthrough.putString("question3",String.valueOf(progressValue));
        
        /* PUTTING THE BUNDLE IN THE NEW INTENT */
        intent.putExtras(objectPassthrough);

        /* STARTING THE NEW ACTIVITY */
        QuestionThree.this.startActivity(intent);
    }
}