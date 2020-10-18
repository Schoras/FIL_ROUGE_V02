package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionTwo extends AppCompatActivity implements View.OnClickListener {

    private Button btnAnswerOne, btnAnswerTwo, btnAnswerThree, btnAnswerFour;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        btnAnswerOne = (Button) findViewById(R.id.activity_game_answer1_btn);
        btnAnswerTwo = (Button) findViewById(R.id.activity_game_answer2_btn);
        btnAnswerThree = (Button) findViewById(R.id.activity_game_answer3_btn);
        btnAnswerFour = (Button) findViewById(R.id.activity_game_answer4_btn);

        btnAnswerOne.setOnClickListener(this);
        btnAnswerTwo.setOnClickListener(this);
        btnAnswerThree.setOnClickListener(this);
        btnAnswerFour.setOnClickListener(this);

        intent = new Intent(QuestionTwo.this, QuestionThree.class);
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
        startActivity(intent);
    }
}