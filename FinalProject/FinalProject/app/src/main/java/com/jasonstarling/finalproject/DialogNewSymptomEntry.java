package com.jasonstarling.finalproject;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogNewSymptomEntry extends DialogFragment {
  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

    LayoutInflater inflater = requireActivity().getLayoutInflater();

    View dialogView = inflater.inflate(R.layout.dialog_new_symptom_entry, null);

    final EditText editSymptom = dialogView.findViewById(R.id.txtAddSymptom);
    Button btnAdd = dialogView.findViewById(R.id.btnAddSymptom);
    Button btnCancel = dialogView.findViewById(R.id.btnSymptomCancel);

    builder.setView(dialogView).setMessage("Add a new symptom");

    btnCancel.setOnClickListener(v -> dismiss());

    btnAdd.setOnClickListener(v -> {
      Symptom newSymptom = new Symptom();
      newSymptom.setSymptomName(editSymptom.getText().toString());

      MainActivity callingActivity = (MainActivity) getActivity();
      assert callingActivity != null;
      //callingActivity.createNewSymptom(newSymptom);

      dismiss();
    });

    return builder.create();
  }
}
