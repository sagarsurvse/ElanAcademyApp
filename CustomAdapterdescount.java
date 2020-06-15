package com.example.admin.elanlivelearningapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapterdescount extends RecyclerView.Adapter<CustomAdapterdescount.viewHolder> {

    Context context;
    ArrayList<MtemModeldescount> arrayListdecount;

    public CustomAdapterdescount(Context context, ArrayList<MtemModeldescount> arrayListdecount) {
        this.context = context;
        this.arrayListdecount = arrayListdecount;
    }

    @Override
    public  CustomAdapterdescount.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_listitem_descount, viewGroup, false);
        return new viewHolder(view);
    }
    @Override
    public  void onBindViewHolder(CustomAdapterdescount.viewHolder viewHolder, int position) {
        viewHolder.iconName.setText(arrayListdecount.get(position).getName());
        viewHolder.icon.setImageResource(arrayListdecount.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayListdecount.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView iconName;

        public viewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);

        }
    }

}