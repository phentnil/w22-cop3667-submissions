package com.jasonstarling.manipulatingbitmaps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
  ImageView myImageView;
  Bitmap myBlankBitmap;
  Bitmap bobBitmap;
  Canvas myCanvas;
  Paint myPaint;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int widthInPixels = 2000;
    int heightInPixels = 1000;

    // Create new Bitmap
    myBlankBitmap = Bitmap.createBitmap(widthInPixels, heightInPixels, Bitmap.Config.ARGB_8888);

    // Initialize Bob
    bobBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bob);

    // Initialize the Canvas with Bitmap to draw on
    myCanvas = new Canvas(myBlankBitmap);

    // Initialize the ImageView
    myImageView = new ImageView(this);

    // Initialize the Paint
    myPaint = new Paint();

    // Draw a blue background
    myCanvas.drawColor(Color.argb(255, 0, 0, 255));

    // Draw some bitmaps
    drawRotatedBitmaps();
    drawEnlargedBitmap();
    drawShrunkenBitmap();

    // Associate the Bitmap with the ImageView
    myImageView.setImageBitmap(myBlankBitmap);

    // Set our drawing as the view for this app
    setContentView(myImageView);
  }

  void drawRotatedBitmaps() {
    int horizontalPosition = 350;
    int verticalPosition = 25;
    Matrix matrix = new Matrix();
    Bitmap rotatedBitmap;
    for (float rotation = 0; rotation < 360; rotation += 30) {
      matrix.reset();
      matrix.preRotate(rotation);
      rotatedBitmap = Bitmap.createBitmap(bobBitmap, 0, 0, bobBitmap.getWidth() - 1, bobBitmap.getHeight() - 1, matrix, true);
      myCanvas.drawBitmap(rotatedBitmap, horizontalPosition, verticalPosition, myPaint);
      horizontalPosition += 120;
      verticalPosition += 70;
      rotation++;
    }
  }

  void drawEnlargedBitmap() {
    bobBitmap = Bitmap.createScaledBitmap(bobBitmap, 300, 400, false);
    myCanvas.drawBitmap(bobBitmap, 25, 25, myPaint);
  }

  void drawShrunkenBitmap() {
    bobBitmap = Bitmap.createScaledBitmap(bobBitmap, 50, 75, false);
    myCanvas.drawBitmap(bobBitmap, 250, 25, myPaint);
  }
}