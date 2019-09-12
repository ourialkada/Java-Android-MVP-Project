package com.ouri.java_android_mvp_project.MVP.Main;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Shirt {

    private String title;
    private String description;
    private Bitmap image;
    private String ID;



    private String type;

    public Shirt(String t,String d,String id,String ty,Bitmap i)
    {
        title = t;
        description=d;
        ID = id;
        type=ty;
        image = i;


    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String description) {
        this.ID = ID;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
