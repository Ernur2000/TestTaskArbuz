package com.bolatovyernur.testtaskarbuz.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolatovyernur.testtaskarbuz.R;
import com.bolatovyernur.testtaskarbuz.databinding.FragmentOrderSuccessBinding;

public class OrderSuccessFragment extends Fragment {
    FragmentOrderSuccessBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderSuccessBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnContinue.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_orderSuccessFragment_to_mainFragment);
        });
    }
}