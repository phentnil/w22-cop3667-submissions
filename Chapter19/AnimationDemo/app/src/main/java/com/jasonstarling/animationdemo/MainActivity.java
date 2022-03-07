package com.jasonstarling.animationdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {
  Animation animFadeIn;
  Animation animFadeOut;
  Animation animFadeInOut;
  Animation animZoomIn;
  Animation animZoomOut;
  Animation animLeftRight;
  Animation animRightLeft;
  Animation animTopBottom;
  Animation animBounce;
  Animation animFlash;
  Animation animRotateLeft;
  Animation animRotateRight;
  ImageView imageView;
  TextView textStatus;
  Button btnFadeIn;
  Button btnFadeOut;
  Button btnFadeInOut;
  Button zoomIn;
  Button zoomOut;
  Button leftRight;
  Button rightLeft;
  Button topBottom;
  Button bounce;
  Button flash;
  Button rotateLeft;
  Button rotateRight;
  SeekBar seekBarSpeed;
  TextView textSeekerSpeed;
  int seekSpeedProgress;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loadAnimations();
    loadUI();
  }

  private void loadAnimations() {
    animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
    animFadeIn.setAnimationListener(this);
    animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
    animFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out);
    animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
    animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
    animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
    animRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left);
    animTopBottom = AnimationUtils.loadAnimation(this, R.anim.top_bot);
    animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
    animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);
    animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
    animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right);
  }

  private void loadUI() {
    imageView = (ImageView) findViewById(R.id.imageView);
    textStatus = (TextView) findViewById(R.id.textStatus);
    textStatus.setText(getString(R.string.text_status_stopped));

    btnFadeIn = (Button) findViewById(R.id.btnFadeIn);
    btnFadeOut = (Button) findViewById(R.id.btnFadeOut);
    btnFadeInOut = (Button) findViewById(R.id.btnFadeInOut);
    zoomIn = (Button) findViewById(R.id.btnZoomIn);
    zoomOut = (Button) findViewById(R.id.btnZoomOut);
    leftRight = (Button) findViewById(R.id.btnLeftRight);
    rightLeft = (Button) findViewById(R.id.btnRightLeft);
    topBottom = (Button) findViewById(R.id.btnTopBottom);
    bounce = (Button) findViewById(R.id.btnBounce);
    flash = (Button) findViewById(R.id.btnFlash);
    rotateLeft = (Button) findViewById(R.id.btnRotateLeft);
    rotateRight = (Button) findViewById(R.id.btnRotateRight);

    btnFadeIn.setOnClickListener(this);
    btnFadeOut.setOnClickListener(this);
    btnFadeInOut.setOnClickListener(this);
    zoomIn.setOnClickListener(this);
    zoomOut.setOnClickListener(this);
    leftRight.setOnClickListener(this);
    rightLeft.setOnClickListener(this);
    topBottom.setOnClickListener(this);
    bounce.setOnClickListener(this);
    flash.setOnClickListener(this);
    rotateLeft.setOnClickListener(this);
    rotateRight.setOnClickListener(this);

    seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
    textSeekerSpeed = (TextView) findViewById(R.id.textSeekerSpeed);
    textSeekerSpeed.setText(String.valueOf(seekBarSpeed.getProgress()));
    seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

      @Override
      public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
        seekSpeedProgress = value;
        textSeekerSpeed.setText(String.format(String.valueOf(seekSpeedProgress), seekBarSpeed.getMax()));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
  }

  @Override
  public void onAnimationEnd(Animation animation) {
    textStatus.setText(getString(R.string.text_status_stopped));
  }

  @Override
  public void onAnimationRepeat(Animation animation) {
  }

  @Override
  public void onAnimationStart(Animation animation) {
    textStatus.setText(getString(R.string.text_status_running));
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.btnFadeIn) {
      animFadeIn.setDuration(seekSpeedProgress);
      animFadeIn.setAnimationListener(this);
      imageView.startAnimation(animFadeIn);
      return;
    }
    if (id == R.id.btnFadeOut) {
      animFadeOut.setDuration(seekSpeedProgress);
      animFadeOut.setAnimationListener(this);
      imageView.startAnimation(animFadeOut);
      return;
    }
    if (id == R.id.btnFadeInOut) {
      animFadeInOut.setDuration(seekSpeedProgress);
      animFadeInOut.setAnimationListener(this);
      imageView.startAnimation(animFadeInOut);
      return;
    }
    if (id == R.id.btnZoomIn) {
      animZoomIn.setDuration(seekSpeedProgress);
      animZoomIn.setAnimationListener(this);
      imageView.startAnimation(animZoomIn);
      return;
    }
    if (id == R.id.btnZoomOut) {
      animZoomOut.setDuration(seekSpeedProgress);
      animZoomOut.setAnimationListener(this);
      imageView.startAnimation(animZoomOut);
      return;
    }
    if (id == R.id.btnLeftRight) {
      animLeftRight.setDuration(seekSpeedProgress);
      animLeftRight.setAnimationListener(this);
      imageView.startAnimation(animLeftRight);
      return;
    }
    if (id == R.id.btnRightLeft) {
      animRightLeft.setDuration(seekSpeedProgress);
      animRightLeft.setAnimationListener(this);
      imageView.startAnimation(animRightLeft);
      return;
    }
    if (id == R.id.btnTopBottom) {
      animTopBottom.setDuration(seekSpeedProgress);
      animTopBottom.setAnimationListener(this);
      imageView.startAnimation(animTopBottom);
      return;
    }
    if (id == R.id.btnBounce) {/*
		   Divide seekSpeedProgress by 10 because with
		   the seekbar having a max value of 5000 it
		   will make the animations range between
		   almost instant and half a second
		   5000 /  10 = 500 milliseconds
		*/
      animBounce.setDuration(seekSpeedProgress / 10);
      animBounce.setAnimationListener(this);
      imageView.startAnimation(animBounce);
      return;
    }
    if (id == R.id.btnFlash) {
      animFlash.setDuration(seekSpeedProgress / 10);
      animFlash.setAnimationListener(this);
      imageView.startAnimation(animFlash);
      return;
    }
    if (id == R.id.btnRotateLeft) {
      animRotateLeft.setDuration(seekSpeedProgress);
      animRotateLeft.setAnimationListener(this);
      imageView.startAnimation(animRotateLeft);
      return;
    }
    if (id == R.id.btnRotateRight) {
      animRotateRight.setDuration(seekSpeedProgress);
      animRotateRight.setAnimationListener(this);
      imageView.startAnimation(animRotateRight);
    }
  }
}