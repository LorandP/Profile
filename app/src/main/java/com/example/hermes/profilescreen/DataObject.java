package com.example.hermes.profilescreen;

/**
 * Created by Hermes on 08/06/2017.
 *
 * Holding the data type that we are going to use in the ListView
 */

public class DataObject {
    private String mWebpage;
    private String mEmail;
    private String mBirthday;

    public String getmWebpage() {
        return mWebpage;
    }

    public void setmWebpage(String mWebpage) {
        this.mWebpage = mWebpage;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmBirthday() {
        return mBirthday;
    }

    public void setmBirthday(String mBirthday) {
        this.mBirthday = mBirthday;
    }
}
