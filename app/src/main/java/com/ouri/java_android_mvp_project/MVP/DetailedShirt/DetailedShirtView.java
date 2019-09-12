package com.ouri.java_android_mvp_project.MVP.DetailedShirt;

import android.graphics.Bitmap;

public interface DetailedShirtView {
    void Success(String name, String description, String quantity, String price, String image);
    void Failed(String exception);
}
