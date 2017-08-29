package com.example.ricky.dicee;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create rollButton and initialization on two separate lines
        Button rollButton;
        rollButton = (Button) findViewById(R.id.rollButton);

        //create ImageView objects and cast the integer ID returned as type ImageView
        //final keyword means it will not be altered
        //R.id grabs ID defined in activity_main.xml
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);

        //create array of dice images
        //R.drawable means res>drawable folder
        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d takes a tag sting and a message string and outputs them as log.debug
                Log.d("Dicee","Pressed!!");

                //create new rng variable of type Random and initialize
                Random randomNumberGenerator = new Random();

                //store random number between 0-5 in number int
                int number = randomNumberGenerator.nextInt(6);

                //print to log
                Log.d("Dicee","This is the random number " + number);

                //grab random item from diceArray and set it as the leftDice image
                leftDice.setImageResource(diceArray[number]);

                //new random number for second dice
                number = randomNumberGenerator.nextInt(6);

                //grab random item from diceArray and set it as the rightDice image
                rightDice.setImageResource(diceArray[number]);
            }
        });
    }
}