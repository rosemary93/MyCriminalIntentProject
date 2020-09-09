package com.example.mycriminalproject.repository;

import com.example.mycriminalproject.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository {
    public static final int CRIME_SIZE = 100;
    private static CrimeRepository sInstance;

    private CrimeRepository() {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < CRIME_SIZE; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime#" + (i + 1));
            crime.setSolved(i % 2 == 0);

            mCrimes.add(crime);
        }
    }

    public static CrimeRepository getInstance() {
        if (sInstance == null)
            sInstance = new CrimeRepository();

        return sInstance;
    }

    private List<Crime> mCrimes;

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public void setCrimes(List<Crime> crimes) {
        mCrimes = crimes;
    }

    public void add(Crime crime) {
        mCrimes.add(crime);
    }



    public Crime getCrime(UUID id)
    {
        for (Crime crime:mCrimes)
        {
            if (crime.getId().equals(id))
                return crime;
        }
        return null;
    }

    public void insertCrime(Crime crime)
    {
        mCrimes.add(crime);
    }

    public void deleteCrime(Crime crime)
    {
        //TODO
    }
    public void updateCrime(Crime crime)
    {
        //TODO
    }
}
