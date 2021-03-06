package com.jasonstarling.finalprojectupdateweek12;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private Symptom mTempSymptom;
  private Food mTempFood;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnAddFoodEntry = findViewById(R.id.btnAddFood);
    Button btnAddSymptomEntry = findViewById(R.id.btnAddSymptom);
    Button btnViewFoodEntry = findViewById(R.id.btnViewFood);
    Button btnViewSymptomEntry = findViewById(R.id.btnViewSymptom);

    btnAddFoodEntry.setOnClickListener(view -> {
      DialogNewFoodEntry dialog = new DialogNewFoodEntry();
      dialog.show(getSupportFragmentManager(), "");
    });
    btnAddSymptomEntry.setOnClickListener(view -> {
      DialogNewSymptomEntry dialog = new DialogNewSymptomEntry();
      dialog.show(getSupportFragmentManager(), "");
    });
    btnViewFoodEntry.setOnClickListener(view -> {
      DialogShowFoodEntry dialog = new DialogShowFoodEntry();
      dialog.sendFoodEntry(mTempFood);
      dialog.show(getSupportFragmentManager(), "123");
    });
    btnViewSymptomEntry.setOnClickListener(view -> {
      DialogShowSymptomEntry dialog = new DialogShowSymptomEntry();
      dialog.sendSymptomEntry(mTempSymptom);
      dialog.show(getSupportFragmentManager(), "123");
    });
  }

  public void createNewSymptom(Symptom newSymptom) {
    mTempSymptom = newSymptom;
  }

  public void createNewFood(Food newFood) {
    mTempFood = newFood;
  }
}