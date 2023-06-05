package com.example.lab6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SitesAdapter extends ArrayAdapter<Site> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Site> sites;

    public SitesAdapter(Context context, int resource, ArrayList<Site> sites){
        super(context, resource, sites);
        this.sites = sites;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        @SuppressLint("ViewHolder") View view = inflater.inflate(this.layout, parent, false);
        ImageView picture = view.findViewById(R.id.pic);
        TextView name = (TextView) view.findViewById(R.id.name);


        Site site = sites.get(position);
        picture.setImageResource(site.getPicResourse());
        name.setText(site.getName());

        return view;
    }

}
