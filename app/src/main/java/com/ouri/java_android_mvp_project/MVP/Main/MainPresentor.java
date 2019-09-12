package com.ouri.java_android_mvp_project.MVP.Main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.ouri.java_android_mvp_project.MVP.SignIn.SignInView;
import com.ouri.java_android_mvp_project.Utils.Constants;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPresentor implements MainModel {
    private Context context;
    private MainView maineView;

    public MainPresentor(Context context) {
        this.context = context;
        maineView= (MainView) context;

    }


    @Override
    public void getList(final String type) {

        final List<Shirt> shirtArray = new ArrayList<>();
        FirebaseFirestore.getInstance().collection("JsosShirts").document(type).collection("AllShirts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                            StrictMode.setThreadPolicy(policy);
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Bitmap b;

                                try
                                {
                                    URL url = new URL(document.getString("image"));
                                    InputStream is = new BufferedInputStream(url.openStream());
                                    b = BitmapFactory.decodeStream(is);
                                    Shirt shirt = new Shirt(document.getString("name"),document.getString("description"),document.getString("ID"),type,b);
                                    shirtArray.add(shirt);
                                } catch(Exception e){

                                }

                            }
                            maineView.displayList(shirtArray);
                        } else {

                        }
                    }

                });
    }
}
