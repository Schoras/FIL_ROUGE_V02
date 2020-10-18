package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Question2 extends AppCompatActivity implements View.ObClickListener {

    private Button btnAnswerOne, btnAnswerTwo, btnAnswerThree, btnAnswerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        btAnswerOne = (Button) findViewById(R.id.activity_game_answer1_btn);
        btAnswerTwo = (Button) findViewById(R.id.activity_game_answer2_btn);
        btAnswerThree = (Button) findViewById(R.id.activity_game_answer3_btn);
        btAnswerFour = (Button) findViewById(R.id.activity_game_answer4_btn);

        btAnswerOne.setOnClickListener(this);
        btAnswerTwo.setOnClickListener(this);
        btAnswerThree.setOnClickListener(this);
        btAnswerFour.setOnClickListener(this);

        Intent intent = new Intent(this.QuestionTwo, QuestionThree.class);
    }

    @Override
    public void onClick(View v) {

        /* GETTING THE INTENT FROM PAST ACTIVITY */
        Bundle objectPassthrough = this.getIntent().getExtras();

        /* SWITCHING VALUES */
        switch(v.getId()){
            case R.id.activity_game_answer1_btn:
                objectPassthrough.putString("question2", "0");
            break;
            case R.id.activity_game_answer2_btn:
            objectPassthrough.putString("question2", "1");
            break;
            case R.id.activity_game_answer3_btn:
            objectPassthrough.putString("question2", "2");
            break;
            case R.id.activity_game_answer4_btn:
            objectPassthrough.putString("question2", "3");
            break;
        }

        /* PUTTING THE EXTRAS IN THE INTENT */
        intent.putExtras(objectPassthrough);

        /* STARTING THE NEW ACTIVITY */
        this.QuestionOne.startActivity(intent);
    }
}