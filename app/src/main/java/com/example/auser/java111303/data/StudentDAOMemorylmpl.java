package com.example.auser.java111303.data;

import java.util.ArrayList;


/**
 * Created by auser on 2017/11/13.
 */

public class StudentDAOMemorylmpl implements StudentDAO {
    int MaxID = 1;
    ArrayList<Student> data = new ArrayList();

    @Override
    public void add(Student s) {
        s.id = MaxID;
        data.add(s);
        MaxID++;
    }

    @Override
    public Student[] getData() {
        return data.toArray(new Student[data.size()]);
    }

    @Override
    public void updata(Student s) {
        for (Student tmp : data) {
            if (tmp.id == s.id) {
                tmp.name = s.name;
                tmp.tel = s.tel;
                tmp.addr = s.addr;
            }
        }
    }
    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public void delete(Student s) {
        for(int i =data.size()-1;i>=0;i--){
            if(data.get(i).id == s.id){
                data.remove(i);
                break;
            }
        }


    }

    @Override
    public Student getOneStudent(int id) {
        for (Student tmp :data){
            if(tmp.id ==id){
                return tmp;
            }

        }
        return null;
    }

    @Override
    public Student[] searchByName(String name) {
        ArrayList<Student> tmpList =new ArrayList<>();
        for (Student tmp :data){
            if(tmp.name.equals(name)){
                tmpList.add(tmp);
            }
        }
        //將 ArrayList 的項目複製到指定項目類型的新陣列。
        return  tmpList.toArray(new Student[tmpList.size()]);
    }
}