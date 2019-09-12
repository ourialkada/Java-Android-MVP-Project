package com.ouri.java_android_mvp_project.Utils;

import android.os.StrictMode;
import android.util.Log;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Scanner;

public class utils {


    public static String getDocument(String type,String ID)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        try {
            String out = new Scanner(new URL("https://ouri-node-test.herokuapp.com/getDocument?type=" + type + "&id=" + ID).openStream(), "UTF-8").useDelimiter("\\A").next();
            return out;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
