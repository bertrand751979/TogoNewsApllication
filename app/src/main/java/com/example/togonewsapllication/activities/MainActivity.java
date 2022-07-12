package com.example.togonewsapllication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.togonewsapllication.R;
import com.example.togonewsapllication.fragments.FranceNewsFavoriFragment;
import com.example.togonewsapllication.fragments.FranceTopNewsFragment;
import com.example.togonewsapllication.fragments.GlobalFranceNewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    public static String ARTICLE_EXTRA = "article_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GlobalFranceNewsFragment()).commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNav.setSelectedItemId(R.id.nav_news);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_news:
                    selectedFragment = new GlobalFranceNewsFragment();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.nav_top_news:
                    selectedFragment = new FranceTopNewsFragment();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.nav_favorite:
                    selectedFragment = new FranceNewsFavoriFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

}