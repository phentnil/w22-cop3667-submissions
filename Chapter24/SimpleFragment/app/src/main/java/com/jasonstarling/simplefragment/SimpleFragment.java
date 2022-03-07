package com.jasonstarling.simplefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {
  String myString;
  Button myButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    myString = "Hello from SimpleFragment";
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_layout, container, false);
    myButton = view.findViewById(R.id.button);
    myButton.setOnClickListener(view1 -> Toast.makeText(getActivity(), myString, Toast.LENGTH_SHORT).show());
    return view;
  }
}
