package com.example.mycriminalproject.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mycriminalproject.R;
import com.example.mycriminalproject.controller.fragment.CrimeDetailFragment;

import java.util.UUID;

public class CrimeDetailActivity extends SingleFragmentActivity {
    public static final String EXTRA_CRIME_ID = "com.example.mycriminalproject.crimeId";


    @Override
    public Fragment createFragment() {
        UUID crimeId= (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        //be mahze sakhtane fragment bayad dakhele hafeze args dakhele fragment harchizi
        // lazeme put konim ta fragment be activity vabaste nabashe
        /*CrimeDetailFragment crimeDetailFragment=new CrimeDetailFragment();
        Bundle args=new Bundle();
        args.putSerializable(ARGS_CRIME_ID,crimeId);
        crimeDetailFragment.setArguments(args);
        return  crimeDetailFragment;*/


        CrimeDetailFragment crimeDetailFragment=CrimeDetailFragment.newInstance(crimeId);
        return crimeDetailFragment;
    }

    public static Intent newIntent(Context context, UUID crimeId)
    {
        Intent intent=new Intent(context,CrimeDetailActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
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


