package com.jasonstarling.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jasonstarling.finalproject.databinding.FragmentFirstBinding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

  public FragmentFirstBinding binding;

  @Override
  public View onCreateView(
    @NonNull LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState
  ) {

    binding = FragmentFirstBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    binding.buttonFirst.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
      .navigate(R.id.action_FirstFragment_to_SecondFragment));
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}