package com.jasonstarling.dynamicarrayexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Declare and allocate our array
    int[] ourArray = new int[1000];

    /* Let's initialize ourArray using a for loop
     * as more than a few variables is a lot of typing! */
    for (int i = 0; i < 1000; i++) {
      /* Put the value of `i * 5` into our array
       * at the position determined by i. */
      ourArray[i] = i * 5;

      // Output to show the current iteration
      Log.i("info", "i = " + i);
      Log.i("info", "ourArray[i] = " + ourArray[i]);
    }
  }
}