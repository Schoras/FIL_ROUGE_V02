package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Question1 extends AppCompatActivity implements View.OnClickListener {

    private SeekBar seekBar;
    private Button btnContinue;
    int progressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        seekBar = (SeekBar) findViewById(R.id.activity_game_question_dolor_seekBar);
        btnContinue = (Button) findViewById(R.id.buttonContinue);
        btnContinue.setOnClickListener(this);

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 3;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {}

            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Intent intent = new Intent(this.QuestionTwo, QuestionThree.class);
    }

    @Override
    public void onClick(View v) {

        /* GETTING THE PAST BUNDLE */
        Bundle objectPassthrough = this.getIntent().getExtras();

        /* ASSIGNING THE PROGRESS BAR VALUE TO THE BUNDLE */
        objectPassthrough.puString("question3",String.valueOf(progressValue));
        
        /* PUTTING THE BUNDLE IN THE NEW INTENT */
        intent.putExtras(objectPassthrough);

        /* STARTING THE NEW ACTIVITY */
        this.QuestionOne.startActivity(intent);
    }
}