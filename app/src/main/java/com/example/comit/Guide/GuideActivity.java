package com.example.comit.Guide;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.comit.R;

import java.util.List;

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

        Intent intent1 = new Intent(this, Guide_frag_1.class); // 이동 액티비티 설정

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

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final ListViewItem item = (ListViewItem) adapter.getItem(position);
                startActivity(intent1); // 액티비티 이동
                Toast.makeText(GuideActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show(); // 여긴 지워도됨
            }
        });
    }


}
