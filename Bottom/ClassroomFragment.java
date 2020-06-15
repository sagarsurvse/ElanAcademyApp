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

public class ClassroomFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_classroom, null);
    }
}
