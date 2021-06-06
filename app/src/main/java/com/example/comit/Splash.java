package com.example.comit;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;

import com.example.comit.LoginActivity;
import com.example.comit.MainPage;
import com.example.comit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거


        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 1500); // 1초 후에 hd handler 실행  3000ms = 3초

    }

    private class splashhandler implements Runnable{
        public void run(){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                // User is signed in
                // go to main page
                startActivity(new Intent(getApplication(), MainPage.class));
//                Splash.this.finish();
                Toast.makeText(getApplication(),"자동 로그인 성공!",Toast.LENGTH_SHORT).show();
            } else {
                // No user is signed in
                // go to loging page
                startActivity(new Intent(getApplication(), LoginActivity.class));
            }
//            startActivity(new Intent(getApplication(), MainPage.class)); //로딩이 끝난 후, ChoiceFunction 이동
            Splash.this.finish(); // 로딩페이지 Activity stack에서 제거
        }
    }



    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }

}

