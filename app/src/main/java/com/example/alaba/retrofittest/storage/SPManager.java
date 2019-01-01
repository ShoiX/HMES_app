package com.example.alaba.retrofittest.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.alaba.retrofittest.models.User;

/*Shared Preference Manager*/
public class SPManager {
    private static final String SHARED_PREF_BANE = "HMES_shared_pref_xOxO";
    private static SPManager mInstace;
    private Context mCtx;

    private SPManager(Context mCtx){
        this.mCtx = mCtx;
    }

    public static synchronized SPManager getInstance(Context mCtx){
        if (mInstace == null){
            mInstace = new SPManager(mCtx);
        }
        return mInstace;
    }

    public void saveUser(User user){
        SharedPreferences sp = mCtx.getSharedPreferences(SHARED_PREF_BANE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putInt("id", user.getId());
        editor.putString("email", user.getEmail());
        editor.putString("name", user.getName());

        editor.apply();
    }

    public boolean isLogged(){
        SharedPreferences sp = mCtx.getSharedPreferences(SHARED_PREF_BANE, Context.MODE_PRIVATE);

        return sp.getInt("id", -1) != -1;
    }

    public User getUser(){
        SharedPreferences sp = mCtx.getSharedPreferences(SHARED_PREF_BANE, Context.MODE_PRIVATE);
        return new User(
                sp.getInt("id", -1),
                sp.getString("email", null),
                sp.getString("name", null)
        );
    }

    public void clear(){
        SharedPreferences sp = mCtx.getSharedPreferences(SHARED_PREF_BANE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }
}
