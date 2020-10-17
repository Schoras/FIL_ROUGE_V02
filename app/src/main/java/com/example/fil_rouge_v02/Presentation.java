package com.example.fil_rouge_v02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Presentation extends AppCompatActivity {

    private RadioButton menRb,womenRb;
    private EditText inputName;
    private EditText inputAge;
    private Button startQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        menRb = (RadioButton) findViewById(R.id.menRb);
        womenRb = (RadioButton) findViewById(R.id.womenRb);
        inputName = (EditText) findViewById(R.id.inputName);
        inputAge = (EditText) findViewById(R.id.inputAge);
        startQuestion = (Button) findViewById(R.id.startQuestion);

        startQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(Presentation.this, Activity_question1.class);
                startActivity(e);}
        });



    }
}