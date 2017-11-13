package com.example.auser.java111303.data;

import java.util.ArrayList;
import java.util.Date;

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
}