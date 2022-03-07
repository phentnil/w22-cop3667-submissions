package com.jasonstarling.livedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LiveDrawingView extends SurfaceView implements Runnable {
  private final boolean DEBUGGING = true;
  private final int MILLIS_IN_SECOND = 1000;
  private SurfaceHolder mOurHolder;
  private Canvas mCanvas;
  private Paint mPaint;
  private long mFPS;
  private int mScreenX;
  private int mScreenY;
  private int mFontSize;
  private int mFontMargin;
  private Thread mThread = null;
  private volatile boolean mDrawing;
  private boolean mPaused = true;

  public LiveDrawingView(Context context, int x, int y) {
    super(context);
    mScreenX = x;
    mScreenY = y;
    mFontSize = mScreenX / 20;
    mFontMargin = mScreenX / 75;
    mOurHolder = getHolder();
    mPaint = new Paint();
  }

  @Override
  public void run() {
    while (mDrawing) {
      long frameStartTime = System.currentTimeMillis();
      if (!mPaused) {
        update();
      }
      draw();
      long timeThisFrame = System.currentTimeMillis() - frameStartTime;
      if (timeThisFrame > 0) {
        mFPS = MILLIS_IN_SECOND / timeThisFrame;
      }
    }
  }

  private void update() {
    //
  }

  private void draw() {
    if (mOurHolder.getSurface().isValid()) {
      mCanvas = mOurHolder.lockCanvas();
      mCanvas.drawColor(Color.argb(255, 0, 0, 0));
      mPaint.setColor(Color.argb(255, 255, 255, 255));
      mPaint.setTextSize(mFontSize);
      if (DEBUGGING) {
        printDebuggingText();
      }
      mOurHolder.unlockCanvasAndPost(mCanvas);
    }
  }

  private void printDebuggingText() {
    int debugSize = mFontSize / 2;
    int debugStart = 150;
    mPaint.setTextSize(debugSize);
    mCanvas.drawText("FPS: " + mFPS, 10, debugStart + debugSize, mPaint);
  }

  public void pause() {
    mDrawing = false;
    try {
      mThread.join();
    } catch (InterruptedException e) {
      Log.e("Error", "joining thread");
    }
  }

  public void resume() {
    mDrawing = true;
    mThread = new Thread(this);
    mThread.start();
  }
}
