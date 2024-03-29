package com.TriviaForTechnicians.a5in5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class LearningObjectives extends AppCompatActivity {

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




    public void GoHome(View view) {
        Intent intent = new Intent (this, topic_selection.class);
        startActivity(intent);
    }

    public void take_me_to_history(View view)
    {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void GoStudyCase1(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/page/get-coverage-prescription-drugs#_Living_in_a");
        startActivity(intent);


    }
    public void GoStudyCase2(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/page/get-coverage-prescription-drugs#_Living_in_a");
        startActivity(intent);

    }
    public void GoStudyCase3(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/laws/statute/04p03?fbclid=IwAR1HOD48YbA5XxIsxPqgXChZlS1SeCghPQKwrg37MiI4ANXW6EtmW1UVne8");
        startActivity(intent);

    }
    public void GoStudyCase4(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/laws/statute/90p23?fbclid=IwAR1GoGcOzLZXpOwBzPYshBRw5sP6Jl4jpOJN5nGl8RtWdXuulmaRoahz69k");
        startActivity(intent);

    }
    public void GoStudyCase5(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/page/learn-about-ohip-plus?fbclid=IwAR07ikrJRL2QNnm2WarOQ92z_VmXzIYx7v5IlL8Xhans-nA28yLzHVEl42Y#section-2");
        startActivity(intent);
    }


}
