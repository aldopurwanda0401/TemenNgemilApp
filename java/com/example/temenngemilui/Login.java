package com.example.temenngemilui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.temenngemilui.CustomAlertDialog.ErrorMessage;
import com.google.android.material.tabs.TabLayout;

public class Login extends AppCompatActivity {
EditText username,password;
TableRow tableRow1,tableRow2;
TextView textView;
Button btn_login;
LinearLayout linear;
float v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userkey = username.getText().toString();
                String passkey = password.getText().toString();
                if (userkey.equals("aldo")&&passkey.equals("aldo")){
                    trans(view);
                    finish();
                }else{
                    ErrorMessage errorMessage = new ErrorMessage(view,"USERNAME ATAU PASSWORD SALAH");
                }
            }
        });

        tableRow1 = findViewById(R.id.rowuser);
        tableRow2 = findViewById(R.id.rowpass);
        textView = findViewById(R.id.txtjudul);
        linear = findViewById(R.id.linear);

        tableRow1.setTranslationX(800);
        tableRow2.setTranslationX(800);
        textView.setTranslationX(800);
        btn_login.setTranslationX(800);
        linear.setTranslationY(900);

        tableRow1.setAlpha(v);
        tableRow2.setAlpha(v);
        textView.setAlpha(v);
        btn_login.setAlpha(v);
        linear.setAlpha(v);


        tableRow1.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        tableRow2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        textView.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        btn_login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        linear.animate().translationY(0).alpha(1).setDuration(900).setStartDelay(100).start();
    }
    public void trans(View view){
        Intent moveacti = new Intent(Login.this,MainActivity.class);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Toast.makeText(getApplicationContext(),"Welcome User",Toast.LENGTH_LONG).show();
        startActivity(moveacti,bundle);
    }
}