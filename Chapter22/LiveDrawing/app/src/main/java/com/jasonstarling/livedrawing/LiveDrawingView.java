package com.jasonstarling.livedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class LiveDrawingView extends SurfaceView implements Runnable {
  // Set whether we are debugging
  private final boolean DEBUGGING = true;

  // Set a constant for number of milliseconds per second
  private final int MILLIS_IN_SECOND = 1000;

  // Objects needed for drawing
  private final SurfaceHolder mOurHolder;
  private final Paint mPaint;
  // Screen resolution width
  private final int mScreenX;
  // Screen resolution height
  private final int mScreenY;
  // Use for the font size
  private final int mFontSize;
  // Use for the font margin
  private final int mFontMargin;
  // Set up maximum ParticleSystems
  private final int MAX_SYSTEMS = 1000;
  // Set up a paused flag
  private boolean mPaused = true;
  private Canvas mCanvas;
  // Save the frames per second
  private long mFPS;
  // Set up the Thread
  private Thread mThread = null;
  // Set up a drawing flag
  private volatile boolean mDrawing;
  // Use these to make simple buttons
  private RectF mResetButton;
  private RectF mTogglePauseButton;
  // Set up ArrayList to hold ParticleSystems
  private ArrayList<ParticleSystem> mParticleSystems = new ArrayList<>();
  private int mNextSystem = 0;
  private int mParticlesPerSystem = 100;

  // The constructor is called when LiveDrawingActivity calls new LiveDrawingView
  public LiveDrawingView(Context context, int x, int y) {
    // Call the parent class constructor of SurfaceView
    super(context);
    mScreenX = x;
    mScreenY = y;

    // Set font size to 5% (1/20) of screen width
    mFontSize = mScreenX / 20;

    // Set margin to 1.3% (1/75) of screen width
    mFontMargin = mScreenX / 75;

    // getHolder is a SurfaceView method
    mOurHolder = getHolder();

    // Initialize the Paint
    mPaint = new Paint();

    // Initialize the two buttons
    mResetButton = new RectF(0, 0, 100, 100);
    mTogglePauseButton = new RectF(150, 0, 250, 100);

    // Initialize the particles and their systems
    for (int i = 0; i < MAX_SYSTEMS; i++) {
      mParticleSystems.add(new ParticleSystem());
      mParticleSystems.get(i).init(mParticlesPerSystem);
    }
  }

  /* Starting this thread with
   * mThread.start()
   * the run() method is called by Android continuously
   * because we implemented the Runnable interface.
   * Calling mThread.join() will stop the thread. */
  @Override
  public void run() {
    /* mDrawing enables finer control rather than
     * relying on calls to run alone.
     * mDrawing must be true and the thread running
     * for the main loop to execute. */
    while (mDrawing) {
      // Get the time at the start of the loop
      long frameStartTime = System.currentTimeMillis();

      // If the app isn't paused, call the update method
      if (!mPaused) {
        update();
        // Particles are now in their new positions
      }

      // Movement handled, now we can draw the scene
      draw();

      // Determine the time taken in this frame/loop
      long timeThisFrame = System.currentTimeMillis() - frameStartTime;

      // Make sure time is greater than zero so we don't divide by zero
      if (timeThisFrame > 0) {
        /* Store the current frame rate in mFPS
         * ready to pass to the update methods of
         * our particles in the next frame/loop */
        mFPS = MILLIS_IN_SECOND / timeThisFrame;
      }
    }
  }

  private void update() {
    // Update the particles
    for (int i = 0; i < mParticleSystems.size(); i++) {
      if (mParticleSystems.get(i).mIsRunning) {
        mParticleSystems.get(i).update(mFPS);
      }
    }
  }

  // Draw the particle systems and the HUD
  private void draw() {
    if (mOurHolder.getSurface().isValid()) {
      // Lock the canvas (graphics memory) ready to draw
      mCanvas = mOurHolder.lockCanvas();

      // Fill the screen with a solid black
      mCanvas.drawColor(Color.argb(255, 0, 0, 0));

      // Choose a color to paint with (white)
      mPaint.setColor(Color.argb(255, 255, 255, 255));

      // Choose the font size
      mPaint.setTextSize(mFontSize);

      // Draw the particle systems
      for (int i = 0; i < mNextSystem; i++) {
        mParticleSystems.get(i).draw(mCanvas, mPaint);
      }

      // Draw the buttons
      // Set the reset button to red
      mPaint.setColor(Color.argb(255, 255, 0, 0));
      mCanvas.drawRect(mResetButton, mPaint);
      // Set the toggle pause button to green
      mPaint.setColor(Color.argb(255, 0, 255, 0));
      mCanvas.drawRect(mTogglePauseButton, mPaint);

      // Reset color to white
      mPaint.setColor(Color.argb(255, 255, 255, 255));

      if (DEBUGGING) {
        // Draw the HUD
        printDebuggingText();
      }

      // Display the drawing on screen
      mOurHolder.unlockCanvasAndPost(mCanvas);
    }
  }

  private void printDebuggingText() {
    int debugSize = mFontSize / 2;
    int debugStart = 150;
    mPaint.setTextSize(debugSize);
    mCanvas.drawText("FPS: " + mFPS, 10, debugStart + debugSize, mPaint);

    mCanvas.drawText("Systems: " + mNextSystem, 10, mFontMargin + debugStart + debugSize * 2, mPaint);
    mCanvas.drawText("Particles: " + mNextSystem * mParticlesPerSystem, 10, mFontMargin + debugStart + debugSize * 3, mPaint);
  }

  // Called when the user quits the app
  public void pause() {
    // We are no longer drawing
    mDrawing = false;
    try {
      // Attempt to stop the thread
      mThread.join();
    } catch (InterruptedException e) {
      Log.e("Error", "joining thread");
    }
  }

  // Called when the user starts the app
  public void resume() {
    // We are drawing again
    mDrawing = true;

    // Set up a new instance of Thread
    mThread = new Thread(this);

    // Start the thread
    mThread.start();
  }

  @Override
  public boolean onTouchEvent(MotionEvent motionEvent) {
    // User moved a finger while touching the screen
    if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {
      mParticleSystems.get(mNextSystem).emitParticles(new PointF(motionEvent.getX(), motionEvent.getY()));
      mNextSystem++;
      if (mNextSystem == MAX_SYSTEMS) {
        mNextSystem = 0;
      }
    }

    // Did the user touch the screen?
    if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
      // User pressed the screen; was it on Reset button?
      if (mResetButton.contains(motionEvent.getX(), motionEvent.getY())) {
        // Clear the screen of all particles
        mNextSystem = 0;
      }

      // User pressed the screen; was it on Pause button?
      if (mTogglePauseButton.contains(motionEvent.getX(), motionEvent.getY())) {
        mPaused = !mPaused;
      }
    }
    return true;
  }
}
