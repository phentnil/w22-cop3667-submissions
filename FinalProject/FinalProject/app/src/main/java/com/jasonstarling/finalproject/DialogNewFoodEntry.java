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

public class DialogNewFoodEntry extends DialogFragment {
  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

    LayoutInflater inflater = requireActivity().getLayoutInflater();

    View dialogView = inflater.inflate(R.layout.dialog_new_food_entry, null);

    final EditText editFood = dialogView.findViewById(R.id.txtAddFood);
    Button btnAdd = dialogView.findViewById(R.id.btnAddFood);
    Button btnCancel = dialogView.findViewById(R.id.btnFoodCancel);

    builder.setView(dialogView).setMessage("Add a new food");

    btnCancel.setOnClickListener(v -> dismiss());

    btnAdd.setOnClickListener(v -> {
      Food newFood = new Food();
      newFood.setFoodName(editFood.getText().toString());

      MainActivity callingActivity = (MainActivity) getActivity();
      assert callingActivity != null;
      callingActivity.createNewFood(newFood);

      dismiss();
    });

    return builder.create();
  }
}
