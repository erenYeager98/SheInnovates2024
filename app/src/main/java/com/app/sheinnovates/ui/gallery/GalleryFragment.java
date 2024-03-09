package com.app.sheinnovates.ui.gallery;
import com.app.sheinnovates.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.sheinnovates.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private EditText editTextPrincipal, editTextRate, editTextTime;
    private Button buttonCalculate;
    private TextView textViewResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Initialize views
        editTextPrincipal = root.findViewById(R.id.editTextPrincipal);
        editTextRate = root.findViewById(R.id.editTextRate);
        editTextTime = root.findViewById(R.id.editTextTime);
        buttonCalculate = root.findViewById(R.id.buttonCalculate);
        textViewResult = root.findViewById(R.id.textViewResult);

        // Set button click listener
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCompoundInterest();
            }
        });

        return root;
    }

    private void calculateCompoundInterest() {
        try {
            double principal = Double.parseDouble(editTextPrincipal.getText().toString());
            double rate = Double.parseDouble(editTextRate.getText().toString());
            double time = Double.parseDouble(editTextTime.getText().toString());

            double amount = principal * Math.pow(1 + (rate / 100), time);
            double compoundInterest = amount - principal;

            textViewResult.setText("Compound Interest: " + compoundInterest);
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input. Please enter valid numbers.");
        }
    }
}
