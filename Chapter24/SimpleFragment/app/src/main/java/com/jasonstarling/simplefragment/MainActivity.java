package com.jasonstarling.simplefragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a FragmentManager
    FragmentManager fManager = getSupportFragmentManager();

    /* Create a new fragment using the manager,
     * passing in the id of the layout to hold it. */
    Fragment frag = fManager.findFragmentById(R.id.fragmentHolder);

    // Check that fragment has not been initialized
    if (frag == null) {
      // Initialize the fragment as SimpleFragment
      frag = new SimpleFragment();
      fManager.beginTransaction().add(R.id.fragmentHolder, frag).commit();
    }
  }
}