package com.jasonstarling.buildinginsomefunctionality;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class InsertSymptomFragment extends Fragment {
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.content_insert_symptom, container, false);
    final DataManager dm = new DataManager(getActivity());
    Button btnInsert = v.findViewById(R.id.btnInsert);
    final EditText editSymptom = v.findViewById(R.id.editSymptom);
    btnInsert.setOnClickListener(v1 -> dm.insert(editSymptom.getText().toString(), DataManager.DataType.SYMPTOM));
    return v;
  }
}