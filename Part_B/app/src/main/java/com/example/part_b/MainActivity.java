package com.example.part_b;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button buttonGreet;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        buttonGreet = findViewById(R.id.buttonGreet);
        textResult = findViewById(R.id.textResult);

        buttonGreet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString().trim();

                if(name.isEmpty()){
                    textResult.setText("Introduce yourself.");
                }
                else{
                    textResult.setText("Hello, " + name);
                }

            }
        });

    }
}