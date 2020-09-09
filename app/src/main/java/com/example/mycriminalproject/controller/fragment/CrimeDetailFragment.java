package com.example.mycriminalproject.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.mycriminalproject.R;
import com.example.mycriminalproject.model.Crime;
import com.example.mycriminalproject.repository.CrimeRepository;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrimeDetailFragment} factory method to
 * create an instance of this fragment.
 */
public class CrimeDetailFragment extends Fragment {
    EditText mEditTextTitle;
    Button mButtonDate;
    CheckBox mCheckBoxSolved;
    Crime mCrime;
    public CrimeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID id= (UUID) getActivity().getIntent().getSerializableExtra(CrimeListFragment.EXTRA_CRIME_ID);
        CrimeRepository crimeRepository=CrimeRepository.getInstance();
        mCrime=crimeRepository.getCrime(id);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_crime_detail, container, false);

        findViews(view);
        setListeners();
        mEditTextTitle.setText(mCrime.getTitle());
        mCheckBoxSolved.setChecked(mCrime.isSolved());
        mButtonDate.setText(mCrime.getDate().toString());
        mButtonDate.setEnabled(false);
        return view;

    }

    private void setListeners() {
        mCheckBoxSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        mButtonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void findViews(View view) {
        mEditTextTitle=view.findViewById(R.id.edit_text_crime_title);
        mButtonDate=view.findViewById(R.id.button_crime_date);
        mCheckBoxSolved=view.findViewById(R.id.check_box_crime_solved);
    }
}