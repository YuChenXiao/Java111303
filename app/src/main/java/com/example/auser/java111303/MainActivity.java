package com.example.auser.java111303;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.auser.java111303.data.Student;
import com.example.auser.java111303.data.StudentDAOMemorylmpl;
import com.example.auser.java111303.data.StudentDAOtest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static StudentDAOMemorylmpl t = new StudentDAOMemorylmpl();
    RecyclerView mRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder>mAdaper;
    RecyclerView.LayoutManager mLayoutManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView =(RecyclerView)findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManger =new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManger);
        t.add(new Student("BOB","123","321"));
        t.add(new Student("JOY","333","111"));
        mAdaper =new MyAdapter(MainActivity.this,t.getData());
        mRecyclerView.setAdapter(mAdaper);




//        StudentDAOtest1 t =new StudentDAOtest1();
//        t.add(new Student("Bob","123","aabb"));
//        t.add(new Student("Mary","234","ccdd"));
//
//        Student[] mylist =t.getData();
//        for(Student s :mylist){
//            Log.d("DATAS",s.toString());
//        }
//
//        //將第一筆資料更改為878787 再用updata顯示
//        Student editStudent =mylist[0];
//        editStudent.tel ="878787";
//        t.updata(editStudent);
//
//        Student[] mylist1=t.getData();
//        for(Student s :mylist1){
//            Log.d("DATAS","updata:"+s.toString());
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdaper =new MyAdapter(MainActivity.this, t.getData());
        mRecyclerView.setAdapter(mAdaper);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it= new Intent(MainActivity.this,AddActivity.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }
}
