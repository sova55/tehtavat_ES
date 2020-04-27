package com.example.myfirsthttpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Button nappi = (Button)findViewById(R.id.button);
        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText urlKentta = (EditText)findViewById(R.id.editText);
                String teksti = urlKentta.getText().toString();


                loadFromWeb(teksti);

            }
        });


    }

    protected void loadFromWeb(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            String htmlText = Utilities.fromStream(in);
            TextView textView = findViewById(R.id.httpTextView);
            textView.setText(htmlText);
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
