package com.example.fil_rouge_v02;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Presentation extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText inputName;
    private EditText inputAge;
    private Button startQuestion;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        radioGroup = (RadioGroup)findViewById(R.id.genderRadioGroup);
        inputName = (EditText) findViewById(R.id.inputName);
        inputAge = (EditText) findViewById(R.id.inputAge);
        startQuestion = (Button) findViewById(R.id.buttonStartSurvey);

        /**
         * CREATING THE NEW INTENT INSIDE THE ONCREATE
         * TO SKIP THE ASSHLING TO CREATE IT LATER AND MAYBE LOSING THE CONTEXT
         */
        intent = new Intent(Presentation.this, QuestionOne.class);

        /**
         * CREATING A PASSTHROUGH OBJECT THAT'LL .... WELL PASS "THROUGH"
         * OUR DIFFERENT ACTIVITIES ...
         */
        Bundle objectPassthrough = new Bundle();


        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startQuestion.setEnabled(s.toString().length() !=0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                
            }
        });

        startQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        /**
         * CREATING A PASSTHROUGH OBJECT THAT'LL .... WELL PASS "THROUGH"
         * OUR DIFFERENT ACTIVITIES ...
         */
        Bundle objectPassthrough = new Bundle();

        /* GETTING GENDER RADIOBUTTON CHECKED IN RADIOGROUP */
        int selectedButton = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(selectedButton);
        objectPassthrough.putString("gender", String.valueOf(radioButton.getText()));

        /* GETTING THE SURNAME */
        objectPassthrough.putString("surname", String.valueOf(inputName.getText()));

        /* GETTING THE AGE */
        objectPassthrough.putString("age", String.valueOf(inputAge.getText()));

        /* ADDING THE BUNDLE AS AN EXTRA TO LET IT "PASS THROUGH" */
        intent.putExtras(objectPassthrough);

        /* THEN WE START THE NEW ACTIVITY */
        startActivity(intent);
    }
}