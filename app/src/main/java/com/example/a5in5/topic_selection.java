package com.example.a5in5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class topic_selection extends AppCompatActivity {

    FirebaseAuth authDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        authDb = FirebaseAuth.getInstance();
        if (authDb.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

    }



    public void logout(View view) {
        authDb.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }


}
