package com.example.mycriminalproject.controller.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mycriminalproject.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //add CrimeDetailFragment to this activity (dynamic)
        FragmentManager fragmentManager=getSupportFragmentManager();

        //avali mige kojaye activity add konam(id e layoute khali tuye activity ro midim) dovomi mige chio add konam
        //fragmentManager.beginTransaction().add(R.id.fragment_container,crimeDetailFragment).commit();
        //code bala ro nminevisim chon configuration change ro handle nmikone
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment==null)
        {
            fragmentManager.beginTransaction().add(R.id.fragment_container,createFragment()).commit();
        }


    }
}
