package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class End_activity extends AppCompatActivity implements View.OnClickListener {

    private Button exitButton, sendButton;
    private EditText inputmail;
    private TextView textResult;
    private StringBuilder strb = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity);

        exitButton = (Button) findViewById(R.id.exitButton);
        sendButton = (Button) findViewById(R.id.sendButton);
        inputmail = (EditText) findViewById(R.id.inputAge);
        textResult = (TextView) findViewById(R.id.textResult);

        exitButton.setOnClickListener(this);
        sendButton.setOnClickListener(this);

        Bundle objectPassthrough = this .getIntent().getExtras();


        /* QUESTIONS FROM PRESENRTATION ACTIVITY */
        strb.append("Genre : "+objectPassthrough.getString("gender"))
                .append("\n")
                .append("Prenom : "+objectPassthrough.getString("surname"))
                .append("\n")
                .append("Age : "+objectPassthrough.getString("age"))
                .append("\n");

        /* QUESTION FROM ACTIVITY QuestionOne */
        switch(objectPassthrough.getString("question1")){
            case "0":
                strb.append("Controlé positif à la Covid : Jamais");
                break;
            case "1":
                strb.append("Controlé positif à la Covid : Une fois");
                break;
            case "2":
                strb.append("Controlé positif à la Covid : Plusieurs fois ");
                break;
        }
        strb.append("\n");

        /* QUESTION FROM ACTIVITY QuestionTwo */
        switch(objectPassthrough.getString("question2")){
            case "0":
                strb.append("Nombre de contrôles : Aucun");
                break;
            case "1":
                strb.append("Nombre de contrôles : 1 à 3 fois");
                break;
            case "2":
                strb.append("Nombre de contrôles : 4 à 7 fois");
                break;
            case "3":
                strb.append("Nombre de contrôles : Plus de 7 fois");
                break;
        }
        strb.append("\n");

        /* QUESTION FROM ACTIVITY QuestionThree */
        strb.append("Douleur ressentie ou présumée lors des tests : "+objectPassthrough.getString("question3"))
                .append("\n");

        /* QUESTION FROM ACTIVITY QuestionFour */
            textResult.setText(strb.toString());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.exitButton:
                System.exit(0);
            break;
            case R.id.sendButton:

                String uriText =
                        "mailto:"+ inputmail.getText() +
                                "?subject=" + Uri.encode("[RESULTATS TEST APPLICATION COVID]") +
                                "&body=" + Uri.encode("Voici vos les réponses que vous avez saisi" + strb.toString());
                Uri uri = Uri.parse(uriText);
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setData(uri);
                startActivity(Intent.createChooser(sendIntent, "Send email"));

            break;
        }
    }
}