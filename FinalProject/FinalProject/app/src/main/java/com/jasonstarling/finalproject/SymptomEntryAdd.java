package com.jasonstarling.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jasonstarling.finalproject.databinding.FragmentSymptomEntryAddBinding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SymptomEntryAdd extends Fragment {
  private FragmentSymptomEntryAddBinding binding;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentSymptomEntryAddBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    binding.btnAdd.setOnClickListener(this::addSymptom);
    binding.btnCancel.setOnClickListener(this::loadMain);
  }

  private void addSymptom(View view) {
    loadMain(view);
  }

  private void loadMain(View view) {
    NavHostFragment.findNavController(SymptomEntryAdd.this).navigate(R.id.action_symptomFragment_to_mainFragment);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}