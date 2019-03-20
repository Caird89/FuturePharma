package com.example.a5in5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class ResultDetails extends AppCompatActivity {
    TextView Q1;
    TextView Q2;
    TextView Q3;
    TextView Q4;
    TextView Q5;
    TextView username;
    TextView topic;
    TextView score;
    ImageView ImageViewQuestion1,ImageViewQuestion2,ImageViewQuestion3,ImageViewQuestion4,ImageViewQuestion5;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_details);
        //init
        Q1=findViewById(R.id.textViewQ1);
        Q2=findViewById(R.id.textViewQ2);
        Q3=findViewById(R.id.textViewQ3);
        Q4=findViewById(R.id.textViewQ4);
        Q5=findViewById(R.id.textViewQ5);
        ImageViewQuestion1=findViewById(R.id.ImageViewQuestion1);
        ImageViewQuestion2=findViewById(R.id.ImageViewQuestion2);
        ImageViewQuestion3=findViewById(R.id.ImageViewQuestion3);
        ImageViewQuestion4=findViewById(R.id.ImageViewQuestion4);
        ImageViewQuestion5=findViewById(R.id.ImageViewQuestion5);
        username=findViewById(R.id.textViewUserName);
        topic=findViewById(R.id.textViewDetailsTopic);
        score=findViewById(R.id.textViewMyGrade);

        //
        Intent intent = getIntent();
        username.setText("UserName: "+intent.getStringExtra("username"));
        topic.setText(intent.getStringExtra("topic"));
        score.setText(intent.getStringExtra("score"));

            if(intent.getStringExtra("question1").equals("true")){
                ImageViewQuestion1.setImageResource(R.drawable.ic_done_black_24dp);
            }
            else {
                ImageViewQuestion1.setImageResource(R.drawable.ic_error_outline_black_24dp);
            }
        if(intent.getStringExtra("question2").equals("true")){
            ImageViewQuestion2.setImageResource(R.drawable.ic_done_black_24dp);
        }
        else {
            ImageViewQuestion2.setImageResource(R.drawable.ic_error_outline_black_24dp);
        }

        if(intent.getStringExtra("question3").equals("true")){
            ImageViewQuestion3.setImageResource(R.drawable.ic_done_black_24dp);
        }
        else {
            ImageViewQuestion3.setImageResource(R.drawable.ic_error_outline_black_24dp);
        }

        if(intent.getStringExtra("question4").equals("true")){
            ImageViewQuestion4.setImageResource(R.drawable.ic_done_black_24dp);
        }
        else {
            ImageViewQuestion4.setImageResource(R.drawable.ic_error_outline_black_24dp);
        }

        if(intent.getStringExtra("question5").equals("true")){
            ImageViewQuestion5.setImageResource(R.drawable.ic_done_black_24dp);
        }
        else {
            ImageViewQuestion5.setImageResource(R.drawable.ic_error_outline_black_24dp);
        }



        Q1.setText("Question 1: ");
        Q2.setText("Question 2: ");
        Q3.setText("Question 3: ");
        Q4.setText("Question 4: ");
        Q5.setText("Question 5: ");




    }
}
