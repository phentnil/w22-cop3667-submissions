package com.jasonstarling.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
  implements NavigationView.OnNavigationItemSelectedListener {
  private Symptom mTempSymptom;
  private Food mTempFood;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
      this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    /*Button btnAddFoodEntry = findViewById(R.id.btnAddFood);
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
    });*/
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    int id = item.getItemId();

    // Check for specific nav ids here
    if (id == R.id.nav_add_food) {
      // Switch to add food fragment
      AddFoodFragment fragment = new AddFoodFragment();
      transaction.replace(R.id.fragmentHolder, fragment);
      Log.i("navigationItem", "AddFood");
    } else if (id == R.id.nav_add_symptom) {
      // Switch to add symptom fragment
      Log.i("navigationItem", "AddSymptom");
    } else if (id == R.id.nav_show_foods) {
      // Switch to show foods fragment
      Log.i("navigationItem", "ShowFoods");
    } else if (id == R.id.nav_show_symptoms) {
      // Switch to show symptoms fragment
      Log.i("navigationItem", "ShowSymptoms");
    }

    transaction.addToBackStack(null);
    transaction.commit();

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  /*public void createNewSymptom(Symptom newSymptom) {
    mTempSymptom = newSymptom;
  }

  public void createNewFood(Food newFood) {
    mTempFood = newFood;
  }*/
}