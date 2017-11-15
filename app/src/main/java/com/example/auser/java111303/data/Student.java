package com.example.auser.java111303.data;

/**
 * Created by auser on 2017/11/13.
 */

public class Student {
    public  int id;
    public  String name ;
    public  String tel ;
    public  String addr;

    public  Student(String name ,String tel ,String addr){
        this.name =name;
        this.tel =tel;
        this.addr =addr;
    }

    @Override
    public String toString()
    {
        return id+" : 姓名"+name+",電話"+tel+",地址"+addr;
    }

}
