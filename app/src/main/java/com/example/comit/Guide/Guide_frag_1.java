package com.example.comit.Guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Guide_frag_1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_1);

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

        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.inflearn),"인프런","다양한 무료/유료 코딩강의가 있어요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.programmers),"프로그래머스","여러 코딩문제를 풀고 코딩고수가 되어봐요!");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.backjoon),"백준","여러 코딩문제를 풀고, 다른사람들과 경쟁해요");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.github),"깃허브","팀플 프로젝트나 포트폴리오 관리에 짱!");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.stackoverflow),"스택오버플로우","아마 엄청 많이 쓰게될거에요..엄청 많이.");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.sciketlearn),"머신러닝 라이브러리","머신러닝에 관심이 많다면 유용하게 쓸 수 있어요");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final ListViewItem item = (ListViewItem) adapter.getItem(position);
                if (position == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.inflearn.com/"));
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://programmers.co.kr/"));
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/"));
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"));
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/"));
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://scikit-learn.org/"));
                    startActivity(intent);
                }
            }
        });


        Intent intent = new Intent(this, ChatbotActivity.class);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "챗봇 커미를 부릅니다", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(intent);
            }
        });
    }
}
