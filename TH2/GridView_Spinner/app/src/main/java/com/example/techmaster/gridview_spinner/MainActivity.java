package com.example.techmaster.gridview_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    Spinner spiner;
    CheckBox checkBox;
    Button button;
    CustomSpinner customSpinner = new CustomSpinner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.name);
        spiner = findViewById(R.id.thumb);
        checkBox = findViewById(R.id.Check);
        button = findViewById(R.id.Button_add);
        final GridView gridview = (GridView) findViewById(R.id.Layout_Half_Bottom);


        final ArrayList<CustomSpinner> arrayList = new ArrayList<CustomSpinner>();
        final ArrayList<Dish> arrayListDish = new ArrayList<Dish>();

        arrayList.add(new CustomSpinner(Thumbnail.Thumbnail1.getName(),Thumbnail.Thumbnail1.getImg()));
        arrayList.add(new CustomSpinner(Thumbnail.Thumbnail2.getName(),Thumbnail.Thumbnail2.getImg()));
        arrayList.add(new CustomSpinner(Thumbnail.Thumbnail3.getName(),Thumbnail.Thumbnail3.getImg()));
        arrayList.add(new CustomSpinner(Thumbnail.Thumbnail4.getName(),Thumbnail.Thumbnail4.getImg()));
//        arrayList.add(new CustomSpinner("Thumbnail2",R.raw.second_thumbnail));
//        arrayList.add(new CustomSpinner("Thumbnail3",R.raw.third_thumbnail));
//        arrayList.add(new CustomSpinner("Thumbnail4",R.raw.fourth_thumbnail));
        final AdapterSpinner adapter = new AdapterSpinner(this,R.layout.item_thumbnail ,
                R.layout.item_selected_thumbnail, arrayList);
        final DishApdater adapterDish = new DishApdater(this, R.layout.item_dish, arrayListDish);
        gridview.setAdapter(adapterDish);

        spiner.setAdapter(adapter);

        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                customSpinner.Hinh = arrayList.get(i).Hinh;
                customSpinner.TenHinh = arrayList.get(i).TenHinh;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Dish = Name.getText().toString();
                Dish dish = new Dish();
                dish.setTenmon(Dish);
                dish.setCustomSpinner(customSpinner);
                dish.setPromotion(checkBox.isChecked());
                arrayListDish.add(dish);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public enum Thumbnail{
        Thumbnail1("Thumbnail 1",R.raw.first_thumbnail),
        Thumbnail2("Thumbnail 2",R.raw.second_thumbnail),
        Thumbnail3("Thumbnail 3",R.raw.third_thumbnail),
        Thumbnail4("Thumbnail 4",R.raw.fourth_thumbnail);

        private String name;
        private int img;

        Thumbnail(String name, int img){
            this.name = name;
            this.img = img;
        }

        public String getName() {return name;}

        public int getImg() {return img;}
    }
}