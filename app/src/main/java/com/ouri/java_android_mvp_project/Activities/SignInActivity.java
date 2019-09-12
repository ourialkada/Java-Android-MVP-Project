package com.ouri.java_android_mvp_project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.ouri.java_android_mvp_project.MVP.SignIn.SignInPresentor;
import com.ouri.java_android_mvp_project.MVP.SignIn.SignInView;
import com.ouri.java_android_mvp_project.R;

public class SignInActivity extends AppCompatActivity  implements SignInView {
    EditText emailText;
    EditText passwordText;
    TextView errorMessage;
    private SignInPresentor signInPresentor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        emailText = findViewById(R.id.Email);
        passwordText = findViewById(R.id.password);
        errorMessage = findViewById(R.id.error);
        signInPresentor = new SignInPresentor(this);


    }


    public void logInClick(View view) {
        errorMessage.setVisibility(View.GONE);
        if (isValid())
        {
            signInPresentor.logIn(emailText.getText().toString(),passwordText.getText().toString());
        }

    }

    public Boolean isValid()
    {
        if(emailText.getText().length() == 0)
        {
            errorMessage.setVisibility(View.VISIBLE);
            errorMessage.setText("Email Field can not be empty");
            return false;
        }
        if(passwordText.getText().length() == 0)
        {
            errorMessage.setVisibility(View.VISIBLE);
            errorMessage.setText("Password Field can not be empty");
            return false;
        }
        if (!emailText.getText().toString().contains(".com")) {
            errorMessage.setVisibility(View.VISIBLE);
            errorMessage.setText("Email you provided is not in the correct format");
            return false;
        }

        return true;
    }


    @Override
    public void logInSuccess() {
        errorMessage.setVisibility(View.VISIBLE);
        errorMessage.setText("LoginSuccess");
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    public void logInFailed(String exception) {
        errorMessage.setVisibility(View.VISIBLE);
        errorMessage.setText("login failed");
        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show();
    }
}
