package com.example.techmaster.quanlynhanvien_ver2;

public class EmployeePartTime extends Employee {
    @Override
    public double TinhLuong(){
        return 150;
    }
    @Override
    public String toString(){
        return super.toString()+" -->PartTime="+TinhLuong();
    }
}