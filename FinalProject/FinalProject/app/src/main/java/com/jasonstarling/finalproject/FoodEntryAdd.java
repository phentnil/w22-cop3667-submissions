package com.jasonstarling.finalproject;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jasonstarling.finalproject.databinding.FragmentFoodEntryAddBinding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FoodEntryAdd extends Fragment {

  EditText foodEntry;
  private FragmentFoodEntryAddBinding binding;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentFoodEntryAddBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.btnAdd.setOnClickListener(this::addFood);
    binding.btnCancel.setOnClickListener(this::loadMain);
  }

  public void addFood(View v) {
    /*Editable foodEdit = foodEntry.getText();
    String foodValue = String.valueOf(foodEdit);
    Log.d("foodEntry", foodValue);*/
    loadMain(v);
  }

  public void loadMain(View v) {
    NavHostFragment.findNavController(FoodEntryAdd.this).navigate(R.id.action_foodFragment_to_mainFragment);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}