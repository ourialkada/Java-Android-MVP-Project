package com.ouri.java_android_mvp_project.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class utils {
    private static Context context;

    public static String getDocument(final String type, final String ID, Context context)
    {
        utils.context = context;
         getToken(type,ID);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("doc","");
    }

    public static void getToken(final String type, final String ID)
    {
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        mUser.getIdToken(true)
        .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
public void onComplete(@NonNull Task<GetTokenResult> task) {
        if (task.isSuccessful()) {
            String idToken = task.getResult().getToken();
          setToken(idToken,type,ID);
        } else {
            // Handle error -> task.getException();
        }
}
        });
    }

    public static void  setToken(String token, String type, String ID){
        // Send token to your backend via HTTPS
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        try {

            String out = new Scanner(new URL("https://ouri-node-test.herokuapp.com/getDocument?type=" + type + "&id=" + ID + "&token=" + token).openStream(), "UTF-8").useDelimiter("\\A").next();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("doc",out);
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    }

