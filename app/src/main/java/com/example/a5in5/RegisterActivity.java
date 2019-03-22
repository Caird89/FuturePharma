package com.example.a5in5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.spark.submitbutton.SubmitButton;

public class RegisterActivity extends AppCompatActivity {
    // declarations
    FirebaseAuth authDb;
    EditText emailEditText, passwordEditText, confirmEditText;
    Button registerButton;
    ProgressDialog progressDialog;
    TextView termsTextView;
    SubmitButton testsubmit;
    TextView titleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        // init
        authDb = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmEditText = findViewById(R.id.confirmEditText);
        progressDialog = new ProgressDialog(this);
        testsubmit = (SubmitButton) findViewById(R.id.testSubmit);
        titleAnimation();
    }

    public void registerUser(View view) {
        // get user inputs
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirm = confirmEditText.getText().toString();

        // validate inputs
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        if (!password.equals(confirm)) {
            Toast.makeText(this, "Please enter matching passwords", Toast.LENGTH_LONG).show();
            return;
        }

        // if valid, attempt to create user, and if succesfuly created it will take the user straight
        //to the main topic selection page.
        progressDialog.setMessage("Registering...");
        progressDialog.show();

        authDb.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Successfully Registered & Logged In", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
    public void titleAnimation(){
        titleTextView = findViewById(R.id.titleTextView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        titleTextView.startAnimation(animation);
    }
}
