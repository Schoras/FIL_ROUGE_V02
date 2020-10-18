package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuestionOne extends AppCompatActivity implements View.OnClickListener {

    private Button bntAnswerOne, btnAnswerTwo, btnAnswerThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        btAnswerOne = (Button) findViewById(R.id.activity_game_answer1_btn);
        btAnswerTwo = (Button) findViewById(R.id.activity_game_answer2_btn);
        btAnswerthree = (Button) findViewById(R.id.activity_game_answer3_btn);

        btAnswerOne.setOnClickListener(this);
        btAnswerTwo.setOnClickListener(this);
        btAnswerThree.setOnClickListener(this);

        Intent intent = new Intent(this.QuestionOne, QuestionTwo.class);
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
        this.QuestionOne.startActivity(intent);
    }
}