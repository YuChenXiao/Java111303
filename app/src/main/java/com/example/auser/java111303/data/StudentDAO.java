package com.example.auser.java111303.data;

import java.util.ArrayList;

/**
 * Created by auser on 2017/11/13.
 */

public interface StudentDAO {
    void add(Student s);
    Student[] getData();
    void updata(Student s);
    void clear();
    void delete(Student s);
    Student getOneStudent(int id);
    Student[] searchByName(String name);

}
