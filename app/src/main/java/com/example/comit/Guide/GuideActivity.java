package com.example.comit.Guide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.comit.R;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView)findViewById(R.id.guide_list);
        listview.setAdapter(adapter);
        
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"1번","1번 설명이에요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"2번","2번 설명이에요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"3번","3번 설명이에요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"4번","4번 설명이에요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"5번","5번 설명이에요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"6번","6번 설명이에요");

//        listview.setOnClickListener(new AdapterView.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//            }
//        }); // 클릭리스너 넣는거 해보자
    }


}
