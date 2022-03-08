package com.jasonstarling.agedatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ResultsFragment extends Fragment {
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.content_results, container, false);

    // Create an instance of our DataManager
    DataManager dm = new DataManager(getActivity());

    // Get a reference to the TextView to show the results in
    TextView textResults = v.findViewById(R.id.textResults);

    // Create and initialize a Cursor with all the results in
    Cursor c = dm.selectAll();

    // A String to hold all the text
    StringBuilder list = new StringBuilder();

    // Loop through the results in the Cursor
    while (c.moveToNext()) {
      // Add the results to the String
      // with a little formatting
      list.append(c.getString(1)).append(" - ").append(c.getString(2)).append("\n");
    }

    // Display the String in the TextView
    textResults.setText(list.toString());
    return v;
  }
}