package com.example.admin.elanlivelearningapp.Status;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admin.elanlivelearningapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

public class Status1 extends AppCompatActivity {

    boolean isCacheEnabled = true;
    boolean isImmersiveEnabled = true;
    boolean isTextEnabled = true;
    long storyDuration = 3000L;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status1);








    }
}
