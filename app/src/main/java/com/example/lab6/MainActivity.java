package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Next(View view){


        User user = new User();
        EditText lastname = findViewById(R.id.lastname);
        EditText first = findViewById(R.id.firstname);
        EditText email = findViewById(R.id.email);
        TextView error = findViewById(R.id.error);
        boolean flag = true;

        if(lastname.getText().toString().equals("")){
            lastname.getBackground().setTint(Color.parseColor("#d91a1a"));
            error.setText("Не все поля заполнены!");
            flag = false;
        }
        else {
            user.setLastname(lastname.getText().toString());
        }

        if(first.getText().toString().equals("")){
            first.getBackground().setTint(Color.parseColor("#d91a1a"));
            error.setText("Не все поля заполнены!");
            flag = false;
        }
        else {
            user.setFirstname(first.getText().toString());
        }

        if(email.getText().toString().equals("")){
            email.getBackground().setTint(Color.parseColor("#d91a1a"));
            error.setText("Не все поля заполнены!");
            flag = false;
        }
        else {
            user.setEmail(email.getText().toString());
        }

        if(flag){
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra(User.class.getSimpleName(), user);
            startActivity(intent);
        }

    }
}