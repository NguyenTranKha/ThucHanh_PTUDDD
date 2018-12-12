package com.example.techmaster.customapdater;

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