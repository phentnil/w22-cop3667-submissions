package com.jasonstarling.lifecycledemo;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.jasonstarling.lifecycledemo.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);

    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    binding.fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show();
      }
    });
    Toast.makeText(this, "In onCreate", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onCreate");
  }

  @Override
  public void onStart() {
    // First call the "official" version of this method
    super.onStart();

    Toast.makeText(this, "In onStart", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onStart");
  }

  @Override
  public void onResume() {
    // First call the "official" version of this method
    super.onResume();

    Toast.makeText(this, "In onResume", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onResume");
  }

  @Override
  public void onPause(){
    // First call the "official" version of this method
    super.onPause();

    Toast.makeText(this, "In onPause", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onPause");
  }

  @Override
  public void onStop(){
    // First call the "official" version of this method
    super.onStop();

    Toast.makeText(this, "In onStop", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onStop");
  }

  @Override
  public void onDestroy(){
    // First call the "official" version of this method
    super.onDestroy();

    Toast.makeText(this, "In onDestroy", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onDestroy");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    Toast.makeText(this, "In onCreateOptionsMenu", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onCreateOptionsMenu");
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    Toast.makeText(this, "In onOptionsItemSelected", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onOptionsItemSelected");
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
  public boolean onSupportNavigateUp() {
    Toast.makeText(this, "In onSupportNavigateUp", Toast.LENGTH_SHORT).show();
    Log.i("info", "In onSupportNavigateUp");
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
      || super.onSupportNavigateUp();
  }
}