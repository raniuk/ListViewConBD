package com.amg.wm.project2.utils;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amg.wm.project2.R;


public class ArrayAdapterobj extends ArrayAdapter<LVObjects> {
    private Context context;
    private ArrayList<LVObjects> alObjects;

    public ArrayAdapterobj(Context context, ArrayList<LVObjects> alObjects) {
        super(context, R.layout.tmp_list, alObjects);
        this.context = context;
        this.alObjects = alObjects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemOjb = convertView;
        ContentHolder holder;

        if (itemOjb == null) {
            itemOjb = LayoutInflater.from(context).inflate(R.layout.tmp_list, null);
            holder = new ContentHolder();
            holder.ivIcon = (ImageView) itemOjb.findViewById(R.id.ivIconlv);
            holder.tvTitle = (TextView) itemOjb.findViewById(R.id.tvTitlelv);
            itemOjb.setTag(holder);
        }
        holder = (ContentHolder) itemOjb.getTag();
        holder.ivIcon.setImageResource(alObjects.get(position).getDrawableImageID());
        holder.tvTitle.setText(alObjects.get(position).getTitle());

        return itemOjb;
    }
}