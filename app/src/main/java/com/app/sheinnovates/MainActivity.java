package com.app.sheinnovates;//package com.app.sheinnovates;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import com.app.sheinnovates.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private String[] titles = {"Title 1", "Title 2", "Title 3"};
    private int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        // Loop through the data arrays to create CardViews dynamically
        for (int i = 0; i < titles.length; i++) {
            // Create a new CardView
            CardView cardView = new CardView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    getResources().getDimensionPixelSize(R.dimen.card_width),
                    getResources().getDimensionPixelSize(R.dimen.card_height)
            );
            layoutParams.setMargins(getResources().getDimensionPixelSize(R.dimen.card_margin), 0,
                    getResources().getDimensionPixelSize(R.dimen.card_margin), 0);
            cardView.setLayoutParams(layoutParams);

            // Set the content for the CardView
            cardView.setContentPadding(
                    getResources().getDimensionPixelSize(R.dimen.card_padding),
                    getResources().getDimensionPixelSize(R.dimen.card_padding),
                    getResources().getDimensionPixelSize(R.dimen.card_padding),
                    getResources().getDimensionPixelSize(R.dimen.card_padding)
            );

            // Inflate the layout for the CardView
            cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));

            // Add title to the CardView
            TextView titleTextView = new TextView(this);
            titleTextView.setText(titles[i]);

            // Add image to the CardView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResources[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            // Add title and image to the CardView
            cardView.addView(titleTextView);
            cardView.addView(imageView);

            // Add the CardView to the linear layout
            linearLayout.addView(cardView);
        }

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onSupportNavigateUp () {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }
    public void loadWebViewUrl(String url) {
        webView.loadUrl(url);
    }

}
