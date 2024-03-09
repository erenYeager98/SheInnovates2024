package com.app.sheinnovates.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.sheinnovates.MainActivity;
import com.app.sheinnovates.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.sheinnovates.R;

public class SlideshowFragment extends Fragment {

    private Button slideshowButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        slideshowButton = root.findViewById(R.id.openUrlButton);
        slideshowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });

        return root;
    }

    private void openWebView() {
        // Start the WebView activity
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.loadWebViewUrl("https://erenyeager98.github.io/");
        }
    }
}
