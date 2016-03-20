package com.example.compiler;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusename(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }
    public void setFilenamee(String filename) {
        prefs.edit().putString("filename",filename).commit();
    }

    public String getFilename() {
        String usename = prefs.getString("filename","");
        return usename;
    }
    public void setEditText(String filename) {
        prefs.edit().putString("edittext",filename).commit();
    }

    public String getEditText() {
        String usename = prefs.getString("edittext","");
        return usename;
    }
    public void deleteEditText() {
        prefs.edit().remove("edittext").commit();
    }
    public void deleteFilename() {
        prefs.edit().remove("filename").commit();
    }
    public boolean containsUser(String user)
    {
    	return prefs.contains(user);
    }
    public void logout()
    {
    	prefs.edit().clear().commit();
    }
   
}