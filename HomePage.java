package com.example.admin.elanlivelearningapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.admin.elanlivelearningapp.Bottom.AskFragment;
import com.example.admin.elanlivelearningapp.Bottom.ClassroomFragment;
import com.example.admin.elanlivelearningapp.Bottom.CoursesFragment;
import com.example.admin.elanlivelearningapp.Bottom.HomeFragment;
import com.example.admin.elanlivelearningapp.Bottom.MaterialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

public class HomePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {



    private AppBarConfiguration mAppBarConfiguration;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home_page);





        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottomnav);
        navigation.setOnNavigationItemSelectedListener(this);


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.classroom:
                fragment = new ClassroomFragment();
                break;

            case R.id.courses:
                fragment = new CoursesFragment();
                break;

            case R.id.materials:
                fragment = new MaterialFragment();
                break;

            case R.id.ASK:
                fragment = new AskFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
