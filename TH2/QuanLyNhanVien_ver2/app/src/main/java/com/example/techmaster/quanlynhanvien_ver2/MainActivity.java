package com.example.techmaster.quanlynhanvien_ver2;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText MaNhanVien;
    EditText TenNhanVien;
    RadioButton ChinhThuc;
    RadioButton ThoiVu;
    Button Enter;
    RadioGroup GroupRadio;
    Employee employee;
    ArrayList<Employee> employees;
    ListView DanhSachNhanVien;
    ArrayAdapter DanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaNhanVien = findViewById(R.id.MaNhanVien);
        TenNhanVien = findViewById(R.id.TenNhanVien);
        ChinhThuc = findViewById(R.id.ChinhThuc);
        ThoiVu = findViewById(R.id.ThoiVu);
        Enter = findViewById(R.id.Enter);
        DanhSachNhanVien = findViewById(R.id.DanhSachNhanVien);
        GroupRadio = findViewById(R.id.GroupRadio);

        employees = new ArrayList<Employee>();
        DanhSach = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, employees);
        DanhSachNhanVien.setAdapter(DanhSach);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });
    }

    public void addNewEmployee() {
        //Lấy ra đúng id của Radio Button được checked
        int RadioID = GroupRadio.getCheckedRadioButtonId();
        String MaNhanVien = this.MaNhanVien.getText().toString();
        String TenNhanVien = this.TenNhanVien.getText().toString();
        if (RadioID == R.id.ChinhThuc) {
            //tạo instance là FullTime
            employee = new EmployeeFullTime();
        } else {
            //Tạo instance là Partime
            employee = new EmployeePartTime();
        }
        //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(MaNhanVien);
        employee.setName(TenNhanVien);
        //Đưa employee vào ArrayList
        employees.add(employee);
        //Cập nhập giao diện
        DanhSach.notifyDataSetChanged();
    }
}