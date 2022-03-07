package com.jasonstarling.canvasdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
  ImageView myImageView;
  Bitmap myBlankBitmap;
  Canvas myCanvas;
  Paint myPaint;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Default size 800x600
    int widthInPixels = 800;
    int heightInPixels = 600;

    // Create a new Bitmap
    myBlankBitmap = Bitmap.createBitmap(widthInPixels, heightInPixels, Bitmap.Config.ARGB_8888);

    // Initialize Canvas with Bitmap
    myCanvas = new Canvas(myBlankBitmap);

    // Initialize ImageView
    myImageView = new ImageView(this);

    // Initialize Paint
    myPaint = new Paint();

    // Set entire Bitmap background color to blue
    myCanvas.drawColor(Color.argb(255, 0, 0, 255));

    // Set text size to 100 pixels
    myPaint.setTextSize(100);

    // Change paint to white
    myPaint.setColor(Color.argb(255, 255, 255, 255));

    // Draw some text
    myCanvas.drawText("Hello World!", 100, 100, myPaint);

    // Change paint to yellow
    myPaint.setColor(Color.argb(255, 212, 207, 62));

    // Draw a circle
    myCanvas.drawCircle(400, 250, 100, myPaint);

    // Set ImageView ImageBitmap with the BlankBitmap
    myImageView.setImageBitmap(myBlankBitmap);

    // Use our drawing as the view for this app
    setContentView(myImageView);
  }
}