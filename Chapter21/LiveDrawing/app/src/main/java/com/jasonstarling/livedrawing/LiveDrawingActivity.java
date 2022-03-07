package com.jasonstarling.livedrawing;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;

public class LiveDrawingActivity extends Activity {
  private LiveDrawingView mLiveDrawingView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Using no title bar
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    // Set up the Display
    Display display = getWindowManager().getDefaultDisplay();

    // Get a Point, which holds two integer coordinates
    Point size = new Point();

    // Save the display size to our Point
    display.getSize(size);

    // Set up our LiveDrawingView with the Point size instance
    mLiveDrawingView = new LiveDrawingView(this, size.x, size.y);

    // Set up the ContentView with our LiveDrawingView instance
    setContentView(mLiveDrawingView);
  }

  @Override
  protected void onResume() {
    super.onResume();
    mLiveDrawingView.resume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mLiveDrawingView.pause();
  }
}