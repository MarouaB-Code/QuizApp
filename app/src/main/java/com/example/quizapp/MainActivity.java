package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String[] questions = {
            "Comment s'écrit le nombre 10?",
            "Comment s'écrit le nombre 8?",
            "Comment s'écrit le nombre 6?",
            "Comment s'écrit le nombre 60?",
            "Comment s'écrit le nombre 20?",
            "Comment s'écrit le nombre 29?",
            "Comment s'écrit le nombre 5?",
            "Comment s'écrit le nombre 2?",
            "Comment s'écrit le nombre 19?",
            "Comment s'écrit le nombre 14?",
            "Comment s'écrit le nombre 7?",
            "Comment s'écrit le nombre 4?",
            "Comment s'écrit le nombre 9?",
            "Comment s'écrit le nombre 3?",
    };
    String[] answers = {"dix", "huit", "six", "soixante", "vingt", "vingt neuf", "cinq", "deux", "dix neuf", "quatorze ","sept","quatre","neuf","trois"};
    String[] opt = {
            "dis", "dix", "diss", "dise",
            "wit", "wite", "uite", "huit",
            "six", "sixt", "sise", "sis",
            "soixant", "soicente", "soixante", "soisente",
            "vin", "ving", "vint", "vingt",
            "vintneuve", "vingt neuf", "vinneufe", "ving neuf.",
            "cinq", "cink", "sinq", "cinque",
            "de", "deus", "deu", "deux",
            "disneuve", "dix neuf", "disneuf", "dix neuve",
            "qatorz", "quatorse", "quatorze", "katorze",
            "sett", "septe", "sept", "set",
            "qatre", "quatre", "katre", "quattre",
            "neuf", "neufe", "neuve", "neuff",
            "trwa", "trois", "troi", "troix"



    };
    int flag=0;

    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Intent intent = getIntent();
        //String name= intent.getStringExtra("myname");

        //if (name.trim().equals(""))
        //textView.setText("Hello User");
        // else
        // textView.setText("Hello " + name);

        submitbutton= findViewById(R.id.button3);

        tv= findViewById(R.id.tvque);

        radio_g= findViewById(R.id.answersgrp);
        rb1= findViewById(R.id.radioButton);
        rb2= findViewById(R.id.radioButton2);
        rb3= findViewById(R.id.radioButton3);
        rb4= findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "SVP selectionner un choix", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Bonne réponse", Toast.LENGTH_SHORT).show();


                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Fausse réponse", Toast.LENGTH_SHORT).show();

                }

                flag++;

                // if (score != null)
                // score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);



                }
                else
                {
                    marks=correct;
                    checkEnd();

                    //Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    // startActivity(in);
                }
                radio_g.clearCheck();

            }
        });


    }

    private void checkEnd(){



        AlertDialog.Builder AlertdialogBuild= new AlertDialog.Builder(this);
        AlertdialogBuild.setCancelable(false);
        AlertdialogBuild.setTitle("TERMINER..!!!");
        AlertdialogBuild.setIcon(R.drawable.quiz_logo);
        AlertdialogBuild.setMessage("Vous avez terminer , Votre score est:  " +correct + "/14" );
        AlertdialogBuild.setPositiveButton("REJOUER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();


            }
        })
                .setNegativeButton("QUIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                        //startActivity(intent);
                        finish();
                    }
                });
        AlertDialog alertDialog= AlertdialogBuild.create();
        alertDialog.show();

    }

}
