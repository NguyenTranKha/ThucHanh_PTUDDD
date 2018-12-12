package com.example.techmaster.quanlynhanvien_ver2;

public abstract class Employee {
    private String id;
    private String name;
    public String getname() {
        return name;
    }
    public String getid(){
        return id;
    };
    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public abstract double TinhLuong();
    @Override
    public String toString(){
        return this.id+" - " + this.name;
    }
}