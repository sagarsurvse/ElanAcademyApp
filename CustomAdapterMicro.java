package com.example.admin.elanlivelearningapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapterMicro extends RecyclerView.Adapter<CustomAdapterMicro.viewHolder> {

    Context context;
    ArrayList<MtemModelMicro> arrayListdecount;

    public CustomAdapterMicro(Context context, ArrayList<MtemModelMicro> arrayListdecount) {
        this.context = context;
        this.arrayListdecount = arrayListdecount;
    }

    @Override
    public  CustomAdapterMicro.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_listitem_micro, viewGroup, false);
        return new viewHolder(view);
    }
    @Override
    public  void onBindViewHolder(CustomAdapterMicro.viewHolder viewHolder, int position) {
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