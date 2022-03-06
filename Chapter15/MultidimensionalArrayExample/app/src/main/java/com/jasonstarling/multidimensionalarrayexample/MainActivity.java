package com.jasonstarling.multidimensionalarrayexample;

import android.os.Bundle;
import android.util.Log;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // A Random object for generating question numbers later
    Random randInt = new Random();

    // A variable to hold the random value generated
    int questionNumber;

    /* Declare and allocate in separate stages for clarity
     * but we don't have to */
    String[][] countriesAndCities;

    /* Set up a 2 dimensional array
     * Containing 5 arrays with 2 elements each
     * Perfect for 5 "What's the capital city" questions */
    countriesAndCities = new String[5][2];

    /* Now we load the questions and answers into our arrays
     * feel free to do this with less questions to save typing
     * But don't do more or you will get an exception */
    countriesAndCities[0][0] = "United Kingdom";
    countriesAndCities[0][1] = "London";

    countriesAndCities[1][0] = "USA";
    countriesAndCities[1][1] = "Washington";

    countriesAndCities[2][0] = "India";
    countriesAndCities[2][1] = "New Delhi";

    countriesAndCities[3][0] = "Brazil";
    countriesAndCities[3][1] = "Brasilia";

    countriesAndCities[4][0] = "Kenya";
    countriesAndCities[4][1] = "Nairobi";

    /* The country is stored at element 0
     * The capital is stored at element 1
     * Here are two variables that reflect this */
    final int country = 0;
    final int capital = 1;

    // A for loop to ask 3 questions
    for (int i = 0; i < 3; i++) {
      // Now we can get a random question number between 0 and 4
      questionNumber = randInt.nextInt(5);

      /* Ask the question and in this case just
       * give the answer for the sake of brevity */
      Log.i("info", "The capital of " + countriesAndCities[questionNumber][country]);
      Log.i("info", "is " + countriesAndCities[questionNumber][capital]);
    }
  }
}