package com.example.mycriminalproject.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.mycriminalproject.R;
import com.example.mycriminalproject.model.Crime;
import com.example.mycriminalproject.repository.CrimeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrimeListFragment} factory method to
 * create an instance of this fragment.
 */
public class CrimeListFragment extends Fragment {

    RecyclerView mRecyclerView;


    public CrimeListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_crime_list, container, false);
        //1: find kardane recycler view
        findViews(view);
        //2: taEne noe recyclerView(vazifash positioing)
        initView();
        return view;
    }
    //3: sakhte classe view holder (chon dar adapter objectesho lazem darim)
    //important: agar chand ja estefade mikonim class joda misazim agar faghat yek ja mikhaim
    //inner class minevisim

    private class CrimeHolder extends RecyclerView.ViewHolder{
    //vazife viewHolder negah dashtane refrence az mohtaviAte har row hast
       private TextView mTextViewTitle;
       private TextView mTextViewDate;
       private Crime mCrime;

        public CrimeHolder(@NonNull View itemView) {
            super(itemView);
            //itemView view  har row hast

            mTextViewTitle=itemView.findViewById(R.id.textView_row_crime_title);
            mTextViewDate=itemView.findViewById(R.id.textView_row_crime_date);
        }

        public void bindCrime(Crime crime)
        {
            mCrime=crime;
            mTextViewTitle.setText(crime.getTitle());
            mTextViewDate.setText(crime.getDate().toString());
        }

    }

    //4: sakhte adapter
    //adapter 3 vazife dare--> 1)tedade row ha ro behesh bedim
    //2) sakhte viewHolder -> onCreateViewHolder
    //3) bind kardane har row va moshakhas kardane positione har row(onBindViewHolder)
    //ertebate beine view va dataSet injast
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>
    {
        private List<Crime> mCrime;

        public List<Crime> getCrime() {
            return mCrime;
        }

        public void setCrime(List<Crime> crime) {
            mCrime = crime;
        }

        public CrimeAdapter(List<Crime> crime) {
            mCrime = crime;
        }

        @Override
        public int getItemCount() {
            return mCrime.size();
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //crimeHolder yek view mikhad in view hamun layout har satr hast ke aval bayad inflate konim
            //aval LayoutInflater ro get mikonim ke bahash betunim inflate konim
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            //hala inflate mikonim dakhele yek container ke khodesh dade(parent)
            View view=layoutInflater.inflate(R.layout.crime_row_list,parent,false);
            //dar asl bayad intori nevesht-->
            //View view=LayoutInflater.from(getActivity()).inflate(R.layout.crime_row_list,parent,false);
            CrimeHolder crimeHolder=new CrimeHolder(view);
            return crimeHolder;
        }

        //data ro mikhunim va dakhele view set mikonim
        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime=mCrime.get(position);

            holder.bindCrime(crime);
        }
    }





    private void findViews(View view) {
        mRecyclerView= view.findViewById(R.id.recycler_view_crime_list);
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //5: sakhtane adapter
        CrimeRepository crimeRepository=CrimeRepository.getInstance();
        CrimeAdapter crimeAdapter=new CrimeAdapter(crimeRepository.getCrimes());
        //6: set kardane adapter dar recycler view
        mRecyclerView.setAdapter(crimeAdapter);
    }
}