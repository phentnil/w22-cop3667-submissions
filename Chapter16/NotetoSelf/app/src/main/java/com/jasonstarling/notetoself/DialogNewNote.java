package com.jasonstarling.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogNewNote extends DialogFragment {
  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();
    View dialogView = inflater.inflate(R.layout.dialog_new_note, null);

    final EditText editTitle = dialogView.findViewById(R.id.editTitle);
    final EditText editDescription = dialogView.findViewById(R.id.editDescription);
    final CheckBox checkBoxIdea = dialogView.findViewById(R.id.checkBoxIdea);
    final CheckBox checkBoxTodo = dialogView.findViewById(R.id.checkBoxTodo);
    final CheckBox checkBoxImportant = dialogView.findViewById(R.id.checkBoxImportant);
    Button btnCancel = dialogView.findViewById(R.id.btnCancel);
    Button btnOK = dialogView.findViewById(R.id.btnOK);

    builder.setView(dialogView).setMessage("Add a new note");

    // Handle the Cancel button
    btnCancel.setOnClickListener(v -> dismiss());

    // Handle the OK button
    btnOK.setOnClickListener(v -> {
      // Create a new note
      Note newNote = new Note();

      // Set its variables to match entries on the form
      newNote.setTitle(editTitle.getText().toString());
      newNote.setDescription(editDescription.getText().toString());
      newNote.setIdea(checkBoxIdea.isChecked());
      newNote.setTodo(checkBoxTodo.isChecked());
      newNote.setImportant(checkBoxImportant.isChecked());

      // Get a reference to MainActivity
      MainActivity callingActivity = (MainActivity) getActivity();

      // Pass newNote back to MainActivity
      assert callingActivity != null;
      callingActivity.createNewNote(newNote);

      // Quit the dialog
      dismiss();
    });

    return builder.create();
  }
}
