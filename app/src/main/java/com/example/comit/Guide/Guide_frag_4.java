package com.example.comit.Guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Guide_frag_4 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_4);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

        ListView listview;
        ListViewAdapter_3 adapter;

        adapter = new ListViewAdapter_3();

        listview = (ListView)findViewById(R.id.guide_list);
        listview.setAdapter(adapter);

        adapter.addItem("MOBICOM\n","담당교수 : 황경호 교수님\n\n" + "연구 분야 : 인공지능(머신러닝, 강화학습)\n\t\t\t\t\t\t\t 블록체인\n\t\t\t\t\t\t\t 통신 네트워크 \n\t\t\t\t\t\t\t 어플리케이션 개발(AOS,IOS)\n\n" +
                "위치 : N5동 405, 406호"
                );
        adapter.addItem("CIS\n","담당교수 : 김태훈 교수님, 방인규 교수님(정보통신공학과)\n\n" + "연구 분야 : 5G/IoT\n\t\t\t\t\t\t\t 무선정보보안\n\t\t\t\t\t\t\t 딥러닝\n\t\t\t\t\t\t\t 강화학습\n\n" + "위치 : N4동 614호");
        adapter.addItem("AIM\n","담당교수 : 장한얼 교수님\n\n 연구분야 : 이미지 핑거프린팅 기술\n\t\t\t\t\t\t\t 정보은닉 탐지 기술\n\t\t\t\t\t\t\t 딥페이크 탐지/방어기술\n\n " + "위치 : N4동 603호");
        adapter.addItem("AAIL\n","담당교수 : 임경태 교수님\n\n 연구분야 : 실생활에 적용될 수 있는 인공지능 기술\n\t\t\t\t\t\t\t 자연어처리(챗봇,음성인식,번역기 등등)\n\n " + "위치 : N4동(미정)");
        adapter.addItem("CS\n","담당교수 : 최창범 교수님\n\n 연구분야 : 컴퓨터 시뮬레이션\n\t\t\t\t\t\t\t 이산사건 시스템, M&S이론\n\t\t\t\t\t\t\t 국방 M&S이론/방법론/환경개발\n\t\t\t\t\t\t\t HLA/RTI 기반 연동/분산 시뮬레이션\n\n" + "위치 : N4동(미정)");
        adapter.addItem("Artoa\n","담당교수 : 이재흥 교수님\n\n 연구분야 : 임베디드\n\t\t\t\t\t\t\t 딥러닝(영상처리)\n\n " + "위치 : N4동 505호");
        adapter.addItem("Syslet\n","담당교수 : 김영찬 교수님\n\n 연구분야 : DataBase\n\t\t\t\t\t\t\t MiddleWare\n\n" + "위치 : N4동");
        adapter.addItem("ISL\n","담당교수 : 김차종 교수님\n\n 연구분야 : JAVA\n\t\t\t\t\t\t\t C/C++\n\t\t\t\t\t\t\t WEB\n\t\t\t\t\t\t\t ANDROID\n\t\t\t\t\t\t\t 인공지능\n\n" + "위치 : N4동 612호");


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
