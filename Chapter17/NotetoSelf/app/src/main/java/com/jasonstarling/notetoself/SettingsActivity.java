package com.jasonstarling.notetoself;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
  private SharedPreferences.Editor mEditor;
  private boolean mShowDividers;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);
    SharedPreferences mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
    mEditor = mPrefs.edit();
    mShowDividers = mPrefs.getBoolean("dividers", true);
    SwitchMaterial switch1 = findViewById(R.id.switch1);

    // Set the switch on or off as appropriate
    switch1.setChecked(mShowDividers);
    switch1.setOnCheckedChangeListener(
      (buttonView, isChecked) -> {
        if (isChecked) {
          mEditor.putBoolean("dividers", true);
          mShowDividers = true;
        } else {
          mEditor.putBoolean("dividers", false);
          mShowDividers = false;
        }
      }
    );
  }

  @Override
  protected void onPause() {
    super.onPause();
    mEditor.commit();
  }
}