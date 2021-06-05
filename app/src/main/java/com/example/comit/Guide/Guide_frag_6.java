package com.example.comit.Guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Guide_frag_6 extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_6);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

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
