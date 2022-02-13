package com.jasonstarling.exploringmethodoverloading;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  int answer = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Declare and initialize a String and an int
    int anInt = 10;
    String aString = "I am a string";

    // Now call the different versions of printStuff
    // The name stays the same, only the parameters vary
    printStuff(anInt);
    printStuff(aString);
    printStuff(anInt, aString);

    // Call the computeSum method with a target value of 10
    computeSum(10);
  }

  void printStuff(int myInt) {
    Log.i("info", "This is the int only version");
    Log.i("info", "myInt = " + myInt);
  }

  void printStuff(String myString) {
    Log.i("info", "This is the String only version");
    Log.i("info", "myString = " + myString);
  }

  void printStuff(int myInt, String myString) {
    Log.i("info", "This is the combined int and String version");
    Log.i("info", "myInt = " + myInt);
    Log.i("info", "myString = " + myString);
  }

  void computeSum(int target) {
    answer += target;
    if (target > 0) {
      Log.d("target = ", "" + target);
      computeSum(target - 1);
      /** Added a void return so that it doesn't print too many answer lines
       *  while exiting the recursion */
      return;
    }
    Log.d("answer = ", "" + answer);
  }
}