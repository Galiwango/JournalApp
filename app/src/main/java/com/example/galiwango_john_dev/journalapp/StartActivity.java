package com.example.galiwango_john_dev.journalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    private Button btnReg, btnLog;

    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btnReg = (Button) findViewById(R.id.start_reg_btn);
        btnLog = (Button) findViewById(R.id.start_log_btn);

        fAuth = FirebaseAuth.getInstance();
        updateUI();

    }

    public void OpenLogin(View view) {
        Intent logIntent = new Intent(StartActivity.this, LoginActivity.class);
        startActivity(logIntent);
    }

    public void OpenReg(View view) {
        Intent regIntent = new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(regIntent);
    }
    private void updateUI(){
        if (fAuth.getCurrentUser() != null){
            Log.i("StartActivity", "fAuth != null");
            Intent startIntent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(startIntent);
            finish();
        } else {

            Log.i("StartActivity", "fAuth == null");
        }
    }
}
