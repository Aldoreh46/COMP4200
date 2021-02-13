package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


public class ExplicitActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editTextId);

    }
    public void submit(View view) {
        String data = editText.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra( "DATA", data);
        startActivity(intent);

    }

}
