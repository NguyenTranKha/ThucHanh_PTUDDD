package com.example.techmaster.gridview_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishApdater extends BaseAdapter {
    private Context context;
    private int layout;
    List<Dish> menu;

    public DishApdater(Context context, int layout, List<Dish> menu) {
        this.context = context;
        this.layout = layout;
        this.menu = menu;
    }

    @Override
    public int getCount() {
        return menu.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        ImageView imageViewBackground = (ImageView)view.findViewById(R.id.imageBackground);
        TextView inforbackground = (TextView)view.findViewById(R.id.inforbackground);
        ImageView boolen = (ImageView)view.findViewById(R.id.boolen);
        boolen.setImageResource(R.raw.ic_promotion);

        imageViewBackground.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageViewBackground.setImageResource(menu.get(i).getCustomSpinner().Hinh);
        inforbackground.setText(menu.get(i).getTenmon());
        if(menu.get(i).isPromotion())
        {
            boolen.setVisibility(View.VISIBLE);
        }
        else
        {
            boolen.setVisibility(View.GONE);
        }
        return view;
    }
}
