package com.TriviaForTechnicians.a5in5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        username.setText(intent.getStringExtra("username"));
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

    public void GoHome(View view) {
        Intent intent = new Intent (this, topic_selection.class);
        startActivity(intent);
    }

    public void GoFurtherCase1(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/laws/statute/90p23?fbclid=IwAR1GoGcOzLZXpOwBzPYshBRw5sP6Jl4jpOJN5nGl8RtWdXuulmaRoahz69k");
        startActivity(intent);

    }
    public void GoFurtherCase2(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/page/get-coverage-prescription-drugs?fbclid=IwAR0KmX9EGrf1piKGL0c-8O1QtOlg84mkpLcKcqEfR0VjQtBBiPS0LypJPrc#section-0");
        startActivity(intent);

    }
    public void GoFurtherCase3(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/page/learn-about-ohip-plus?fbclid=IwAR07ikrJRL2QNnm2WarOQ92z_VmXzIYx7v5IlL8Xhans-nA28yLzHVEl42Y#section-2");
        startActivity(intent);

    }
    public void GoFurtherCase4(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.ontario.ca/laws/statute/04p03?fbclid=IwAR1HOD48YbA5XxIsxPqgXChZlS1SeCghPQKwrg37MiI4ANXW6EtmW1UVne8");
        startActivity(intent);

    }
    public void GoFurtherCase5(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","http://www.ocpinfo.com/extra/Code-of-Ethics/?fbclid=IwAR26IqH56hoeJYyDyAywuUDsKo_5OwuLYw3AJpHsGlh7qlrtVkGezDzcDVQ#?page=6");
        startActivity(intent);

    }
    public void GoFurtherCase6(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","http://www.ocpinfo.com/registration/training-exams/jp-exam/jp-resources/e-learning-modules/didfa-module/");
        startActivity(intent);

    }
    public void GoFurtherCase7(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","http://www.ocpinfo.com/registration/training-exams/jp-exam/jp-resources/e-learning-modules/odb-module/");
        startActivity(intent);

    }
    public void GoFurtherCase8(View view) {
        Intent intent =new Intent(getApplicationContext(),CaseStudyActivity.class);
        intent.putExtra("case","https://www.thestar.com/news/canada/2018/06/30/ohip-to-no-longer-give-kids-young-adults-with-private-insurance-free-medication.html?fbclid=IwAR3enUV4I0YmaC9pE_Bp9pTfMwZM1prNR6HQbqy-V_1jDlENanwm4Qtlmio");
        startActivity(intent);
    }
}
