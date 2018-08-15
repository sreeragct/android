package com.example.sree.mydetailspro;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sree on 14-01-2018.
 */

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "shared";

    public static final String KEY_NAME = "name";
    public static final String KEY_BRANCH = "branch";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_PLACE = "place";
    public static final String KEY_BATCH = "batch";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_BUTTON = "button";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setValue(String name,String branch,String batch,String mobile,String email,String place) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_BRANCH, branch);
        editor.putString(KEY_BATCH, batch);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PLACE, place);
        editor.commit();
    }
}
