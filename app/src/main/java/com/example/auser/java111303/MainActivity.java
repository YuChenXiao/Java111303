package com.example.auser.java111303;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.auser.java111303.data.Student;
import com.example.auser.java111303.data.StudentDAOFilelmpl;
import com.example.auser.java111303.data.StudentDAOMemorylmpl;
import com.example.auser.java111303.data.StudentDAOtest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener{
    public static StudentDAOFilelmpl t;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder>mAdaper;
    RecyclerView.LayoutManager mLayoutManger;
    GestureDetector mGD;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = new StudentDAOFilelmpl(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManger = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManger);
//        t.add(new Student("BOB", "123", "321"));
//        t.add(new Student("JOY", "333", "111"));
        mGD = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        }
        );
        mRecyclerView.addOnItemTouchListener(this);
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

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View v = rv.findChildViewUnder(e.getX(), e.getY());
        if (mGD.onTouchEvent(e)) {
            int position = rv.getChildLayoutPosition(v);
            // Toast.makeText(MainActivity.this, "posi:" + position, Toast.LENGTH_SHORT).show();
            if (position >= 0) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", t.getData()[position].id);
                startActivity(it);
            }


        }

        return false;
    }

        @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}
