package com.example.comit.Guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Guide_frag_3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_3);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

        ListView listview;
        ListViewAdapter_2 adapter;

        adapter = new ListViewAdapter_2();

        listview = (ListView)findViewById(R.id.guide_list);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.hyunbin),"이현빈 교수님",
                "전공 분야 : 스마트팜, 딥러닝 응용, 메모리 인터페이스\n\n" +
                     "관련교과목 : 디지털 시스템 설계, 마이크로 프로세서, 임베디드시스템응용\n\n" +
                     "연구실 : N4동 411호 \n\n" +
                     "이메일 : bean@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.chajong),"김차종 교수님","전공 분야 : 컴퓨터 그래픽, 정보공학\n\n" +
                "관련교과목 : 컴퓨터그래픽스, Linux/Linux System, JAVA\n\n" +
                "연구실 : N4동 609호\n\n" +
                "이메일 : cjkim@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.jaeheung),"이재흥 교수님","전공 분야 : 컴퓨터구조, SoC\n\n" +
                "관련교과목 : 마이크로프로세서, 디지털 시스템, 임베디드 시스템\n\n" +
                "연구실 : N4동 610호\n\n" +
                "이메일 : jhlee@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.youngtaek),"진영택 교수님","전공 분야 : 소프트웨어공학\n\n" +
                "관련교과목 : 소프트웨어공학\n\n" +
                "연구실 : N4동 611호\n\n" +
                "이메일 ytjin@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.jungho),"김정호 교수님","전공 분야 : 컴퓨터통신, 네트워크\n\n" +
                "관련교과목 : 데이터통신, 정보보호\n\n" +
                "연구실 : N4동 409호\n\n" +
                "이메일 : jhkim@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.gyungho),"황경호 교수님","전공 분야 : 이동통신네트워크\n\n" +
                "관련교과목 : 이동통신네트워크, 모바일컴퓨팅과응용, 네트워크프로그래밍\n\n" +
                "연구실 : N5동 413호\n\n" +
                "이메일 : gabriel@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.taehoon),"김태훈 교수님","전공 분야 : 무선통신, 사물인터넷\n\n" +
                "관련교과목 : 프로그래밍언어, 알고리즘, 사물인터넷응용\n\n" +
                "연구실 : N4동 604호\n\n" +
                "이메일 : thkim@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.haneur),"장한얼 교수님","전공 분양 : 컴퓨터비전, 인공지능\n\n" +
                "관련교과목 : 컴퓨터비전, 인공지능\n\n" +
                "연구실 : N4동 607호\n\n" +
                "이메일 : hejang@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.changbum),"최창범 교수님","전공 분야 : 컴퓨터공학, 모델링 및 시뮬레이션\n\n" +
                "관련교과목 : C/C++프로그래밍, 시스템 프로그래밍, 소프트웨어 공학\n\n" +
                "연구실 : N4동 415호\n\n" +
                "이메일 : cbchoi@hanbat.ac.kr");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.gyungtae),"임경태 교수님","전공 분야 : 인공지능, 자연어처리\n\n" +
                "관련교과목 : 자연어처리, 딥러닝\n\n" +
                "연구실 : N4동 605호\n\n" +
                "이메일 : ktlim@hanbat.ac.kr");


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
