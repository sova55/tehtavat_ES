package com.example.myfirsthttpdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

private class lataaNettiSivu extends AsyncTask<String,Integer,String> {
    protected Long doInBackground() {

        try {
            EditText nettiSivuKentta = (EditText)findViewById
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            String htmlText = Utilities.fromStream(in);
            TextView textView = (TextView)(R.id.httpTextView);
            textView.setText(htmlText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    protected void onProgressUpdate() {

    }

    protected void onPostExecute() {

    }
}

}
