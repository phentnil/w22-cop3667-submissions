package com.jasonstarling.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jasonstarling.finalproject.databinding.FragmentMainBinding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MainFragment extends Fragment {

  private FragmentMainBinding binding;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    binding = FragmentMainBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    binding.buttonAddFoodEntry.setOnClickListener(view1 -> NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_foodFragment));
    binding.buttonAddSymptomEntry.setOnClickListener(view2 -> NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_symptomFragment));
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}