package com.appiness.aac_webservice;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Datum> nameListArray;// = new ArrayList<String>();
    ListView listView;
    RecyclerView recyclerView;
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        listView =  findViewById(R.id.lvName);
        recyclerView =  findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        nameListArray = new ArrayList<Datum>();
        RetrofitRepository.getEmpInfo();
        adapter = new MyAdapter(this,
                nameListArray);
        recyclerView.setAdapter(adapter);
        RetrofitRepository.getIntData().observe(this,ModelInfo ->{
            nameListArray.clear();
            nameListArray.addAll(ModelInfo.getData());
            adapter.notifyDataSetChanged();
        });
    }

    public void getTime(View view){

        RetrofitRepository.getEmpInfo();
        // adapter.notifyDataSetChanged();
    }
}
