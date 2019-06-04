package com.example.gymglish_test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login");

        Button button = findViewById(R.id.login_button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                EditText usernameField = findViewById(R.id.username_text);
                EditText passwordField = findViewById(R.id.password_text);
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                Context context = getApplicationContext();


                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (!isFinishing()){
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("Error")
                                        .setMessage("Username and password can not be blank")
                                        .setCancelable(true)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                // Whatever...
                                            }
                                        })
                                        .show();
                            }
                        }
                    });

                }else if(!username.equals("test") || !password.equals("12345")){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (!isFinishing()){
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("Error")
                                        .setMessage("Wrong Credentials")
                                        .setCancelable(true)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                // Whatever...
                                            }
                                        })
                                        .show();
                            }
                        }
                    });


                }else{

                    Intent myIntent = new Intent(MainActivity.this, ListActivity.class);
                    MainActivity.this.startActivity(myIntent);

                }
            }
        });
    }
}
