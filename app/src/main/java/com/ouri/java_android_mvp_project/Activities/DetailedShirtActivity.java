package com.ouri.java_android_mvp_project.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ouri.java_android_mvp_project.MVP.DetailedShirt.DetailedShirtPresentor;
import com.ouri.java_android_mvp_project.MVP.DetailedShirt.DetailedShirtView;
import com.ouri.java_android_mvp_project.MVP.Main.Shirt;
import com.ouri.java_android_mvp_project.R;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

public class DetailedShirtActivity extends AppCompatActivity implements DetailedShirtView {

    TextView name;
    TextView description;
    TextView price;
    TextView quantity;
    ImageView imageView;
    DetailedShirtPresentor detailedShirtPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detialed_shirt);
        detailedShirtPresentor = new DetailedShirtPresentor(this);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        imageView = findViewById(R.id.fullImage);
        description.setMovementMethod(new ScrollingMovementMethod());
        Bundle bun = getIntent().getExtras();
        detailedShirtPresentor.setData(bun.getString("json"));

    }



    @Override
    public void Success(String name,String description,String quantity,String price, String image) {

        try
        {
            URL url = new URL(image);
            InputStream is = new BufferedInputStream(url.openStream());
            Bitmap b = BitmapFactory.decodeStream(is);
            this.imageView.setImageBitmap(b);
        } catch(Exception e){

        }

        this.name.setText(name);
        this.description.setText(description);
        this.quantity.setText(quantity);
        this.price.setText("$"+price);
    }

    @Override
    public void Failed(String exception) {

        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
