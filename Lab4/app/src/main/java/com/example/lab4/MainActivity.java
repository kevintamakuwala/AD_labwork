package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button vote1=(Button) findViewById(R.id.vote1),vote2=(Button) findViewById(R.id.vote2);
        TextView candidate1Name=(TextView) findViewById(R.id.candidateName1),candidate2Name=(TextView) findViewById(R.id.candidateName2);
        Candidate candidate1=new Candidate("James Bond"),candidate2=new Candidate("Jack Sparrow");

        candidate1Name.setText(candidate1.getName());
        candidate2Name.setText(candidate2.getName());

        vote1.setOnClickListener(new View.OnClzickListener() {
            @Override
            public void onClick(View view) {
                candidate1.incrementVote();
                Toast.makeText(MainActivity.this, "Voted for "+candidate1.getName()+"\nVote Count: "+candidate1.getVote(), Toast.LENGTH_SHORT).show();
            }
        });
        vote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                candidate2.incrementVote();
                Toast.makeText(MainActivity.this, "Voted for "+candidate2.getName()+"\nVote Count: "+candidate2.getVote(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}