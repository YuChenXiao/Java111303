package com.example.auser.java111303;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.auser.java111303.data.Student;
import com.example.auser.java111303.data.StudentDAOMemorylmpl;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOMemorylmpl dao =new StudentDAOMemorylmpl();
        dao.clear();
        dao.add(new Student("AA","11","aabb"));
        dao.clear();
        dao.add(new Student("Ab","22","aabb"));
        dao.add(new Student("Ac","33","aabb"));
        Student[] stus =dao.getData();
        assertEquals(stus.length,2);
    }
}
