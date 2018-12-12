package com.example.techmaster.customapdater;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText MaNhanVien;
    EditText TenNhanVien;
    Button Enter;
    RadioGroup GroupRadio;
    Employee employee;
    ArrayList<Employee> employees;
    ListView DanhSachNhanVien;
    EmployeeAdapter DanhSach;
    CheckBox QuanLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaNhanVien = findViewById(R.id.MaNhanVien);
        TenNhanVien = findViewById(R.id.TenNhanVien);
        Enter = findViewById(R.id.Enter);
        DanhSachNhanVien = findViewById(R.id.DanhSachNhanVien);
        QuanLy = findViewById(R.id.toggle);

        employees = new ArrayList<Employee>();
        DanhSach = new EmployeeAdapter(this, android.R.layout.simple_list_item_1, employees);
        DanhSachNhanVien.setAdapter(DanhSach);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });
    }

    public void addNewEmployee() {
        String MaNhanVien = this.MaNhanVien.getText().toString();
        String TenNhanVien = this.TenNhanVien.getText().toString();

        employee = new EmployeeFullTime();
        //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(MaNhanVien);
        employee.setName(TenNhanVien);
        if (QuanLy.isChecked()) {
            employee.setManager(true);
            QuanLy.setChecked(false);
        }
        else
            employee.setManager(false);
        QuanLy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    employee.setManager(true);
                } else {
                    employee.setManager(false);
                }
            }
        });
        //Đưa employee vào ArrayList
        employees.add(employee);
        //Cập nhập giao diện
        DanhSach.notifyDataSetChanged();
    }
}