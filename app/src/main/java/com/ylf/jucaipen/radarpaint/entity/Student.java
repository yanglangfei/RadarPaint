package com.ylf.jucaipen.radarpaint.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/10.
 */
public class Student implements Serializable {

    private  int id;
    private  String name;
    private  int No;
    private  int sex;
    private  String address;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        No = no;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNo() {
        return No;
    }

    public int getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }
}
