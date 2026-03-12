package com.example.part_c;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText inputGuess;
    Button buttonGuess;
    TextView textMessage;

    int randomNumber;
    int attempts;

    Random random = new Random();

    void newGame(){
        randomNumber = random.nextInt(10) + 1;
        attempts = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputGuess = findViewById(R.id.inputGuess);
        buttonGuess = findViewById(R.id.buttonGuess);
        textMessage = findViewById(R.id.textMessage);

        newGame();

        buttonGuess.setOnClickListener(v -> {

            String input = inputGuess.getText().toString().trim();

            if(input.isEmpty()){
                textMessage.setText(getString(R.string.enter_integer));
                return;
            }

            int guess;

            try{
                guess = Integer.parseInt(input);
            }
            catch(Exception e){
                textMessage.setText(getString(R.string.enter_integer));
                return;
            }

            if(guess < 1 || guess > 10){
                textMessage.setText(getString(R.string.range_error));
                return;
            }

            attempts++;

            if(guess < randomNumber){
                textMessage.setText(getString(R.string.too_small));
            }
            else if(guess > randomNumber){
                textMessage.setText(getString(R.string.too_large));
            }
            else{

                if(attempts == 2){
                    textMessage.setText(getString(R.string.correct_second));
                }
                else{
                    textMessage.setText(getString(R.string.wrong_attempt));
                    newGame();
                }

            }

        });

    }
}