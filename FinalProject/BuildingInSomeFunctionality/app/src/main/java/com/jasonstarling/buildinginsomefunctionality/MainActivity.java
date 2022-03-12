package com.jasonstarling.buildinginsomefunctionality;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  /* Todo: Create two columns; one for food entries, other for symptoms
   *
   * Suggestion from Final Project - Designing the User Interface:
   *
   * I just wanted to take a sec to say that, as a person with about 50 billion food
   * sensitivities, I truly appreciate your app! It would be super cool if your View
   * buttons could do "View By Food" and "View By Symptom" and show a two column
   * sorted list with Food | Symptom, instead of just viewing entered foods or
   * entered symptoms. Maybe storing foods in one array and symptoms in another?
   * Either way, I really like where you're headed!!
   *  */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
      .setAction("Action", null).show());

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
      this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.

    // Create a transaction
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    int id = item.getItemId();

    if (id == R.id.nav_insert_food) {
      // Create a new fragment of the appropriate type
      InsertFoodFragment fragment = new InsertFoodFragment();
      // What to do and where to do it
      transaction.replace(R.id.fragmentHolder, fragment);

    } else if (id == R.id.nav_insert_symptom) {
      // Create a new fragment of the appropriate type
      InsertSymptomFragment fragment = new InsertSymptomFragment();
      // What to do and where to do it
      transaction.replace(R.id.fragmentHolder, fragment);

    } else if (id == R.id.nav_search) {
      SearchFragment fragment = new SearchFragment();
      transaction.replace(R.id.fragmentHolder, fragment);

    } else if (id == R.id.nav_delete) {
      DeleteFragment fragment = new DeleteFragment();
      transaction.replace(R.id.fragmentHolder, fragment);

    } else if (id == R.id.nav_results_foods) {
      ResultsFoodsFragment fragment = new ResultsFoodsFragment();
      transaction.replace(R.id.fragmentHolder, fragment);

    } else if (id == R.id.nav_results_symptoms) {
      ResultsSymptomsFragment fragment = new ResultsSymptomsFragment();
      transaction.replace(R.id.fragmentHolder, fragment);

    }

    // Ask Android to remember which
    // menu options the user has chosen
    transaction.addToBackStack(null);

    // Implement the change
    transaction.commit();

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}