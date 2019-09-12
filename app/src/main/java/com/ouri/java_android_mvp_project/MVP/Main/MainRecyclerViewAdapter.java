package com.ouri.java_android_mvp_project.MVP.Main;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ouri.java_android_mvp_project.MVP.DetailedShirt.DetailedShirtPresentor;
import com.ouri.java_android_mvp_project.R;
import com.ouri.java_android_mvp_project.Utils.utils;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder>{

    private List<Shirt> shirts;
    private Context context;
    private MainView maineView;

    public MainRecyclerViewAdapter(List<Shirt> shirts,Context context) {
        this.shirts = shirts;
        this.context = context;
        maineView= (MainView) context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView =  inflater.inflate(R.layout.activity_request_recycler_view, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        final Shirt item = shirts.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.image.setImageBitmap(item.getImage());


        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =   utils.getDocument(shirts.get(position).getType(),shirts.get(position).getID());
                maineView.clicked(s);

            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =   utils.getDocument(shirts.get(position).getType(),shirts.get(position).getID());
                maineView.clicked(s);


            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =   utils.getDocument(shirts.get(position).getType(),shirts.get(position).getID());
                maineView.clicked(s);


            }
        });





    }


    @Override
    public int getItemCount() {
        return shirts.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        ImageView image;

        MainViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image2);
        }
    }
}



