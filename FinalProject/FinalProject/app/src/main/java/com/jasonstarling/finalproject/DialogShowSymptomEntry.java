package com.jasonstarling.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogShowSymptomEntry extends DialogFragment {
  private Symptom mSymptom;

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();
    View dialogView = inflater.inflate(R.layout.dialog_show_symptom, null);
    TextView txtTitle = dialogView.findViewById(R.id.txtTitle);
    txtTitle.setText(mSymptom.getSymptomName());
    Button btnOK = dialogView.findViewById(R.id.btnOK);
    builder.setView(dialogView).setMessage("Your symptom entry");
    btnOK.setOnClickListener(view -> dismiss());
    return builder.create();
  }

  public void sendSymptomEntry(Symptom mTempSymptom) {
    mSymptom = mTempSymptom;
  }
}
