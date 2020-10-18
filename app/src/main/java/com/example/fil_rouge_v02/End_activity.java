package com.example.fil_rouge_v02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class End_activity extends AppCompatActivity implements View.OnClickListener {

    private Button exitButton, sendButton;
    private EditText inputmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity);

        exitButton = (Button) findViewById(R.id.exitButton);
        sendButton = (Button) findViewById(R.id.sendButton);
        inputmail = (EditText) findViewById(R.id.inputAge);

        exitButton.setOnClickListener(this);
        sendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.exitButton:
                finish();
            break;
            case R.id.sendButton:
                Bundle objectPassthrough = this .getIntent().getExtras();

                StringBuilder strb = new StringBuilder();

                /* QUESTIONS FROM PRESENRTATION ACTIVITY */
                strb.append("Genre : "+objectPassthrough.getString("gender"))
                    .append("\n")
                    .append("Prenom : "+objectPassthrough.getString("surname"))
                    .append("\n")
                    .append("Age : "+objectPassthrough.getString("age"))
                    .append("\n");

                /* QUESTION FROM ACTIVITY QuestionOne */
                switch(objectPasthrough.getString("question1")){
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
                switch(objectPasthrough.getString("question2")){
                    case "0":
                        strb.append("Nombre de contrôles : Aucun");
                    break;
                    case "1":
                        strb.append("Nombre de contrôles : 1 à 3 fois");
                    break;
                    case "2":
                        strb.append("Nombre de contrôles : 4 à 7 fois");
                    break;
                    case "2":
                        strb.append("Nombre de contrôles : Plus de 7 fois");
                    break;
                }
                strb.append("\n");

                /* QUESTION FROM ACTIVITY QuestionThree */
                strb.append("Douleur ressentie ou présumée lors des tests : "+objectPassthrough.getString("question3"))
                    .append("\n");

                /* QUESTION FROM ACTIVITY QuestionFour */


                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:"+inputmail.getText()));
                i.putExtra(Intent.EXTRA_SUBJECT, "Resultats questionnaire");
                i.putExtra(Intent.EXTRA_TEXT, strb.toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MyActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            break;
        }
    }
}