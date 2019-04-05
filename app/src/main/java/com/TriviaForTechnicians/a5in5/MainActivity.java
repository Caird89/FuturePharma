package com.TriviaForTechnicians.a5in5;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Dialog epicDialog;
    Button buttomNext, buttomNext2;
    TextView textViewTitle, textViewTitle2, feedback, feedback2;
    TextView questionTextview;
    RadioGroup answersRadioGroup;
    RadioButton radioButton;
    FirebaseAuth authDb;
    DatabaseReference db;
    Button Submit;

    int score = 0;
    int questioncout = 0;
    String topic = "5in5";
    String questionA1;
    String questionA2;
    String questionA3;
    String questionA4;
    String questionA5;
    Boolean t;
    int t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authDb = FirebaseAuth.getInstance();
        if (authDb.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        //init
        questionTextview = findViewById(R.id.questionTextView);
        questionTextview.setMovementMethod(new ScrollingMovementMethod());
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        Submit = findViewById(R.id.submitButton);
        //testsubmit = (SubmitButton) findViewById(R.id.testSubmit);

        epicDialog = new Dialog(this);


        updatedQuestion();

    }

    private void showMe() {

        Toast.makeText(this, "Please select one answer", Toast.LENGTH_LONG).show();
    }

    private void ShowRightPopup(String reason) {
        epicDialog.setContentView(R.layout.custom_popup_correct);
        buttomNext = (Button) epicDialog.findViewById(R.id.buttomNext);
        textViewTitle = (TextView) epicDialog.findViewById(R.id.textViewTitle);
        feedback = (TextView) epicDialog.findViewById(R.id.Feedback);
        feedback.setMovementMethod(new ScrollingMovementMethod());
        feedback.setText(reason);
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
        buttomNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
                updatedQuestion();
            }
        });

    }

    private void ShowWrongPopup(String reason) {
        epicDialog.setContentView(R.layout.custom_popup_wrong);
        buttomNext2 = (Button) epicDialog.findViewById(R.id.buttomNext2);
        textViewTitle2 = (TextView) epicDialog.findViewById(R.id.textViewTitle2);
        feedback2 = (TextView) epicDialog.findViewById(R.id.Feedback2);
        feedback2.setMovementMethod(new ScrollingMovementMethod());
        feedback2.setText(reason);
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
        buttomNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
                updatedQuestion();
            }
        });

    }

    private void updatedQuestion() {
        questioncout++;


        if (questioncout > 5) {
            String resultId = db.push().getKey();
            String userName = authDb.getCurrentUser().getEmail();

            Result result = new Result(resultId, userName, topic, questionA1, questionA2, questionA3, questionA4, questionA5, score);
            db = FirebaseDatabase.getInstance().getReference("results");
            db.child(resultId).setValue(result);

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(intent);


        } else {
            db = FirebaseDatabase.getInstance().getReference().child("questions").child(String.valueOf(questioncout));
            db.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final question Question = dataSnapshot.getValue(question.class);
                    questionTextview.setText(Question.getquestion());


                    for (int i = 0; i < answersRadioGroup.getChildCount(); i++) {
                        if (i == 0) {
                            ((RadioButton) answersRadioGroup.getChildAt(i)).setText(Question.getanswerA());
                        } else if (i == 1) {
                            ((RadioButton) answersRadioGroup.getChildAt(i)).setText(Question.getanswerB());
                        } else if (i == 2) {
                            ((RadioButton) answersRadioGroup.getChildAt(i)).setText(Question.getanswerC());
                        } else {
                            ((RadioButton) answersRadioGroup.getChildAt(i)).setText(Question.getanswerD());
                        }

                    }


                    Submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int selectedId;


                                    selectedId = answersRadioGroup.indexOfChild(answersRadioGroup
                                    .findViewById(answersRadioGroup.getCheckedRadioButtonId()));
                            if (selectedId > -1) {

                                if (questioncout == 1) {
                                    if (selectedId == Question.getcurrect()) {
                                        questionA1 = "true";
                                        ShowRightPopup(Question.getreason());
                                        score++;
                                    } else {
                                        questionA1 = "false";
                                        ShowWrongPopup(Question.getreason());
                                    }
                                    answersRadioGroup.clearCheck();

                                }
                                if (questioncout == 2) {
                                    if (selectedId == Question.getcurrect()) {
                                        questionA2 = "true";
                                        score++;
                                        ShowRightPopup(Question.getreason());
                                    } else {
                                        questionA2 = "false";
                                        ShowWrongPopup(Question.getreason());
                                    }
                                    answersRadioGroup.clearCheck();
                                }
                                if (questioncout == 3) {
                                    if (selectedId == Question.getcurrect()) {
                                        questionA3 = "true";
                                        score++;
                                        ShowRightPopup(Question.getreason());
                                    } else {
                                        questionA3 = "false";
                                        ShowWrongPopup(Question.getreason());
                                    }
                                    answersRadioGroup.clearCheck();

                                }
                                if (questioncout == 4) {
                                    if (selectedId == Question.getcurrect()) {
                                        questionA4 = "true";
                                        score++;
                                        ShowRightPopup(Question.getreason());
                                    } else {
                                        questionA4 = "false";
                                        ShowWrongPopup(Question.getreason());
                                    }
                                    answersRadioGroup.clearCheck();

                                }
                                if (questioncout == 5) {
                                    if (selectedId == Question.getcurrect()) {
                                        questionA5 = "true";
                                        score++;
                                        ShowRightPopup(Question.getreason());
                                    } else {
                                        questionA5 = "false";
                                        ShowWrongPopup(Question.getreason());
                                    }
                                    answersRadioGroup.clearCheck();

                                }
                            } else {
                                showMe();
                            }
                        }

                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }


    }


    public void logout(View view) {
        authDb.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

}
