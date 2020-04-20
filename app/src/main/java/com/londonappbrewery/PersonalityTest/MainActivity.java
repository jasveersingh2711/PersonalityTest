package com.londonappbrewery.PersonalityTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends Activity {

    // Member variables accessible in all the methods of the MainActivity:
    Button YesButton;
    Button NoButton;
    TextView QuestionTextView;
    int Index;
    int Question;


    // Create question bank using the YesNo class for each item in the array
    @NonNull
    private YesNo[] QuestionBank = new YesNo[]{
            new YesNo(R.string.question_1),
            new YesNo(R.string.question_2),
            new YesNo(R.string.question_3),
            new YesNo(R.string.question_4),
            new YesNo(R.string.question_5),
            new YesNo(R.string.question_6),
            new YesNo(R.string.question_7),
            new YesNo(R.string.question_8),
            new YesNo(R.string.question_9),
            new YesNo(R.string.question_10),
            new YesNo(R.string.question_11),
            new YesNo(R.string.question_12),
            new YesNo(R.string.question_13),
            new YesNo(R.string.question_14),
            new YesNo(R.string.question_15),
            new YesNo(R.string.question_16),
            new YesNo(R.string.question_17),
            new YesNo(R.string.question_18),
            new YesNo(R.string.question_19),
            new YesNo(R.string.question_20),

    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning button with variables
        YesButton = findViewById(R.id.yes_button);
        NoButton = findViewById(R.id.no_button);
        QuestionTextView = findViewById(R.id.question_text_view);
        Question = QuestionBank[Index].getQuestionID();
        QuestionTextView.setText(Question);

        YesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        NoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
    }
    private void updateQuestion() {

        // This takes the modulus. Not a division.
        Index = (Index + 1) % QuestionBank.length;

        // Present an alert dialog if we reach the end.
        if (Index == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

            alert.setTitle("Personality Test Over");
            alert.setCancelable(false);
            String[] result = {"Reformer", "Helper", "Achiever", "individualist","Investigator","Loyalist","Enthusiast","Challeger","Peacemaker"};
            Random r=new Random();
            int randomNumber=r.nextInt(result.length);
            alert.setMessage("You are a " + result[randomNumber]);
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        Question = QuestionBank[Index].getQuestionID();
        QuestionTextView.setText(Question);


    }
}


