package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionOne extends AppCompatActivity implements View.OnClickListener {

    private Button btnAnswerOne, btnAnswerTwo, btnAnswerThree;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        intent = new Intent(QuestionOne.this, QuestionTwo.class);

        btnAnswerOne = (Button) findViewById(R.id.activity_game_answer1_btn);
        btnAnswerTwo = (Button) findViewById(R.id.activity_game_answer2_btn);
        btnAnswerThree = (Button) findViewById(R.id.activity_game_answer3_btn);

        btnAnswerOne.setOnClickListener(this);
        btnAnswerTwo.setOnClickListener(this);
        btnAnswerThree.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        /* GETTING THE EXTRAS FROM THE PAST ACTIVITY */
        Bundle objectPassthrough = this.getIntent().getExtras();

        /* SWITCHING OVER THE VALUE TO PASS WHEN CLICKING DIFFERENT BUTTONS */
        switch(v.getId()){
            case R.id.activity_game_answer1_btn:
                objectPassthrough.putString("question1", "0");
            break;
            case R.id.activity_game_answer2_btn:
            objectPassthrough.putString("question1", "1");
            break;
            case R.id.activity_game_answer3_btn:
            objectPassthrough.putString("question1", "2");
            break;

        }

        /* ADDIGN THE EXTRAS TO THE INTENT */
        intent.putExtras(objectPassthrough);

        /* STARTING THE NEW ACTIVITY */
        startActivity(intent);
    }
}