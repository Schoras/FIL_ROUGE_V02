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
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        seekBar = (SeekBar) findViewById(R.id.seekBar_painmeter);
        btnContinue = (Button) findViewById(R.id.buttonContinue);
        btnContinue.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = seekBar.getProgress();

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {}

            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        intent = new Intent(QuestionThree.this, End_activity.class);
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
        startActivity(intent);
    }
}