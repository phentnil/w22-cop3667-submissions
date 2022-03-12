package com.jasonstarling.buildinginsomefunctionality;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class InsertFoodFragment extends Fragment {
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.content_insert_food, container, false);
    final DataManager dm = new DataManager(getActivity());
    // Todo: create entries with the date/time entered automatically
    Button btnInsert = v.findViewById(R.id.btnInsert);
    final EditText editFood = v.findViewById(R.id.editFood);
    btnInsert.setOnClickListener(v1 -> dm.insert(editFood.getText().toString(), DataManager.DataType.FOOD));
    return v;
  }
}