package com.example.mycriminalproject.controller.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.mycriminalproject.controller.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context)
    {
        Intent intent=new Intent(context,CrimeListActivity.class);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        return CrimeListFragment.newInstance();
    }
}