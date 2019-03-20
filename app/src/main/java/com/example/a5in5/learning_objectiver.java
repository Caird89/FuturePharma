package com.example.a5in5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class learning_objectiver extends AppCompatActivity {

    FirebaseAuth authDb;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        authDb = FirebaseAuth.getInstance();
        if (authDb.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        Button gogogo = (Button)findViewById(R.id.gogogo);
        Button quiz2 = (Button)findViewById(R.id.topic_2);
        Button quiz3 = (Button)findViewById(R.id.topic_3);
        Button quiz4 = (Button)findViewById(R.id.topic_4);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_objectiver);

    }

    public void start_quiz(View view)
    {
        //todo instead send to Steven's learning objectives page.
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void take_me_quiz2(View view)
    {
        //insert link to learning objectives / other set of questions here.
    }
    public void take_me_quiz3(View view)
    {
        //insert link to learning objectives / other set of questions here.
    }
    public void take_me_quiz4(View view)
    {
        //insert link to learning objectives / other set of questions here.
    }




    public void logout(View view) {
        authDb.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void take_me_to_history(View view)
    {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

}
