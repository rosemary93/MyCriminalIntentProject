package com.example.mycriminalproject.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mycriminalproject.R;
import com.example.mycriminalproject.controller.fragment.CrimeDetailFragment;

public class CrimeDetailActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new CrimeDetailFragment();
    }







    /*Button add;
    Button remove;*/



    /*private void findViews() {
        add = findViewById(R.id.button_add_crime);
        remove = findViewById(R.id.button_remove_crime);
    }

    private void setListeners() {
        CrimeDetailFragment crimeDetailFragment =new CrimeDetailFragment(); ;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, crimeDetailFragment).commit();
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().remove(crimeDetailFragment).commit();
            }
        });
    }*/
}


