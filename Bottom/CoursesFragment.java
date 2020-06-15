package com.example.admin.elanlivelearningapp.Bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.elanlivelearningapp.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/**
 * Created by Belal on 1/23/2018.
 */

public class CoursesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
         View ROOT = inflater.inflate(R.layout.activity_courses, null);

        return ROOT;
    }
}
