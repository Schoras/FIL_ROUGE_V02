package com.example.fil_rouge_v02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Presentation extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText inputName;
    private EditText inputAge;
    private Button startQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        radioGroup = (RadioGroup) findByViewId(R.id.genderRadioGroup)
        inputSurname = (EditText) findViewById(R.id.inputSurname);
        inputAge = (EditText) findViewById(R.id.inputAge);
        startSurveyButton = (Button) findViewById(R.id.buttonStartSurvey);

        /**
         * CREATING THE NEW INTENT INSIDE THE ONCREATE
         * TO SKIP THE ASSHLING TO CREATE IT LATER AND MAYBE LOSING THE CONTEXT
         */
        Intent intent = new Intent(this.Presentation, QuestionOne.class);

        /**
         * CREATING A PASSTHROUGH OBJECT THAT'LL .... WELL PASS "THROUGH"
         * OUR DIFFERENT ACTIVITIES ...
         */
        Bundle objectPassthrough = new Bundle();
        objectPassthrough.putString("")

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

        startSurveyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        /* GETTING GENDER RADIOBUTTON CHECKED IN RADIOGROUP */
        int selectedButton = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findByViewId(selectedButton);
        objectPassthrough.putString("gender",radioButton.getText());

        /* GETTING THE SURNAME */
        objectPassthrough.putString("surname", inputSurname.getText());

        /* GETTING THE AGE */
        objectPassthrough.putString("age", inputAge.getText());

        /* ADDING THE BUNDLE AS AN EXTRA TO LET IT "PASS THROUGH" */
        intent.putExtras(objetcPassThrough);

        /* THEN WE START THE NEW ACTIVITY */
        this.Presentation.startActivity(intent);
    }
}