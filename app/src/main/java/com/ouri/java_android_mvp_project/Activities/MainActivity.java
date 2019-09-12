package com.ouri.java_android_mvp_project.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ouri.java_android_mvp_project.MVP.Main.MainPresentor;
import com.ouri.java_android_mvp_project.MVP.Main.MainRecyclerViewAdapter;
import com.ouri.java_android_mvp_project.MVP.Main.MainView;
import com.ouri.java_android_mvp_project.MVP.Main.Shirt;
import com.ouri.java_android_mvp_project.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    protected TextView mTextMessage;
    RecyclerView request_card_view;
    RecyclerView card_view;
    MainPresentor mainPresentor;
    ImageView imageView;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.navigation);
        mTextMessage = findViewById(R.id.message);
        request_card_view = (RecyclerView) findViewById(R.id.request_card_view);
        card_view=  findViewById(R.id.request_card_view);
        card_view.setLayoutManager(new LinearLayoutManager(this));
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mainPresentor = new MainPresentor(this);
        imageView = findViewById(R.id.imageView);
        pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("loading");

    }


    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Home:
                    mTextMessage.setText(R.string.title_home);
                    imageView.setVisibility(View.VISIBLE);
                    request_card_view.setVisibility(View.GONE);
                    return true;
                case R.id.Men:
                    mTextMessage.setText(R.string.Men);
                    mainPresentor.getList("Men");
                    pd.show();
                    return true;
                case R.id.Women:
                    mTextMessage.setText(R.string.Women);
                    mainPresentor.getList("Women");
                    pd.show();
                    return true;
                case R.id.Kids:
                    mTextMessage.setText(R.string.Kids);
                    mainPresentor.getList("Kids");
                    pd.show();
                    return true;
            }
            return false;
        }
    };


    @Override
    public void displayList(List<Shirt> shirts) {
        pd.cancel();
        imageView.setVisibility(View.GONE);
        request_card_view.setVisibility(View.VISIBLE);
        card_view.setAdapter(new MainRecyclerViewAdapter(shirts,this));

    }

    @Override
    public void clicked(String s) {
        Intent i = new Intent(this, DetailedShirtActivity.class);
        i.putExtra("json",s);
        startActivity(i);
    }
}
