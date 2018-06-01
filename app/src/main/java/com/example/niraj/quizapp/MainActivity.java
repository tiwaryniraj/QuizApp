package com.example.niraj.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ansFour;
    CheckBox qus2op1;
    CheckBox qus2op2;
    CheckBox qus2op3;
    CheckBox qus2op4;
    RadioButton qus1op3;
    RadioButton qus3op2;
    RadioButton qus5op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansFour = findViewById(R.id.ans4);
        qus2op1 = findViewById(R.id.qus2op1);
        qus2op2 = findViewById(R.id.qus2op2);
        qus2op3 = findViewById(R.id.qus2op3);
        qus2op4 = findViewById(R.id.qus2op4);
        qus3op2 = findViewById(R.id.qus3op2);
        qus5op4 = findViewById(R.id.qus5op4);
        qus1op3 = findViewById(R.id.qus1op3);
    }
/*
* qusXopY means Question X's Yth Option
* For radioButtons we only check for correct option and for checkBoxs we use && operator,
* to check the correct logic,
* for EditText we generate a boolean value from it and then use it to get the final score.
* */
    public void showScore(View view) {

        boolean secondAnswer1 = qus2op1.isChecked();
        boolean secondAnswer2 = qus2op2.isChecked();
        boolean secondAnswer3 = qus2op3.isChecked();
        boolean secondAnswer4 = qus2op4.isChecked();

        String ansOfFour = ansFour.getText().toString();
        boolean fourAnswer = false;
        if (ansOfFour.equals("16")) {
            fourAnswer = true;
        }
        RadioButton ansFirst = findViewById(R.id.qus1op3);
        boolean answerFirst = ansFirst.isChecked();
        RadioButton ansThird = findViewById(R.id.qus3op2);
        boolean answerThird = ansThird.isChecked();
        RadioButton ansFifth = findViewById(R.id.qus5op4);
        boolean answerFifth = ansFifth.isChecked();

        int score = calculate(secondAnswer1, secondAnswer3, secondAnswer2, secondAnswer4, fourAnswer, answerFifth, answerFirst, answerThird);
        if(score == 5) {
            Toast.makeText(this, "Awesome perfect Score, Congratulations!", Toast.LENGTH_LONG).show(); //Created a toast to show the result
        }else {
            Toast.makeText(this, "Your Score is " + score + " Out of 5 :)", Toast.LENGTH_LONG).show();
        }
    }

    public int calculate(boolean secondAnswer1, boolean secondAnswer3, boolean secondAnswer2, boolean secondAnswer4, boolean fourAnswer, boolean answerFifth, boolean answerFirst, boolean answerThird) {
        int score = 0;
        if (answerFirst) {
            score = score + 1;
        }
        if (secondAnswer1 && secondAnswer4 && secondAnswer3 && !secondAnswer2) {        //If and only if all option except 2 are checked only then the score will Increment
            score = score + 1;
        }
        if (answerThird) {
            score = score + 1;
        }
        if (fourAnswer) {
            score = score + 1;
        }
        if (answerFifth) {
            score = score + 1;
        }
        return score;
    }
}