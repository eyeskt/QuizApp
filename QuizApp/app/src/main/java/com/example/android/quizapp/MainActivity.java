package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctAnswerNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private String CheckQuestion1Answer() {
        EditText editText = (EditText) findViewById(R.id.question_1_edittext);
        String Question1Answer = editText.getText().toString();
        correctAnswerNumber += 1;
        return Question1Answer;
    }

    private void CheckQuestion2Answer() {
        CheckBox question2CheckBox1 = findViewById(R.id.Question2CheckBox1);
        CheckBox question2CheckBox2 = findViewById(R.id.Question2CheckBox2);
        CheckBox question2CheckBox3 = findViewById(R.id.Question2CheckBox3);
        boolean checkbox1 = question2CheckBox1.isChecked();
        boolean checkbox2 = question2CheckBox2.isChecked();
        boolean checkbox3 = question2CheckBox3.isChecked();

        if (checkbox1 && checkbox2 && !checkbox3) {
            correctAnswerNumber += 1;
        }
    }

    public void CheckQuestion3Answer(){
        RadioButton question3RadioButton1 = findViewById(R.id.Question3RadioButton1);
        boolean radiobutton1 = question3RadioButton1.isChecked();

        if (radiobutton1){
            correctAnswerNumber += 1;
        }
    }

    public void CheckQuestion4Answer(){
        RadioButton question4RadioButton2 = findViewById(R.id.Question4RadioButton2);
        boolean radiobutton2 = question4RadioButton2.isChecked();

        if (radiobutton2){
            correctAnswerNumber += 1;
        }
    }

    private void resetCorrectAnswers() {
        correctAnswerNumber = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            CheckQuestion1Answer();
            CheckQuestion2Answer();
            CheckQuestion3Answer();
            CheckQuestion4Answer();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswerNumber + "/4",
                    Toast.LENGTH_LONG).show();
            resetCorrectAnswers();
        }
    };
}
