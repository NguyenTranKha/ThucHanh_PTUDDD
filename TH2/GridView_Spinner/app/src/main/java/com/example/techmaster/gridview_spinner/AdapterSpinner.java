package com.example.techmaster.gridview_spinner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterSpinner extends BaseAdapter {

    Context context;
    int mylayout;
    int layoutspinner;
    List<CustomSpinner> arraylist;

    public AdapterSpinner(Context context,int layoutspinner ,int mylayout, List<CustomSpinner> arraylist){
        this.context = context;
        this.arraylist = arraylist;
        this.mylayout = mylayout;
        this.layoutspinner = layoutspinner;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mylayout,null);
        TextView textView = (TextView)convertView.findViewById(R.id.thum_name);
        textView.setText(arraylist.get(i).TenHinh);
        return convertView;
    }

    @Override
    public View getDropDownView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layoutspinner,null);
        TextView textView = (TextView)convertView.findViewById(R.id.content);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.img);
        textView.setText(arraylist.get(i).TenHinh);
        imageView.setImageResource(arraylist.get(i).Hinh);

        return convertView;
    }
}