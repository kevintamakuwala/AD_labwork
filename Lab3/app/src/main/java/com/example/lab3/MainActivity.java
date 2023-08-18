package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

        Intent intent;
        intent = new Intent(MainActivity.this,Home.class);

        SharedPreferences pref = getSharedPreferences("user_details", MODE_PRIVATE);

        if (pref.contains("username") && pref.contains("password")) {
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us=user.getText().toString(),pw=pwd.getText().toString();
                if(us.equals("kevin") && pw.equals("google"))
                {

                    Toast toast=Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT);
                    toast.show();

                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", us);
                    editor.putString("password", pw);
                    editor.commit();

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