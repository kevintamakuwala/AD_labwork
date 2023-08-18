package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.submit);
        EditText user=(EditText) findViewById(R.id.username),pwd=(EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us=user.getText().toString(),pw=pwd.getText().toString();
                if(us.equals("admin") && pw.equals("123"))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent=new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }


}