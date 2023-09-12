package com.example.lab8;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTaskRunner myAsyncTaskRunner = new MyAsyncTaskRunner();
                myAsyncTaskRunner.execute();
            }
        });


    }

    private class MyAsyncTaskRunner extends AsyncTask<String, String, String> {
        String response;
        ProgressDialog progressDialog = new ProgressDialog(MainActivity2.this);

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(String... s) {
            textView.setText(s[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping");
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    publishProgress(response = "Slept for " + (i + 1) + " Seconds");
                }
            } catch (Exception e) {
                response = e.getMessage();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        }
    }
}
