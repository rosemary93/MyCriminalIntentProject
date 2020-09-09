package com.example.mycriminalproject.model;

import java.util.Date;
import java.util.UUID;

public class Crime {
    //id is necessaary for each model
    private UUID mId;
    private String mTitle;
    private boolean mIsSolved;
    private Date mDate;


    public Crime() {
    mId=UUID.randomUUID();
    mDate=new Date();
    }

    //only id has getter
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved() {
        return mIsSolved;
    }

    public void setSolved(boolean solved) {
        mIsSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }


}
