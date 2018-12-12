package com.example.techmaster.datalistview_already;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview); //khai bao vi tri hien thi mang
        final ArrayList<String> list = new ArrayList<String>(); //khai bao mang luu tru

        list.add("Nguyễn Trần Kha");
        list.add("Lê Vũ Trùng Dương");
        list.add("Nguyễn Trọng Nhân");
        list.add("Trần Minh Tân");
        list.add("Huỳnh Vĩnh Phú");
        list.add("Lữ Khải Thông");
        list.add("Bùi Anh Khoa");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        //đưa list ra adapter

        listView.setAdapter(adapter);
        //đưa list ra listview
        final TextView txtchon = findViewById(R.id.txtselection);
        listView.setOnItemClickListener(new AdapterView
                .OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0,View arg1,
                    int vitri,long arg3) {

                txtchon.setText("Vị Trí : "+ vitri +
                        "\nHọ Tên: "+list.get(vitri));
            };
        });
    }
}
