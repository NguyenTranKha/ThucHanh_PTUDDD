package com.example.techmaster.customapdater;

public abstract class Employee {
    private String id;
    private String name;
    private Boolean Manager;
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
    public Boolean isManager(){
        return Manager;
    }

    public void setManager(Boolean Manager){
        this.Manager = Manager;
    }

    public abstract double TinhLuong();
    @Override
    public String toString(){
        return this.id+" - " + this.name;
    }
}