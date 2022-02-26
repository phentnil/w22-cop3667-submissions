package com.jasonstarling.javameetui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  // An int variable to hold a value
  private int value = 0;

  // A bunch of Buttons and a TextView
  private Button btnAdd;
  private Button btnTake;
  private Button btnGrow;
  private Button btnShrink;
  private Button btnHide;
  private Button btnReset;
  private TextView txtValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a reference to all the buttons in our UI
    // Match them up to all our Button objects
    btnAdd = findViewById(R.id.btnAdd);
    btnTake = findViewById(R.id.btnTake);
    btnGrow = findViewById(R.id.btnGrow);
    btnShrink = findViewById(R.id.btnShrink);
    btnHide = findViewById(R.id.btnHide);
    btnReset = findViewById(R.id.btnReset);
    txtValue = findViewById(R.id.txtValue);

    // Listen for all the button clicks
    btnAdd.setOnClickListener(this);
    btnTake.setOnClickListener(this);
    btnGrow.setOnClickListener(this);
    btnShrink.setOnClickListener(this);
    btnHide.setOnClickListener(this);
    btnReset.setOnClickListener(this);
    txtValue.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    // A local variable to use later
    float size;

    switch (view.getId()) {
      case R.id.btnAdd:
        value++;
        txtValue.setText("" + value);
        break;
      case R.id.btnTake:
        value--;
        txtValue.setText("" + value);
        break;
      case R.id.btnGrow:
        size = txtValue.getTextScaleX();
        txtValue.setTextScaleX(size + 1);
        break;
      case R.id.btnShrink:
        size = txtValue.getTextScaleX();
        txtValue.setTextScaleX(size - 1);
        break;
      case R.id.btnHide:
        if (txtValue.getVisibility() == View.VISIBLE) {
          // Hide it
          txtValue.setVisibility(View.INVISIBLE);
          // Change the text on the button
          btnHide.setText("SHOW");
        } else {
          // Show it
          txtValue.setVisibility(View.VISIBLE);
          // Change button to "HIDE"
          btnHide.setText("HIDE");
        }
        break;
      case R.id.btnReset:
        value = 0;
        txtValue.setText("" + value);

        // Added the ability to reset the textScaleX property to 1.0
        txtValue.setTextScaleX(1.0F);
        break;
    }
  }
}