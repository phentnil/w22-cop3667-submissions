package com.jasonstarling.javameetui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  // An int variable to hold a value
  private int value = 0;

  private Button btnHide;
  private TextView txtValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a reference to all the buttons in our UI
    // Match them up to all our Button objects
    Button btnAdd = findViewById(R.id.btnAdd);
    Button btnTake = findViewById(R.id.btnTake);
    Button btnGrow = findViewById(R.id.btnGrow);
    Button btnShrink = findViewById(R.id.btnShrink);
    btnHide = findViewById(R.id.btnHide);
    Button btnReset = findViewById(R.id.btnReset);
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
    int viewId = view.getId();

    if (viewId == R.id.btnAdd) {
      txtValue.setText(++value);
    }
    if (viewId == R.id.btnTake) {
      txtValue.setText(--value);
    }
    if (viewId == R.id.btnGrow) {
      size = txtValue.getTextScaleX();
      txtValue.setTextScaleX(size + 1);
    }
    if (viewId == R.id.btnShrink) {
      size = txtValue.getTextScaleX();
      txtValue.setTextScaleX(size - 1);
    }
    if (viewId == R.id.btnHide) {
      if (txtValue.getVisibility() == View.VISIBLE) {
        // Hide it
        txtValue.setVisibility(View.INVISIBLE);
        // Change button to "SHOW"
        btnHide.setText(getString(R.string.btnHide_show));
      } else {
        // Show it
        txtValue.setVisibility(View.VISIBLE);
        // Change button to "HIDE"
        btnHide.setText(getString(R.string.btnHide_hide));
      }
    }
    if (viewId == R.id.btnReset) {
      value = 0;
      txtValue.setText(value);

      // Added the ability to reset the textScaleX property to 1.0
      txtValue.setTextScaleX(1.0F);
    }
  }
}