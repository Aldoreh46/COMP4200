package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tview);

        Bundle dataIn = getIntent().getExtras();
        if (dataIn != null) {
            String data = dataIn.getString("DATA");
            textView.setText(data);
        }
    }

    public void ExplicitIntent(View view) {
        startActivity(new Intent(this, ExplicitActivity.class));
    }

    public void ImplicitIntent(View view) {

        Intent sendIntent;
        sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send");
        sendIntent.setType("text/plain");

        try {
            startActivity(sendIntent);
        }
        catch  (ActivityNotFoundException e){

        }
    }
}