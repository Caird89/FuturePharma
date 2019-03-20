package com.example.a5in5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    // declare
    FirebaseAuth authDb;
    EditText emailEditText, passwordEditText;
    ProgressDialog progressDialog;
    Button LoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // init
        authDb = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        progressDialog = new ProgressDialog(this);
        LoginButton = findViewById(R.id.loginButton);
        // redirect to main activity if user is already logged in
        if (authDb.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), ResultActivity.class));
        }
    }

    public void showRegisterActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    public void loginUser(View view) {
        // get inputs
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // validate
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Invalid password", Toast.LENGTH_LONG).show();
            return;
        }

        // authenticate
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        authDb.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}