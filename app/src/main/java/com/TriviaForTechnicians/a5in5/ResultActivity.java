package com.TriviaForTechnicians.a5in5;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    ListView listViewResults;
    DatabaseReference db;
    TextView topic;
    TextView score;

    TextView userName;
    List<Result> results;
    FirebaseAuth authDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listViewResults=findViewById(R.id.ListResult);
        userName=findViewById(R.id.textViewUserName);

        //db connection & and reference to artists collection

        authDb = FirebaseAuth.getInstance();
        userName.setText(authDb.getCurrentUser().getEmail());



        results= new ArrayList<>();
        listViewResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get position
                Result result= results.get(position);
                // create intent
                Intent intent =new Intent(getApplicationContext(),ResultDetails.class);

                String score= String.valueOf(result.getscore());


                intent.putExtra("question1",result.getq1());
                intent.putExtra("question2",result.getq2());
                intent.putExtra("question3",result.getq3());
                intent.putExtra("question4",result.getq4());
                intent.putExtra("question5",result.getq5());
                intent.putExtra("score",score);
                intent.putExtra("username",result.getuserName());
                intent.putExtra("topic",result.gettopic());
                intent.putExtra("resultId",result.getresultId());

                startActivity(intent);



            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        Query query = FirebaseDatabase.getInstance().getReference("results").orderByChild("userName")
                .equalTo(authDb.getCurrentUser().getEmail());
        //create listener for data changes
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //clear the data
                results.clear();

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Result result= postSnapshot.getValue(Result.class);
                    results.add(result);
                }

                //create data adapter and bind to list
                ResultList resultAdpter = new ResultList(ResultActivity.this,results);
                listViewResults.setAdapter(resultAdpter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void GoHome(View view) {
        Intent intent = new Intent (this, topic_selection.class);
        startActivity(intent);

    }
}
