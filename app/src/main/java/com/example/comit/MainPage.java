package com.example.comit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.comit.Community.CommunityActivity;
import com.example.comit.Guide.GuideActivity;
import com.example.comit.LectureEval.LectureEvalActivity;
import com.example.comit.Notice.NoticeActivity;
import com.example.comit.Settings.SettingsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainPage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainpage);

            Button btn_notice = findViewById(R.id.btn_notice);
            Button btn_community = findViewById(R.id.btn_community);
            Button btn_guide = findViewById(R.id.btn_guide);
            Button btn_lecture = findViewById(R.id.btn_lecture);
            Button btn_settings = findViewById(R.id.btn_settings);

            Intent intent = new Intent(this, ChatbotActivity.class);

            btn_notice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainPage.this, NoticeActivity.class); // 페이지전환을 위한 인텐트
                    startActivity(intent);
                }
            });
            btn_guide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainPage.this, GuideActivity.class);
                    startActivity(intent);
                }
            });
            btn_community.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainPage.this, CommunityActivity.class);
                    startActivity(intent);
                }
            });
            btn_lecture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainPage.this, LectureEvalActivity.class);
                    startActivity(intent);
                }
            });
            btn_settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainPage.this, SettingsActivity.class);
                    startActivity(intent);
                }
            });


            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
            // 상태바 제거

            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            //상단바 제거

            //잠깐 첫화면 MainPage로 바꿈

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "챗봇 커미를 부릅니다", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    startActivity(intent);
                }
            }); // 플로팅버튼 리스너
        }
    }
