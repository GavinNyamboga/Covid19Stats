package com.dev.covid19stats;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.dev.covid19stats.ui.CountryFragment;
import com.dev.covid19stats.ui.GlobalFragment;
import com.dev.covid19stats.ui.InfoFragment;
import com.dev.covid19stats.ui.NewsFragment;
import com.dev.covid19stats.ui.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;


public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        loadFragment(new GlobalFragment());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

       // getSupportActionBar().hide();



    }
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.navigation_global:
                fragment = new GlobalFragment();
                break;
            case R.id.navigation_country:
                fragment = new CountryFragment();
                break;
            case R.id.navigation_news:
                fragment = new NewsFragment();
                break;
            case R.id.navigation_info:
                fragment = new InfoFragment();
                break;
            case R.id.navigation_search:
                fragment = new SearchFragment();
                break;
        }
        return loadFragment(fragment);
    }

}
