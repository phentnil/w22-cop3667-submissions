package com.jasonstarling.buildinginsomefunctionality;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

public class DeleteFragment extends Fragment {
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.content_delete, container, false);
    final DataManager dm = new DataManager(getActivity());
    Button btnDelete = v.findViewById(R.id.btnDelete);
    RadioButton radioButtonSymptom = v.findViewById(R.id.radioButtonSymptom);
    DataManager.DataType x = DataManager.DataType.FOOD;
    if (radioButtonSymptom.isChecked()) {
      x = DataManager.DataType.SYMPTOM;
    }
    final EditText editDelete = v.findViewById(R.id.editDelete);
    DataManager.DataType finalX = x;
    btnDelete.setOnClickListener(v1 -> dm.delete(editDelete.getText().toString(), finalX));
    return v;
  }
}
