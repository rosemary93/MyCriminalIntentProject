package com.example.mycriminalproject.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.mycriminalproject.controller.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {



    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}