package com.jasonstarling.imagepager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
  ViewPager viewPager;
  PagerAdapter adapter;
  int[] images;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Grab the images and place them in our array
    images = new int[]{
      R.drawable.image1,
      R.drawable.image2,
      R.drawable.image3,
      R.drawable.image4,
      R.drawable.image5,
      R.drawable.image6
    };

    // Get a reference to the ViewPager
    viewPager = findViewById(R.id.pager);

    // Initialize our adapter
    adapter = new ImagePagerAdapter(MainActivity.this, images);

    // Bind the Adapter to the ViewPager
    viewPager.setAdapter(adapter);
  }
}