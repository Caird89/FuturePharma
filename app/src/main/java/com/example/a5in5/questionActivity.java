package com.example.a5in5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class questionActivity extends AppCompatActivity {
    DatabaseReference db;
    EditText topic;
    EditText qustion;
    EditText A;
    EditText B;
    EditText C;
    EditText D;
    EditText Currect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //init
        topic=findViewById(R.id.editTextTopic);
        qustion=findViewById(R.id.editTextQuestion);
        A=findViewById(R.id.editTextA);
        B=findViewById(R.id.editTextB);
        C=findViewById(R.id.editTextC);
        D=findViewById(R.id.editTextD);
        Currect=findViewById(R.id.editTextCurrect);
        //db connection & and reference to artists collection
        db= FirebaseDatabase.getInstance().getReference("questions");

    }

    public void CreatQuestion(View view) {
        String question=qustion.getText().toString().trim();
        String Topic=topic.getText().toString().trim();
        String a=A.getText().toString().trim();
        String b=B.getText().toString().trim();
        String c=C.getText().toString().trim();
        String d=D.getText().toString().trim();
        String qustionId = "5";
       // int currect= Integer.parseInt(Currect.getText().toString().trim());
        //question Question = new  question(qustionId, question, Topic,   a,b,  c,  d, reason,currect);
        //db.child(qustionId).setValue( Question );
    }
}
