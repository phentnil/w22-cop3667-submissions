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
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    mLiveDrawingView = new LiveDrawingView(this, size.x, size.y);
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