package com.jasonstarling.devicedetection;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private TextView txtOrientation;
  private TextView txtResolution;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a reference to our TextView widgets
    txtOrientation = findViewById(R.id.txtOrientation);
    txtResolution = findViewById(R.id.txtResolution);
  }

  @SuppressLint("DefaultLocale")
  public void detectDevice(@SuppressWarnings("unused") View v) {
    // Get the orientation
    Display display = getWindowManager().getDefaultDisplay();
    txtOrientation.setText(String.valueOf(display.getRotation()));

    // Get the resolution
    Point xy = new Point();
    display.getSize(xy);
    txtResolution.setText(String.format("x = %d y = %d", xy.x, xy.y));
  }
}