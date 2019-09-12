package com.ouri.java_android_mvp_project.MVP.DetailedShirt;

import android.content.Context;
import android.util.Log;


import com.ouri.java_android_mvp_project.Activities.DetailedShirtActivity;
import com.ouri.java_android_mvp_project.MVP.Main.MainView;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DetailedShirtPresentor implements DetailedShirtModel {

    private Context context;
    private DetailedShirtView detailedShirtView;


    public DetailedShirtPresentor(Context context)
    {
        this.context = context;
        detailedShirtView = (DetailedShirtView) context;
    }

    @Override
    public void setData(String json) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject JSON = (JSONObject) parser.parse(json);
            detailedShirtView.Success(JSON.get("name").toString(),JSON.get("description").toString(),JSON.get("price").toString(),JSON.get("quantity").toString(),JSON.get("image").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
