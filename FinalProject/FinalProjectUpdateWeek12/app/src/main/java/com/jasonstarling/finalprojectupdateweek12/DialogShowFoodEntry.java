package com.jasonstarling.finalprojectupdateweek12;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogShowFoodEntry extends DialogFragment {
  private Food mFood;

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();
    View dialogView = inflater.inflate(R.layout.dialog_show_food_entry, null);
    TextView txtTitle = dialogView.findViewById(R.id.txtTitle);
    txtTitle.setText(mFood.getFoodName());
    Button btnOK = dialogView.findViewById(R.id.btnOK);
    builder.setView(dialogView).setMessage("Your Food Entry");
    btnOK.setOnClickListener(view -> dismiss());

    return builder.create();
  }

  public void sendFoodEntry(Food mTempFood) {
    mFood = mTempFood;
  }
}
