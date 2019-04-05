package com.TriviaForTechnicians.a5in5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class topic_selection extends AppCompatActivity {

    FirebaseAuth authDb;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        authDb = FirebaseAuth.getInstance();
        if (authDb.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
//
//        Button quiz1 = (Button)findViewById(R.id.topic_1);
//        Button quiz2 = (Button)findViewById(R.id.topic_2);
//        Button quiz3 = (Button)findViewById(R.id.topic_3);
//        Button quiz4 = (Button)findViewById(R.id.topic_4);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

    }

    public void take_me_quiz1(View view)
    {
        //todo instead send to Steven's learning objectives page.
        Intent intent = new Intent(getApplicationContext(), LearningObjectives.class);
        startActivity(intent);
    }
    public void take_me_quiz2(View view)
    {
        Toast.makeText(this, "The quiz is coming soon.", Toast.LENGTH_LONG).show();
        //insert link to learning objectives / other set of questions here.
    }
    public void take_me_quiz3(View view)
    {
        Toast.makeText(this, "The quiz is coming soon.", Toast.LENGTH_LONG).show();
        //insert link to learning objectives / other set of questions here.
    }
    public void take_me_quiz4(View view)
    {
        Toast.makeText(this, "The quiz is coming soon.", Toast.LENGTH_LONG).show();
        //insert link to learning objectives / other set of questions here.
    }







    public void logout(View view) {
        authDb.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void take_me_to_history(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(intent);
    }


}


