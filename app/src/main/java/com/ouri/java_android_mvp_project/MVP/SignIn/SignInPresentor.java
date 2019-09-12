package com.ouri.java_android_mvp_project.MVP.SignIn;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ouri.java_android_mvp_project.Utils.Constants;

public class SignInPresentor implements SignInModel{

    private Context context;
    private SignInView signInView;



    public SignInPresentor(Context context) {
        this.context = context;
        signInView= (SignInView) context;

    }

    @Override
    public void logIn(String email,String password) {

        Constants.auth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        signInView.logInSuccess();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                signInView.logInFailed(e.getMessage());
            }
        });


    }
}
